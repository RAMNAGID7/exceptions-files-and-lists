// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package carDealership;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The Car class represents a car object with its properties such as car number, year of production, manufacturer,
 * <p>
 * kilometers driven, and price.
 */
public class Car {
    private String carNumber;
    private int yearOfProduction;
    private String manufacturer;
    private int kilometers;
    private int price;

    /**
     * Constructs a Car object with the provided car number, year of production, manufacturer, kilometers, and price.
     *
     * @param carNumber        the car number
     * @param yearOfProduction the year of production
     * @param manufacturer     the manufacturer
     * @param kilometers       the kilometers driven
     * @param price            the price of the car
     * @throws ArithmeticException if any of the provided values are invalid
     */
    public Car(String carNumber, int yearOfProduction, String manufacturer, int kilometers, int price) {
        if (carNumber.length() != 6) {
            throw new ArithmeticException("Car number is less than 6 digits.");
        }
        for (int i = 0; i < carNumber.length(); i++) {
            int temp = carNumber.charAt(i);
            if (temp < 48 || temp > 57) {
                throw new ArithmeticException("Car number with wrong digits.");
            }
        }
        this.carNumber = carNumber;
        if (yearOfProduction < 2017 || yearOfProduction > 2023) {
            throw new ArithmeticException("The year of production must be from 2017 and more.");
        }
        this.yearOfProduction = yearOfProduction;
        this.manufacturer = manufacturer;
        if (kilometers < 0) {
            throw new ArithmeticException("kilometers must be positive.");
        }
        this.kilometers = kilometers;
        if (price < 0) {
            throw new ArithmeticException("Price must be positive.");
        }
        this.price = price;
    }

    /**
     * Returns a string representation of the Car object.
     *
     * @return a string representation of the Car object
     */
    @Override
    public String toString() {
        return "Car{" +
                "carNumber='" + carNumber + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", manufacturer='" + manufacturer + '\'' +
                ", kilometers=" + kilometers +
                ", price=" + price +
                '}';
    }

    /**
     * Replaces the content of the specified line in the file with the corresponding content from the carArrayList.
     *
     * @param filePath     the path of the file
     * @param index        the index of the line to replace
     * @param carArrayList the ArrayList of Car objects
     */
    public void replaceCurrentCarFile(Path filePath, int index, ArrayList<Car> carArrayList) {
// Read the lines from the file into a list
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(filePath.toUri()));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

// Check if the index is within the bounds of the lines list
        if (index < 0 || index >= lines.size()) {
            System.out.println("Invalid index");
            return;
        }

// Replace the line at the specified index with the corresponding content from the list
        lines.set(index, String.valueOf(carArrayList.get(index)));

// Write the modified lines back to the file
        try {
            Files.write(Paths.get(filePath.toUri()), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the car information to the provided BufferedWriter.
     *
     * @param writer the BufferedWriter to write to
     */
    public void writeToFile(BufferedWriter writer) {
        try {
// Write car information to the file using the BufferedWriter
            writer.write("Car details: " + toString());
            writer.newLine();
            writer.flush(); // Flush the writer to ensure data is written immediately
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Calculates the new price of the car based on the provided percentage.
     *
     * @param percentage the percentage to decrease the price by
     * @throws ArithmeticException if the percentage is negative or if the resulting car value becomes too low
     */
    public void carValue(int percentage) throws ArithmeticException {
        if (percentage < 0) {
            throw new ArithmeticException("Percentage must be a non-negative value.");
        }
        int newValue = price * (100 - percentage) / 100;
        if (newValue < 5000) {
            throw new ArithmeticException("Car value becomes too low.");
        }
        price = newValue;
    }

    /**
     * Returns the car number.
     *
     * @return the car number
     */
    public String getNumCar() {
        return carNumber;
    }
}

