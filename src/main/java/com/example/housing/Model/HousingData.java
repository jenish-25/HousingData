package com.example.housing.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class HousingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long HouseNum;
    private int bedroooms;
    private float bathroooms;
    private float squareFootage;
    private String location;
    private double salePrice;
}
