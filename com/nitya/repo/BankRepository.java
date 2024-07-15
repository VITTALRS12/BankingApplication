package com.nitya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.nitya.entity.Bank;

@RestController
public interface BankRepository extends JpaRepository<Bank, String> {

}

