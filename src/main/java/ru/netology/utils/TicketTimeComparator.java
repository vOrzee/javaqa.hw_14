package ru.netology.utils;

import ru.netology.dto.Ticket;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int timeToFlyFirstTicket = t1.getTimeTo() - t1.getTimeFrom();
        int timeToFlySecondTicket = t2.getTimeTo() - t2.getTimeFrom();
        return Integer.compare(timeToFlyFirstTicket, timeToFlySecondTicket);
    }
}
