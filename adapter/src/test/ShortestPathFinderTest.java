package test;

import metro.ShortestPathFinder;
import metro.Station;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ShortestPathFinderTest {

    @Test
    public void testFindShortestPath() {


        Station s1 = new Station("Station 1");
        Station s2 = new Station("Station 2");
        Station s3 = new Station("Station 3");
        Station s4 = new Station("Station 4");


        s1.addNeighbor(s2);
        s2.addNeighbor(s3);
        s3.addNeighbor(s4);


        ArrayList<Station> path = ShortestPathFinder.findShortestPath(s1, s4);


        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(s1, path.get(0));
        assertEquals(s2, path.get(1));
        assertEquals(s3, path.get(2));
        assertEquals(s4, path.get(3));
    }

    @Test
    public void testFindShortestPathNoPath() {


        Station s1 = new Station("Station 1");
        Station s2 = new Station("Station 2");
        Station s3 = new Station("Station 3");


        s1.addNeighbor(s2);


        ArrayList<Station> path = ShortestPathFinder.findShortestPath(s1, s3);


        assertNull(path);
    }

    @Test
    public void testFindShortestPathSameStartAndEnd() {


        Station s1 = new Station("Station 1");


        ArrayList<Station> path = ShortestPathFinder.findShortestPath(s1, s1);


        assertNotNull(path);
        assertEquals(1, path.size());
        assertEquals(s1, path.get(0));
    }
}