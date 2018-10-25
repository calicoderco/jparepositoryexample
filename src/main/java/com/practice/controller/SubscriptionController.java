package com.practice.controller;

import com.practice.model.Subscription;
import com.practice.model.SubscriptionBody;
import com.practice.repository.SubscriptionRepository;
import com.practice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Subscription> getAllSubscriptions(@RequestParam(name="id", required=false) Long id, @RequestParam(name="body", required=false) String body) {
        if(id != null) {
            Collection<Subscription> subscriptions = new LinkedHashSet<Subscription>();
            subscriptions.add(subscriptionRepository.findById(id).get());
            return subscriptions;
        } else if(body != null) {
            return subscriptionRepository.findAllSubscriptionsWithBodyLike(body);
        } else {
            return subscriptionService.getAllSubscriptions();
        }
    }
}
