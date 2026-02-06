package com.hbk.showservice.dto;

import com.hbk.corefw.dto.CoreIdDTO;
import com.hbk.showservice.util.SeatStatus;

public class MovieTheatreShowSeatDTO extends CoreIdDTO {
    private Long seatId;
    private SeatStatus seatStatus;

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }
}
