package com.example.housing.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HouseMaxSalePrice {
    private String location;
    private double maxSalePrice;
}
