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

    @Column(name = "tran_Type")
    private String tranType;

    @Column(name = "cif")
    private String cif;

    @Column(name = "tran_Date")
    private Date tranDate;

    @Column(name = "amount")
    private int amount;

    @Column(name = "status")
    private String status;

    @Column(name = "debit_Acct")
    private String debitAcct;

    @Column(name = "credit_Acct")
    private String creditAcct;

    @Column(name = "remark")
    private String remark;
}
