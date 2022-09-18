package mng.main.avantstay.reservation.process;

import mng.main.avantstay.reservation.entity.ReservationEntity;

import java.lang.reflect.InvocationTargetException;

public class ReservationProcessConfirmReservation extends ReservationProcessBase {

    public ReservationProcessConfirmReservation(ReservationEntity reservation) throws InvocationTargetException, IllegalAccessException {
        super(reservation);
    }


//    /**
//     * @return
//     * @throws InvocationTargetException
//     * @throws IllegalAccessException
//     */
//    public ReservationEntity makeReservation() {
//        this.reservationEntity.flagReserved = Boolean.TRUE;
//        return this.reservationEntity;
//    }

}
