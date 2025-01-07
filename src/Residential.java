public abstract class Residential extends Property {
    private int parkingLots = 0;

    public Residential(String address, double area, double price, int parkingLots) {
        super(address, area, price);
        setParkingLots(parkingLots);
    }




    public int getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(int parkingLots) {
        if(parkingLots<0)
        {
            throw new IllegalArgumentException("parkingLots cannot be negative.");
        }
        this.parkingLots = parkingLots;
    }

    @Override
    public String toString() {
         return "Residential: " + super.toString() + ", Parking Lots: " + parkingLots;
    }


}
