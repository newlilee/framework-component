package com.example.graphql;

import com.example.graphql.fetcher.GraphqlDataFetchers;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * GraphQL Provider
 *
 * @author clx
 */
@Component
public class GraphqlProvider {

	private GraphQL graphql;
	private GraphqlDataFetchers graphqlDataFetchers;

	@Autowired
	public GraphqlProvider(GraphqlDataFetchers graphqlDataFetchers) {
		this.graphqlDataFetchers = graphqlDataFetchers;
	}


	@PostConstruct
	public void init() throws IOException {
		URL url = Resources.getResource("schema.graphql");
		String sdl = Resources.toString(url, Charsets.UTF_8);
		GraphQLSchema graphQLSchema = this.buildSchema(sdl);
		this.graphql = GraphQL.newGraphQL(graphQLSchema).build();
	}

	@Bean
	public GraphQL graphql() {
		return graphql;
	}

	/**
	 * build schema
	 *
	 * @param sdl
	 * @return
	 */
	private GraphQLSchema buildSchema(String sdl) {
		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(sdl);
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
				.type(newTypeWiring("Book").dataFetcher("author", graphqlDataFetchers.getAuthorDataFetcher())).build();
	}
}
