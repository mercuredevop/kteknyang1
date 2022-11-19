package com.kaffotek.nyang.service;

import java.util.List;

import com.kaffotek.nyang.shared.dto.AddressDTO;


public interface AddressService {
	List<AddressDTO> getAddresses(String userId);
    AddressDTO getAddress(String addressId);
}
