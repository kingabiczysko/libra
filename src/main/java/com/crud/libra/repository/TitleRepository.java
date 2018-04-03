package com.crud.libra.repository;

import com.crud.libra.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TitleRepository extends CrudRepository<Title, Long> {

    @Override
    List<Title> findAll();

    @Override
    Optional<Title> findById(Long idTitle);

    @Override
    Title save(Title title);

    @Override
    void deleteById(Long idTitle);

    @Override
    long count();

}
