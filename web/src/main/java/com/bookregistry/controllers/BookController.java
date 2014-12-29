package com.bookregistry.controllers;


import com.bookregistry.facades.BookFacade;
import com.bookregistry.serialization.factories.impl.BookSerializationFactory;
import com.bookregistry.serialization.models.BookBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Stateless
public class BookController {

    @EJB
    private BookFacade bookFacade;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public BookBean getBook(@QueryParam("id") Integer id) {
        BookSerializationFactory factory = new BookSerializationFactory();
        return factory.serialize(bookFacade.findById(id));
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookBean> getBooks() {
        BookSerializationFactory factory = new BookSerializationFactory();
        return factory.serializeAll(bookFacade.findAll());
    }
}
