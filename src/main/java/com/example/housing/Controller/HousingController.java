package com.example.housing.Controller;

import com.example.housing.Model.AvgSalePriceByLocation;
import com.example.housing.Model.HouseMaxSalePrice;
import com.example.housing.Model.HousingData;
import com.example.housing.Service.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("housing")
public class HousingController {

    @Autowired
    HousingService housingService;


    //we can add house data using HousingData entity
    @PostMapping("add")
    public List<HousingData> saveData(@RequestBody List<HousingData> housingDataList){
        return housingService.saveData(housingDataList);
    }

    //sum all the salPrice and get average of it
    @GetMapping("average")
    public double average(){
        return housingService.average();
    }

    //pr location exa.= surat's all salePrice add and then avg it.
//            "kapodra": 17000.0,
//            "rajkot": 17000.0,
//            "surat": 16500.0,
//            "sayan": 1000.0,
//            "amroli": 15000.0
    @GetMapping("avg-per-location")
    public HashMap<String,Double> getAvgByLocation(){
        return housingService.getAvgByLocation();
    }

    //return the max sale price of all the data
    @GetMapping("maxSalePrice")
    public double maxSalePrice(){
        return housingService.maxSalePrice();
    }
    //return the min sale price of all the data
    @GetMapping("minSalePrice")
    public double minSalePrice(){
        return housingService.minSalePrice();
    }

    //
    @GetMapping("QAvg")
    public double QAvgSalePrice(){
        return housingService.QAvgSalePrice();
    }

    @GetMapping("QAvgSaleByLocation")
    public List<AvgSalePriceByLocation> QavgSalePriceByLocation(){
        return housingService.QAvgSalePriceByLocation();
    }

    @GetMapping("Qmax")
    public List<HouseMaxSalePrice> QmaxSalePrice(){
        return housingService.QMaxSalePrice();
    }
    @GetMapping("Qmin")
    public List<HouseMaxSalePrice> QminSalePrice(){
        return housingService.QMinSalePrice();
    }
}
