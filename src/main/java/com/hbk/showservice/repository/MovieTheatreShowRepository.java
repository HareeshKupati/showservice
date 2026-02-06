package com.hbk.showservice.repository;

import com.hbk.corefw.repository.CoreRepository;
import com.hbk.showservice.jdo.MovieTheatreShowJDO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface MovieTheatreShowRepository extends CoreRepository<MovieTheatreShowJDO, Long> {

    @EntityGraph(attributePaths = {"movieTheatreShowSeats","showTime"})
    @Query("select mts from MovieTheatreShowJDO mts JOIN FETCH mts.movieTheatreShowSeats mtss " +
            "where mts.movieId = :movieId and mts.showTime.id = :showId and mts.theatreId = :theatreId " +
            "and mts.showDate = :showDate and mtss.seatId IN :seatIds")
    List<MovieTheatreShowJDO> findByMovieShowAndTheatreId(@Param("movieId") Long movieId,
                                                          @Param("showId") Long showId,
                                                          @Param("theatreId") Long theatreId,
                                                          @Param("showDate") Calendar showDate,
                                                          @Param("seatIds") List<Long> seatIds);

}
