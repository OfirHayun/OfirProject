public class Commercial extends  Property{
    private boolean storeroom = false;
    private double yield = 0.0;

    public void taxIt() {
        double tax = getPrice() * 0.05;
        System.out.println("Tax for Commercial: " + tax);
    }

    public Commercial(String address, double area, double price, boolean storeroom, double yield) {
        super(address, area, price);
        this.storeroom = storeroom;
        this.yield = yield;
    }

    public Commercial(String address, double area, double price, double yield) {
        super(address, area, price);
        this.yield = yield;
    }

    public boolean isStoreroom() {
        return storeroom;
    }

    public void setStoreroom(boolean storeroom) {
        this.storeroom = storeroom;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        if(yield<0.0)
        {
            throw new IllegalArgumentException("yield cannot be negative.");
        }
        this.yield = yield;
    }

    public double expectedYield(){
        return getPrice()*(getYield()/100)/12;
    }

    @Override
    public String toString() {
        return "Commercial:" + super.toString()+ "storeroom:" + storeroom +
                ", yield=:" + yield;

    }
}
