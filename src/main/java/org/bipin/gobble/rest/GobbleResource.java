package org.bipin.gobble.rest;

import org.bipin.gobble.lib.utils.RestResponse;
import org.bipin.gobble.repositories.GobbleRepository;
import org.bipin.gobble.repositories.infos.GameInfo;
import org.bipin.gobble.rest.adaptors.GameRequestAdaptor;

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
  private GameRequestAdaptor gameRequestAdaptor;

  @Inject
  public GobbleResource(GobbleRepository gobbleRepository, GameRequestAdaptor gameRequestAdaptor) {
    this.gobbleRepository = gobbleRepository;
    this.gameRequestAdaptor = gameRequestAdaptor;
  }

  @POST
  public Response playGame(JsonObject jsonObject){
    GameInfo info= new GameInfo();
    return RestResponse.ok(gobbleRepository.execute(gameRequestAdaptor.toInfo(jsonObject)));
  }

}
