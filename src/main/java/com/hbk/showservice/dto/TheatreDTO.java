package com.hbk.showservice.dto;

import com.hbk.corefw.dto.CoreIdDTO;

import java.util.List;

public class TheatreDTO extends CoreIdDTO{
    private String name;
    private String address;
    private String city;
    private String state;
    private List<Long> seatGroupIds;
    private List<SeatGroupDTO> seatGroups;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSeatGroupIds() {
        return seatGroupIds;
    }

    public void setSeatGroupIds(List<Long> seatGroupIds) {
        this.seatGroupIds = seatGroupIds;
    }

    public List<SeatGroupDTO> getSeatGroups() {
        return seatGroups;
    }

    public void setSeatGroups(List<SeatGroupDTO> seatGroups) {
        this.seatGroups = seatGroups;
    }
}
