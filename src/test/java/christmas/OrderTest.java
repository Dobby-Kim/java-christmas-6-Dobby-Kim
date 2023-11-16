package christmas;

import christmas.enums.Menu;
import christmas.model.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class OrderTest {

    @Test
    void testValidOrder() {
        Order order = new Order(Menu.MUSHROOM_SOUP, 2);
        assertEquals(Menu.MUSHROOM_SOUP, order.getMenu());
        assertEquals(2, order.getQuantity());
    }

    @Test
    void testInvalidOrder() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order(Menu.BBQ_RIBS, 0);
        });
    }
}
