package com.petermarshall;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player1;
    private Player player2;
    private String name1 = "Andy Murray";
    private String name2 = "Roger Federer";

    @Before
    public void setup() {
        player1 = new Player(name1);
        player2 = new Player(name2);
    }

    @Test
    public void canCreatePlayers() {
        assertNotNull(player1);
        assertNotNull(player2);
    }

    @Test
    public void canGetName() {
        assertEquals(player1.getName(), name1);
        assertEquals(player2.getName(), name2);
    }

    @Test
    public void canGetScore() {
        assertNotNull(player1.getScore());
        assertNotNull(player2.getScore());
    }
}
