package com.practice.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Subscription {
    public String articleName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(mappedBy = "subscription")
    public Collection<SubscriptionBody> bodies;
}
