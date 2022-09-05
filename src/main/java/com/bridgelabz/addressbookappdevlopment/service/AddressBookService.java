package com.bridgelabz.addressbookappdevlopment.service;

import com.bridgelabz.addressbookappdevlopment.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevlopment.entity.AddressBook;
import com.bridgelabz.addressbookappdevlopment.exception.AddressBookException;
import com.bridgelabz.addressbookappdevlopment.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    AddressBookRepository repo;
    public String getWelcome() {
        return "Welcome to Address Book !";
    }
    public AddressBook saveDataToRepo(AddressBookDTO addressBookDTO) {
        AddressBook newAddressBook = new AddressBook(addressBookDTO);
        repo.save(newAddressBook);
        return newAddressBook;
    }
    public AddressBook getRecordById(Integer id) {
        List<AddressBook> addressList = repo.findAll();
        AddressBook newAddressBook = addressList.stream().filter(addressData->addressData.getId()==id)
                .findFirst()
                .orElseThrow(()->new AddressBookException("Particular address book details not found"));
        return newAddressBook;
    }
    public List<AddressBook> getRecord(){
        return repo.findAll();
    }
    public AddressBook updateRecordById(Integer id, AddressBookDTO addressBookDTO) {
        AddressBook newBook = new AddressBook(id,addressBookDTO);
        repo.save(newBook);
        return newBook;
    }
    public String deleteRecordById(Integer id) {
        //repo.deleteById(id);
        List<AddressBook> addressList = repo.findAll();
        AddressBook newAddressBook = addressList.stream().filter(addressData->addressData.getId()==id)
                .findFirst()
                .orElseThrow(()->new AddressBookException("Particular address book details not found"));
        repo.delete(newAddressBook);
        return null;

    }
}
