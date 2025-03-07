import java.util.HashMap;
import java.util.Map;

public class Bag {
    private Map<String, Integer> items;

    public String getItems() {
        return items.toString(); // Returns a string representation of the items
    }


    public Bag() {
        items = new HashMap<>();
        items.put("Pokéball", 5); // Default starting Pokéballs
        items.put("Great Ball", 0);
        items.put("Ultra Ball", 0);
        items.put("Master Ball", 0);
    }

    public void addItem(String item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    } 

    public boolean useItem(String item) {
        System.out.println("Attempting to use item: " + item);
        if (items.getOrDefault(item, 0) > 0) {
            items.put(item, items.get(item) - 1);
            System.out.println("Item used successfully: " + item);
            return true;
        }
        System.out.println("Failed to use item: " + item + " (not available)");
        return false;
    }

    public void displayBagContents() {
        System.out.println("Bag Contents:");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }
    }

    public boolean hasItem(String item) {
        return items.getOrDefault(item, 0) > 0;
    }
}
