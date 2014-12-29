package com.bookregistry.dao.impl;

import com.bookregistry.dao.BaseDao;
import com.bookregistry.models.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class BookDaoImpl extends BaseDao<Book> {

    public BookDaoImpl() {
        super(Book.class);
    }
}
