package com.company.model;

import java.util.ArrayList;

public class Brewer {
  private String name;
  private String address;
  private ArrayList<Brand> brandsList;

  public Brewer(String name, String address) {
    this.name = name;
    this.address = address;
    this.brandsList = new ArrayList<>();
  }

  // Getters and setters
  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public ArrayList<String> getBrandsList() {
    ArrayList<String> names = new ArrayList<String>();
    for (int i = 0; i < brandsList.size(); i++) {
      names.add(brandsList.get(i).getName());
    }
    return names;
  }

  public ArrayList<Brand> getBrandList() {
    return brandsList;
  }

  // Function to remove a brand into the brandList of a brewer.
  public void addBrand(Brand brand){
    this.brandsList.add(brand);
  }

  // Function to remove a brand into the brandList of a brewer.
  public void RemoveBrand(Brand brand) {this.brandsList.remove(brand);}

  @Override
  public String toString(){
      ArrayList<Brand> brands = this.brandsList;
      String brandsString = "";
      for (Brand brand:brands) {
          // First possibility: add beer to string (with all data)
          //toString += beer.toString();
          //Other possibility: just add beer name
          brandsString = brandsString.concat(brand.getName());
          if (brand != brands.get(brands.size() - 1)) {
              brandsString += ", ";
          }
      }
      return String.format("%20s%20s%20s",
              this.name, this.address,brandsString);
  }
}