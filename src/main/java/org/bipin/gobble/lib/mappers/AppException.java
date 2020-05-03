package org.bipin.gobble.lib.mappers;

import org.bipin.gobble.lib.exceptions.GobbleException;
import org.bipin.gobble.lib.exceptions.GobbleExceptionType;
import org.bipin.gobble.repositories.helpers.HelperUtils;

import javax.json.Json;
import javax.json.JsonObject;
/**
 * @author bipin on 2020-05-01 11:09
 */
public class AppException extends GobbleException {

  public AppException(GobbleExceptionType gobbleExceptionType) {
    super(gobbleExceptionType);
  }

  public JsonObject toJson() {
    return Json.createObjectBuilder()
        .add("time", HelperUtils.getTime())
        .add("code", this.getExceptionType().getCode())
        .add("message", this.getExceptionType().getDescription())
        .build();
  }
}
