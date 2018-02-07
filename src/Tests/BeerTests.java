import com.company.Json.JsonRead;
import com.company.Json.JsonWrite;
import org.junit.Assert;
import org.junit.Test;
import com.company.model.Brewer;
import com.company.model.Brand;
import com.company.model.Beer;
import com.company.model.Brewer;
import com.company.model.Brand;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class BeerTests
{
    @Test
    public void BeerTest(){
        Beer beer =new Beer("Jup","Pils",6,50,2.5,5);
        Assert.assertEquals("Should be Jup","Jup",beer.getName());
        Assert.assertEquals("Should be Pils","Pils",beer.getType());
        Assert.assertEquals(6,beer.getDegree(),0.001);
        Assert.assertEquals(50,beer.getConditioning(),0.001);
        Assert.assertEquals(2.5,beer.getPrice(),0.001);
        Assert.assertEquals(5,beer.getEvaluation(),0.001);
    }
    @Test
    public void BrewerTest(){
        Brewer brewer = new Brewer("InBev","There");
        Assert.assertEquals("Should be InBev","InBev",brewer.getName());
        Assert.assertEquals("Should be There","There",brewer.getAddress());
        Assert.assertEquals("Should be 0",0,brewer.getBrandList().size());
        Brand brand = new Brand("Pechmel","Here");
        brewer.addBrand(brand);
        Assert.assertEquals("Should be 1",1,brewer.getBrandList().size());
        brewer.RemoveBrand(brand);
        Assert.assertEquals("Should be 0",0,brewer.getBrandList().size());

    }
    @Test
    public void BrandTest(){
        Brand brand = new Brand("Pechmel","Here");
        Assert.assertEquals("Should be PechMel","Pechmel",brand.getName());
        Assert.assertEquals("Should be Here","Here",brand.getAddress());
        Beer beer= new Beer("Jup","Pils",6,50,2.5,5);
        Assert.assertEquals("Should be 0",0,brand.getBeersList().size());
        brand.addBeer(beer);
        Assert.assertEquals("Should be 1",1,brand.getBeersList().size());
        brand.removeBeer(beer);
        Assert.assertEquals("Should be 0",0,brand.getBeersList().size());


    }
}
