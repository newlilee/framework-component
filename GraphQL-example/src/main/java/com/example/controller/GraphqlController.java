package com.example.controller;

import com.example.util.JsonUtils;
import com.google.common.collect.Maps;
import graphql.ExceptionWhileDataFetching;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLError;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author clx
 */
@RestController
public class GraphqlController {

	private GraphQL graphql;

	@Autowired
	public GraphqlController(GraphQL graphql) {
		this.graphql = graphql;
	}

	@PostMapping(value = "/api/graphql", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> graphql(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> body) {
		String query = (String) body.get("query");
		if (Objects.isNull(query)) {
			query = StringUtils.EMPTY;
		}
		String operationName = (String) body.get("operationName");
		Map<String, Object> variables = (Map<String, Object>) body.get("variables");
		if (variables == null) {
			variables = Maps.newLinkedHashMap();
		}

		Map<String, Object> graphqlQuery = executeGraphqlQuery(query, operationName, variables, body, request);
		if (Objects.isNull(graphqlQuery)) {
			graphqlQuery = Maps.newHashMapWithExpectedSize(2);
			graphqlQuery.put("code", 1);
			graphqlQuery.put("msg", "操作失败");
		}
		return graphqlQuery;
	}

	private Map<String, Object> executeGraphqlQuery(String query, String operationName, Map<String, Object> variables,
	                                                Map<String, Object> body, HttpServletRequest request) {
		long currentTimeMillis = System.currentTimeMillis();
		ExecutionInput executionInput = ExecutionInput.newExecutionInput()
				.query(query)
				.operationName(operationName)
				.variables(variables)
				.build();

		ExecutionResult executionResult = this.graphql.execute(executionInput);

		//gql返回格式化
		Map<String, Object> result = Maps.newLinkedHashMap();
		List<GraphQLError> errors = executionResult.getErrors();
		if (errors != null && !errors.isEmpty()) {
			result.put("code", 500);
			result.put("msg", "服务器内部错误");
			for (GraphQLError graphqlError : errors) {
				if (graphqlError instanceof ExceptionWhileDataFetching) {
					ExceptionWhileDataFetching exceptionWhileDataFetching = (ExceptionWhileDataFetching) graphqlError;
					Throwable exception = exceptionWhileDataFetching.getException();
				} else {

				}
			}
		} else {
			result.put("code", 0);
			result.put("msg", "success");
		}
		if (executionResult.isDataPresent()) {
			result.put("data", executionResult.getData());
		}
		if (Objects.nonNull(executionResult.getExtensions())) {
			result.put("extensions", executionResult.getExtensions());
		}

		String hostAddress = "";
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			hostAddress = localHost.getHostAddress();
		} catch (UnknownHostException e) {

		}

		StringBuilder logBuilder = new StringBuilder();
		logBuilder.append("system=").append("graphql-example").append("||")
				.append("hostIp=").append(hostAddress).append("||")
				.append("userIp=").append(request.getHeader("X-Forwarded-For")).append("||")
				.append("url=").append("/api/graphql").append("||")
				.append("postParams=").append(JsonUtils.toJsonStr(body)).append("||")
				.append("timestamp=").append(currentTimeMillis).append("||")
				.append("response=").append(JsonUtils.toJsonStr(result)).append("||")
				.append("timeElapsed=").append(System.currentTimeMillis() - currentTimeMillis);
		return result;
	}
}
