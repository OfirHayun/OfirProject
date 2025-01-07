import java.util.ArrayList;

public class RealEstateManager {
    private String name;
    ArrayList<Property> properties = new ArrayList();

    public RealEstateManager(String name) {
        if(name.isEmpty() || name ==null){
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Property property){
        if (property == null) {
            throw new IllegalArgumentException("Property cannot be null.");
        }

        if(properties.contains(property)){
            throw new IllegalArgumentException("this property is already in the system.");
        }
        properties.add(property);
    }
    public ArrayList<Property> Properties_For_price(double price){
        ArrayList<Property> BudgetProperties = new ArrayList<>();
        for (Property property : properties) {
            if (property.getPrice()<=price)
                BudgetProperties.add(property);
        }

        return BudgetProperties;
    }

    public double SumOfProperties(){
        double sum = 0.0;
        for (Property property : properties) {
            sum+=property.getPrice();
        }
        return sum;
    }
}
