package ru.netology.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CachbackServiceJunit4Test {
    public CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldCalculateIf900Positive() {
        assertEquals(100, service.remain(900));
    }

    @Test
    public void shouldCalculateIf1000Positive() {
        assertEquals(0, service.remain(1000)); //кажется, это обещанный баг
    }

    @Test
    public void shouldCalculateIf1001Positive() {
        assertEquals(0, service.remain(1001)); // зачем нам предлагает закупить на 999р, если у нас уже выше границы?
    }

    @Test
    public void shouldCalculateIf0Positive() {
        assertEquals(1000, service.remain(0));
    }

    @Test
    public void shouldCalculateIfNegative() {
        assertEquals(1001, service.remain(-1)); //очень странно, что вообще можно купить на -1рубль :)
    }
}