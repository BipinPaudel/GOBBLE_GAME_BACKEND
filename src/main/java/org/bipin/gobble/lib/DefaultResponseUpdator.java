package org.bipin.gobble.lib;

import javax.enterprise.inject.Default;

@Default
public class DefaultResponseUpdator implements ResponseUpdater {
  @Override
  public Object update(Object data) {
    if (data != null) return data;
    return null;
  }
}
