package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountConstants;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.dto.ResponseDTO;
import com.eazybytes.accounts.service.IAccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountController {

    private IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {

        iAccountsService.createAccount(customerDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp = "[0-9]{10}", message = "Mobile number must be 10 digits")
                                                               String mobileNumber) {

        CustomerDTO customerDTO = iAccountsService.fetchAccountDetails(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccount(@Valid @RequestBody CustomerDTO customerDTO) {
        iAccountsService.updateAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccount(@RequestParam @Pattern(regexp = "[0-9]{10}", message = "Mobile number must be 10 digits") String mobileNumber) {
        iAccountsService.deleteAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
    }
}
