public class Vila extends  Residential{
    private int levels = 1;

    public Vila(String address, double area, double price, int parkingLots, int levels) {
        super(address, area, price, parkingLots);
        setLevels(levels);
    }

    public int getLevels() {
        return levels;
    }

    public void taxIt() {
        double tax = getPrice() * 0.08; // מס 8% עבור דירה
        System.out.println("Tax for vila: " + tax);
    }
    public void setLevels(int levels) {
        if(levels < 1)
        {
            throw new IllegalArgumentException("Levels must be at least 1.");
        }
        this.levels = levels;
    }

    @Override
    public String toString() {
        return "Vila:" + super.toString() + "levels:" + levels;
    }
}
