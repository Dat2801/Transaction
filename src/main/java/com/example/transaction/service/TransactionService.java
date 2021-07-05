package com.example.transaction.service;

import com.example.transaction.model.CustomerSumAmount;
import com.example.transaction.model.Transaction;
import com.example.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Integer getTransactionRate() {
        return transactionRepository.getTransactionRate();
    }

//    public Integer getTransactionSum() {
//        return transactionRepository.getSumTransaction();
//    }

//    public Integer getSumCIF() {
//        return transactionRepository.getSumCIF();
//    }

    public Integer getSumSaving() {
        return transactionRepository.getSumSaving();
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Integer countAllByModuleAndTranTypeAndStatusAndTranDateBetween(
            String module,
            String tranType,
            String status,
            Date tranDateStart,
            Date tranDateEnd){
        return transactionRepository.countAllByModuleAndTranTypeAndStatusAndTranDateBetween(module, tranType, status, tranDateStart, tranDateEnd);
    }

    public Integer countCifByModuleAndTranTypeAndStatusAndTranDateBetween(
            String module,
            String tranType,
            String status,
            Date tranDateStart,
            Date tranDateEnd) {
        return transactionRepository.countCifByModuleAndTranTypeAndStatusAndTranDateBetween(module, tranType, status, tranDateStart, tranDateEnd);
    }
}
