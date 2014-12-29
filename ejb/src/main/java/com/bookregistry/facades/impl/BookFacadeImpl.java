package com.bookregistry.facades.impl;

import com.bookregistry.dao.impl.BookDaoImpl;
import com.bookregistry.facades.BookFacade;
import com.bookregistry.models.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BookFacadeImpl implements BookFacade {

    @EJB
    private BookDaoImpl bookDao;

    @Override
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

}
