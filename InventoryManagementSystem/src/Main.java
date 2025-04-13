public class Main {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();

        Product p1 = new Product("P001", "Keyboard", "Mechanical keyboard");
        service.addProduct(p1, 100);

        System.out.println("Available: " + service.getAvailableStock(p1)); // 100

        service.reserveProduct(p1, 10);
        System.out.println("Available after reserve: " + service.getAvailableStock(p1)); // 90

        service.releaseProduct(p1, 5);
        System.out.println("Available after release: " + service.getAvailableStock(p1)); // 95
    }
}