package com.gridnine.testing.filter.interfaces;

import com.gridnine.testing.Flight;

public interface FlightFilter {
    boolean permission(Flight flight);
}
