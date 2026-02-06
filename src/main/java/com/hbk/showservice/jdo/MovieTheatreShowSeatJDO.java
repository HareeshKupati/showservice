package com.hbk.showservice.jdo;

import com.hbk.corefw.jdo.CoreIdJDO;
import com.hbk.showservice.util.SeatStatus;
import jakarta.persistence.*;

import java.util.Calendar;

@Entity
@Table(name = "movie_theatre_show_seat")
public class MovieTheatreShowSeatJDO extends CoreIdJDO {
    @Column(name = "seat_id", nullable = false)
    private Long seatId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "movie_theatre_show_id", nullable = false)
    private MovieTheatreShowJDO movieTheatreShow;

    @Column(name = "seat_status", nullable = false)
    private SeatStatus seatStatus;

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public MovieTheatreShowJDO getMovieTheatreShow() {
        return movieTheatreShow;
    }

    public void setMovieTheatreShow(MovieTheatreShowJDO movieTheatreShow) {
        this.movieTheatreShow = movieTheatreShow;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

}
