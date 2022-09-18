package mng.main.avantstay.reservation.process;

import mng.main.avantstay.reservation.entity.ReservationEntity;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class ReservationProcessCalculateAmount extends ReservationProcessBase {


    public ReservationProcessCalculateAmount(ReservationEntity reservation) throws InvocationTargetException, IllegalAccessException {
        super(reservation);
    }

    @Override
    public String processName() {
        return "CALCULATE_AMOUNT";
    }

    /**
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public ReservationEntity calculateReservation() {
        this.reservation.totalAmount = BigDecimal.TEN;
//        this.reservation.totalAmount = BigDecimal.valueOf(-1);
        return this.reservation;
    }

}
