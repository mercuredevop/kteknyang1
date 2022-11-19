package com.kaffotek.nyang.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaffotek.nyang.io.entity.RoundEntity;

@Repository
public interface RoundRepository extends PagingAndSortingRepository<RoundEntity, Long> {
	RoundEntity findByDate(String date);
	RoundEntity findByBeneficiary(String beneficiary);
	RoundEntity findByRoundId(String roundId);
}
