package test;

import metro.Line;
import metro.Station;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class StationTest {

    @Test
    public void testGetName() {
        Station station = new Station("Kings Cross");
        assertEquals("Kings Cross", station.getName());
    }

    @Test
    public void testGetNeighbors() {
        Station station1 = new Station("Kings Cross");
        Station station2 = new Station("Euston");
        Station station3 = new Station("Paddington");
        station1.addNeighbor(station2);
        station1.addNeighbor(station3);
        ArrayList<Station> neighbors = station1.getNeighbors();
        assertTrue(neighbors.contains(station2));
        assertTrue(neighbors.contains(station3));
        assertEquals(2, neighbors.size());
    }

    @Test
    public void testGetLines() {
        Station station = new Station("Kings Cross");
        Line line1 = new Line("Circle Line");
        Line line2 = new Line("Piccadilly Line");
        station.addLines(line1);
        station.addLines(line2);
        ArrayList<Line> lines = station.getLines();
        assertTrue(lines.contains(line1));
        assertTrue(lines.contains(line2));
        assertEquals(2, lines.size());
    }

    @Test
    public void testAddLines() {
        Station station = new Station("Kings Cross");
        Line line = new Line("Circle Line");
        station.addLines(line);
        ArrayList<Line> lines = station.getLines();
        assertTrue(lines.contains(line));
        assertEquals(1, lines.size());
    }

    @Test
    public void testAddNeighbor() {
        Station station1 = new Station("Kings Cross");
        Station station2 = new Station("Euston");
        station1.addNeighbor(station2);
        ArrayList<Station> neighbors = station1.getNeighbors();
        assertTrue(neighbors.contains(station2));
        assertEquals(1, neighbors.size());
        ArrayList<Station> station2Neighbors = station2.getNeighbors();
        assertTrue(station2Neighbors.contains(station1));
        assertEquals(1, station2Neighbors.size());
    }
}