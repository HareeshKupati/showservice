package com.hbk.showservice.service;

import com.hbk.showservice.dto.SeatBookingDTO;
import com.hbk.showservice.jdo.MovieTheatreShowJDO;
import com.hbk.showservice.jdo.MovieTheatreShowSeatJDO;
import com.hbk.showservice.repository.MovieTheatreShowRepository;
import com.hbk.showservice.util.SeatStatus;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService{

    @Autowired
    MovieTheatreShowRepository movieTheatreShowRepository;

    @Override
    @Transactional
    public SeatBookingDTO createBooking(SeatBookingDTO seatBookingDTO) {

        List<MovieTheatreShowJDO>  movieTheatreShows = movieTheatreShowRepository.findByMovieShowAndTheatreId(seatBookingDTO.getMovieId(),
                seatBookingDTO.getShowId(),
                seatBookingDTO.getTheatreId(),
                seatBookingDTO.getShowDate(),
                seatBookingDTO.getSeatIds());
        if(movieTheatreShows.size() != 1)
            throw new RuntimeException("Invalid request");
        MovieTheatreShowJDO movieTheatreShowJDO = movieTheatreShows.get(0);
        if(movieTheatreShowJDO.getMovieTheatreShowSeats() != null
                && movieTheatreShowJDO.getMovieTheatreShowSeats().size()==seatBookingDTO.getSeatIds().size()){
            for(MovieTheatreShowSeatJDO movieTheatreShowSeatJDO: movieTheatreShowJDO.getMovieTheatreShowSeats()){
                movieTheatreShowSeatJDO.setSeatStatus(SeatStatus.LOCKED);
            }
        }
        return seatBookingDTO;
    }

    @Override
    public SeatBookingDTO getBooking(Long id) {
        return null;
    }
}
