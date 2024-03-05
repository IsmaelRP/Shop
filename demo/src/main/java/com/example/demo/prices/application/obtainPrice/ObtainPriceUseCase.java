package com.example.demo.prices.application.obtainPrice;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.prices.domain.model.PriceQuery;
import com.example.demo.prices.domain.repository.PriceQueryRepository;

@Service
public class ObtainPriceUseCase {

	@Autowired
	private PriceQueryRepository priceQueryRepository;

    public Optional<PriceQuery> findPriceByDate(LocalDateTime application, int product_id, short subsidiary_id){
        return this.priceQueryRepository.findByApplicationDate(application, product_id, subsidiary_id);
    }

}
