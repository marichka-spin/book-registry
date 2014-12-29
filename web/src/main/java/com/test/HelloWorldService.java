package com.test;

import com.bookregistry.facades.BookFacade;
import com.bookregistry.serialization.models.BookBean;
import com.test.module.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
@Stateless
public class HelloWorldService {

    @EJB
    private HelloWorld helloWorldBean;

    @EJB
    private BookFacade bookFacade;

    @GET
    @Path("/sayhello")
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        System.out.println(bookFacade.findAll());
        return "<h2> " + helloWorldBean.sayHello() +" </h2>";
    }

    @GET
    @Path("/sayjson")
    @Produces(MediaType.APPLICATION_JSON)
    public BookBean getJson() {
        BookBean book = new BookBean();
        book.setIsbn("12346457568");
        book.setTitle("Harry Potter");
        return book;
    }

    @GET
    @Path("/sayxml")
    @Produces(MediaType.APPLICATION_XML)
    public Book getXml() {
        Book book = new Book();
        book.setIsbn("12346457568");
        book.setTitle("Harry Potter");
        return book;
    }

}
