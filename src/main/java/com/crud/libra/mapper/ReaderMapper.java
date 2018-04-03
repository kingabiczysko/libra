package com.crud.libra.mapper;

import com.crud.libra.domain.Reader;
import com.crud.libra.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    public Reader mapToReader (final ReaderDto readerDto){
        return new Reader(
                readerDto.getIdReader(),
                readerDto.getName(),
                readerDto.getSurname()
        );
    }

    public ReaderDto mapToReaderDto (final Reader reader){
        return new ReaderDto(
                reader.getIdReader(),
                reader.getName(),
                reader.getSurname()
        );
    }

    public List<ReaderDto> readerDtoList (final List<Reader> readerList){
        return readerList.stream()
                .map(r-> new ReaderDto( r.getIdReader(),r.getName(), r.getSurname()))
                .collect(Collectors.toList());
    }

}
