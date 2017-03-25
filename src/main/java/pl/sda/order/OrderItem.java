package pl.sda.order;

import pl.sda.item.ItemType;

import java.math.BigDecimal;

/**
 * Created by pzawa on 25.03.2017.
 */
public class OrderItem {
    public final String name;
    public final ItemType itemType;
    public final int quantity;
    public final BigDecimal price;

    public OrderItem(String name, ItemType itemType, int quantity, BigDecimal price) {
        this.name = name;
        this.itemType = itemType;
        this.quantity = quantity;
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
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
