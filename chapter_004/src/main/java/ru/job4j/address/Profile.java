package ru.job4j.address;

import java.util.List;
import java.util.stream.Collectors;

/**
 *Class Profile преобразует список профилей в список адрессов.
 *@author chupin
 *@since 5.01.2020
 */

public class Profile {
    private Address address;

    public Profile() {
    }
    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public List<Address> collect(List<Profile> profiles) {

        return   profiles.stream().map(profil -> profil.getAddress()).collect(Collectors.toList());
    }
}