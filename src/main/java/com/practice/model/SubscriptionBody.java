package com.practice.model;

import javax.persistence.*;

@Entity
public class SubscriptionBody {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long id;

    @Lob
    @Column(length=100000)
    public String data;

    @ManyToOne
    Subscription subscription;
}
