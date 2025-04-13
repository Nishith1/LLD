package entity;

public class Location {
    double latitude;
    double longitude;

    public Location(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public double distanceTo(Location other) {
        // Simple Euclidean; in production use Haversine formula
        double dx = this.latitude - other.latitude;
        double dy = this.longitude - other.longitude;
        return Math.sqrt(dx * dx + dy * dy);
    }
}