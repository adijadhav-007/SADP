import java.util.Observable;

public class WeatherStation extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged();  
        notifyObservers(); 
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

       weatherStation.addObserver((observable, arg) -> {
            WeatherStation ws = (WeatherStation) observable;
            System.out.println("Updated Weather Measurements:");
            System.out.println("Temperature: " + ws.getTemperature());
            System.out.println("Humidity: " + ws.getHumidity());
            System.out.println("Pressure: " + ws.getPressure());
        });

        weatherStation.setMeasurements(25.5f, 65.0f, 1013.1f);
        weatherStation.setMeasurements(26.0f, 70.0f, 1012.5f);
        weatherStation.setMeasurements(24.8f, 90.0f, 1012.8f);
    }
}
