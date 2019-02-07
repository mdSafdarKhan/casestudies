package com.example.demo.springguide;

public interface BookRepository {

    Book getByIsbn(String isbn);
}