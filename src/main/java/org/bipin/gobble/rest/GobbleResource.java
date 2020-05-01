package org.bipin.gobble.rest;

import org.bipin.gobble.lib.utils.RestResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author bipin on 2020-05-01 11:09
 */
@RequestScoped
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Named
public class GobbleResource {

  @POST
  public Response playGame(JsonObject jsonObject){
    return RestResponse.ok();
  }

}
