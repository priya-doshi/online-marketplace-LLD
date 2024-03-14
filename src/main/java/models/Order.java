package models;

import enums.OrderStatus;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private User user;
    private Cart cart;
    private Date orderDate;
    private OrderStatus orderStatus;


}
