package com.gridnine.testing.interfaces.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.interfaces.FlightFilter;

import java.time.LocalDateTime;

public class DepartureBeforeNowFilter implements FlightFilter {
    @Override
    public boolean permission(Flight flight) {
        return flight.getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()));
    }
}
