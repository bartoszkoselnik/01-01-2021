package com.workspace.rentcar.dto.car;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ReturnCarRcCarDTO {
    private List<Long> idsOfReturnCars;
    private BigDecimal finalPrice;
    private LocalDate returnDate;

    public List<Long> getIdsOfReturnCars() {
        return idsOfReturnCars;
    }

    public void setIdsOfReturnCars(List<Long> idsOfReturnCars) {
        this.idsOfReturnCars = idsOfReturnCars;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
