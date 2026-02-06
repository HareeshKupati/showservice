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

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status", nullable = false)
    private SeatStatus seatStatus;

    @Column(name = "locked_by", nullable = true)
    private Long lockedBy;

    @Column(name = "locked_time", nullable = true)
    private Calendar lockedTime;

    @Version
    @Column(name = "row_version" , nullable = false)
    private Integer rowVersion;

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
        if(SeatStatus.LOCKED.equals(seatStatus)){
            if(lockedTime != null){
                Calendar lockedDateTime = (Calendar) lockedTime.clone();
                lockedDateTime.add(Calendar.MINUTE, 2);
                if(SeatStatus.LOCKED.equals(seatStatus) && Calendar.getInstance().compareTo(lockedDateTime)>0){
                    return SeatStatus.OPEN;
                }
            } else {
                return SeatStatus.OPEN;
            }
        }
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Long getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(Long lockedBy) {
        this.lockedBy = lockedBy;
    }

    public Calendar getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Calendar lockedTime) {
        this.lockedTime = lockedTime;
    }

    public Integer getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }
}
