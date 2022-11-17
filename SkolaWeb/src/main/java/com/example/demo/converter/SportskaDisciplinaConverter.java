package com.example.demo.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.SportskaDisciplinaRepository;

import model.Sportskadisciplina;
import model.Teren;

public class SportskaDisciplinaConverter implements Converter<String, Sportskadisciplina> {

	SportskaDisciplinaRepository sdr;
	
	 public SportskaDisciplinaConverter(SportskaDisciplinaRepository sdr) {
		this.sdr = sdr;
	}
	
	@Override
	public Sportskadisciplina convert(String source) {
		int sdid=-1;
		 try {
			 sdid = Integer.parseInt(source);
		 }
		 catch(NumberFormatException e) {
			 throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Sportskadisciplina.class), sdid, null);
		 }
		  Sportskadisciplina sd = sdr.findById(sdid).get();
		 //Grupa apdejtovana = gr.grupaUpdateBrojPopunjenih(g);
		 return sd;
	}

}
