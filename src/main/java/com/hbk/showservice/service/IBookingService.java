package com.hbk.showservice.service;


import com.hbk.showservice.dto.SeatBookingDTO;

public interface IBookingService {

    SeatBookingDTO createBooking(SeatBookingDTO seatBookingDTO);

    SeatBookingDTO getBooking(Long id);

}
