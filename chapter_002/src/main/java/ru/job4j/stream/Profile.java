package ru.job4j.stream;

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
}
