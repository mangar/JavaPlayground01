package mng.main.avantstay.reservation.process.workflow;

import mng.main.avantstay.reservation.entity.ReservationEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReservationProcessFeedback implements Serializable {

    public static final String STATUS_INITIAL = "INITIAL";
    public static final String STATUS_OK = "OK";
    public static final String STATUS_WARNING = "WARNING";
    public static final String STATUS_ERROR = "ERROR";


    public ReservationEntity reservation;



    public String currentStatus = STATUS_INITIAL;


    public List<LogProcess> logs = new ArrayList<LogProcess>();
    public List<ReservationEntity> reservations = new ArrayList<ReservationEntity>();

    public static ReservationProcessFeedback create() {
        ReservationProcessFeedback instance = new ReservationProcessFeedback();
        instance.reservation = new ReservationEntity();
        instance.currentStatus = STATUS_INITIAL;

        instance.logs.add(LogProcess.create("INITIAL", "INITIAL", "Starting Reservation process", LogProcess.TYPE_LOG));
        return instance;
    }


    public void addLog(String processStep, String processName, String message, String type) {
        this.logs.add(LogProcess.create(processStep, processName, message, type));
    }


    public void updateReservation(final ReservationEntity reservationEntity) {
        this.reservations.add(this.reservation);
        this.reservation = reservationEntity;
    }


    public String describeLastLog() {
        StringBuffer ret = new StringBuffer();

        LogProcess log = this.logs.get( this.logs.size() -1 );
        ret.append(" [ ").append(log.type).append(" ] ").append(log.date).append(" - ").append(log.processStep).append(" - ").append(log.processName).append(" - ").append(log.message);

        return ret.toString();
    }


}
