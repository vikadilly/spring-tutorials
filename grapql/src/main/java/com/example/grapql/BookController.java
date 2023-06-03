package com.example.grapql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @QueryMapping //this controller declares how to fetch a Book as defined under the Query type.
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping //maps a handler method to a field in the GraphQL schema and declares it to be the DataFetcher for that field
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}