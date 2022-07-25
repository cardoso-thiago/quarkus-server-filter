package br.com.cardoso;

import br.com.cardoso.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @Inject
    public GreetingService greetingService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.hello();
    }

    @GET
    @Path("/world")
    @Produces(MediaType.TEXT_PLAIN)
    public String world() {
        return greetingService.world();
    }
}