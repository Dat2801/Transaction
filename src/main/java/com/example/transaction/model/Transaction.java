package com.example.transaction.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "transaction_table", schema = "transaction")
public class Transaction {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "module")
    private String module;

    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "cif")
    private String cif;

    @Column(name = "tran_date")
    private Date tranDate;

    @Column(name = "amount")
    private double amount;

    @Column(name = "status")
    private String status;

    @Column(name = "debit_acct")
    private String debitAcct;

    @Column(name = "credit_acct")
    private String creditAcct;

    @Column(name = "remark")
    private String remark;
}
