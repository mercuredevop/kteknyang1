package com.kaffotek.nyang.service;

import java.util.List;
import com.kaffotek.nyang.shared.dto.RoundDto;

public interface RoundService {
	RoundDto createRound(RoundDto round);
	RoundDto getRound(String roundId);
	RoundDto getRoundByDueDate(String date);
	RoundDto updateRound(String roundId, RoundDto user);
	void deleteRound(String roundId);
	List<RoundDto> getRounds(int page, int limit);
}
