package mng.main.avantstay.reservation.process.workflow;

import java.util.Date;

public class LogProcess {

    public static final String TYPE_LOG = "LOG";
    public static final String TYPE_WARNING = "WARNING";
    public static final String TYPE_ERROR = "ERROR";


    String processStep;
    String processName;
    String message;
    String type = LogProcess.TYPE_LOG;
    Date date;

    private LogProcess(String processStep, String processName, String message, String type) {
        this.processStep = processStep;
        this.processName = processName;
        this.message = message;
        this.type = type;
        this.date = new Date();

    }

    public final static LogProcess create(String processStep, String processName, String message, String type) {
        return new LogProcess(processStep, processName, message, type);
    }


}
