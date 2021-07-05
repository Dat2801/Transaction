package com.example.transaction.service;

import com.example.transaction.model.CustomerSumAmount;
import com.example.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerSumAmountService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<CustomerSumAmount> getTop(){
        return transactionRepository.getTop5();
    };
}
