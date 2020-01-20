package ru.job4j.address;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public Address() {

    }

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

    public List<Address> collect(List<Address> addresses) {
        return   addresses.stream().sorted(new AddressComp()).distinct().collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}