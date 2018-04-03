package com.crud.libra.repository;

import com.crud.libra.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book>findAll();

    @Override
    Optional<Book> findById(Long idBook);


    @Override
    Book save (Book book);

    @Override
    void deleteById(Long idBook);

    @Override
    long count();

}
