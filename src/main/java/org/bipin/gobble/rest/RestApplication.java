package org.bipin.gobble.rest;

import org.bipin.gobble.lib.filters.CorsFilter;
import org.bipin.gobble.lib.mappers.*;

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
    classes.add(AppExceptionMapper.class);
    classes.add(InternalServerExceptionMapper.class);
    classes.add(MethodNotAllowedExceptionMapper.class);
    classes.add(NoSuchElementExceptionMapper.class);
    classes.add(NotAuthorizedExceptionMapper.class);
    classes.add(NullPointerExceptionMapper.class);
    classes.add(UnSupportedMediaTypeExceptionMapper.class);
    classes.add(CorsFilter.class);
    return classes;
  }

}
