package com.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
@Autowired
private 	CurrencyExchangeServiceProxy proxy;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean ConvertCurrency(@PathVariable String from,
			@PathVariable String to, 
			@PathVariable BigDecimal quantity ) {
		System.out.println("sriraam ");
		return new CurrencyConversionBean(1L,from,to,BigDecimal.ONE,quantity,quantity,0);
		

		
	}


	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean ConvertCurrencyFeign(@PathVariable String from,
			@PathVariable String to, 
			@PathVariable BigDecimal quantity ) {
//		feign
		System.out.println("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}");
		 CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		 response.setQuantity(quantity);
		 BigDecimal conversionMultiple=  response.getConversionMultiple();
		 BigDecimal setTotalCalculatedAmount=conversionMultiple;
		 
		 response.setTotalCalculatedAmount(setTotalCalculatedAmount);
		 
		return response;
		
	}

}
