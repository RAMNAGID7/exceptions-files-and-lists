// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package carDealership;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


/**
 * The CarDealership class represents a car dealership management system.
 * <p>
 * It provides functionalities for managing employees and inventory of cars,
 * <p>
 * as well as selling cars and saving data to files.
 */
public class CarDealership {

    /**
     * Sorts an ArrayList in ascending order using the Bubble Sort algorithm.
     *
     * @param arrayList the ArrayList to be sorted
     * @param <T>       the type of elements in the ArrayList, must implement the Comparable interface
     */
    private static <T extends Comparable<T>> void sortArrayList(ArrayList<T> arrayList) {
        int n = arrayList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayList.get(j).compareTo(arrayList.get(j + 1)) > 0) {
                    // Swap elements at index j and j+1
                    T temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Checks if an employee with the given ID exists in the provided ArrayList of employees.
     *
     * @param idUser           the ID of the employee to check
     * @param employeesArrList the ArrayList of employees
     * @return the index of the employee in the ArrayList if found, -1 otherwise
     */
    private static int checkId(String idUser, ArrayList<Employee> employeesArrList) {
        for (int i = 0; i < employeesArrList.size(); i++) {
            if (Objects.equals(employeesArrList.get(i).getId(), idUser)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if a car with the given license plate number exists in the provided ArrayList of cars.
     *
     * @param number     the license plate number to check
     * @param carArrList the ArrayList of cars
     * @return the index of the car in the ArrayList if found, -1 otherwise
     */
    private static int checkLicencePlate(String number, ArrayList<Car> carArrList) {
        for (int i = 0; i < carArrList.size(); i++) {
            if ((carArrList.get(i).getNumCar().equals(number))) return i;

        }
        return -1;
    }

    /**
     * The main method that executes the car dealership management system.
     *
     * @param args command line arguments
     * @throws IOException if an I/O error occurs while reading or writing files
     */
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("src/carDealership/Sold.txt.txt");
        Path path2 = Paths.get("src/carDealership/carDealership.txt.txt");
        int count = 0;
        ArrayList<Car> inventory = new ArrayList<>();
        ArrayList<Car> arrayListOfSoldCars = new ArrayList<>();
        File file = new File(path2.toUri());
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            try {
                String line = scanner.nextLine();
                String[] carData = line.split("\\s"); // Assuming the data is comma-separated

                // Validate the car data before creating a Car object
                if (carData.length == 5) {
                    String carNumber = carData[0].trim();
                    int year = Integer.parseInt(carData[1].trim());
                    String manufacturer = carData[2].trim();
                    int kilometers = Integer.parseInt((carData[3].trim()));
                    int price = Integer.parseInt((carData[4].trim()));

                    // Create a new Car object and add it to the inventory
                    Car car = new Car(carNumber, year, manufacturer, kilometers, price);
                    inventory.add(car);
                }
            } catch (ArithmeticException E) {
                count++;
                System.out.println(count + " cars with wrong details.");
            }
        }
        Path path3 = Paths.get("src/carDealership/Employee.txt.txt");
        int count2 = 0;
        ArrayList<Employee> employees = new ArrayList<>();
        File file2 = new File(path3.toUri());
        Scanner scanner2 = new Scanner(file2);
        while (scanner2.hasNextLine()) {
            try {
                String line = scanner2.nextLine();
                String[] employeesData = line.split("\\s"); // Assuming the data is comma-separated

                // Validate the car data before creating a Car object
                if (employeesData.length == 3) {
                    String firstname = employeesData[0].trim();
                    String id = employeesData[1].trim();
                    int sales = Integer.parseInt((employeesData[2].trim()));

                    // Create a new Car object and add it to the inventory
                    Employee employee = new Employee(firstname, id, sales);
                    employees.add(employee);
                }
            } catch (ArithmeticException E) {
                count2++;
                System.out.println(count2 + " employees with wrong details.");
            }
        }
        FileWriter soldCarsFileWriter = new FileWriter("src/carDealership/Sold.txt.txt", true);
        FileWriter carsFileWriter = new FileWriter("src/carDealership/carDealership.txt.txt", true);
        BufferedWriter writerToSold = new BufferedWriter(soldCarsFileWriter);
        BufferedWriter writerToCars = new BufferedWriter(carsFileWriter);
        boolean manuRun = true;
        while (manuRun) {
            try {
                System.out.println();
                System.out.println("Select a number from the menu: ");
                for (menu main : menu.values()) {
                    System.out.println(main.getMenu());
                }
                Scanner scannerMenu = new Scanner(System.in);
                int selection = scannerMenu.nextInt();
                switch (selection) {
                    case 1:
                        sortArrayList(employees);
                        for (int i = 0; i < employees.size(); i++) {
                            System.out.println(employees.get(i));
                        }
                        break;
                    case 2:
                        for (int i = 0; i < inventory.size(); i++) {
                            System.out.println(inventory.get(i));
                        }
                        break;
                    case 3:
                        boolean cond = true;
                        while (cond) {
                            try {
                                for (int i = 0; i < employees.size(); i++) {
                                    System.out.println(employees.get(i).firstName + " " + employees.get(i).id);
                                }
                                System.out.println("Choose employee by id: ");
                                String id = scannerMenu.next();
                                int indexOfEmployee = checkId(id, employees);
                                if (indexOfEmployee == -1)
                                    throw new IllegalArgumentException("There is no employee with this" +
                                            " id number or the id isn't correct");
                                for (int i = 0; i < inventory.size(); i++) {
                                    System.out.println(inventory.get(i));
                                }
                                System.out.println("Choose car by licence plate: ");
                                String number = scannerMenu.next();
                                int indexOfCar = checkLicencePlate(number, inventory);
                                if (indexOfCar == -1)
                                    throw new IllegalArgumentException("There is no car with this id number or " +
                                            "the id isn't correct");
                                try {
                                    employees.get(indexOfEmployee).carSell(inventory.get(indexOfCar), writerToSold);
                                    arrayListOfSoldCars.add(inventory.get(indexOfCar));
                                } catch (Exception e) {
                                    e.getStackTrace();
                                }
                                inventory.remove(inventory.get(indexOfCar));
                                cond = false;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 4:
                        int year, kilometers, price;
                        String number, manufacture;
                        System.out.println("Adding a car to the list:" +
                                "\n Enter the car number: ");
                        number = scannerMenu.next();
                        System.out.println("Enter the car year: ");
                        year = scannerMenu.nextInt();
                        System.out.println("Enter the car manufacture: ");
                        manufacture = scannerMenu.next();
                        System.out.println("Enter the car kilometers count: ");
                        kilometers = scannerMenu.nextInt();
                        System.out.println("Enter the car price: ");
                        price = scannerMenu.nextInt();
                        Car car = new Car(number, year, manufacture, kilometers, price);
                        try {
                            inventory.add(car);
                            inventory.get(inventory.size() - 1).writeToFile(writerToCars);
                            System.out.println("Car added successfully!");
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            for (int i = 0; i < inventory.size(); i++) {
                                inventory.get(i).replaceCurrentCarFile(path2, i, inventory);
                            }
                            writerToCars.close();
                            writerToSold.close();
                            System.out.println("Details saved successfully!");
                            manuRun = false;
                        } catch (Exception e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }
                        break;
                }
            } catch (Exception E) {
                E.printStackTrace();
                E.getStackTrace();
            }
        }
    }
}

