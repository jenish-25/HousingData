package com.example.housing.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HouseMinSalePrice {
    private String location;
    private double minSalePrice;
}
