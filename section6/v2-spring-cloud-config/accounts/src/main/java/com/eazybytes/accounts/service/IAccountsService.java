package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.AccountDTO;
import com.eazybytes.accounts.dto.CustomerDTO;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountsService {

    void createAccount(CustomerDTO customerDTO);

    CustomerDTO fetchAccountDetails(String mobileNumber);

    @Transactional
    void updateAccount(CustomerDTO customerDTO);

    @Transactional
    void deleteAccount(String mobileNumber);
}
