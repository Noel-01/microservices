package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.AccountDTO;
import com.eazybytes.accounts.entity.Account;

public class AccountsMapper {

    public static AccountDTO mapToAccountDTO(Account account, AccountDTO accountDto) {
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    public static Account mapToAccount(AccountDTO accountDto, Account account) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }

}
