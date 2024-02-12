package com.example.housing.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AvgSalePriceByLocation {
    private String location;
    private double avgSalePrice;
}
