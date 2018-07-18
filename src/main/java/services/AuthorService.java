package services;

import db.ConnectionHelper;
import models.Author;
import org.h2.tools.Server;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="authorService", eager = true)
@ApplicationScoped
public class AuthorService {
    private List<Author> authors;

    @PostConstruct
    public void init() {
        try {
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        authors = new ArrayList<>();
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
        try {
            Connection connection = ConnectionHelper.getConnection();
            Statement statement = connection.createStatement();
            ConnectionHelper.createTableTEST (connection, statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authors;
    }
}
