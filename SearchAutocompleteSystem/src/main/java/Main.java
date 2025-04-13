public class Main {
    public static void main(String[] args) {
        AutocompleteService service = new AutocompleteService();
        service.insert("apple", 100);
        service.insert("app", 200);
        service.insert("application", 50);
        service.insert("apartment", 10);

        System.out.println(service.getSuggestions("app")); // [app, apple, application]
    }
}