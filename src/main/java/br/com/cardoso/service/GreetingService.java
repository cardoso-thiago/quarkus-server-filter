package br.com.cardoso.service;

import br.com.cardoso.filter.HeaderFilter;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class GreetingService {

    public String hello() {
        Client client = ClientBuilder.newBuilder()
                .register(HeaderFilter.class)
                .build();
        WebTarget webTarget = client.target("http://localhost:8080");
        Response response = webTarget.path("/world").request().get();
        return "Hello " + response.readEntity(String.class);
    }

    public String world() {
        return "world";
    }
}
