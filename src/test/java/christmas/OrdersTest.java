package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    private Orders orders;

    @BeforeEach
    void setup() {
        List<Order> orderList = Arrays.asList(
                new Order(Menu.MUSHROOM_SOUP, 2),
                new Order(Menu.BBQ_RIBS, 1)
        );
        orders = new Orders(orderList);
    }

    @Test
    void testGetOrders() {
        List<Order> retrievedOrders = orders.getOrders();
        assertNotSame(orders, retrievedOrders);
        assertEquals(2, retrievedOrders.size());
    }

    @Test
    void testCalculateTotalAmount() {
        int total = orders.calculateTotalAmount();
        int expectedTotal = Menu.MUSHROOM_SOUP.getPrice() * 2 + Menu.BBQ_RIBS.getPrice() * 1;
        assertEquals(expectedTotal, total);
    }

    @Test
    void testUnmodifiableOrdersList() {
        assertThrows(UnsupportedOperationException.class, () -> {
            orders.getOrders().add(new Order(Menu.CHOCOLATE_CAKE, 1));
        });
    }
}
