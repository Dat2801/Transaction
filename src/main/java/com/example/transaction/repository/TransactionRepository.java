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

    @Query(value = "select count(*) / (select count(*)" +
            "from transaction_table tt where tt.status = 'SUCCESS'" +
            "AND tt.module ='FUNDTRANSFER'" +
            "AND tt.tran_Type='FT_INT_TRANS_ACC'" +
            "AND (tt.tran_Date BETWEEN '2021-06-01 00:00:00' AND '2021-06-30 15:00:00')" +
            ")" +
            "from transaction_table t where t.status = 'FAIL'" +
            "AND t.module ='FUNDTRANSFER'" +
            "AND t.tran_Type='FT_INT_TRANS_ACC'" +
            "AND (t.tran_Date BETWEEN '2021-06-01 00:00:00' AND '2021-06-30 15:00:00')", nativeQuery = true)
    Integer getTransactionRate();

//    @Query(value = "select count(t.CIF)" +
//            "from transaction_table as t where t.module = 'BILLPAY'" +
//            "AND t.tran_Type = 'PHONE_TOPUP' AND t.status = 'FAIL'" +
//            "AND (t.tran_Date BETWEEN '2021-01-01 00:00:00' AND '2021-06-30 15:00:00')", nativeQuery = true)
//    Integer getSumCIF();

    @Query(value = "select sum(t.amount)" +
            "from transaction_table as t where t.module = 'SAVING'" +
            "AND t.tran_Type = 'SAVING' AND t.status = 'SUCCESS'" +
            "AND (t.tran_Date BETWEEN '2021-01-01 00:00:00' AND '2021-06-30 15:00:00')", nativeQuery = true)
    Integer getSumSaving();

    @Query(value = "select  t.cif,sum(t.amount) as sumAmount from transaction_table as t where t.module = 'BILLPAY'" +
            "AND t.tran_Type = 'PHONE_TOPUP' AND t.status = 'SUCCESS'" +
            "AND (t.tran_Date  BETWEEN '2021-06-01 00:00:00' AND '2021-06-30 13:45:16')" +
            "group by t.cif order by sumAmount DESC LIMIT 5"
            , nativeQuery = true)
    List<CustomerSumAmount> getTop5();

    Integer countAllByModuleAndTranTypeAndStatusAndTranDateBetween(
            String module, String tranType, String status, Date tranDateStart, Date tranDateEnd);

    Integer countCifByModuleAndTranTypeAndStatusAndTranDateBetween(
            String module, String tranType, String status, Date tranDateStart, Date tranDateEnd);
}
