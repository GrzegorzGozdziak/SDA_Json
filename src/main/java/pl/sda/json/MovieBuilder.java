package pl.sda.json;

public class MovieBuilder {
    private Movie movie = new Movie();

    public MovieBuilder withFirstName(String originalTitle) {
        movie.setOriginalTitle(originalTitle);
        return this;
    }

    public MovieBuilder withLastName(String plTitle) {
        movie.setPlTitle(plTitle);
        return this;
    }
}
