package com.example.demo.security;


import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.SkolaUlogaRepository;

import model.SkolaUloga;


public class RoleConverter  implements Converter<String, SkolaUloga> {
	
	SkolaUlogaRepository r;
	
	public RoleConverter(SkolaUlogaRepository r){
		this.r=r;
	}
	
	public SkolaUloga convert(String source) {
			  int idRole=-1;
		       try{
		    	   idRole=Integer.parseInt(source);
		       }
		       catch(NumberFormatException e){
		    	   throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(SkolaUloga.class),idRole, null);
		       }
		       SkolaUloga role=r.getById(idRole);
		      return role;
		  }
}

