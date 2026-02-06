package com.hbk.showservice.service;

import com.hbk.corefw.dto.Error;
import com.hbk.corefw.service.CoreService;
import com.hbk.showservice.dto.ShowTimeDTO;
import com.hbk.showservice.jdo.ShowTimeJDO;
import com.hbk.showservice.repository.ShowTimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeService extends CoreService<ShowTimeDTO, ShowTimeJDO, Long, ShowTimeRepository> {

    @Override
    public void mapToDTO(ShowTimeJDO jdo, ShowTimeDTO dto) {

    }

    @Override
    public void mapToJDO(ShowTimeDTO dto, ShowTimeJDO jdo) {

    }

    @Override
    public List<Error> validateDTO(ShowTimeDTO dto) {
        return List.of();
    }
}
