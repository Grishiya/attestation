package com.gridnine.testing.filter.interfaces.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.filter.interfaces.FlightFilter;

import java.util.stream.IntStream;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public boolean permission(Flight flight) {
        return IntStream.range(0, flight.getSegments().size() - 1)
                .anyMatch(i -> flight.getSegments().get(i).getArrivalDate()
                        .isAfter(flight.getSegments().get(i + 1).getDepartureDate()));
    }
}
