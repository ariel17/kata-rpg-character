package com.pedidosya.domain;

import java.util.Objects;

public class RPGCharacter {

    public static final int INITIAL_LEVEL = 1;

    public static final int INITIAL_HEALTH = 1000;

    public static final int HIT_THRESHOLD = 5;

    public static final double HIT_REDUCER = 0.5;

    public static final double HIT_INCREASER = 1.5;

    private int health;

    private int level;

    private boolean alive;

    private String name;

    public RPGCharacter(String name){
        health = INITIAL_HEALTH;
        level = INITIAL_LEVEL;
        alive = true;
        this.name = name;
    }

    public RPGCharacter(String name, int level){
        health = INITIAL_HEALTH;
        this.level = level;
        alive = true;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean getsHit(RPGCharacter enemy, int damage) {
        if (enemy.equals(this)) {
            return false;
        }

        double realDamage;
        if (level >= enemy.getLevel() + HIT_THRESHOLD ) {
            realDamage = damage * HIT_REDUCER;
        } else if (level <= enemy.getLevel() - HIT_THRESHOLD) {
            realDamage = damage * HIT_INCREASER;
        } else {
            realDamage = damage;
        }

        health -= realDamage;
        if (health <= 0) {
            alive = false;
            health = 0;
        }
        return true;
    }

    public boolean heal(RPGCharacter ally, int health) {
        if (ally.equals(this) || !alive) {
            return false;
        }
        this.health += health;
        if (this.health > 1000) {
            this.health = 1000;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RPGCharacter)) return false;
        RPGCharacter that = (RPGCharacter) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}