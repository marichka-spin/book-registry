package com.bookregistry.facades;

import com.bookregistry.models.Book;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BookFacade {

    public Book findById(Integer id);
    public List<Book> findAll();

}
