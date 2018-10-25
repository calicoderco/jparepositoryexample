package com.practice.repository;

import com.practice.model.Subscription;

import java.util.Collection;

public interface SubscriptionCustomRepository {

    public Collection<Subscription> findAllSubscriptionsWithBodyLike(String stringToSearchFor);
}
