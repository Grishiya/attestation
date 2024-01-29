package com.gridnine.testing.filter.interfaces.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.filter.interfaces.FlightFilter;

import java.time.temporal.ChronoUnit;

public class GroundTimeMoreThanTwoHoursFilter implements FlightFilter {
    @Override
    public boolean permission(Flight flight) {
        long groundTime = flight.getSegments().stream()
                .skip(1)
                .mapToLong(segment -> ChronoUnit.MINUTES.between(segment.getArrivalDate(), segment.getDepartureDate()))
                .sum();
        return groundTime > 120;
    }
}
