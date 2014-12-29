package com.bookregistry.serialization.factories.impl;

import com.bookregistry.models.Book;
import com.bookregistry.serialization.factories.SerializationFactory;
import com.bookregistry.serialization.models.BookBean;

import java.util.ArrayList;
import java.util.List;

public class BookSerializationFactory implements SerializationFactory<BookBean, Book> {

    @Override
    public BookBean serialize(Book model) {
        if (model != null) {
            BookBean bean = new BookBean();
            bean.setId(model.getId().intValue());
            bean.setIsbn(model.getIsbn());
            bean.setTitle(model.getTitle());
            return bean;
        }
        return null;
    }

    @Override
    public List<BookBean> serializeAll(List<Book> models) {
        List<BookBean> beans = new ArrayList<BookBean>();
        for (Book model : models) {
            beans.add(serialize(model));
        }
        return beans;
    }
}
