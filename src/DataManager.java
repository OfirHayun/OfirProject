import java.util.ArrayList;

public class DataManager {
    public ArrayList<Property> generateProperties() {
        ArrayList<Property> properties = new ArrayList<>();

        // 2 מגרשים
        properties.add(new Plot("Tel Aviv, Rothschild 22", 500, 1_000_000, PlotType.URBAN));
        properties.add(new Plot("Negev, Mitzpe Ramon", 300, 800_000, PlotType.AGRICULTURAL));

        // 2 דירות מגורים
        properties.add(new Apartment("Jerusalem, Ben Yehuda 10", 80, 1_200_000, 3, 4));
        properties.add(new Apartment("Haifa, Herzl 5", 100, 1_500_000, 4, 2));

        // 2 וילות
        properties.add(new Vila("Eilat, Kfar Maccabiah", 250, 5_000_000, 4, 3));
        properties.add(new Vila("Tel Aviv, Havatzelet 17", 200, 4_000_000, 5, 5));

        // 2 דירות נופש
        properties.add(new Vacation("Netanya, Sea View 12", 60, 900_000, 4, 4));
        properties.add(new Vacation("Dead Sea, Paradise 21", 70, 1_100_000, 6, 6));

        // 2 נדל"ן מסחרי
        properties.add(new Commercial("Haifa, Industrial Zone 8", 400, 2_000_000, false, 0.15));
        properties.add(new Commercial("Tel Aviv, Mall Area 3", 350, 2_500_000, true, 0.05));

        // 2 משרדים
        properties.add(new Office("Tel Aviv, King George 2", 150, 1_800_000));
        properties.add(new Office("Haifa, Port Area 6", 120, 1_500_000));

        return properties;
    }
}
