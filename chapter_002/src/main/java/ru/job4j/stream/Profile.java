package ru.job4j.stream;

import java.util.Objects;

public class Profile {
    private Address address;
    private String name;

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public Profile(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Profile{"
                + "address=" + address.getCity()
                + " " + address.getStreet()
                + " " + address.getHome()
                + " " + address.getApartment()
                + " " + name
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address) &&
                Objects.equals(name, profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name);
    }
}

