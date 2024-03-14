package models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private String cartItemId;
    private Product product;
    private Integer quantity;


}
