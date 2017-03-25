package pl.sda.order;

import pl.sda.transport.TransportType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pzawa on 25.03.2017.
 */
public class Order {
    private int orderNo;
    private TransportType transportType;

    private List<OrderItem> orderItems = new ArrayList<>();


    public Order(int orderNo, TransportType transportType) {
        this.orderNo = orderNo;
        this.transportType = transportType;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public BigDecimal getTotalPrice(){
        //TODO
        return BigDecimal.ZERO;
    }
}
