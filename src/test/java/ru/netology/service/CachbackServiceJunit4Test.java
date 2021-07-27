package ru.netology.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CachbackServiceJunit4Test {
    public CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldCalculateIf900Positive() {
        assertEquals(service.remain(900), 100);
    }

    @Test
    public void shouldCalculateIf1000Positive() {
        assertEquals(service.remain(1000), 1000); //кажется, это обещанный баг
    }

    @Test
    public void shouldCalculateIf1001Positive() {
        assertEquals(service.remain(1001), 999); // зачем нам предлагает закупить на 999р, если у нас уже выше границы?
    }

    @Test
    public void shouldCalculateIf0Positive() {
        assertEquals(service.remain(0), 1000);
    }

    @Test
    public void shouldCalculateIfNegative() {
        assertEquals(service.remain(-1), 1001); //очень странно, что вообще можно купить на -1рубль :)
    }
}