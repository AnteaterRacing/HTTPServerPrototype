package RaspberryPiHTTPServer;

public class SensorData {
    private double acc;
    private double latitude;
    private double longitude;
    private double other;

    public SensorData() {
        acc = 0.0;
        latitude = 0.0;
        longitude = 0.0;
        other = 0.0;
    }

    @Override
    public String toString() {
        return "SensorDataObject [acc=" + acc +
               ",\nlatitude=" + latitude +
               ",\nlongitude=" + longitude +
               ",\nother=" + other + "]";
    }
}