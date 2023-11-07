import java.util.ArrayList;
import java.util.List;
class Manager {
    private List<Taxi> taxis;

    public Manager() {
        taxis = new ArrayList<>();
    }

    public void addTaxi(Taxi taxi) {
        taxis.add(taxi);
    }

    public Taxi findNearestTaxi(double x, double y) {
        if (taxis.isEmpty()) {
            return null;
        }

        Taxi nearestTaxi = taxis.get(0);
        double minDistance = nearestTaxi.calculateDistance(x, y);

        for (Taxi taxi : taxis) {
            double distance = taxi.calculateDistance(x, y);
            if (distance < minDistance) {
                minDistance = distance;
                nearestTaxi = taxi;
            }
        }

        return nearestTaxi;
    }
}

 class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.addTaxi(new Taxi("Taxi1", 7.2, 8.0, 108.5));
        manager.addTaxi(new Taxi("Taxi2", 9.0, 22.4, 122.0));

        double passengerX = 2.0;
        double passengerY = 3.0;

        Passenger passenger = new Passenger(passengerX, passengerY);

        Taxi nearestTaxi = manager.findNearestTaxi(passenger.getLocationX(), passenger.getLocationY());

        if (nearestTaxi != null) {
            double distance = nearestTaxi.calculateDistance(passengerX, passengerY);
            double fare = nearestTaxi.calculateFare(distance);

            System.out.println("The nearest taxi to You is: " + nearestTaxi.getId());
            System.out.println("Fare for the ride You took in Rupees is:" + fare);
        } else {
            System.out.println("Sorry:no taxi available.");
        }
    }
}

