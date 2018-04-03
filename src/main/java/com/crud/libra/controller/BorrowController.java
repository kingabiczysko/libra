package com.crud.libra.controller;

import com.crud.libra.domain.BorrowDto;
import com.crud.libra.mapper.BorrowMapper;
import com.crud.libra.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/libra")
public class BorrowController {
    @Autowired
    private DbService service;

    @Autowired
    private BorrowMapper borrowMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/borrows")
    public List<BorrowDto> getBorrows(){
        return borrowMapper.mapToBorrowDtoList(service.getAllBorrows());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/borrows/{idBorrow}")
    @ResponseBody
    public BorrowDto getBorrow (@PathVariable Long idBorrow) throws LibraNotFoundException{
        return borrowMapper.mapToBorrowDto(service.getBorrow(idBorrow).orElseThrow(LibraNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/borrows", consumes = APPLICATION_JSON_VALUE)
    public void createBorrow (@RequestBody BorrowDto borrowDto){
        service.saveBorrow(borrowMapper.mapToBorrow(borrowDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/borrows/{idBorrow}")
    public void deleteBorrow (@PathVariable final Long idBorrow) throws LibraNotFoundException{
        service.deleteBorrow(idBorrow);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/borrows")
    public BorrowDto updateBorrow(@RequestBody BorrowDto borrowDto){
        return borrowMapper.mapToBorrowDto(service.saveBorrow(borrowMapper.mapToBorrow(borrowDto)));
    }

}
