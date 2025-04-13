public class Stock {
    private int totalQuantity;
    private int reservedQuantity;

    public Stock(int quantity) {
        this.totalQuantity = quantity;
        this.reservedQuantity = 0;
    }

    public synchronized boolean reserve(int quantity) {
        if ((totalQuantity - reservedQuantity) >= quantity) {
            reservedQuantity += quantity;
            return true;
        }
        return false;
    }

    public synchronized void release(int quantity) {
        reservedQuantity -= quantity;
    }

    public synchronized void addStock(int quantity) {
        totalQuantity += quantity;
    }

    public synchronized void removeStock(int quantity) {
        if (quantity <= (totalQuantity - reservedQuantity)) {
            totalQuantity -= quantity;
        } else {
            throw new IllegalArgumentException("Not enough stock to remove");
        }
    }

    public int getAvailableQuantity() {
        return totalQuantity - reservedQuantity;
    }
}
