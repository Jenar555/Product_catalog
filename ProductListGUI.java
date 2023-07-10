import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductListGUI extends JFrame {

    public ProductListGUI(ArrayList<Product> products) {
        setTitle("Product List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JList<String> productList = new JList<>(getListData(products));
        add(new JScrollPane(productList), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String[] getListData(ArrayList<Product> products) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String[] listData = new String[products.size()];

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            String formattedPrice = df.format(product.getPrice());
            listData[i] = "Product: " + product.getName() + ", Price: $" + formattedPrice + ", Description: " + product.getDescription();
        }

        return listData;
    }

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        // Populate the product list
        products.add(new Product("Product 1", 19.99, "Description 1"));
        products.add(new Product("Product 2", 29.99, "Description 2"));
        products.add(new Product("Product 3", 39.99, "Description 3"));
        products.add(new Product("Product 4", 49.99, "Description 4"));
        products.add(new Product("Product 5", 59.99, "Description 5"));

        SwingUtilities.invokeLater(() -> new ProductListGUI(products));
    }
}

class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
