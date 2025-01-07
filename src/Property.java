public abstract class Property {

    private String Address = "Na, na";
    private double area = 0.0;
    private double price = 0.0;


    public Property(String address, double area, double price) {
        setAddress(address);
        setArea(area);
        setPrice(price);
    }

    public abstract void taxIt();


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        if (!address.contains(",")) {
            throw new IllegalArgumentException("Address must contain a comma separating city and street.");
        }
        String[] parts = address.split(",", -1);
        if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new IllegalArgumentException("Address must have a valid city and street name.");
        }
        Address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area < 0) {
            throw new IllegalArgumentException("area cannot be negative.");
        }
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be negative.");
        }
        this.price = price;
    }




    @Override
    public String toString() {
        return "Property: " + Address + ", Area: " + area + ", Price: " + price;
    }
}
