package com.crud.libra.controller;

import com.crud.libra.domain.ReaderDto;
import com.crud.libra.mapper.ReaderMapper;
import com.crud.libra.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/libra")
public class ReaderController {
    @Autowired
    private DbService service;

    @Autowired
    private ReaderMapper readerMapper;


    @RequestMapping(method = RequestMethod.GET, value = "/readers")
    public List<ReaderDto> getReaders(){
        return readerMapper.readerDtoList(service.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/readers", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto){
        service.saveReader(readerMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/readers/{idReader}")
    @ResponseBody
    public ReaderDto getReader(@PathVariable Long idReader) throws LibraNotFoundException{
        return readerMapper.mapToReaderDto(service.getReader(idReader).orElseThrow(LibraNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/readers")
    public void deleteReader (@PathVariable Long idReader){
        service.deleteReader(idReader);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/readers")
    public ReaderDto updateReader (@RequestBody ReaderDto readerDto){
        return readerMapper.mapToReaderDto(service.saveReader(readerMapper.mapToReader(readerDto)));
    }


}
