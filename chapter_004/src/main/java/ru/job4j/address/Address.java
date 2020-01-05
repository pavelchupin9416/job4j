package ru.job4j.address;

/**
 *Class Address содержит адресса туристов.
 *@author chupin
 *@since 5.01.2020
 */

public class Address {
    private String city;
    private String street;

    private int home;

    private int apartment;

    public Address(String city, String street, int home, int apartment) {
      this.city = city;
      this.street = street;
      this.home = home;
      this.apartment = apartment;
    }


    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

}