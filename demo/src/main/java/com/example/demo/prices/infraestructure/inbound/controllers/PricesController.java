package com.example.demo.prices.infraestructure.inbound.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prices.application.obtainPrice.ObtainPriceUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PricesController {
	
	@Autowired
	private ObtainPriceUseCase pricesUseCase;
	
    @GetMapping("findPrice")
    /*public ResponseEntity findPrice(@PathVariable short subsidiary_id,
    								@RequestParam LocalDateTime application, 
    								@RequestParam int product_id){
    								*/
    public ResponseEntity findPrice(@RequestParam short subsidiary_id,
			@RequestParam LocalDateTime application, 
			@RequestParam int product_id){

        return ResponseEntity.ok(this.pricesUseCase.findAllPosts(application, product_id, subsidiary_id));
    }
    
}
