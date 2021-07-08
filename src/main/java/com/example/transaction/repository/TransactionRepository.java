package com.example.transaction.repository;

import com.example.transaction.model.CustomerSumAmount;
import com.example.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
//    @Query(value = "select count(*) as c from transaction_table as t where t.Module = 'BILLPAY' " +
//            "AND t.tran_type = 'PHONE_TOPUP' " +
//            "AND t.status = 'SUCCESS'" +
//            "AND (t.tran_Date  BETWEEN '2021-06-01 00:00:00' AND '2021-06-30 13:45:16')", nativeQuery = true)
//    Integer getSumTransaction();
//    @Query(value = "select count(t.CIF)" +
//            "from transaction_table as t where t.module = 'BILLPAY'" +
//            "AND t.tran_Type = 'PHONE_TOPUP' AND t.status = 'FAIL'" +
//            "AND (t.tran_Date BETWEEN '2021-01-01 00:00:00' AND '2021-06-30 15:00:00')", nativeQuery = true)
//    Integer getSumCIF();

    @Query(value = "call getRatio()", nativeQuery = true)
    Integer getTransactionRatio();

    @Query(value = "call getSumSaving()", nativeQuery = true)
    Integer getSumSaving();

    @Query(value = "call getTop()"
            , nativeQuery = true)
    List<CustomerSumAmount> getTop5();

    Integer countAllByModuleAndTranTypeAndStatusAndTranDateBetween(
            String module, String tranType, String status, Date tranDateStart, Date tranDateEnd);

    Integer countCifByModuleAndTranTypeAndStatusAndTranDateBetween(
            String module, String tranType, String status, Date tranDateStart, Date tranDateEnd);
}
