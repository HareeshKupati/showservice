package com.hbk.showservice.jdo;

import com.hbk.corefw.jdo.CoreIdJDO;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "movie_theatre_show")
public class MovieTheatreShowJDO extends CoreIdJDO {

    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(name = "theatre_id", nullable = false)
    private Long theatreId;

    @ManyToOne
    @JoinColumn(name = "shows_id")
    private ShowTimeJDO show;

    @Column(name = "show_date")
    private Calendar showDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieTheatreShow")
    private List<MovieTheatreShowSeatJDO> movieTheatreShowSeats;

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

    public ShowTimeJDO getShow() {
        return show;
    }

    public void setShow(ShowTimeJDO show) {
        this.show = show;
    }

    public Calendar getShowDate() {
        return showDate;
    }

    public void setShowDate(Calendar showDate) {
        this.showDate = showDate;
    }

    public List<MovieTheatreShowSeatJDO> getMovieTheatreShowSeats() {
        return movieTheatreShowSeats;
    }

    public void setMovieTheatreShowSeats(List<MovieTheatreShowSeatJDO> movieTheatreShowSeats) {
        this.movieTheatreShowSeats = movieTheatreShowSeats;
    }
}
