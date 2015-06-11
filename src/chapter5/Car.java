package chapter5;

/**
 * Car <Description>
 *
 * @author vadya
 */
public class Car {
    private String manufacturer;
    private String model;
    private int modelYear = -1;
    private String licensePlate = "";

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public Car(String manufacturer, String model, int modelYear) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.modelYear = modelYear;
    }

    public Car(String manufacturer, String model, int modelYear, String licensePlate) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.modelYear = modelYear;
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
