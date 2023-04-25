package metro;

import java.util.ArrayList;

public class Station {
    private String station_name;
    private ArrayList<Station> neighbors;
    private ArrayList<Line> lines;

    public Station(String station_name) {
        this.station_name = station_name;
        this.neighbors = new ArrayList<>();
        this.lines = new ArrayList<>();
    }

    public String getName() {
        return station_name;
    }

    public ArrayList<Station> getNeighbors() {
        return neighbors;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public void setNeighbors(ArrayList<Station> neighbors) {
        this.neighbors = neighbors;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public void addLines(Line line){
        lines.add(line);
    }


    public void addNeighbor(Station station){
        neighbors.add(station);
        if (!station.getNeighbors().contains(this)){
            station.addNeighbor(this);
        }
    }

    public void printNeighborStations(){
        for (Station st: neighbors
             ) {
            System.out.println(st.getName());
        }
    }

    public void printStationLines(){
        for (Line st: lines
        ) {
            System.out.println(st.getName());
        }
    }


    }



