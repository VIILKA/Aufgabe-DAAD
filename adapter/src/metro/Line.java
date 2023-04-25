package metro;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> stations;

    public Line(String name) {
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public void addStation(Station station){
        stations.add(station);
    }

    public void printStationsNames(){
        for (Station station:stations) {System.out.println(station.getName());}
    }

    public void printLineName(){
        System.out.println(this.getName());
    }
}
