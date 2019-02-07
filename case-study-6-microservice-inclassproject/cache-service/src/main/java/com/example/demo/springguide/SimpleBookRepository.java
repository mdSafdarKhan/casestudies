package com.example.demo.springguide;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


@CacheConfig(cacheNames = { "books" }) // tells Spring where to store cache for this class
@Component
public class SimpleBookRepository implements BookRepository {

	@Cacheable // caches the result of findAll() method
	@Override
	public Book getByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, "Some book");
	}

	// Don't do this at home
	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}
