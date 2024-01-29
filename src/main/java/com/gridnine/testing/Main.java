package com.gridnine.testing;

import com.gridnine.testing.filter.interfaces.FlightFilter;
import com.gridnine.testing.filter.interfaces.filter.FlightFilterFactory;
import com.gridnine.testing.filter.interfaces.filter.help.Rule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    List<Segment> segments;
    static List<Flight> flights;
    Segment segment = new Segment(LocalDateTime.of(2024, 2, 4, 12, 45),
           LocalDateTime.of( 2024, 2, 4, 16, 0));
    Segment segment1=new Segment(LocalDateTime.of(2024, 2, 4, 11, 45),
            LocalDateTime.of( 2024, 2, 4, 16, 0));
    Flight flight = new Flight(segments);




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