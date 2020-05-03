package org.bipin.gobble.lib.services;

/**
 * @author bipin on 2020-05-01 17:46
 */
public interface ValidatorService<T extends ServiceObject> {
  void validate(T info);
}
