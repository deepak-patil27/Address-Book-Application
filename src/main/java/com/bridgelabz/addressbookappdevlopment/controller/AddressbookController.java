package com.bridgelabz.addressbookappdevlopment.controller;

import com.bridgelabz.addressbookappdevlopment.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevlopment.dto.ResponseDTO;
import com.bridgelabz.addressbookappdevlopment.exception.AddressBookException;
import com.bridgelabz.addressbookappdevlopment.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@RestController
@RequestMapping("/addressbookservice")
public class AddressbookController {
    @Autowired
    IAddressBookService service;
    //Ability to get welcome message
    @GetMapping("/welcome")
    public ResponseEntity<ResponseDTO> getWelcome(){
        String message = service.getWelcome();
        return new ResponseEntity(message,HttpStatus.OK);
    }
    //Ability to store a address book record to repo
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> saveDataToRepo(@Valid @RequestBody AddressBookDTO addressBookDTO){
        ResponseDTO dto = new ResponseDTO("Address Book Record created successfully",service.saveDataToRepo(addressBookDTO));
        return new ResponseEntity(dto,HttpStatus.CREATED);
    }
    //Ability to retrieve all data from repo
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getDataFromRepo(){
        ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",service.getRecord());
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }
    //Ability to get record by id
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getRecordFromRepoByID(@PathVariable Integer id) throws AddressBookException{
        ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",service.getRecordById(id));
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    //Ability to update record for particular id
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateRecordById(@PathVariable Integer id,@Valid @RequestBody AddressBookDTO addressBookDTO){
        ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully",service.updateRecordById(id,addressBookDTO));
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    //Ability to delete record for particular id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully",service.deleteRecordById(id));
        return new ResponseEntity(dto,HttpStatus.OK);
    }

}
