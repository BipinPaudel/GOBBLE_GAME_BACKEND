package org.bipin.gobble.repositories;

import org.bipin.gobble.lib.repo.Repository;
import org.bipin.gobble.repositories.infos.GameInfo;

import java.util.List;

/**
 * @author bipin on 2020-05-01 13:14
 */
public interface SearchService extends Repository<GameInfo, List<String>> {
}
