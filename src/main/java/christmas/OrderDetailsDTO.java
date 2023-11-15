package christmas;

import java.util.List;
import java.util.Map;

public class OrderDetailsDTO {

    private final Date date;
    private final List<OrderDTO> orderDTOs;
    private final Map<String, Integer> discountDetails;
    private final int totalAmount;
    private final int totalDiscount;
    private final int totalBenefit;
    private final EventBadge eventBadge;
    private final boolean isChampagneGiftIncluded;

    public OrderDetailsDTO(Date date, List<OrderDTO> orderDTOs, Map<String, Integer> discountDetails,
                           int totalAmount, int totalDiscount, int totalBenefit, EventBadge eventBadge,
                           boolean isChampagneGiftIncluded) {
        this.date = date;
        this.orderDTOs = orderDTOs;
        this.discountDetails = discountDetails;
        this.totalAmount = totalAmount;
        this.totalDiscount = totalDiscount;
        this.totalBenefit = totalBenefit;
        this.eventBadge = eventBadge;
        this.isChampagneGiftIncluded = isChampagneGiftIncluded;
    }


    public Date getDate() {
        return date;
    }

    public List<OrderDTO> getOrderDTOs() {
        return orderDTOs;
    }

    public Map<String, Integer> getDiscountDetails() {
        return discountDetails;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public int getFinalAmount() {
        return totalAmount - totalDiscount;
    }

    public EventBadge getEventBadge() {
        return eventBadge;
    }

    public boolean isChampagneGiftIncluded() {
        return isChampagneGiftIncluded;
    }


    public int getTotalBenefit() {
        return totalBenefit;
    }
}
