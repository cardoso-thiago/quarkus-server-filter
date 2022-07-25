package br.com.cardoso.filter;

import io.vertx.core.http.HttpServerRequest;
import org.jboss.logmanager.MDC;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class HeaderFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) {
        HttpServerRequest serverRequest = (HttpServerRequest) MDC.getObject("http_server_request");
        requestContext.getHeaders().add("server_header_test", serverRequest.getHeader("server_header_test"));
    }
}
