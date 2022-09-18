package mng.main.yaml;

import com.github.javafaker.Faker;
import mng.main.yaml.entity.Order;
import mng.main.yaml.entity.OrderItem;
import mng.main.yaml.entity.Orders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFactory {


    public static final Orders generateOrder(int quantity) {

        Orders orders = new Orders();
        Faker faker = new Faker();


        for (int i = 0; i < quantity; i++) {

            // Items
            List<OrderItem> items = new ArrayList<OrderItem>();
            for (int t = quantity; t > 0; t--) {
                OrderItem item = new OrderItem(
                        faker.idNumber().valid(),
                        faker.commerce().promotionCode(),
                        faker.commerce().productName(),
                        Integer.valueOf(t + ""),
                        new BigDecimal(faker.commerce().price().replace(",", "."))
                );

                items.add(item);
            }

            // Order
            Order o = new Order(
                    faker.idNumber().validSvSeSsn(),
                    faker.idNumber().ssnValid(),
                    new Date(),
                    items
            );

            orders.getOrders().add(o);
        }

        return orders;
    }


}
