public class Office extends Property {
    public Office(String address, double area, double price) {
        super(address, area, price);
    }
    @Override
    public void taxIt() {
        double tax = getPrice() * 0.05;
        System.out.println("Tax for office : " + tax);
    }
    @Override
    public String toString() {
        return "Office:" + super.toString();
    }
}
