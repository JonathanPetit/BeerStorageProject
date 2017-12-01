package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Brouwer {
  private String name;
  private List<BrandBeer> brandList;

  public String GetName(){return name;}
  public List<BrandBeer> GetBrandList(){return brandList;}

  public void SetName(String name){this.name = name;}
  public void SetBrandList(List<BrandBeer> brandList){this.brandList = brandList;}

  public Brouwer(String name){
    SetName(name);

    List<BrandBeer> brandList = new LinkedList<BrandBeer>();
    SetBrandList(brandList);
  }

  public void AddBrand(BrandBeer brand){
    // Add a beer of the brand represented by the object BrandBeer
    List<BrandBeer> updatedBrandList = this.GetBrandList();
    updatedBrandList.add(brand);

    SetBrandList(updatedBrandList);
  }

  public String BrandBeerList2String(String sep) {
    List<BrandBeer> brandBeerList = this.GetBrandList();
    String listStringed = brandBeerList.stream().map(BrandBeer::GetName).collect(Collectors.joining(sep));
    return listStringed;
  }

}