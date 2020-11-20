import Elements.*;
import com.company.Location;
import com.company.TerrainMap;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapTest {
    @Test
    public void isEqualsSchools_SchoolsIsEquals_True() {
        SchoolElement school1 = new SchoolElement(1, 3, Element.TypeOfElement.SCHOOL, "School");
        SchoolElement school2 = new SchoolElement(1, 3, Element.TypeOfElement.SCHOOL, "School");
        Assert.assertTrue(school1.equals(school2) && school2.equals(school1));
        school1.print();
    }

    @Test
    public void isEqualsCafes_CafesIsEquals_True() {
        CafeElement cafeElement1 = new CafeElement(2, 6, Element.TypeOfElement.CAFE, "Cafe");
        CafeElement cafeElement2 = new CafeElement(2, 6, Element.TypeOfElement.CAFE, "Cafe");
        Assert.assertTrue(cafeElement1.equals(cafeElement2) && cafeElement2.equals(cafeElement1));
        cafeElement1.print();
    }

    @Test
    public void isEqualsHospitals_HospitalsIsEquals_True() {
        HospitalElement hospitalElement1 = new HospitalElement(2, 6, Element.TypeOfElement.HOSPITAL, "Hospital");
        HospitalElement hospitalElement2 = new HospitalElement(2, 6, Element.TypeOfElement.HOSPITAL, "Hospital");
        Assert.assertTrue(hospitalElement1.equals(hospitalElement2) && hospitalElement2.equals(hospitalElement1));
        hospitalElement1.print();
    }

    @Test
    public void isEqualsHouses_HousesIsEquals_True() {
        HouseElement houseElement1 = new HouseElement(3, 1, Element.TypeOfElement.HOUSE, "House");
        HouseElement houseElement2 = new HouseElement(3, 1, Element.TypeOfElement.HOUSE, "House");
        Assert.assertTrue(houseElement1.equals(houseElement2) && houseElement2.equals(houseElement1));
        houseElement1.print();
    }

    @Test
    public void isEqualsShops_ShopsIsEquals_True() {
        ShopElement shopElement1 = new ShopElement(3, 1, Element.TypeOfElement.SHOP, "Shop");
        ShopElement shopElement2 = new ShopElement(3, 1, Element.TypeOfElement.SHOP, "Shop");
        Assert.assertTrue(shopElement1.equals(shopElement2) && shopElement2.equals(shopElement1));
        shopElement1.print();
    }

    @Test
    public void isEqualsNulls_NullsIsEquals_True() {
        NullElement nullElement1 = new NullElement(3, 1, Element.TypeOfElement.NULL, "");
        NullElement nullElement2 = new NullElement(3, 1, Element.TypeOfElement.NULL, "");
        Assert.assertTrue(nullElement1.equals(nullElement2) && nullElement2.equals(nullElement1));
        nullElement1.print();
    }

    @Test
    public void calculateDistanceSchool_createTheSamePoint_Zero(){
        SchoolElement schoolElement = new SchoolElement(1, 2, Element.TypeOfElement.SCHOOL, "School");

        schoolElement.calcDistance(1, 2);
        schoolElement.toString();
    }

    @Test
    public void calculateDistanceHospitel_createTheSamePoint_Zero(){
        HospitalElement hospitalElement = new HospitalElement(1, 2, Element.TypeOfElement.HOSPITAL, "Hospital");

        hospitalElement.calcDistance(1, 2);
        hospitalElement.toString();
    }

    @Test
    public void isEqualsMaps_MapsIsEquals_True(){
        TerrainMap map1 = new TerrainMap(5);
        TerrainMap map2 = new TerrainMap(5);
        Assert.assertTrue(map1.equals(map2) && map2.equals(map1));
        map1.print();
    }

    @Test
    public void addElementInMap_MapIsEmpty_True(){
        TerrainMap map = new TerrainMap(3);
        SchoolElement schoolElement = new SchoolElement(1, 2, Element.TypeOfElement.SCHOOL, "School");

        map.addElementToMap(schoolElement);
        schoolElement.print();
        map.print();
    }

    @Test
    public void setLocationOnMap_CreateNewLocation_PrintLocation(){
        Location location = new Location(1, 2);
        TerrainMap map = new TerrainMap(4);

        map.getAroundElement(2);
        map.printLocation();
        map.infoMap();
    }

    @Test
    public void changeLocation_MovementToTheSamePoint_False(){
        Location location = new Location(1, 2);
        SchoolElement schoolElement = new SchoolElement(1, 2, Element.TypeOfElement.SCHOOL, "School");

        Location.Calculate calculate = location.new Calculate();
        calculate.elementAround(2, schoolElement);
        calculate.isEqual(schoolElement);

        Location.Move move = location.new Move();
        move.goTo(schoolElement);


    }

    @Test
    public void locationInfo_CreateNewLocation_PrintInfo(){
        Location location = new Location(1, 2);
        TerrainMap map = new TerrainMap(4);

        location.setX(2);
        location.setY(1);
        location.setName("School");

        Location.Info info = location.new Info();
        info.printInfo();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addElementInException_TwoIdenticalElements_ExpectMessage() throws Exception {
        SchoolElement school = new SchoolElement(1, 3, Element.TypeOfElement.SCHOOL, "name");

        TerrainMap map1 = new TerrainMap(3);
        map1.addElementToMap(new SchoolElement(1, 3, Element.TypeOfElement.SCHOOL, "name"));

        exception.expect(RuntimeException.class);
        exception.expectMessage("It Element will be already create");

        map1.addElementToMap(school);

        throw new NullPointerException("It Element will be already create");
    }


}
