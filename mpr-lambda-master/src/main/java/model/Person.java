package model;

import java.util.List;

public class Person {
    private String name;
    private String surname;
    private List<String> phoneNumbers;
    private List<Address> addresses;
    private Role role;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Role getRole() {
        return role;
    }

    public int getAge() {
        return age;
    }
}
