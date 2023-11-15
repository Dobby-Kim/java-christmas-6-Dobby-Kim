package christmas.util;

import christmas.enums.Menu;
import christmas.model.Order;
import christmas.model.Orders;
import christmas.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class OrderUtil {


    private static Orders createOrders(String[] orderInputs) {
        List<Order> orders = new ArrayList<>();

        for (String orderInput : orderInputs) {
            String[] parts = orderInput.trim().split(Constant.MENU_AMOUNT_PARSER);
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

