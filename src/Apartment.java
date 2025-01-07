public class Apartment extends Residential {
    private int rooms = 1;

    public Apartment(String address, double area, double price, int parkingLots, int rooms) {
        super(address, area, price, parkingLots);
        setRooms(rooms);
    }
    public void taxIt() {
        double tax = getPrice() * 0.08; // מס 8% עבור דירה
        System.out.println("Tax for Apt: " + tax);
    }
    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if(!(rooms > 1))
        {
            throw new IllegalArgumentException("Num of rooms has to be bigger then 1");
        }

        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Apartment:" + super.toString() + ", rooms:" + rooms;
    }
}
