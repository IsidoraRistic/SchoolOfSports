package com.example.demo.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.TerenRepository;

import model.Grupa;
import model.Teren;

public class TerenConverter implements Converter<String, Teren>{

	TerenRepository tr;
	public TerenConverter(TerenRepository tr) {
		this.tr = tr;
	}
	
	
	@Override
	public Teren convert(String source) {
		 int terenid=-1;
		 try {
			 terenid = Integer.parseInt(source);
		 }
		 catch(NumberFormatException e) {
			 throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Teren.class), terenid, null);
		 }
		  Teren t = tr.findById(terenid).get();
		 //Grupa apdejtovana = gr.grupaUpdateBrojPopunjenih(g);
		 return t;
	}
	
}
