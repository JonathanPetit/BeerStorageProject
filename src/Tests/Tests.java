import com.company.Json.JsonRead;
import com.company.Json.JsonWrite;
import com.company.controller.Controller;
import org.junit.Assert;
import org.junit.Test;
import com.company.model.Brewer;
import com.company.model.Brand;
import com.company.model.Beer;
import com.company.model.Brewer;
import com.company.model.Brand;
import com.company.controller.Controller;
import com.company.model.Inventory;
import com.company.model.Function;
import com.company.views.View;
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
        beer.setPrice(3.5);
        Assert.assertEquals(3.5,beer.getPrice(),0.001);

        Assert.assertEquals(5,beer.getEvaluation(),0.001);
        beer.setEvaluation(3.0);
        Assert.assertEquals(3.0,beer.getEvaluation(),0.001);
        Assert.assertEquals("Should be good","                 Jup                " +
                "Pils                 6.0                50.0                 3.5                 " +
                "3.0",beer.beautifulString());
    }
    @Test
    public void BrewerTest(){
        Brewer brewer = new Brewer("InBev","There","69");
        Assert.assertEquals("Should be InBev","InBev",brewer.getName());
        Assert.assertEquals("Should be There","There",brewer.getAddress());
        brewer.setAddress("NotThere");
        Assert.assertEquals("Should be NotThere","NotThere",brewer.getAddress());
        Assert.assertEquals("Should be 69","69",brewer.getNumber());
        brewer.setNumber("0");
        Assert.assertEquals("Should be 0","0",brewer.getNumber());
        Assert.assertEquals("Should be 0",0,brewer.getBrandList().size());
        Assert.assertEquals("Should be a long string","               " +
                "InBev            NotThere                   0" +
                "                    ",brewer.beautifulString());
        Brand brand = new Brand("Pechmel","Here","30");
        brewer.addBrand(brand);
        Assert.assertEquals("Should be 1", 1, brewer.getBrandsList().size());
        brewer.RemoveBrand(brand);
        Assert.assertEquals("Should be 0", 0, brewer.getBrandsList().size());

    }
    @Test
    public void BrandTest(){
        Brand brand = new Brand("Pechmel","Here","69");
        Assert.assertEquals("Should be PechMel","Pechmel",brand.getName());
        Assert.assertEquals("Should be Here","Here",brand.getAddress());
        brand.setAddress("NotHere");
        Assert.assertEquals("Should be NotHere","NotHere",brand.getAddress());
        Assert.assertEquals("Should be 69","69",brand.getNumber());
        brand.setNumber("0");
        Assert.assertEquals("Should be 0","0",brand.getNumber());
        Assert.assertEquals("should be ","             Pechmel             NotHere  " +
                "                 0                    ",brand.beautifulString());
        Beer beer= new Beer("Jup","Pils",6,50,2.5,5);
        Assert.assertEquals("Should be 0",0,brand.getBeersList().size());

        brand.addBeer(beer);
        Assert.assertEquals("Should be 1", 1, brand.getBeersList().size());
        brand.removeBeer(beer);
        Assert.assertEquals("Should be 0", 0, brand.getBeersList().size());


    }
    @Test
    public void JsonTest(){
        // Test jsonRead
        Controller controller= Controller.getInstance();
        JsonRead json = new JsonRead();
        List<Object> out = json.readFile("Brewer");
        int size = out.size();
        Assert.assertEquals("should be 1", size, out.size());
        JsonWrite wjson = new JsonWrite();

        ArrayList<Object> brewers = new ArrayList<Object>();
        Brewer brewer = new Brewer("Bush", "LLN");
        brewers.add(brewer);
        wjson.writeFile("Brewer", brewers, controller.getParamsBrewer());

        // Test Add Object to json
        out = json.readFile("Brewer");
        Assert.assertEquals("should be 2", size+1, out.size());
        Brewer brewer2 = new Brewer("Bush","LLN");
        ArrayList<Object> brewers2 = new ArrayList<Object>();
        brewers.add(brewer2);
        wjson.writeFile("Brewer", brewers2, controller.getParamsBrewer());

        // Test getByArgs
        Assert.assertEquals("should be 2",size+1, out.size());
        List<Object> brands = json.getByArg("Brand", "address", "BrandAddress");
        Assert.assertEquals("should be 1",1, brands.size());
        Object brandstest = json.getByName("Brand", "OtherBrandBeer");
        Assert.assertEquals("should be 1", 1, brands.size());

    }
    @Test
    public void ControllerTests(){

        Controller controller = Controller.getInstance();

        //Test Singleton
        try {
            Controller controller2 = Controller.getInstance();

        } catch (Exception e) {
            Assert.fail();
        }

        //Test addCommand
        ArrayList<String> params = new ArrayList<>();
        params.add("-b");
        params.add("-c");
        controller.addCommands("test", params);
        Assert.assertEquals("should be params",
                params,controller.getCommandsList().get("test"));

        //Test parseCommand
        ArrayList<String> parsed = controller.parseCommand("test -b -c");
        Assert.assertEquals("shoud be 3", 3,parsed.size());
        Assert.assertEquals("should be 'test'", "-b",parsed.get(1));
    }
    @Test
    public void InventoryTest(){
        Inventory inv= new Inventory();
        Brewer brewer = new Brewer("InBev","There","69");
        inv.addBrewer(brewer);
        ArrayList<Brewer> brewerlist= inv.getBrewersList();
        Assert.assertEquals("should be good",brewer,brewerlist.get(0));
    }

}
