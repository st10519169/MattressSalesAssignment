package mattresssales;

public class Main {
    public static void main(String[] args) {
        Product productApp = new Product();
        PrintProduct printer = new PrintProduct(productApp);
        printer.printReport();
    }
}
