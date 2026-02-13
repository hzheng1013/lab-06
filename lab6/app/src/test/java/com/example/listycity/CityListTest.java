

package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList(); //return list
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta"); //return object
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCity_trueWhenPresent_evenIfDifferentObject() {
        CityList cityList = mockCityList();
        City sameData = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(sameData));
    }

    @Test
    void testHasCity_falseWhenNotPresent() {
        CityList cityList = mockCityList();
        assertFalse(cityList.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDelete_removesCity() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        cityList.delete(new City("Edmonton", "Alberta"));
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testDelete_throwsWhenCityNotPresent() {
        CityList cityList = mockCityList();
        assertThrows(NoSuchElementException.class,
                () -> cityList.delete(new City("Calgary", "Alberta")));
    }

    @Test
    void testCountCities_returnsCorrectCount() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("Edmonton", "Alberta"));
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
    }

}
