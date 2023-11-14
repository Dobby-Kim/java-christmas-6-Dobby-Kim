package christmas;


public class Order {
    private final Menu menu;
    private final int quantity;

    public Order(Menu menu, int quantity) {
        this.menu = menu;

        validator(quantity);
        this.quantity = quantity;
    }

    private void validator(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException(ErrorMessage.formatErrorMessage("주문"));
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
