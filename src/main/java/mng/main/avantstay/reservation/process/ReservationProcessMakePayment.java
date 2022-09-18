package mng.main.avantstay.reservation.process;

import mng.main.avantstay.reservation.entity.ReservationEntity;

import java.lang.reflect.InvocationTargetException;

public class ReservationProcessMakePayment extends ReservationProcessBase {

    public ReservationProcessMakePayment(ReservationEntity reservationEntityInstance) throws InvocationTargetException, IllegalAccessException {
        super(reservationEntityInstance);
    }

//
//    /**
//     * @return
//     * @throws InvocationTargetException
//     * @throws IllegalAccessException
//     */
//    public ReservationEntity makePayment(final String creditCardNumberParam) {
//        this.reservationEntity.flagPaid = Boolean.TRUE;
//        return this.reservationEntity;
//    }

}
