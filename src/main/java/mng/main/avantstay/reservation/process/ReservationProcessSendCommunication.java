package mng.main.avantstay.reservation.process;

import mng.main.avantstay.reservation.entity.ReservationEntity;

import java.lang.reflect.InvocationTargetException;

public class ReservationProcessSendCommunication extends ReservationProcessBase {

    public ReservationProcessSendCommunication(ReservationEntity reservationEntityInstance) throws InvocationTargetException, IllegalAccessException {
        super(reservationEntityInstance);
    }

//
//    /**
//     * @return
//     * @throws InvocationTargetException
//     * @throws IllegalAccessException
//     */
//    public ReservationEntity makePayment(final String creditCardNumberParam) {
//        this.reservationEntity.flagConfirmationSent = Boolean.TRUE;
//        return this.reservationEntity;
//    }

}
