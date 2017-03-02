package pl.sda.json;

import java.util.List;
import java.util.Map;

public class UserBuilder {
    private User user = new User();

    public UserBuilder withFirstName(String firstName) {
        user.setFirstName(firstName);
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        user.setLastName(lastName);
        return this;
    }

    public UserBuilder withAddresses(Map<String, Address> addresses) {
        user.setAddresses(addresses);
        return this;
    }

    public UserBuilder withAddresses(String addressName, Address address) {
        user.getAddresses().put(addressName, address);
        return this;
    }

    public UserBuilder withChildrenNames(List<String> names) {
        user.setChildrenNames(names);
        return this;
    }

    public User build() {
        return user;
    }
}
