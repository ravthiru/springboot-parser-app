package com.test.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.parser.model.Transaction;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long> {

}
