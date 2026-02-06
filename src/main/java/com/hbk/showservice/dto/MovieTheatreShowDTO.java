package com.hbk.showservice.dto;

import com.hbk.corefw.dto.CoreIdDTO;

import java.util.Calendar;
import java.util.List;

public class MovieTheatreShowDTO extends CoreIdDTO {
    private Long theatreId;

    private Long movieId;

    private Long showId;

    private ShowTimeDTO show;

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

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public ShowTimeDTO getShow() {
        return show;
    }

    public void setShow(ShowTimeDTO show) {
        this.show = show;
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
