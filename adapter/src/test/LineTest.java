package test;

import static org.junit.Assert.*;

import metro.Line;
import metro.Station;
import org.junit.Test;
import java.util.ArrayList;

public class LineTest {

    @Test
    public void testGetName() {
        Line line = new Line("Red");
        assertEquals("Red", line.getName());
    }

    @Test
    public void testSetName() {
        Line line = new Line("Green");
        line.setName("Purple");
        assertEquals("Purple", line.getName());
    }

    @Test
    public void testGetStations() {
        Line line = new Line("Blue");
        ArrayList<Station> stations = new ArrayList<>();
        Station station1 = new Station("A");
        Station station2 = new Station("B");
        Station station3 = new Station("C");
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);
        line.setStations(stations);
        assertEquals(stations, line.getStations());
    }

    @Test
    public void testAddStation() {
        Line line = new Line("Yellow");
        Station station = new Station("D");
        line.addStation(station);
        assertTrue(line.getStations().contains(station));
    }

    @Test
    public void testPrintStationsNames() {
        Line line = new Line("Orange");
        ArrayList<Station> stations = new ArrayList<>();
        Station station1 = new Station("E");
        Station station2 = new Station("F");
        Station station3 = new Station("G");
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);
        line.setStations(stations);
        line.printStationsNames();

    }

    @Test
    public void testPrintLineName() {
        Line line = new Line("Pink");
        line.printLineName();

    }

}