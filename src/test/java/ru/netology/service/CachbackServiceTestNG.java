package ru.netology.service;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CachbackServiceTestNG {
    public CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldCalculateIf900Positive() {
        assertEquals(service.remain(900), 100);
    }

    @Test
    public void shouldCalculateIf1000Positive() {
        assertEquals(service.remain(1000), 0); //кажется, это обещанный баг
    }

    @Test
    public void shouldCalculateIf1001Positive() {
        assertEquals(service.remain(1001), 0); //а в итоге предлагает закупить еще на 999р
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