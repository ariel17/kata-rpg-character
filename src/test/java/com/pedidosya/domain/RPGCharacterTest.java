package com.pedidosya.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RPGCharacterTest {

    private RPGCharacter character;

    private RPGCharacter other;

    @Before
    public void setUp() {
        character = new RPGCharacter("me");
        other = new RPGCharacter("other");
    }

    @Test
    public void testNew() {
        Assert.assertEquals(1, character.getLevel());
        Assert.assertEquals(1000, character.getHealth());
        Assert.assertTrue(character.isAlive());
    }

    @Test
    public void testHitButAlive() {
        Assert.assertTrue(character.getsHit(other, 100));
        Assert.assertEquals(900, character.getHealth());
        Assert.assertTrue(character.isAlive());
    }

    @Test
    public void testHitAndDead() {
        Assert.assertTrue(character.getsHit(other,2000));
        Assert.assertEquals(0, character.getHealth());
        Assert.assertFalse(character.isAlive());
    }

    @Test
    public void testHealWhenDead() {
        Assert.assertTrue(character.getsHit(other, 2000));
        Assert.assertFalse(character.heal(other, 1000));
    }

    @Test
    public void testHealWhenAliveButLessThan1000() {
        Assert.assertTrue(character.getsHit(other, 400));
        Assert.assertTrue(character.heal(other,200));
        Assert.assertEquals(800, character.getHealth());
    }

    @Test
    public void testHealWhenAliveButMoreThan1000() {
        Assert.assertTrue(character.getsHit(other,400));
        Assert.assertTrue(character.heal(other,500));
        Assert.assertEquals(1000, character.getHealth());
    }

    @Test
    public void testCannotHealMyself() {
        Assert.assertTrue(character.getsHit(other,400));
        Assert.assertFalse(character.heal(character,200));
        Assert.assertEquals(600, character.getHealth());
    }

    @Test
    public void testCannotHitMyself() {
        Assert.assertFalse(character.getsHit(character,400));
        Assert.assertEquals(1000, character.getHealth());
    }

    @Test
    public void testEnemyHitsMoreHarder() {
        other = new RPGCharacter("powerful", 6);
        Assert.assertTrue(character.getsHit(other, 50));
        Assert.assertEquals(925, character.getHealth());
    }

    @Test
    public void testEnemyHitsSoftly() {
        character = new RPGCharacter("powerful", 10);
        Assert.assertTrue(character.getsHit(other, 50));
        Assert.assertEquals(975, character.getHealth());
    }
}
