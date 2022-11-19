package com.kaffotek.nyang.ui.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaffotek.nyang.service.RoundService;
import com.kaffotek.nyang.shared.dto.RoundDto;
import com.kaffotek.nyang.shared.dto.UserDto;
import com.kaffotek.nyang.ui.model.request.RoundDetailsRequestModel;
import com.kaffotek.nyang.ui.model.response.RoundRest;
import com.kaffotek.nyang.ui.model.response.UserRest;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("rounds") //http://localhost:8080/rounds
@CrossOrigin(origins="http://127.0.0.1:3000")
public class RoundController {
	
	@Autowired
	RoundService roundService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<RoundRest> getRounds(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "6") int limit) {
		List<RoundRest> returnValue = new ArrayList<>();
		
		List<RoundDto> rounds = roundService.getRounds(page, limit);
		
		Type listType = new TypeToken<List<RoundRest>>() {
		}.getType();
		returnValue = new ModelMapper().map(rounds, listType);
		
		
		return returnValue;
	}
	
	@ApiOperation(value="The Get Single Round Details Web Service Endpoint",
			notes="${roundController.GetRound.ApiOperation.Notes}")
	@GetMapping(path = "/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE })
	public RoundRest getRound(@PathVariable String id) {
		RoundRest returnValue = new RoundRest();

		RoundDto roundDto = roundService.getRound(id);
		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(roundDto, RoundRest.class);

		return returnValue;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
	public RoundRest createRound(@RequestBody RoundDetailsRequestModel roundDetails) throws Exception {
		RoundRest returnValue = new RoundRest();
		
		ModelMapper modelMapper = new ModelMapper();
		RoundDto roundDto = modelMapper.map(roundDetails, RoundDto.class);
		
		RoundDto createdRound = roundService.createRound(roundDto);
		returnValue = modelMapper.map(createdRound, RoundRest.class);
		
		return returnValue;
	}
	
	@PutMapping
	public String updateRound() {
		return "update round was called";
	}
	
	@DeleteMapping
	public String deleteRound() {
		return "delete round was called";
	}
}
