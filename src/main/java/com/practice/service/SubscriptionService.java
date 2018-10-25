package com.practice.service;

import com.practice.model.Subscription;
import com.practice.model.SubscriptionBody;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Service
public class SubscriptionService {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional public Collection<Subscription> getAllSubscriptions() {
        System.out.println("transName: " + TransactionSynchronizationManager.getCurrentTransactionName() + ", isAlive: " + TransactionSynchronizationManager.isActualTransactionActive());

        Query q = entityManager.createQuery("select s from Subscription s");
        List<Subscription> subscriptions = q.getResultList();
        return subscriptions;
    }

    @Transactional public Collection<SubscriptionBody> getBodiesById(Long id) {
        System.out.println("transName: " + TransactionSynchronizationManager.getCurrentTransactionName() + ", isAlive: " + TransactionSynchronizationManager.isActualTransactionActive());
        Query q = entityManager.createQuery("select s from Subscription s where s.id=" + id);
        Subscription subscription = (Subscription) q.getSingleResult();
        return subscription.bodies;
    }


}
