package com.hbk.showservice.dto;

import com.hbk.corefw.dto.CoreIdDTO;

public class SeatDTO extends CoreIdDTO {
    private String rowNo;

    private Integer seatNo;

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }
}
