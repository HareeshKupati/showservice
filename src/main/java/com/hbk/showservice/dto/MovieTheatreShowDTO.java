package com.hbk.showservice.dto;

import com.hbk.corefw.dto.CoreIdDTO;

import java.util.Calendar;
import java.util.List;

public class MovieTheatreShowDTO extends CoreIdDTO {
    private Long theatreId;

    private Long movieId;

    private Long showTimeId;

    private ShowTimeDTO showTime;

    private Calendar showDate;

    private List<MovieTheatreShowSeatDTO> movieTheatreShowSeats;

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(Long showTimeId) {
        this.showTimeId = showTimeId;
    }

    public ShowTimeDTO getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTimeDTO showTime) {
        this.showTime = showTime;
    }

    public Calendar getShowDate() {
        return showDate;
    }

    public void setShowDate(Calendar showDate) {
        this.showDate = showDate;
    }

    public List<MovieTheatreShowSeatDTO> getMovieTheatreShowSeats() {
        return movieTheatreShowSeats;
    }

    public void setMovieTheatreShowSeats(List<MovieTheatreShowSeatDTO> movieTheatreShowSeats) {
        this.movieTheatreShowSeats = movieTheatreShowSeats;
    }
}
