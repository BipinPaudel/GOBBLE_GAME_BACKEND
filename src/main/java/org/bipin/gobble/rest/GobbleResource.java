package org.bipin.gobble.rest;

import org.bipin.gobble.lib.Dictionary;
import org.bipin.gobble.lib.utils.RestResponse;
import org.bipin.gobble.repositories.GobbleRepository;
import org.bipin.gobble.repositories.infos.GameInfo;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

/**
 * @author bipin on 2020-05-01 11:09
 */
@RequestScoped
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Named
public class GobbleResource {

  private GobbleRepository gobbleRepository;

  @Inject
  public GobbleResource(GobbleRepository gobbleRepository) {
    this.gobbleRepository = gobbleRepository;
  }

  @POST
  public Response playGame(JsonObject jsonObject){
    GameInfo info= new GameInfo();
    info.setTest(jsonObject.getString("abc",""));
    return RestResponse.ok(gobbleRepository.execute(info));
  }

}
