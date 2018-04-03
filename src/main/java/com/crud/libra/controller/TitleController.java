package com.crud.libra.controller;

import com.crud.libra.domain.TitleDto;
import com.crud.libra.mapper.TitleMapper;
import com.crud.libra.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/libra")
public class TitleController {
    @Autowired
    private DbService service;

    @Autowired
    private TitleMapper titleMapper;


    @RequestMapping(method = RequestMethod.GET, value = "/titles")
    public List<TitleDto> getTitles(){
        return titleMapper.mapToTitleDtoList(service.getAllTitles());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/titles/{idTitle}")
    @ResponseBody
    public TitleDto getTitle(@PathVariable Long idTitle) throws LibraNotFoundException
    {
        return titleMapper.mapToTitleDto(service.getTitle(idTitle).orElseThrow(LibraNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/titles", consumes = APPLICATION_JSON_VALUE)
    public void createTitle (@RequestBody TitleDto titleDto){
        service.saveTitle(titleMapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/titles/{idTitle}")
    public void deleteTitle(@PathVariable Long idTitle) throws LibraNotFoundException {
        service.deleteTitle(idTitle);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/titles" )
    public TitleDto updateTitle (@RequestBody TitleDto titleDto){
        return titleMapper.mapToTitleDto(service.saveTitle(titleMapper.mapToTitle(titleDto)));
    }
}
