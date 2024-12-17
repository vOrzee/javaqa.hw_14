package ru.netology.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Ticket implements Comparable<Ticket> {
    private final String from; // аэропорт откуда
    private final String to; // аэропорт куда
    private final int price; // цена
    private final int timeFrom; // время вылета (по москве)
    private final int timeTo; // время прилёта (по москве)

    public Ticket(String from, String to, int price, int timeFrom, int timeTo) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    @Override
    public int compareTo(Ticket o) {
        return Integer.compare(this.price, o.price);
    }
}
