package com.example.demo.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.InstruktorRepository;

import model.Instruktor;
import model.Teren;

public class InstruktorConverter implements Converter<String, Instruktor>{

	InstruktorRepository ir;
	
	
	public InstruktorConverter(InstruktorRepository ir) {
		
		this.ir = ir;
	}


	@Override
	public Instruktor convert(String source) {
		int instruktorid=-1;
		 try {
			 instruktorid = Integer.parseInt(source);
		 }
		 catch(NumberFormatException e) {
			 throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Instruktor.class), instruktorid, null);
		 }
		  Instruktor i = ir.findById(instruktorid).get();
		 //Grupa apdejtovana = gr.grupaUpdateBrojPopunjenih(g);
		 return i;
	}

}
