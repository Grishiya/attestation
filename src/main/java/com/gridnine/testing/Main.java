package com.gridnine.testing;

import com.gridnine.testing.filter.interfaces.FlightFilter;
import com.gridnine.testing.filter.interfaces.filter.FlightFilterFactory;
import com.gridnine.testing.filter.interfaces.filter.help.Rule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<Flight> flights;
    public static void main(String[] args) {
        flights = FlightBuilder.createFlights();
        System.out.println("All flights: " + flights);

        Rule[] rules = Rule.values();
        for (Rule rule : rules) {
            FlightFilter filter = FlightFilterFactory.createFlightFilter(rule);
            List<Flight> filteredFlights = flights.stream()
                    .filter(filter::permission)
                    .collect(Collectors.toList());
            System.out.println("Filtered flights (" + rule + "): " + filteredFlights);
        }
    }
}