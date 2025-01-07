public class Vacation extends Residential{
    private int guests = 1;


    public void taxIt() {
        double tax = getPrice() * 0.25; // מס 8% עבור דירה
        System.out.println("Tax for vacation: " + tax);
    }


    public Vacation(String address, double area, double price, int parkingLots, int guests) {
        super(address, area, price, parkingLots);
        setGuests(guests);
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        if(guests < 1)
        {
            throw new IllegalArgumentException("Guests must be at least 1.");
        }
        this.guests = guests;
    }


    @Override
    public String toString() {
        return "Vacation: " + super.toString() + ", Guests: " + guests;
    }
}
