package com.jmalyjasiak.pactworkshop.promotions.api;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PromotionsRepository {

    private final Map<String, Promotion> db = new ConcurrentHashMap<>();

    public Optional<Promotion> findPromotion(String promotionId) {
        return Optional.of(db.get(promotionId));
    }

    public List<Promotion> getAllPromotions() {
        return List.copyOf(db.values());
    }
}
