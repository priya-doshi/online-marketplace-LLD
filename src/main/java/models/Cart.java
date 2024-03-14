package models;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private String cartId;
    private User user;
    private Map<String, CartItem> cartItems;
    private BigDecimal cartTotal;


}

