package org.bipin.gobble.lib.filters;



import org.bipin.gobble.lib.ResponseUpdater;
import org.bipin.gobble.lib.utils.LoggerUtils;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Provider
@PreMatching
public class CorsFilter implements ContainerResponseFilter {

  private Logger logger = LoggerUtils.getLogger(CorsFilter.class);

  @Override
  public void filter(
      ContainerRequestContext requestContext, ContainerResponseContext responseContext)
      throws IOException {
    ResponseUpdater responseUpdater = this.getResponseUpdater();
    responseContext.getHeaders().add("Access-Control-Allow-Origin", this.getAllowedOrigin());
    responseContext
        .getHeaders()
        .add("Access-Control-Allow-Headers", getAllowedHeaders(requestContext));
    responseContext
        .getHeaders()
        .add("Access-Control-Expose-Headers", getRequestedExposedHeaders(requestContext));
    responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
    responseContext.getHeaders().add("Access-Control-Allow-Methods", this.getAllowedMethods());
    // responseContext.getHeaders().add("Access-Control-Max-Age", this.getMaxAged());
    responseContext.getHeaders().add("x-responded-by", "city-tech-response-filter");
    requestContext
        .getHeaders()
        .add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
    requestContext.getHeaders().add(HttpHeaders.EXPIRES, "0");
    requestContext.getHeaders().add("Pragma", "no-cache");
  }

  private ResponseUpdater getResponseUpdater() {
    Instance<ResponseUpdater> appDetail = CDI.current().select(ResponseUpdater.class);
    if (appDetail != null && appDetail.stream().count() > 0) return appDetail.get();
    return null;
  }

  protected String getAllowedOrigin() {
    return "*";
  }

  protected String getAllowedHeaders(ContainerRequestContext responseContext) {
    List<String> headers = null;
    if (responseContext.getHeaders() != null) {
      headers = responseContext.getHeaders().get("Access-Control-Allow-Headers");
    }
    if (headers == null) {
      headers = new ArrayList<>();
    }
    headers.add("origin");
    headers.add("accept");
    headers.add("content-type");
    headers.add("X-Requested-With");
    headers.add("X-XSRF-TOKEN");
    headers.add("Pragma");
    headers.add("User-Agent");
    headers.add("Lang");
    return headers.stream().collect(Collectors.joining(","));
  }

  protected String getRequestedExposedHeaders(ContainerRequestContext requestContext) {
    List<String> headers = requestContext.getHeaders().get("Access-Control-Expose-Headers");
    if (headers == null) {
      headers = new ArrayList<>();
    }
    headers.add("X-XSRF-TOKEN");
    return headers.stream().collect(Collectors.joining(","));
  }

  protected String getAllowedMethods() {
    List<String> methods = new ArrayList<>();
    methods.add("GET");
    methods.add("POST");
    methods.add("PUT");
    methods.add("DELETE");
    methods.add("OPTIONS");
    methods.add("HEAD");
    return methods.stream().collect(Collectors.joining(","));
  }

  protected int getMaxAged() {
    return 42 * 60 * 60;
  }
}
