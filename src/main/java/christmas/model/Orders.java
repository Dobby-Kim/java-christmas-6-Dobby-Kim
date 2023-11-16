package christmas.model;

import java.util.Collections;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public int calculateTotalAmount() {
        return orders.stream()
                .mapToInt(order -> order.getMenu().getPrice() * order.getQuantity())
                .sum();
    }

    public int calculateTotalQuantity() {
        return orders.stream()
                .mapToInt(Order::getQuantity)
                .sum();
    }
}
