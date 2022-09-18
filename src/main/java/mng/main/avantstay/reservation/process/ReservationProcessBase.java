package mng.main.avantstay.reservation.process;

import mng.main.avantstay.reservation.entity.ReservationEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ReservationProcessBase {

    public ReservationEntity reservation;


    public ReservationProcessBase(final ReservationEntity reservation) throws InvocationTargetException, IllegalAccessException {
        this.reservation = new ReservationEntity();
        BeanUtils.copyProperties(this.reservation, reservation);
    }


    public String processName() {
        return "";
    }

}
