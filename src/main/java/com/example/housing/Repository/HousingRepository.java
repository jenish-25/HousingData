package com.example.housing.Repository;

import com.example.housing.Model.HousingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousingRepository  extends JpaRepository<HousingData,Long> {
    @Query(value = "select AVG(sale_price) from housing_data;",nativeQuery = true)
    double getAvgSaleReport();

    @Query(value = "select location as location , avg(sale_Price) as averageSalePrice from Housing_data group by location",nativeQuery = true)
    List<Object[]> QAvgSalePriceByLocation();

    @Query(value = "select location as location , MAX(sale_price) as maxSalePrice from housing_data group by location ",nativeQuery = true)
    List<Object[]> qMaxSalePrice();
    @Query(value = "select location as location , MIN(sale_price) as maxSalePrice from housing_data group by location ",nativeQuery = true)
    List<Object[]> qMinSalePrice();
}
