package org.bipin.gobble.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bipin on 2020-05-01 11:08
 */
@ApplicationScoped
@ApplicationPath("/v1/gobble")
public class RestApplication extends Application {
  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<>();
    classes.add(IllegalArgumentException.class);
    classes.add(GobbleResource.class);
    return classes;
  }

}
