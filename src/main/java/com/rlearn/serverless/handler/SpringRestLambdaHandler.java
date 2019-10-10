package com.rlearn.serverless.handler;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SpringRestLambdaHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse>{

	private static SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler = null;
	
	static{
		try {
			handler = SpringLambdaContainerHandler.getAwsProxyHandler(SpringConfig.class);
		} catch (ContainerInitializationException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context) {
		return handler.proxy(awsProxyRequest, context);
	}
}
