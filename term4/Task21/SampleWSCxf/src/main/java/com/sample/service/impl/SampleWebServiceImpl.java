package com.sample.service.impl;

import com.sample.generated.Book;
import com.sample.service.SampleWebService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.sample.service.SampleWebService")
public class SampleWebServiceImpl implements SampleWebService {
    @Override
    public Book getDataFromWebService() {
        Book book = new Book();
        book.setTitle("Title from Server");
        book.setAuthor("Author from Server");
        book.setDescription("Description from Server");
        book.setPublisher("Publisher from Server");
        book.setPublishedYear(2014);
        return book;
    }

}