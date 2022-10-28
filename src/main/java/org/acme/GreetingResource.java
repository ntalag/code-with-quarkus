package org.acme;

import java.beans.AppletInitializer;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/hello-world")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

    //    String appuser = System.getenv("appUser");
    //    String appSecretkey = System.getenv("appSecretkey");
    //     return "Hola from "+ appuser +":"+appSecretkey+ " Reactive";
    Map<String, Object> report = new HashMap<>();
    report.put("Greeting Fron Quarkus", "Hello World");
    //report.put("appUser", System.getenv("appUser"));
    //report.put("appSecret", System.getenv("appSecretkey"));
    String jsonResult="";
    ObjectMapper mapper = new ObjectMapper();
    try {
         jsonResult = mapper.writeValueAsString(report);
         
    } catch (JsonProcessingException e) {
        
        e.printStackTrace();
    }
     
     return jsonResult;
    }
}
