package com.gridnine.testing.interfaces;

import com.gridnine.testing.Flight;

public interface FlightFilter {
    boolean permission(Flight flight);
}
