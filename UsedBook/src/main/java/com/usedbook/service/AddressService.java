package com.usedbook.service;

import com.usedbook.pojo.Address;

import java.util.List;

public interface AddressService {
    List<Address> getByUserId(String aUserId);
    int addAddress(Address address);
}
