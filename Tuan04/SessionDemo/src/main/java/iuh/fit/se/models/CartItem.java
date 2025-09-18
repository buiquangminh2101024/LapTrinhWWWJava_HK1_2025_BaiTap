package iuh.fit.se.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItem {
    private int partNumber;
    private String modelDescription;
    private double unitCost;
    private int quantity;
    private double totalCost;
}
