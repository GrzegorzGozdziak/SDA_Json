package pl.sda.json;

public class DirectorBuilder {

    private Director director = new Director();

    public DirectorBuilder withFirstName(String firstName) {
        director.setFirstName(firstName);
        return this;
    }

    public DirectorBuilder withLastName(String lastName) {
        director.setLastName(lastName);
        return this;
    }
}
