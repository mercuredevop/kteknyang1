package com.kaffotek.nyang.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kaffotek.nyang.exceptions.RoundServiceException;
import com.kaffotek.nyang.io.entity.RoundEntity;
import com.kaffotek.nyang.io.entity.UserEntity;
import com.kaffotek.nyang.io.repository.RoundRepository;
import com.kaffotek.nyang.service.RoundService;
import com.kaffotek.nyang.shared.Utils;
import com.kaffotek.nyang.shared.dto.RoundDto;
import com.kaffotek.nyang.shared.dto.UserDto;

@Service
public class RoundServiceImpl implements RoundService{
	
	@Autowired
	RoundRepository roundRepository;
	
	@Autowired
	Utils utils;

	//CREATE A ROUND 
	@Override
	public RoundDto createRound(RoundDto round) {
		
		if (roundRepository.findByDate(round.getDate()) != null)
			throw new RoundServiceException("Record already exists");
		
		ModelMapper modelMapper = new ModelMapper();
		RoundEntity roundEntity = modelMapper.map(round, RoundEntity.class);
		
		String publicRoundId = utils.generateUserId(30);
		roundEntity.setRoundId(publicRoundId);
		
		RoundEntity storedRoundDetails = roundRepository.save(roundEntity);
		
		RoundDto returnValue  = modelMapper.map(storedRoundDetails, RoundDto.class);
		
		return returnValue;
	}

	//GET A ROUND BY ID 
	@Override
	public RoundDto getRound(String roundId) {
		RoundDto returnValue = new RoundDto();
		RoundEntity roundEntity = roundRepository.findByRoundId(roundId);

		if (roundEntity == null)
			System.out.println("Round with ID: " + roundId + " not found");

		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(roundEntity, RoundDto.class);
		//BeanUtils.copyProperties(userEntity, returnValue);

		return returnValue;
	}

	@Override
	public RoundDto getRoundByDueDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoundDto updateRound(String roundId, RoundDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRound(String roundId) {
		// TODO Auto-generated method stub
		
	}

	//GET ALL THE ROUND(PAGINATE)
	@Override
	public List<RoundDto> getRounds(int page, int limit) {
		List<RoundDto> returnValue = new ArrayList<>();
		
		if(page>0) page = page-1;
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<RoundEntity> roundsPage = roundRepository.findAll(pageableRequest);
		List<RoundEntity> rounds = roundsPage.getContent();
		
		for (RoundEntity roundEntity : rounds) {
            RoundDto roundDto = new RoundDto();
            BeanUtils.copyProperties(roundEntity, roundDto);
            returnValue.add(roundDto);
        }
		
		
		return returnValue;
	}

}
