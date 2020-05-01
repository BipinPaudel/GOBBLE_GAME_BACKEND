package org.bipin.gobble.lib.repo;

/**
 * @author bipin on 2020-05-01 13:12
 */
public interface Repository<I,O> {
  O execute(I info);
}
