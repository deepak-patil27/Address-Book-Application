package com.bridgelabz.addressbookappdevlopment.repository;



import com.bridgelabz.addressbookappdevlopment.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressBookRepository extends JpaRepository<AddressBook, Integer>{

}
