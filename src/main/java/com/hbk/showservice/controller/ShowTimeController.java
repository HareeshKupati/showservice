package com.hbk.showservice.controller;

import com.hbk.corefw.controller.SimpleCrudController;
import com.hbk.showservice.dto.ShowTimeDTO;
import com.hbk.showservice.jdo.ShowTimeJDO;
import com.hbk.showservice.repository.ShowTimeRepository;
import com.hbk.showservice.service.ShowTimeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/showtimes")
public class ShowTimeController extends SimpleCrudController<ShowTimeDTO, ShowTimeJDO, Long, ShowTimeRepository, ShowTimeService> {
}
