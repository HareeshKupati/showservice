package com.hbk.showservice.controller;

import com.hbk.corefw.dto.DTOWrapper;
import com.hbk.showservice.dto.SeatBookingDTO;
import com.hbk.showservice.service.IBookingService;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final IBookingService service;

    public BookingController(IBookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DTOWrapper<SeatBookingDTO>> create(@RequestBody SeatBookingDTO req) throws ValidationException {
        SeatBookingDTO seatBookingDTO = service.createBooking(req);
        return ResponseEntity.status(HttpStatus.OK).body(new DTOWrapper<>(seatBookingDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOWrapper<SeatBookingDTO>> get(@PathVariable Long id) throws ValidationException {
        return ResponseEntity.status(HttpStatus.OK).body(new DTOWrapper<>(service.getBooking(id)));
    }

}
