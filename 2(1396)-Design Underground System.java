import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores check-in information: id -> (stationName, time)
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stores total travel time and trip count
    class Trip {
        double totalTime;
        int count;

        Trip(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    private Map<Integer, CheckIn> checkIns;
    private Map<String, Trip> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);

        String route = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        Trip trip = trips.getOrDefault(route, new Trip(0, 0));
        trip.totalTime += travelTime;
        trip.count++;

        trips.put(route, trip);

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Trip trip = trips.get(route);
        return trip.totalTime / trip.count;
    }
}
