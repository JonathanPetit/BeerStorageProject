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

<<<<<<< HEAD
  public ArrayList<BrandBeer> getBrandList() {
=======
  public ArrayList<Brand> getBrandList() {
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
    return brandsList;
  }

  // Function to remove a brand into the brandList of a brewer.
  public void addBrand(Brand brand){
    this.brandsList.add(brand);
  }

<<<<<<< HEAD
<<<<<<< HEAD
  public void RemoveBrand(BrandBeer brand) {this.brandsList.remove(brand);}


=======
  public void RemoveBrand(Brand brand) {this.brandsList.remove(brand);}

<<<<<<< HEAD
  public String beautifulString() {
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
    return String.format("%20s%20s%20s%20s",
            this.name, this.address, this.number,brandsString);
  }
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
  @Override
  public String toString(){
    String toString = "{";
    toString += "\"name\": \""+this.name;
    toString += "\", \"address\": \""+this.address;
    toString += "\", \"number\": \""+this.number;
    toString += "\", \"brandsList\": [";
<<<<<<< HEAD
    ArrayList<BrandBeer> brandBeers = this.brandsList;
    for (BrandBeer brandBeer:brandBeers){
=======
    ArrayList<Brand> brandBeers = this.brandsList;
    for (Brand brandBeer:brandBeers){
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
      // First possibility: add brandBeer to string (so with all data)
      // toString += brandBeer.toString();
      // Other possibility: just add brandBeer name
      toString = toString.concat("\""+brandBeer.getName()+"\"");
      if (brandBeer != brandBeers.get(brandBeers.size()-1)){
        toString += ",";
=======
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
>>>>>>> a47aa3b60271dacf72c4cbebe1e2e79fb3d184e3
      }
      return String.format("%20s%20s%20s",
              this.name, this.address,brandsString);
  }
<<<<<<< HEAD


=======
  // Function to remove a brand into the brandList of a brewer.
  public void RemoveBrand(Brand brand) {this.brandsList.remove(brand);}

>>>>>>> 404ff1be70dbcc0279071ef4f017b73e2b69c41c
=======
>>>>>>> a47aa3b60271dacf72c4cbebe1e2e79fb3d184e3
}