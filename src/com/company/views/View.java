package com.company.views;
import com.company.model.*;


import java.util.Collections;
import java.util.List;


public class View {
  private List<Object> listing;
  private List<Object> GetListing(){return listing;}


<<<<<<< HEAD
    public View(List<Brewer> list_from_db){
        //Begin with a A to Z sorting
        //  Collections.sort(list_from_db);
        this.listing = list_from_db;
    }

    //Display inventory with a A to Z sorting methode
    public void atoz() {
        //  this.GetListing().forEach(item->display_Brewer(item));
    }

    //Display inventory with a Z to A sorting methode
    public void ztoa() {
        List<Brewer>list = GetListing();
        Collections.reverse(list);
        //  list.forEach(item->display_Brewer(item));
=======
  public View(List<Object> list_from_db){
    //Begin with a A to Z sorting

    //  Collections.sort(list_from_db);
    this.listing = list_from_db;
  }

  //Display inventory with a A to Z sorting methode
  public void atoz() {
    String entete = null;
    String text = "";
    for (Object item:listing){
      String objectType = item.getClass().toString();
      if (objectType.contains("Brand")) {
        if (entete == null) {
          entete = String.format("%20s%20s%20s%20s","Name","Address","Number","BeersList");
        }
        Brand brandBeer = (Brand) item;
        text = text.concat(brandBeer.beautifulString()+"\n");
      }
      else if (objectType.contains("Beer")){
        if (entete == null){
          entete = String.format("%20s%20s%20s%20s%20s%20s","Name","type","Degree","Conditioning",
                  "Price", "Evaluation");
          //String name, String type, double degree, double conditioning, double price,
          //                   double evaluation
        }
        Beer beer = (Beer) item;
        text = text.concat(beer.beautifulString()+"\n");
      }
      else if (objectType.contains("Brewer")){
        if (entete == null){
          entete = String.format("%20s%20s%20s%20s","Name","Address","Number","BrandsList");
        }
        Brewer brewer = (Brewer) item;
        text = text.concat(brewer.beautifulString()+"\n");
      }
      else {
        System.out.println("none");
      }
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
    }
    System.out.println(entete);
    System.out.println(text);
  }

  //Display inventory with a Z to A sorting methode
  public void ztoa() {
    List<Object>list = GetListing();
    Collections.reverse(list);
    //  list.forEach(item->display_Brewer(item));
  }


<<<<<<< HEAD
    //Check if we find a query in inventory and display the Brewer where he find it.
    /*
    public void search(String query)
    {
        for(Brewer b : this.GetListing()) {
            if (b.GetName() != null && b.GetName().contains(query)) {
               display_Brewer(b);
            }
            else {
                for(BrandBeer beer : b.GetBrandList()) {
                    if (beer.GetName() != null && beer.GetName().contains(query)) {
                        display_Brewer(b);
                    }
                    else{
                        for (ModelBeer model : beer.GetModelList())
                            if (model.GetModel() != null &&model.GetModel().contains(query)) {
                                display_Brewer(b);
                            }
                    }
=======
  //Check if we find a query in inventory and display the Brewer where he find it.
  /*
  public void search(String query)
  {
    for(Brewer b : this.GetListing()) {
      if (b.GetName() != null && b.GetName().contains(query)) {
         display_Brewer(b);
      }
      else {
        for(BrandBeer beer : b.GetBrandList()) {
          if (beer.GetName() != null && beer.GetName().contains(query)) {
            display_Brewer(b);
          }
          else{
            for (ModelBeer model : beer.GetModelList()){
              if (model.GetModel() != null &&model.GetModel().contains(query)) {
                  display_Brewer(b);
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
                }
          }
        }
      }
    }
  }


<<<<<<< HEAD
    //Display method
    private void display_Brewer(Brewer b){
        System.out.println("");
        System.out.println("Brewer :  "+b.GetName());
        for(BrandBeer Beer : b.GetBrandList()) {
            System.out.println("  Brand : "+Beer.GetName()+":");
            for(ModelBeer Model : Beer.GetModelList()){
                System.out.println("   -> "+Model.GetModel());
            }
        }
        System.out.println("");
        System.out.println("---------------------------------------------");
    }
    */
=======
  //Display method
  private void display_Brewer(Brewer b){
      System.out.println("");
      System.out.println("Brewer :  "+b.GetName());
      for(BrandBeer Beer : b.GetBrandList()) {
          System.out.println("  Brand : "+Beer.GetName()+":");
          for(ModelBeer Model : Beer.GetModelList()){
              System.out.println("   -> "+Model.GetModel());
          }
      }
      System.out.println("");
      System.out.println("---------------------------------------------");
  }
  */
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
}