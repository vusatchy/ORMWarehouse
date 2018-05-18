package com.lnu.bd.rest;

import com.lnu.bd.dao.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public void transaction(@RequestParam(name = "fail") boolean fail) {
        try {
            transactionRepository.processUserTransaction(fail);
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

}
