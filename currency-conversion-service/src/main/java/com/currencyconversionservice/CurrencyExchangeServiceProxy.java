package com.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchange-service")//,url="localhost:8000")
@FeignClient(name="netflix-zuul-api-gateway-server")//,url="localhost:8000")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
public CurrencyConversionBean  retrieveExchangeValue(@PathVariable String from,@PathVariable  String to);
//(@PathVariable("from") String from,@PathVariable("from")  String to);
		 


}
