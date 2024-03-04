package com.example.demo.prices.infraestructure.inbound.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prices.application.obtainPrice.ObtainPriceUseCase;
import com.example.demo.prices.domain.model.PriceQuery;
import com.example.demo.shared.ResponseObj;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PricesController {
	
	@Autowired
	private ObtainPriceUseCase pricesUseCase;

	Logger logger = LoggerFactory.getLogger(PricesController.class);
	
    @SuppressWarnings("rawtypes")
	@GetMapping("findPrice")
    public ResponseEntity<ResponseObj> findPrice(@RequestParam short subsidiary_id,
    											@RequestParam int product_id, 
    											@RequestParam LocalDateTime application){


    	Optional<PriceQuery> priceQueryOptional = this.pricesUseCase.findAllPosts(application, product_id, subsidiary_id);
    	
        if (priceQueryOptional.isPresent()) {
        	logger.info("Price controller - findPrice successful");
            return ResponseEntity.ok(new ResponseObj<PriceQuery>(priceQueryOptional.get(), "Price found"));
        } else {
        	logger.warn("Price controller - findPrice unsuccessful");
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObj<String>("Error", "Price not found"));
        }
        
    }
    
}
