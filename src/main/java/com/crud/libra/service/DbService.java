package com.crud.libra.service;

import com.crud.libra.domain.Book;
import com.crud.libra.domain.Borrow;
import com.crud.libra.domain.Reader;
import com.crud.libra.domain.Title;
import com.crud.libra.repository.BookRepository;
import com.crud.libra.repository.BorrowRepository;
import com.crud.libra.repository.ReaderRepository;
import com.crud.libra.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BorrowRepository borrowRepository;


    public List<Title> getAllTitles(){
        return titleRepository.findAll();
    }

    public Optional<Title> getTitle (final Long idTitle){
        return titleRepository.findById(idTitle);
    }

    public Title saveTitle (final Title title){
        return titleRepository.save(title);
    }

    public void deleteTitle (final Long idTitle){
        titleRepository.deleteById(idTitle);
    }



    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook (final Long idBook){ return bookRepository.findById(idBook);}

    public Book saveBook (final Book book){
        return bookRepository.save(book);
    }

    public void deleteBook (final  Long idBook){
        bookRepository.deleteById(idBook);
    }


    public List<Book> getAllBooksByStatus (final String status){return bookRepository.findAllByStatus(status);}
    public List<Book> getAllBooksByStatusAndTitle (final String status, final Long title){
        return bookRepository.findAllByStatusAndTitle(status, title);
    }

    public List<Reader> getAllReaders(){
        return readerRepository.findAll();
    }

    public Optional<Reader> getReader (final Long idReader){
        return readerRepository.findById(idReader);
    }

    public Reader saveReader (final Reader reader){
        return readerRepository.save(reader);
    }

    public void deleteReader(final Long idReader){
        readerRepository.deleteById(idReader);
    }


    public List<Borrow> getAllBorrows(){
        return borrowRepository.findAll();
    }

    public Optional<Borrow> getBorrow(final Long idBorrow){
        return  borrowRepository.findById(idBorrow);

    }

    public Borrow saveBorrow(final Borrow borrow){
        return borrowRepository.save(borrow);
    }

    public void deleteBorrow(final Long idBorrow){
        borrowRepository.deleteById(idBorrow);
    }

}

