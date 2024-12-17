package ru.netology.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.dto.Ticket;
import ru.netology.utils.TicketTimeComparator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();

    // Вообще время скорее всего в Unix time, но в тестах это не принципиально
    Ticket ticket1 = new Ticket("Moscow", "Paris", 100, 10, 15);
    Ticket ticket2 = new Ticket("Moscow", "Paris", 200, 12, 17);
    Ticket ticket3 = new Ticket("Moscow", "Paris", 150, 14, 20);
    Ticket ticket4 = new Ticket("Moscow", "London", 300, 16, 20);
    Ticket ticket5 = new Ticket("Moscow", "Paris", 50, 8, 11);

    @BeforeEach
    void setUp() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
    }

    @Test
    void shouldReturnNegativeWhenFirstPriceIsLower() {
        assertTrue(ticket1.compareTo(ticket2) < 0);
    }

    @Test
    void shouldReturnPositiveWhenFirstPriceIsHigher() {
        assertTrue(ticket2.compareTo(ticket1) > 0);
    }

    @Test
    void shouldReturnZeroWhenPricesAreEqual() {
        Ticket ticketEqual = new Ticket("Moscow", "Paris", 100, 10, 15);
        assertEquals(0, ticket1.compareTo(ticketEqual));
    }

    @Test
    void shouldReturnZeroWhenFlightDurationsAreEqual() {
        assertEquals(0, timeComparator.compare(ticket1, ticket2));
    }

    @Test
    void shouldReturnNegativeWhenFirstFlightIsShorter() {
        assertTrue(timeComparator.compare(ticket5, ticket1) < 0); // 3 часа < 5 часов
    }

    @Test
    void shouldReturnPositiveWhenFirstFlightIsLonger() {
        assertTrue(timeComparator.compare(ticket3, ticket1) > 0); // 6 часов > 5 часов
    }

    @Test
    void shouldFindTicketsAndSortByPrice() {
        Ticket[] expected = {ticket5, ticket1, ticket3, ticket2};
        Ticket[] actual = aviaSouls.search("Moscow", "Paris");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyWhenNoTicketsFound() {
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Moscow", "Berlin");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketsAndSortByFlightDuration() {
        Ticket[] expected = {ticket5, ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Paris", timeComparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyWhenNoTicketsFoundWithComparator() {
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Berlin", timeComparator);
        assertArrayEquals(expected, actual);
    }
}
