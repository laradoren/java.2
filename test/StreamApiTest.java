
import Elements.*;
import com.company.TerrainMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class StreamApiTest {
    private TerrainMap map, map1;
    public List<ShopElement> shopElements;

    @Before
    public void init() {
        map = new TerrainMap(5);
        map.addElementToMap(new SchoolElement(1, 1, Element.TypeOfElement.SCHOOL, "School1", 333));
        map.addElementToMap(new SchoolElement(1, 2, Element.TypeOfElement.SCHOOL, "School2", 333));
        map.addElementToMap(new SchoolElement(1, 3, Element.TypeOfElement.SCHOOL, "School3", 222));

        map.addElementToMap(new CafeElement(0, 1, Element.TypeOfElement.CAFE, "Cafe1", 300));
        map.addElementToMap(new CafeElement(0, 2, Element.TypeOfElement.CAFE, "Cafe2", 100));
        map.addElementToMap(new CafeElement(0, 3, Element.TypeOfElement.CAFE, "Cafe3", 500));

        map.addElementToMap(new HospitalElement(2, 1, Element.TypeOfElement.HOSPITAL, "Hospital1", 222));
        map.addElementToMap(new HospitalElement(2, 2, Element.TypeOfElement.HOSPITAL, "Hospital2", 111));
        map.addElementToMap(new HospitalElement(2, 3, Element.TypeOfElement.HOSPITAL, "Hospital3", 143));

        map.addElementToMap(new HouseElement(3, 1, Element.TypeOfElement.HOUSE, "House1", 112));
        map.addElementToMap(new HouseElement(3, 2, Element.TypeOfElement.HOUSE, "House2", 231));
        map.addElementToMap(new HouseElement(3, 3, Element.TypeOfElement.HOUSE, "House3", 121));

        map.addElementToMap(new ShopElement(1, 1, Element.TypeOfElement.SHOP, "Shop1", 333));
        map.addElementToMap(new ShopElement(1, 2, Element.TypeOfElement.SHOP, "Shop2", 333));
        map.addElementToMap(new ShopElement(1, 3, Element.TypeOfElement.SHOP, "Shop3", 433));
        map.addElementToMap(new ShopElement(1, 4, Element.TypeOfElement.SHOP, "Shop4", 533));
        map.addElementToMap(new ShopElement(1, 5, Element.TypeOfElement.SHOP, "Shop5", 633));
        map.addElementToMap(new ShopElement(0, 1, Element.TypeOfElement.SHOP, "Shop6", 733));

        map1 = new TerrainMap(5);
        map1.addElementToMap(new HospitalElement(2, 1, Element.TypeOfElement.HOSPITAL, "Hospital1", 222));
        map1.addElementToMap(new HospitalElement(2, 2, Element.TypeOfElement.HOSPITAL, "Hospital2", 111));
        map1.addElementToMap(new HospitalElement(2, 3, Element.TypeOfElement.HOSPITAL, "Hospital3", 143));
        map1.addElementToMap(new HospitalElement(0, 1, Element.TypeOfElement.HOSPITAL, "Hospital4", 222));
        map1.addElementToMap(new HospitalElement(0, 2, Element.TypeOfElement.HOSPITAL, "Hospital5", 111));
        map1.addElementToMap(new HospitalElement(0, 3, Element.TypeOfElement.HOSPITAL, "Hospital6", 143));

        shopElements = new ArrayList<>();
        shopElements.add(new ShopElement(1, 1, Element.TypeOfElement.SHOP, "Shop1", 333));
        shopElements.add(new ShopElement(1, 2, Element.TypeOfElement.SHOP, "Shop2", 433));
        shopElements.add(new ShopElement(1, 3, Element.TypeOfElement.SHOP, "Shop3", 533));


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
        double expected = 733.0;

        //WHEN

        float actual = map.getMaxPrice();
        System.out.println(actual);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getAveragePrice_IsAverageCorrect_True() {
        //GIVEN
        double expected = 318.1111145019531;

        //WHEN

        float actual = map.getAveragePrice();
        System.out.println(actual);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getGroupByTypeOfUpperClothesAndPrice_isFilterCorrect_True() {
        //GIVEN
        Map<Boolean, List<ShopElement>> expected = new HashMap<>();
        expected.put(Boolean.TRUE, Arrays.asList(shopElements.get(0), shopElements.get(1), shopElements.get(2)));
        expected.put(Boolean.FALSE, Arrays.asList());

        //WHEN
        Map<Boolean, List<ShopElement>> actual;
        actual = TerrainMap.getGroupByCondition(shopElements,p -> p.getElement().equals(Element.TypeOfElement.SHOP) &&
                p.getPrice()>100);

        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMostPopularTypeOfUpperCloth_IsPopularCorrect_True() {
        //GIVEN
        List<TerrainMap> mapList = Arrays.asList(map, map1);
        List<String> expected = Arrays.asList("Hospital", "Shop");

        //WHEN
        List<String> actual = TerrainMap.getMostFrequentElement(mapList);

        //THEN
        Assert.assertEquals(actual, expected);
    }


}
