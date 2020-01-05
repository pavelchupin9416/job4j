package ru.job4j.addreess;

import org.junit.Test;
import ru.job4j.address.Address;
import ru.job4j.address.AddressComp;
import ru.job4j.address.Profile;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;


import static org.junit.Assert.assertThat;

public class ProfileTest {
    @Test
    public void whenProfilConvertAddress() {
        List<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile(new Address("Moscow", "Lomonosow", 55, 205)));
        profiles.add(new Profile(new Address("Penza", "Suvorova", 144, 41)));
        profiles.add(new Profile(new Address("Samara", "Lenina", 12, 5)));
        List<Address> result = new Profile().collect(profiles);
        assertThat(result.get(0), is(profiles.get(0).getAddress()));
    }

    @Test
    public void whenDistinctAddress() {
        List<Address> addres = new ArrayList<Address>();
        addres.add(new Address("Penza", "Suvorova", 144, 41));
        addres.add(new Address("Moscow", "Lomonosow", 55, 205));
        addres.add(new Address("Samara", "Lenina", 12, 5));
        addres.add(new Address("Moscow", "Lomonosow", 55, 205));
        List<Address> result = new Address().collect(addres);
        result.sort(new AddressComp());
        assertThat(result.get(0), is(addres.get(1)));
    }
}
