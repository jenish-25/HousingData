package com.example.housing.Service;

import com.example.housing.Model.AvgSalePriceByLocation;
import com.example.housing.Model.HouseMaxSalePrice;
import com.example.housing.Model.HousingData;
import com.example.housing.Repository.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HousingService {

    @Autowired
    HousingRepository housingRepository;

    public List<HousingData> saveData(List<HousingData> housingDataList) {
        return housingRepository.saveAll(housingDataList);
    }

    public double average() {
        List<HousingData> housingData1=housingRepository.findAll();
        double sum=0;
        for(HousingData h: housingData1){
            sum+=h.getSalePrice();
        }
        return sum/housingData1.size();
    }

    public HashMap<String, Double> getAvgByLocation() {
        List<HousingData> housingDataList=housingRepository.findAll();
        HashMap<String,Double> avgPriceByLocation=new HashMap<>();
        HashMap<String,Integer> count=new HashMap<>();
        for (HousingData h: housingDataList){
            double salePrice =h.getSalePrice();
            if(!avgPriceByLocation.containsKey(h.getLocation())){
                avgPriceByLocation.put(h.getLocation(),salePrice);
            }
            else{
                avgPriceByLocation.put(h.getLocation(),salePrice+avgPriceByLocation.get(h.getLocation()));
            }
            if(!count.containsKey(h.getLocation())){
                count.put(h.getLocation(),1);
            }
            else{
                count.put(h.getLocation(),count.get(h.getLocation())+1);
            }
        }
        for (Map.Entry<String,Double> e:avgPriceByLocation.entrySet()){
            avgPriceByLocation.put(e.getKey(),e.getValue()/count.get(e.getKey()));
        }
        return avgPriceByLocation;
    }

    public double maxSalePrice() {
        List<HousingData> housingData=housingRepository.findAll();
        double max=Double.MIN_VALUE;
        for (HousingData h: housingData){
            if(h.getSalePrice()>max){
                max=h.getSalePrice();
            }
        }
        return max;
    }

    public double minSalePrice() {
        List<HousingData> housingData=housingRepository.findAll();
        double min=Double.MAX_VALUE;
        for (HousingData h: housingData){
            if(h.getSalePrice()<min){
                min=h.getSalePrice();
            }
        }
        return min;
    }
    public double QAvgSalePrice() {
        return housingRepository.getAvgSaleReport();
    }

    public List<AvgSalePriceByLocation> QAvgSalePriceByLocation() {
        List<Object []> list=housingRepository.QAvgSalePriceByLocation();
        List<AvgSalePriceByLocation> avgSalePriceByLocations=new ArrayList<>();
        for(Object[] obj: list){
            avgSalePriceByLocations.add(AvgSalePriceByLocation.builder().location((String) obj[0]).avgSalePrice((Double) obj[1]).build());
        }
        return avgSalePriceByLocations;
    }

    public List<HouseMaxSalePrice> QMaxSalePrice() {
        List<Object[]> list=housingRepository.qMaxSalePrice();
        List<HouseMaxSalePrice> maxSalePrices=new ArrayList<>();
        for (Object[] obj:list){
            maxSalePrices.add(HouseMaxSalePrice.builder().location((String) obj[0]).maxSalePrice((Double)obj[1]).build());
        }
        return maxSalePrices;
    }
    public List<HouseMaxSalePrice> QMinSalePrice() {
        List<Object[]> list=housingRepository.qMinSalePrice();
        List<HouseMaxSalePrice> minSalePrices=new ArrayList<>();
        for (Object[] obj:list){
            minSalePrices.add(HouseMaxSalePrice.builder().location((String) obj[0]).maxSalePrice((Double)obj[1]).build());
        }
        return minSalePrices;
    }

}
