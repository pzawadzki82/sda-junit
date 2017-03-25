package pl.sda.order;

import java.math.BigDecimal;

/**
 * Created by pzawa on 25.03.2017.
 */
public class OrderItem {
    public final String name;
    public final int quantity;
    public final BigDecimal price;

    public OrderItem(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
