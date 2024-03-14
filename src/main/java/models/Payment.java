package models;

import enums.PaymentStatus;
import enums.PaymentType;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private String paymentId;
    private Order order;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private BigDecimal amountPaid;
}
