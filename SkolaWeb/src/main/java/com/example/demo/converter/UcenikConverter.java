package com.example.demo.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.UcenikRepository;

import model.Teren;
import model.Ucenik;

public class UcenikConverter implements Converter<String, Ucenik> {

	UcenikRepository ur;
	
	
	
	
	
	
	public UcenikConverter(UcenikRepository ur) {
		
		this.ur = ur;
	}






	@Override
	public Ucenik convert(String source) {
		 int ucenikid=-1;
		 try {
			 ucenikid = Integer.parseInt(source);
		 }
		 catch(NumberFormatException e) {
			 throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Teren.class), ucenikid, null);
		 }
		  Ucenik u = ur.findById(ucenikid).get();
		 //Grupa apdejtovana = gr.grupaUpdateBrojPopunjenih(g);
		 return u;
	}

	
	
	
}
