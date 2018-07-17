package beans;

import models.Author;
import services.AuthorService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean
public class SelectOneView {

    private Author author;
    private List<Author> authors;

    @ManagedProperty("#{authorService}")
    private AuthorService service;

    @PostConstruct
    public void init() {
        authors = service.getAuthors();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setService(AuthorService service) {
        this.service = service;
    }
}
