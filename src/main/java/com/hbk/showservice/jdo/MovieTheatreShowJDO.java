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
    @JoinColumn(name = "showtime_id")
    private ShowTimeJDO showTime;

    @Column(name = "show_date")
    private Calendar showDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movieTheatreShow")
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

    public ShowTimeJDO getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTimeJDO showTime) {
        this.showTime = showTime;
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
