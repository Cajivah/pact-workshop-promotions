package com.jmalyjasiak.pactworkshop.promotions.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PromotionsController {

    private final PromotionsRepository promotionsRepository;

    public PromotionsController(PromotionsRepository promotionsRepository) {
        this.promotionsRepository = promotionsRepository;
    }

    @GetMapping
    public List<Promotion> getAllPromotions() {
        return promotionsRepository.getAllPromotions();
    }

    @GetMapping("v1/promotions/{promotionId}")
    public Promotion findPromotion(@PathVariable String promotionId) {
        return promotionsRepository.findPromotion(promotionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}