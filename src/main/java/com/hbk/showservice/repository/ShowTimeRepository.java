package com.hbk.showservice.repository;

import com.hbk.corefw.repository.CoreRepository;
import com.hbk.showservice.jdo.ShowTimeJDO;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepository extends CoreRepository<ShowTimeJDO, Long> {
}
