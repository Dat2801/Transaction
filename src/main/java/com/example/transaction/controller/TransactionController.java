package com.example.transaction.controller;

import com.example.transaction.model.CustomerSumAmount;
import com.example.transaction.model.Transaction;
import com.example.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

//    @GetMapping("/sum")
//    public ResponseEntity<Integer> getSum() {
//        return new ResponseEntity<>(transactionService.getTransactionSum(), HttpStatus.OK);
//    }

    @GetMapping("/getRatio")
    public ResponseEntity<Integer> getRatio() {
        return new ResponseEntity<>(transactionService.getTransactionRatio(), HttpStatus.OK);
    }

//    @GetMapping("/cif")
//    public ResponseEntity<Integer> getSumCIF() {
//        return new ResponseEntity<>(transactionService.getSumCIF(), HttpStatus.OK);
//    }

    @GetMapping("/getSaving")
    public ResponseEntity<Integer> getSumSaving() {
        return new ResponseEntity<>(transactionService.getSumSaving(), HttpStatus.OK);
    }

    @GetMapping("/getTop")
    public ResponseEntity<List<CustomerSumAmount>> getTop() {
        return new ResponseEntity<>(transactionService.getTop(), HttpStatus.OK);
    }

    @PostMapping("/getInsert")
    @ResponseBody
    public ResponseEntity<Transaction> getInsertData(@RequestBody Transaction transaction)  {
        return new ResponseEntity<>(transactionService.save(transaction), HttpStatus.CREATED);
    }

    @GetMapping("/getCount")
    public ResponseEntity<Integer> countAllByModuleAndTranTypeAndStatusAndTranDateBetween(
            String module, String tranType, String status, Date tranDateStart, Date tranDateEnd) throws Exception {
        module = "BILLPAY";
        tranType = "PHONE_TOPUP";
        status = "SUCCESS";
        tranDateStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-06-01 00:00:00");
        tranDateEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-06-30 00:00:00");
        return new ResponseEntity<>(transactionService.countAllByModuleAndTranTypeAndStatusAndTranDateBetween(
                module, tranType, status, tranDateStart, tranDateEnd), HttpStatus.OK);
    }

    @GetMapping("/getCIF")
    public ResponseEntity<Integer> countCifByModuleAndTranTypeAndStatusAndTranDateBetween(
            String module,
            String tranType,
            String status,
            Date tranDateStart,
            Date tranDateEnd) throws ParseException {
        module = "BILLPAY";
        tranType = "PHONE_TOPUP";
        status = "FAIL";
        tranDateStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-01-01 00:00:00");
        tranDateEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-06-30 00:00:00");
        return new ResponseEntity<>(transactionService.countCifByModuleAndTranTypeAndStatusAndTranDateBetween(module, tranType, status, tranDateStart, tranDateEnd), HttpStatus.OK);
    }
}
