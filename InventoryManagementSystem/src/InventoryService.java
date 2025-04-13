import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<Product, Stock> inventory = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        inventory.put(product, new Stock(quantity));
    }

    public boolean reserveProduct(Product product, int quantity) {
        Stock stock = inventory.get(product);
        if (stock != null) {
            return stock.reserve(quantity);
        }
        return false;
    }

    public void releaseProduct(Product product, int quantity) {
        Stock stock = inventory.get(product);
        if (stock != null) {
            stock.release(quantity);
        }
    }

    public void addStock(Product product, int quantity) {
        Stock stock = inventory.get(product);
        if (stock != null) {
            stock.addStock(quantity);
        }
    }

    public int getAvailableStock(Product product) {
        Stock stock = inventory.get(product);
        return stock != null ? stock.getAvailableQuantity() : 0;
    }
}
