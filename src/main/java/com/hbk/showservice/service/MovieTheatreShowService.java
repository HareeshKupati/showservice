package com.hbk.showservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbk.corefw.dto.DTOWrapper;
import com.hbk.corefw.dto.Error;
import com.hbk.corefw.dto.FieldLocation;
import com.hbk.corefw.exception.ResourceNotFoundException;
import com.hbk.corefw.service.CoreService;
import com.hbk.showservice.dto.DTOUnwrapper;
import com.hbk.showservice.dto.MovieTheatreShowDTO;
import com.hbk.showservice.dto.SeatDTO;
import com.hbk.showservice.dto.TheatreDTO;
import com.hbk.showservice.jdo.MovieTheatreShowJDO;
import com.hbk.showservice.jdo.MovieTheatreShowSeatJDO;
import com.hbk.showservice.repository.MovieTheatreShowRepository;
import com.hbk.showservice.repository.ShowTimeRepository;
import com.hbk.showservice.util.SeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieTheatreShowService extends CoreService<MovieTheatreShowDTO, MovieTheatreShowJDO, Long, MovieTheatreShowRepository> {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ShowTimeRepository showTimeRepository;

    @Autowired
    ObjectMapper objectMapperFX;

    @Override
    public void mapToDTO(MovieTheatreShowJDO jdo, MovieTheatreShowDTO dto) {

    }

    @Override
    public void mapToJDO(MovieTheatreShowDTO dto, MovieTheatreShowJDO jdo) {
        jdo.setShow(showTimeRepository.findById(dto.getShowId()).orElse(null));
        if(CollectionUtils.isEmpty(dto.getMovieTheatreShowSeats())){
            List<Long> seatIds = getSeatIdsForTheatre(dto.getTheatreId());
            List<MovieTheatreShowSeatJDO> movieTheatreShowSeatJDOS =
            seatIds.stream().map(e-> createMovieTheatreShowSeatJDO(e, jdo)).collect(Collectors.toList());
            jdo.setMovieTheatreShowSeats(movieTheatreShowSeatJDOS);
        }
    }

    @Override
    public List<Error> validateDTO(MovieTheatreShowDTO dto) {
        return List.of();
    }

    public List<Long> getSeatIdsForTheatre(Long theatreId){
        ResponseEntity<DTOUnwrapper> responseEntity = restTemplate.getForEntity("http://localhost:8082/theatreservice/api/v1/theatres/{id}", DTOUnwrapper.class,theatreId);
        if(responseEntity.getBody() != null){
            TheatreDTO theatreDTO = objectMapperFX.convertValue(responseEntity.getBody().getContent(), TheatreDTO.class);
            return theatreDTO.getSeatGroups().stream().flatMap(e-> e.getSeats().stream()).map(SeatDTO::getId).distinct().collect(Collectors.toList());
        }
        return null;
    }

    public MovieTheatreShowSeatJDO createMovieTheatreShowSeatJDO(Long seatId, MovieTheatreShowJDO jdo){
        MovieTheatreShowSeatJDO movieTheatreShowSeatJDO= new MovieTheatreShowSeatJDO();
        movieTheatreShowSeatJDO.setSeatId(seatId);
        movieTheatreShowSeatJDO.setSeatStatus(SeatStatus.OPEN);
        movieTheatreShowSeatJDO.setMovieTheatreShow(jdo);
        return movieTheatreShowSeatJDO;
    }
}
