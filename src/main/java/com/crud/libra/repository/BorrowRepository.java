package com.crud.libra.repository;

import com.crud.libra.domain.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BorrowRepository extends CrudRepository <Borrow, Long> {

    @Override
    List<Borrow> findAll();

    @Override
    Optional<Borrow> findById(Long idBorrow);

    @Override
    Borrow save (Borrow borrow);

    @Override
    void deleteById(Long idBorrow);

    @Override
    long count();
}
