package org.bipin.gobble.repositories;

import org.bipin.gobble.lib.repo.Repository;
import org.bipin.gobble.repositories.infos.GameInfo;
import org.bipin.gobble.repositories.infos.ResultInfo;

import java.util.List;

/**
 * @author bipin on 2020-05-01 13:14
 */
public interface SearchRepository extends Repository<GameInfo, List<String>> {
}
