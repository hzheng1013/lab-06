package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * Checks whether the given city is currently in the list.
     * This uses the City equality rules to decide if two cities are the same.
     * @param city the city to look for
     * @return true if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }
    /**
     * Removes the given city from the list.
     * If the city is not found, this method throws an exception.
     * @param city the city to remove
     * @throws NoSuchElementException if the city is not present in the list
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new NoSuchElementException("City not found: " + city);
        }
    }
    /**
     * Returns the number of cities currently stored in the list.
     * @return the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}

