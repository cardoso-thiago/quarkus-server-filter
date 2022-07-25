package br.com.cardoso.filter;

import io.vertx.core.http.HttpServerRequest;
import org.jboss.logmanager.MDC;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
public class ServerRequestFilter implements ContainerRequestFilter {

    @Context
    public HttpServerRequest serverRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        MDC.putObject("http_server_request", serverRequest);
        System.out.println(serverRequest.getHeader("server_header_test"));
    }
}
