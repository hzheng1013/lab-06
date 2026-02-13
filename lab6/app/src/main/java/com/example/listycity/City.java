package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    /**
     * Constructs a City with the given city name and province name.
     * @param city the city name
     * @param province the province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * Returns the city name.
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }
    /**
     * Returns the province name.
     * @return the province name
     */
    String getProvinceName(){
        return this.province;
    }
    /**
     * Compares this city with another city for ordering.
     * Comparison is based on the city name in lexicographical order.
     * @param o the other city to compare to
     * @return a negative integer, zero, or a positive integer as this city's name
     *         is less than, equal to, or greater than the other city's name
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
    /**
     * Indicates whether some other object is equal to this one.
     * Two City objects are considered equal if they have the same city name
     * and the same province name.
     * @param o the reference object with which to compare
     * @return true if this object is the same as the o argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return Objects.equals(city, other.city) &&
                Objects.equals(province, other.province);
    }
    /**
     * Returns a hash code value for this city.
     * This implementation is consistent with equals: if two cities are equal,
     * they will have the same hash code.
     *
     * @return a hash code value for this city
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
