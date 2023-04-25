package metro;

import java.util.*;

public class ShortestPathFinder {

    public static ArrayList<Station> findShortestPath(Station start, Station end) {

        // Initialisierung der besuchten und Warteschlangen-Arrays
        HashMap<Station, Station> visited = new HashMap<>();
        Queue<Station> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, null);

        // Starten Sie den BFS-Algorithmus
        while (!queue.isEmpty()) {
            Station current = queue.poll();

            // Wenn wir das Ziel erreichen, sind wir fertig.
            if (current == end) {
                break;
            }

            // Andernfalls werden alle nicht besuchten Nachbarn in die Warteschlange aufgenommen.
            for (Station neighbor : current.getNeighbors()) {
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, current);
                }
            }
        }

        // Wenn wir das Ziel nicht gefunden haben, geben wir null zurück.
        if (!visited.containsKey(end)) {
            return null;
        }

        // Konstruieren Sie einen kürzesten Weg, indem Sie dem besuchten Feld folgen
        ArrayList<Station> path = new ArrayList<>();
        Station current = end;
        while (current != null) {
            path.add(0, current);
            current = visited.get(current);
        }

        return path;
    }
}
