package services;

import models.Author;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="authorService", eager = true)
@ApplicationScoped
public class AuthorService {
    private List<Author> authors;

    @PostConstruct
    public void init() {
        authors = new ArrayList<Author>();
        authors.add(new Author(0, "Afterdark", "afterdark"));
        authors.add(new Author(1, "Afternoon", "afternoon"));
        authors.add(new Author(2, "Afterwork", "afterwork"));
        authors.add(new Author(3, "Aristo", "aristo"));
        authors.add(new Author(4, "Black-Tie", "black-tie"));
        authors.add(new Author(5, "Blitzer", "blitzer"));
        authors.add(new Author(6, "Bluesky", "bluesky"));
        authors.add(new Author(7, "Bootstrap", "bootstrap"));
        authors.add(new Author(8, "Casablanca", "casablanca"));
        authors.add(new Author(9, "Cupertino", "cupertino"));
        authors.add(new Author(10, "Cruze", "cruze"));
    }
    public List<Author> getAuthors() {
        return authors;
    }
}
