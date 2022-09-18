package mng.main.avantstay.reservation.process.workflow;

import mng.main.avantstay.reservation.entity.PropertyEntity;
import mng.main.avantstay.reservation.entity.ReservationEntity;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReservationProcesFlowTest {

    @Test
    void testFlow() {

        /**
         * 1. Select the Property
         * 2. Select the dates
         * 3. Select # of guests
         *
         * 4. Check Availability
         * 5. Get the price
         * 6. Make the Payment
         * 7. Make the Reservation
         * 8. Send communication
         */


        ReservationEntity reservation = new ReservationEntity();

        // 1.
        reservation.property = new PropertyEntity("id-123-1234-1234", "Property Name #01");

        // 2.
        reservation.startDate = new Date();
        reservation.endDate = new Date();

        // 3.
        reservation.numberOfGuests = Integer.valueOf(4);


        try {
            System.out.println("---");
            ReservationWorkflow reservationWorkflow = new ReservationWorkflow(reservation);

            // 4.
            reservationWorkflow.checkAvailability(new Date(), new Date());
            System.out.println("> " + reservationWorkflow.feedback.describeLastLog());

            // 5.
            reservationWorkflow.calculateAmount();
            System.out.println("> " + reservationWorkflow.feedback.describeLastLog());


            // 6.


            // 7.


            // 8.


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        assertTrue(true);

    }


}