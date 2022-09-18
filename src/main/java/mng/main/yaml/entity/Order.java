package mng.main.yaml.entity;

import java.util.Date;
import java.util.List;


public class Order {

    private String id;
    private String orderNo;
    private Date date;
    private List<OrderItem> orderItems;

    public Order(String id, String orderNo, Date date, List<OrderItem> orderItems) {
        this.id = id;
        this.orderNo = orderNo;
        this.date = date;
        this.orderItems = orderItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
