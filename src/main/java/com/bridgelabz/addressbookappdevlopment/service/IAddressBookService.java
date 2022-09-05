package com.bridgelabz.addressbookappdevlopment.service;

import com.bridgelabz.addressbookappdevlopment.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevlopment.entity.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    public String getWelcome();
    public AddressBook saveDataToRepo(AddressBookDTO addressBookDTO);
    public AddressBook getRecordById(Integer id);
    public List<AddressBook> getRecord();
    public AddressBook updateRecordById(Integer id, AddressBookDTO addressBookDTO);
    public String deleteRecordById(Integer id);
}
