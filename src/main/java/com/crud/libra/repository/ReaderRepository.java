package com.crud.libra.repository;

import com.crud.libra.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Long idReader);

    @Override
    Reader save (Reader reader);

    @Override
    void deleteById (Long idReader);

    @Override
    long count();


}
