// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package carDealership;

import java.io.BufferedWriter;


/**
 * The Employee class represents an employee in a car dealership.
 * It provides functionalities for managing employee information, such as name, ID, sales, and salary.
 */
public class Employee implements Comparable<Employee> {
    public String firstName;
    public String id;
    public int sales;

    /**
     * Constructs an Employee object with the specified first name, ID, and sales.
     *
     * @param firstName the first name of the employee
     * @param id        the ID of the employee
     * @param sales     the number of sales made by the employee
     * @throws ArithmeticException if the first name, ID, or sales value is invalid
     */
    public Employee(String firstName, String id, int sales) {
        // Validate the first name
        for (int i = 0; i < firstName.length(); i++) {
            int temp = firstName.charAt(i);
            if (i == 0) {
                if (temp < 65 || temp > 90) {
                    throw new ArithmeticException("The first name must have letters only.");
                }
            } else {
                if (temp < 96 || temp > 123) {
                    throw new ArithmeticException("The first name must have letters only.");
                }
            }
        }

        this.firstName = firstName;

        // Validate the ID
        if (id.length() != 9) {
            throw new ArithmeticException("ID number must have 9 digits.");
        }
        for (int i = 0; i < id.length(); i++) {
            int temp = id.charAt(i);
            if (temp < 48 || temp > 57) {
                throw new ArithmeticException("ID number must have digits only.");
            }
        }
        this.id = id;

        // Validate the sales value
        if (sales < 0) {
            throw new ArithmeticException("Sales must be positive.");
        }
        this.sales = sales;
    }

    /**
     * Checks if the class uses the java.io.BufferedWriter class.
     *
     * @return true if the class uses BufferedWriter, false otherwise
     */
    public boolean useOfIO() {
        try {
            Class.forName("java.io.BufferedWriter");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /**
     * Performs the car selling operation by writing the car details to the provided BufferedWriter
     * and increments the sales count of the employee.
     *
     * @param car    the car to be sold
     * @param writer the BufferedWriter to write the car details
     */
    public void carSell(Car car, BufferedWriter writer) {
        if (useOfIO()) {
            car.writeToFile(writer);
            sales++;
        } else {
            System.out.println("IO library is never used.");
        }
    }

    /**
     * Calculates and returns the salary of the employee based on the number of sales.
     *
     * @return the salary of the employee
     */
    public int salary() {
        return 6000 + sales * 100;
    }

    /**
     * Returns a string representation of the Employee object.
     *
     * @return a string representation of the Employee object
     */
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", id='" + id + '\'' +
                ", sales=" + sales +
                ", salary=" + salary() +
                '}';
    }

    /**
     * Compares this employee to another employee based on their sales count.
     *
     * @param other the other Employee object to compare
     * @return 0 if the sales counts are equal, -1 if this employee has fewer sales,
     * <p>
     * 1 otherwise
     */
    @Override
    public int compareTo(Employee other) {
        if (this.sales == other.sales) {
            return 0;
        }
        if (this.sales < other.sales) {
            return -1;
        }
        return 1;
    }

    /**
     * Returns the first name of the employee.
     *
     * @return the first name of the employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the ID of the employee.
     *
     * @return the ID of the employee
     */
    public String getId() {
        return id;
    }
}
