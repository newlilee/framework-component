package com.example.graphql;

import com.example.graphql.fetcher.GraphQLDataFetchers;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.nextgen.GraphQL;
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
public class GraphQLProvider {

	@Autowired
	private GraphQLDataFetchers graphQLDataFetchers;

	private GraphQL graphQL;

	@PostConstruct
	public void init() throws IOException {
		URL url = Resources.getResource("schema.graphqls");
		String sdl = Resources.toString(url, Charsets.UTF_8);
		GraphQLSchema graphQLSchema = this.buildSchema(sdl);
		this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	}

	@Bean
	public GraphQL graphQL() {
		return graphQL;
	}

	private GraphQLSchema buildSchema(String sdl) {
		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(sdl);
		RuntimeWiring runtimeWiring = this.buildWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
	}

	private RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type(newTypeWiring("Query").dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
				.type(newTypeWiring("Book").dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher())).build();
	}
}
