package com.tka.Performance.Optimization.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Performance.Optimization.dao.CountryDao;
import com.tka.Performance.Optimization.entity.Country;
import com.tka.Performance.Optimization.entity.Employee;

@Service
public class CountryService {
	
	@Autowired
	CountryDao dao;

	public String addCountry(Country c) {
		
		String msg = dao.addCountry(c);
		if (Objects.isNull(msg)) {
			msg="Country is Not Addedd";
		}
		
		return msg;
	}

	public String updateCountry(Country c, int id) {
		String msg = dao.updateCountry(c,id);
		if (Objects.isNull(msg)) {
			msg="Country is Not Updated";
		}
		return msg;
	}

	public String deleteCountry(int id) {
		String msg = dao.deleteCountry(id);
		if (Objects.isNull(msg)) {
			msg="Country is Not Deleted";
		}
		return msg;
	}

	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		return list;
	}

	public Country getParticularCountryById(int id) {
		Country con = dao.getParticularCountryById(id);
		return con;
	}

	

}
