package com.bridgelabz.addressbookappdevlopment.entity;

import com.bridgelabz.addressbookappdevlopment.dto.AddressBookDTO;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "address_book")

public class AddressBook {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;





    @ElementCollection
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "id"))
    List<String> address;
    public AddressBook() {

    }


    public AddressBook(Integer id, String firstName, String lastName, String email, long phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = Collections.singletonList(address);


    }
    public AddressBook(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.id = id;
        this.address = Collections.singletonList(addressBookDTO.address);
    }
    public AddressBook(Integer id,AddressBookDTO addressBookDTO) {
        this.id=id;
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = Collections.singletonList(addressBookDTO.getAddress());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address.toString();
    }

    public void setAddress(String address) {
        this.address = Collections.singletonList(address);
    }
}
