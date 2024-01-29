package com.gridnine.testing.filter.interfaces.filter;

import com.gridnine.testing.filter.interfaces.FlightFilter;
import com.gridnine.testing.filter.interfaces.filter.help.Rule;
import com.gridnine.testing.filter.interfaces.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filter.interfaces.impl.DepartureBeforeNowFilter;
import com.gridnine.testing.filter.interfaces.impl.GroundTimeMoreThanTwoHoursFilter;

public class FlightFilterFactory {
    public static FlightFilter createFlightFilter(Rule rule) {
    switch (rule) {
        case DEPARTURE_BEFORE_NOW:
            return new DepartureBeforeNowFilter();
        case ARRIVAL_BEFORE_DEPARTURE:
            return new ArrivalBeforeDepartureFilter();
        case GROUND_TIME_MORE_THAN_TWO_HOURS:
            return new GroundTimeMoreThanTwoHoursFilter();
        default:
            throw new IllegalArgumentException("Unknown rule: " + rule);
    }
}
}
