package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.model.NeedyPeople;

public interface NeedyPeopleDao   extends JpaRepository<NeedyPeople,Integer>{
	/*
	 * public int createNeedyPerson(NeedyPeople person); public boolean
	 * readLoginData(NeedyPeople person); public boolean requestForHelp(NeedyPeople
	 * person);
	 */
}
