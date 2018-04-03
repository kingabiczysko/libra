package com.crud.libra.mapper;

import com.crud.libra.domain.Book;
import com.crud.libra.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook (final BookDto bookDto){
        return new Book(
                bookDto.getIdBook(),
                bookDto.getStatus()
                ,
                bookDto.getTitle()
        );
    }

    public BookDto mapToBookDto (final Book book){
        return new BookDto(
                book.getIdBook(),
                book.getStatus()
                ,
                book.getTitle()
        );
    }

    public List<BookDto> mapToBookDtoList (final List<Book> bookList){
        return bookList.stream()
                .map (b-> new BookDto(b.getIdBook(), b.getStatus()
                        , b.getTitle()
                        ))
                .collect(Collectors.toList());
    }
}
