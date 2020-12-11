import Elements.*;
import com.company.TerrainMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class StreamApiTest {
    private TerrainMap map;

    @Before
    public void init() {
        map = new TerrainMap(5);
        map.addElementToMap(new SchoolElement(1, 1, Element.TypeOfElement.SHOP, "School1", 333));
        map.addElementToMap(new SchoolElement(1, 2, Element.TypeOfElement.SHOP, "School2", 333));
        map.addElementToMap(new SchoolElement(1, 3, Element.TypeOfElement.SHOP, "School3", 222));

        map.addElementToMap(new CafeElement(0, 1, Element.TypeOfElement.CAFE, "Cafe1", 300));
        map.addElementToMap(new CafeElement(0, 2, Element.TypeOfElement.CAFE, "Cafe2", 100));
        map.addElementToMap(new CafeElement(0, 3, Element.TypeOfElement.CAFE, "Cafe3", 500));

        map.addElementToMap(new HospitalElement(2, 1, Element.TypeOfElement.HOSPITAL, "Hospital1", 222));
        map.addElementToMap(new HospitalElement(2, 2, Element.TypeOfElement.HOSPITAL, "Hospital2", 111));
        map.addElementToMap(new HospitalElement(2, 3, Element.TypeOfElement.HOSPITAL, "Hospital3", 143));

        map.addElementToMap(new HouseElement(3, 1, Element.TypeOfElement.HOUSE, "House1", 112));
        map.addElementToMap(new HouseElement(3, 2, Element.TypeOfElement.HOUSE, "House2", 231));
        map.addElementToMap(new HouseElement(3, 3, Element.TypeOfElement.HOUSE, "House3", 121));

    }
    @Test
    public void getCafePriceSum_IsSumCorrect_True() {
        //GIVEN
        float expected = 900;

        //WHEN
        float actual = map.getCafePriceSum();

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getMaxPrice_IsMaxCorrect_True() {
        //GIVEN
        double expected = 500;

        //WHEN

        float actual = map.getMaxPrice();
        System.out.println(actual);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getAveragePrice_IsAverageCorrect_True() {
        //GIVEN
        double expected = 227.3333282470703;

        //WHEN

        float actual = map.getAveragePrice();
        System.out.println(actual);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }



}
