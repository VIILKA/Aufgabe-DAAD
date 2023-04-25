package test;

import metro.Line;
import metro.Station;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestClasses {

    @Test
    void testLineName() {
        Line line = new Line("Line 1");
        Assertions.assertEquals("Line 1", line.getName());
    }

    @Test
    void testLineStations() {
        Line line = new Line("Line 1");
        ArrayList<Station> stations = new ArrayList<>();
        Station station1 = new Station("Station 1");
        Station station2 = new Station("Station 2");
        stations.add(station1);
        stations.add(station2);
        line.setStations(stations);
        Assertions.assertEquals(2, line.getStations().size());
        Assertions.assertEquals("Station 1", line.getStations().get(0).getName());
        Assertions.assertEquals("Station 2", line.getStations().get(1).getName());
    }

    @Test
    void testStationName() {
        Station station = new Station("Station 1");
        Assertions.assertEquals("Station 1", station.getName());
    }

    @Test
    void testStationNeighbors() {
        Station station1 = new Station("Station 1");
        Station station2 = new Station("Station 2");
        station1.addNeighbor(station2);
        Assertions.assertEquals(1, station1.getNeighbors().size());
        Assertions.assertEquals("Station 2", station1.getNeighbors().get(0).getName());
    }

    @Test
    void testStationLines() {
        Station station = new Station("Station 1");
        ArrayList<Line> lines = new ArrayList<>();
        Line line1 = new Line("Line 1");
        Line line2 = new Line("Line 2");
        lines.add(line1);
        lines.add(line2);
        station.setLines(lines);
        Assertions.assertEquals(2, station.getLines().size());
        Assertions.assertEquals("Line 1", station.getLines().get(0).getName());
        Assertions.assertEquals("Line 2", station.getLines().get(1).getName());
    }
}