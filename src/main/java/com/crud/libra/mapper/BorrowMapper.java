package com.crud.libra.mapper;

import com.crud.libra.domain.Borrow;
import com.crud.libra.domain.BorrowDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BorrowMapper {

    public Borrow mapToBorrow (final BorrowDto borrowDto){
        return new Borrow(
                borrowDto.getIdBorrow(),
                borrowDto.getBorrowDate(),
                borrowDto.getReturnDate(),
                borrowDto.getReader(),
                borrowDto.getBook()
        );
    }

    public BorrowDto mapToBorrowDto (final Borrow borrow){
        return new BorrowDto(
                borrow.getIdBorrow(),
                borrow.getBorrowDate(),
                borrow.getReturnDate(),
                borrow.getReader(),
                borrow.getBook()
        );
    }

    public List<BorrowDto> mapToBorrowDtoList (final List<Borrow> borrowList){
        return borrowList.stream()
                .map(b-> new BorrowDto(b.getIdBorrow(), b.getBorrowDate(), b.getReturnDate(),
                        b.getReader(), b.getBook()))
                .collect(Collectors.toList());
    }


}
