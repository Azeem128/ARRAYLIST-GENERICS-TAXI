public class Taxi {
    private String id;
    private double locationX;
    private double locationY;
    private double fareRate;
    public Taxi(String id, double locationX, double locationY,double fareRate) {
        this.id = id;
        this.locationX = locationX;
        this.locationY = locationY;
        this.fareRate = fareRate;
    }

    public double getLocationX() {
        return locationX;
    }

    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public String getId() {
        return id;}
    public void setId(String id) {
        this.id = id;
    }
    public double calculateFare(double distance) {
        return distance * fareRate;}

    public void setFareRate(double fareRate) {
        this.fareRate = fareRate;
    }

    public double calculateDistance(double x, double y) {
        double changeinX = x - locationX;
        double changeinY = y - locationY;
        return Math.sqrt(changeinX * changeinX + changeinY * changeinY);
    }
}
