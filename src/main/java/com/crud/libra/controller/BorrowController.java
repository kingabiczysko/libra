package com.crud.libra.controller;

import com.crud.libra.domain.BorrowDto;
import com.crud.libra.mapper.BorrowMapper;
import com.crud.libra.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/libra")
public class BorrowController {
    @Autowired
    private DbService dbService;

    @Autowired
    private BorrowMapper borrowMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/borrows")
    public List<BorrowDto> getBorrows(){
        return borrowMapper.mapToBorrowDtoList(dbService.getAllBorrows());
    }
}
