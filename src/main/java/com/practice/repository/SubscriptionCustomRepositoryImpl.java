package com.practice.repository;
import com.practice.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Collections;

public class SubscriptionCustomRepositoryImpl implements SubscriptionCustomRepository {
    @Autowired
    EntityManager entityManager;

    public SubscriptionCustomRepositoryImpl() {
        System.out.println("Creating custom repository impl");
    }

    public Collection<Subscription> findAllSubscriptionsWithBodyLike(String stringToSearchFor) {
        return Collections.EMPTY_SET;
    }
}
