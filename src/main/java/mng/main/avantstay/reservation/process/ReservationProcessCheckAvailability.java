package mng.main.avantstay.reservation.process;

import mng.main.avantstay.reservation.entity.ReservationEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class ReservationProcessCheckAvailability extends ReservationProcessBase {


    public ReservationProcessCheckAvailability(ReservationEntity reservation) throws InvocationTargetException, IllegalAccessException {
        super(reservation);
    }

    @Override
    public String processName() {
        return "CHECK_AVAILABILITY";
    }

    /**
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public ReservationEntity check(final Date startDate, final Date endDate) {
        this.reservation.startDate = startDate;
        this.reservation.endDate = endDate;
        this.reservation.flagIsAvailable = Boolean.TRUE;
        return this.reservation;
    }

}
