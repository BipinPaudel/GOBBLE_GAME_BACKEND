package org.bipin.gobble.lib.services;

import java.util.List;

/**
 * @author bipin on 2020-05-01 13:14
 */
public interface SearchService<I extends ServiceObject> {
   List<String> search(I info) ;
}
