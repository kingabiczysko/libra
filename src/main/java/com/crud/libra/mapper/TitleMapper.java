package com.crud.libra.mapper;

import com.crud.libra.domain.Title;
import com.crud.libra.domain.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto){
        return new Title(
                titleDto.getIdTitle(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublishedYear()
        );
    }

    public TitleDto mapToTitleDto(final Title title){
        return new TitleDto(
                title.getIdTitle(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublishedYear()
        );
    }

    public List<TitleDto> mapToTitleDtoList (final List<Title> titleList){
        return titleList.stream()
                .map(t -> new TitleDto(t.getIdTitle(), t.getTitle(), t.getAuthor(), t.getPublishedYear()))
                .collect(Collectors.toList());
    }
}
