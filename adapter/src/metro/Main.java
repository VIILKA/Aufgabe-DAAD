package metro;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class Main {

    public static Station getStation(ArrayList<Station> stationList, String stationName) {
        // In der Liste, die in dieser Methode übergeben wird, finden wir den gewünschten Sender durch einen Namen vom Typ String
        for (Station i: stationList) {
            if(i.getName().equals(stationName)){return i;}
        }
        return null;
    }
    public static void printInfoAboutStations(ArrayList<Station> stations){
        // Ausgabe von Informationen über jede com.Station in der Liste auf der Konsole - ihre Nachbarn und die Leitung, auf der die com.Station liegt
        for (Station st : stations) {
            System.out.println("com.Station: " + st.getName());
            System.out.print("Seine Nachbarn: ");
            st.printNeighborStations();
            System.out.print("Seine Zeilen: ");
            st.printStationLines();
            System.out.println("____________________________");}
    }
    public static void printShortestPath(Station startStation, Station endStation,ArrayList<Station> path, String startLine) {
        // Zeigen Sie in der BFS-Grafikliste den gewünschten Pfad auf der Konsole an
        if (path != null){
            try {
                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i).getName());
                    ArrayList<Line> lineList1 = path.get(i).getLines();
                    ArrayList<Line> lineList2 = path.get(i + 1).getLines();
                    lineList1.retainAll(lineList2);
                    for (Line j : lineList1) {
                        if(startLine == j.getName() || startLine == null){
                            System.out.println(" (" + j.getName()+")");
                        }
                        else {
                            System.out.println(" (Change to " + j.getName() +")");
                        }
                        startLine = j.getName();
                    }

                }
            }catch (IndexOutOfBoundsException ignored){}
        }
        else{
            System.out.println("Path not found");
        }
    }



    public static void main(String[] args) throws Exception {
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Line> lines = new ArrayList<>();

// Lesen von Textdateien aus einem Ordner, Erstellen von Linien- und Stationsobjekten basierend auf den Namen aus den Textdateien und Ausfüllen der Attribute der Objekte
        try {
            File folder = new File("Lines");
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {

                Line line = new Line(file.getName().replace(".txt", ""));
                lines.add(line);

                FileInputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_16LE);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                Station lastStation = null;
                String station_name;

                while ((station_name = bufferedReader.readLine()) != null) {
                    if (getStation(stations, station_name) == null) {
                        Station station = new Station(station_name);
                        if (lastStation != null)
                            station.addNeighbor(lastStation);
                        stations.add(station);
                        station.addLines(line);
                        line.addStation(station);
                        lastStation = station;}
                    else {
                        getStation(stations, station_name).addNeighbor(lastStation);
                        getStation(stations, station_name).addLines(line);
                        line.addStation(getStation(stations, station_name));
                        lastStation = getStation(stations, station_name);
                    }
                }
                bufferedReader.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();}

        // Der Beginn des Programms selbst
        printInfoAboutStations(stations);

        // Empfang des Namens der Start- und Endstation vom Benutzer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Target: ");
        String startStationName = scanner.nextLine();
        System.out.print("Ziel: ");
        String endStationName = scanner.nextLine();

        Station startStation = getStation(stations,startStationName);
        Station endStation = getStation(stations,endStationName);

        // Durchlaufen eines BFS-Graphen mit dem Algorithmus
        ArrayList<Station> path = ShortestPathFinder.findShortestPath(startStation, endStation);
        String startLine = null;

        // Geben Sie den gewünschten Pfad auf der Konsole aus
        printShortestPath(startStation,endStation,path,startLine);




    }
}


