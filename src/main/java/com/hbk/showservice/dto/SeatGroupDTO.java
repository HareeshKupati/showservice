package com.hbk.showservice.dto;

import com.hbk.corefw.dto.CoreIdDTO;

import java.math.BigDecimal;
import java.util.List;

public class SeatGroupDTO extends CoreIdDTO {

    private String name;

    private BigDecimal price;

    private List<SeatDTO> seats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDTO> seats) {
        this.seats = seats;
    }
}
