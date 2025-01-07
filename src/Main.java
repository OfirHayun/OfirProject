import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static class  BudgetException extends Exception {
        public BudgetException(String message) {
            super(message);
        }
    }

    private static RealEstateManager realEstateManager;

    public static void main(String[] args) {
        // Initialize RealEstateManager
        realEstateManager = new RealEstateManager("Some Real Estate Manager Name");
        DataManager dataManager = new DataManager();
        ArrayList<Property> properties = dataManager.generateProperties();

        for (Property property : properties) {
            realEstateManager.add(property);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Real Estate Management Menu ---");
            System.out.println("1 -> Search Properties");
            System.out.println("2 -> Financial Report");
            System.out.println("3 -> Commercial Real Estate Yield");
            System.out.println("4 -> Properties by City");
            System.out.println("5 -> Count of Cities");
            System.out.println("-1 -> Exit Program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Option 1: Properties List");
                    System.out.println("Enter your Budget");
                    int budget = scanner.nextInt();

                    try {
                    propertiesList(budget,properties);
                    } catch (BudgetException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("Option 2: Financial Report");
                    generateFinancialReport(properties);
                    break;
                case 3:
                    System.out.println("Option 3: Commercial Real Estate Yield");
                    calculateCommercialYield(properties);
                    break;
                case 4:
                    System.out.println("Option 4: Properties by City");
                    System.out.println("Enter a city name:");
                    String cityName = scanner.nextLine();

                    listPropertiesByCity(properties,cityName);
                    break;
                case 5:
                    System.out.println("Option 5: Count of Cities");
                    countCities(properties);
                    break;
                case -1:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(-1);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }






    }

    private static void countCities(ArrayList<Property> properties) {
        HashSet<String> cities = new HashSet<>();

        for (Property property : properties) {
            String[] CityName = property.getAddress().split(",");
            cities.add(CityName[0]);

        }

        System.out.println("We have " + cities.size() + " different cities to chose from:");
        System.out.println("the cities names:");
        System.out.println(cities);
    }

    private static void listPropertiesByCity(ArrayList<Property> properties, String cityName) {
        ArrayList<Property> propertiesWithCityName = new ArrayList<>();
        String normalizedCity = cityName.toLowerCase().replace("-", " ");
        for (Property property : properties) {
            String normalizedAdress = property.getAddress().toLowerCase().replace("-"," ");

            if(normalizedAdress.contains(normalizedCity)){
            propertiesWithCityName.add(property);
            }

        }
        if(propertiesWithCityName != null) {
            for (Property property : propertiesWithCityName) {
                System.out.println(property);
            }
        }
        else
            System.out.println("There are no Propeties with the city name you choose.");

    }

    private static void calculateCommercialYield(ArrayList<Property> properties) {
        double sumOfYield = 0;
        for (Property property : properties){
            if(property instanceof Commercial)
            {
                Commercial commercialProperty = (Commercial) property;
                double yieldValue = commercialProperty.getPrice() * commercialProperty.getYield();
                sumOfYield += yieldValue;
            }

        }
        System.out.println("the Sum of the yield is:"+ sumOfYield);
    }

    private static void generateFinancialReport(ArrayList<Property> properties) {
        for (Property property : properties){
            property.taxIt();
        }
    }

    private static void propertiesList(double Budget, ArrayList<Property> properties) throws BudgetException {
        if(Budget<0)
        {
            throw new BudgetException("Budget cant be negative");
        }
        System.out.println("The Propeties List For the Budget:");
        for (Property property : properties) {
            if(Budget>=property.getPrice()){
                System.out.println(property);
            }

        }
    }
}
