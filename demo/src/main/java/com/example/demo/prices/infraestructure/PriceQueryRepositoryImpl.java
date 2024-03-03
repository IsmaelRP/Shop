package com.example.demo.prices.infraestructure;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.prices.domain.model.PriceQuery;
import com.example.demo.prices.domain.repository.PriceQueryRepository;
import com.example.demo.prices.infraestructure.outbound.database.PricesH2Repository;
import com.example.demo.prices.infraestructure.outbound.database.entity.Prices;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PriceQueryRepositoryImpl implements PriceQueryRepository {

	@Autowired
	private PricesH2Repository pricesH2Repository;

	@Override
    public Optional<PriceQuery> findByApplicationDate(LocalDateTime application, int productId, short subsidiaryId) {
        Optional<Prices> price = pricesH2Repository.findPriceByDate(productId, subsidiaryId, application);

        return price.map(p -> new PriceQuery(
                p.getId().getProductId(),
                p.getId().getBrandId(),
                p.getPrice(),
                p.getStartDate(),
                p.getEndDate()
        ));
    }
	
}
