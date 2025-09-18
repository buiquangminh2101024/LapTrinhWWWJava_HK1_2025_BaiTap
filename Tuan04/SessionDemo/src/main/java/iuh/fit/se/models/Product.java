package iuh.fit.se.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String model;
    private String description;
    private int quantity;
    private double price;
    private String imgURL;

    public Product(String model, String description, int quantity, double price, String imgURL) {
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.imgURL = imgURL;
    }
}
