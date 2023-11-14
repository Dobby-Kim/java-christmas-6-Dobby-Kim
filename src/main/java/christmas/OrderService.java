package christmas;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static Orders createOrders(String[] orderInputs) {
        List<Order> orders = new ArrayList<>();

        for (String orderInput : orderInputs) {
            String[] parts = orderInput.trim().split("-");
            String menuName = parts[0].trim();

            Menu menu = Menu.fromString(menuName);
            int quantity = Integer.parseInt(parts[1].trim());

            orders.add(new Order(menu, quantity));
        }
        return new Orders(orders);
    }

    public static Orders readUserInputAndCreateOrders() {
        String[] userOrderInput = InputView.readOrderInputs();
        return createOrders(userOrderInput);
    }
}

