package com.example.graphql;

import com.example.graphql.fetcher.GraphqlDataFetchers;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * GraphQL Provider
 *
 * @author clx
 */
@Component
public class GraphqlProvider {

	private final Logger logger = LoggerFactory.getLogger(GraphqlProvider.class);

	private GraphQL graphql;
	private ApplicationContext applicationContext;
	private GraphqlDataFetchers graphqlDataFetchers;

	@Autowired
	public GraphqlProvider(ApplicationContext applicationContext, GraphqlDataFetchers graphqlDataFetchers) {
		this.applicationContext = applicationContext;
		this.graphqlDataFetchers = graphqlDataFetchers;
	}


	@PostConstruct
	public void init() throws IOException {
		Resource[] resources = this.applicationContext.getResources("classpath*:graphqls/*.graphql");
		GraphQLSchema graphQLSchema = this.buildSchema(resources);
		this.graphql = GraphQL.newGraphQL(graphQLSchema).build();
	}

	@Bean
	public GraphQL graphql() {
		return graphql;
	}

	/**
	 * build schema
	 *
	 * @param resources
	 * @return
	 */
	private GraphQLSchema buildSchema(Resource[] resources) {
		TypeDefinitionRegistry typeDefinitionRegistry = new TypeDefinitionRegistry();
		for (Resource resource : resources) {
			try {
				typeDefinitionRegistry.merge(new SchemaParser().parse(resource.getInputStream()));
			} catch (Exception e) {
				logger.error("read schema error:{}", e.getMessage());
			}
		}
		RuntimeWiring runtimeWiring = this.buildWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
	}

	/**
	 * build wiring
	 *
	 * @return
	 */
	private RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type(newTypeWiring("Query").dataFetcher("bookById", graphqlDataFetchers.getBookByIdDataFetcher()))
				.type(newTypeWiring("Book").dataFetcher("author", graphqlDataFetchers.getAuthorDataFetcher()))
				.build();
	}
}
