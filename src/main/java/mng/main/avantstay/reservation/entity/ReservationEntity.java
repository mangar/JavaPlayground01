package mng.main.avantstay.reservation.entity;

import org.apache.commons.beanutils.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class ReservationEntity {

    public PropertyEntity property;
    public Date startDate;
    public Date endDate;
    public Integer numberOfGuests = Integer.valueOf(0);

    public BigDecimal totalAmount = BigDecimal.ZERO;


    public Boolean flagIsAvailable = Boolean.FALSE;

    public Boolean flagPaid = Boolean.FALSE;
    public Boolean flagReserved = Boolean.FALSE;
    public Boolean flagConfirmationSent = Boolean.FALSE;

    public ReservationEntity() {
        super();
    }

    public ReservationEntity(PropertyEntity property, Date startDate, Date endDate, Integer numberOfGuests) {
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfGuests = numberOfGuests;
    }

    public void describe() throws Exception {
        System.out.println("--- ");
        System.out.println("> Reservation  Entity");
        Map<?, ?> content = BeanUtils.describe(this);
        content.keySet().forEach(s -> System.out.println(s + " >> " + content.get(s)));
    }

}
