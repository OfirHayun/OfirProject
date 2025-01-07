public class Plot extends Property{
    private PlotType type;

    public Plot(String address, double area, double price, PlotType type) {
        super(address, area, price);
        this.type = type;
    }

    public PlotType getType() {
        return type;
    }

    public void setType(PlotType type) {
        this.type = type;
    }

    @Override
    public void taxIt() {
        double tax = 0.0;
        switch (type) {
            case URBAN -> {
                tax = getPrice() * 0.1;
                break;
            }
            case AGRICULTURAL -> { tax = getPrice() * 0.02;
                break;
            }
            case INDUSTRIAL -> {tax = getPrice() * 0.05;
                break;
            }

        }
        System.out.println("Tax for " + type + " Plot: " + tax);

    }
    @Override
    public String toString() {
        return "Plot: " + super.toString() + ", Type: " + type;
    }
}
