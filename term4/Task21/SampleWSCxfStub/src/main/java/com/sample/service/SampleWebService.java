package com.sample.service;

import com.sample.generated.Book;

import javax.jws.WebService;

@WebService
public interface SampleWebService {
	public Book getDataFromWebService();
}
