package mng.main.yaml.entity;

import java.util.ArrayList;
import java.util.List;

public class Orders {


    List<Order> orders = new ArrayList<Order>();


    public Orders() {
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
