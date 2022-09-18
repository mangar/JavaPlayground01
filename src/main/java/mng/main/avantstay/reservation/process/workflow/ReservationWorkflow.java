package mng.main.avantstay.reservation.process.workflow;

import mng.main.avantstay.reservation.entity.ReservationEntity;
import mng.main.avantstay.reservation.process.ReservationProcessCalculateAmount;
import mng.main.avantstay.reservation.process.ReservationProcessCheckAvailability;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class ReservationWorkflow {

    ReservationProcessFeedback feedback;


    public ReservationWorkflow(final ReservationEntity reservationEntity) throws InvocationTargetException, IllegalAccessException {
        this.feedback = ReservationProcessFeedback.create();
        BeanUtils.copyProperties(this.feedback.reservation, reservationEntity);
    }


    public void checkAvailability(final Date startDate, final Date endDate) throws InvocationTargetException, IllegalAccessException {
        ReservationProcessCheckAvailability process = new ReservationProcessCheckAvailability(this.feedback.reservation);
        ReservationEntity reservation = process.check(startDate, endDate);

//        this.feedback.reservation = reservation;
        this.feedback.updateReservation(reservation);

        if (this.feedback.reservation.flagIsAvailable) {
            this.feedback.addLog("1", process.processName(), "flagAvailable = true", LogProcess.TYPE_LOG);
        } else {
            this.feedback.addLog("1", process.processName(), "flagAvailable = false", LogProcess.TYPE_ERROR);
        }
    }

    public void calculateAmount() throws InvocationTargetException, IllegalAccessException {

        ReservationProcessCalculateAmount process = new ReservationProcessCalculateAmount(this.feedback.reservation);
        ReservationEntity reservation = process.calculateReservation();

//        this.feedback.reservation = reservation;
        this.feedback.updateReservation(reservation);

        if (this.feedback.reservation.totalAmount.intValue() >= 0) {
            this.feedback.addLog("2", process.processName(), "", LogProcess.TYPE_LOG);
        } else {
            this.feedback.addLog("2", process.processName(), "Price < 0", LogProcess.TYPE_ERROR);
        }
    }

    public void makePayment(final String creditCardNumber) {

    }


    public void makeReservation() {

    }

    public void sendCommunication() {

    }


}
