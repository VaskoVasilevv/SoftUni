package com.example.homework.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
    @ManyToOne
    private User bayer;
    @ManyToMany
    private Set<Game> games;

    public Order() {

    }

    public User getBayer() {
        return bayer;
    }

    public void setBayer(User user) {
        this.bayer = user;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}

