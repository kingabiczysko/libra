package com.crud.libra.controller;

import com.crud.libra.domain.BookDto;
import com.crud.libra.domain.Title;
import com.crud.libra.mapper.BookMapper;
import com.crud.libra.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/libra")
public class BookController {
    @Autowired
    private DbService service;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<BookDto> getBooks(){
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/{idBook}")
    @ResponseBody
    public BookDto getBook(@PathVariable Long idBook) throws LibraNotFoundException{
        return bookMapper.mapToBookDto(service.getBook(idBook).orElseThrow(LibraNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books",consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto){
        service.saveBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{idBook}")
    public void deleteBook (@PathVariable Long idBook) throws LibraNotFoundException{
        service.deleteBook(idBook);
    }

    @RequestMapping (method = RequestMethod.PUT, value = "/books")
    public BookDto updateBook(@RequestBody BookDto bookDto){
        return bookMapper.mapToBookDto(service.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping (method = RequestMethod.GET, value = "/booksavailable")
    public List<BookDto> getBooksAll() {
        return bookMapper.mapToBookDtoList(service.getAllBooksByStatus("ok"));
    }


    @RequestMapping (method = RequestMethod.GET, value = "/booksavailable/{idTitle}")
    public List<BookDto> getBooksAllTitle(@PathVariable Long idTitle){
       Optional <Title> title = service.getTitle(idTitle);
        return bookMapper.mapToBookDtoList(service.getAllBooksByStatusAndTitle("ok", title));
    }

}
