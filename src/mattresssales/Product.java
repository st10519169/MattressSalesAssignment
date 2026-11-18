package mattresssales;

import mattresssales.IProduct;
import java.util.Scanner;

public class Product implements IProduct {
    // 1D array for product names
    private String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    
    // 2D array for sales: 3 products, 3 months
    private int[][] salesData = new int[3][3];
    private int totalSold = 0;
    
    public Product() {
        Scanner scanner = new Scanner(System.in);
        // Prompt user for sales data matching the assignment screenshot
        for (int i = 0; i < productNames.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + productNames[i] + ": ");
                salesData[i][j] = scanner.nextInt();
            }
        }
    }

    @Override
    public int GetTotalProductsSold() {
        totalSold = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                totalSold += salesData[i][j];
            }
        }
        return totalSold;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int totalCount = salesData.length * salesData[0].length;
        return (double) total / totalCount;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        int bestProductIndex = 0;
        
        for (int i = 0; i < productNames.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                productTotal += salesData[i][j];
            }
            if (productTotal > maxSales) {
                maxSales = productTotal;
                bestProductIndex = i;
            }
        }
        return productNames[bestProductIndex] + " (" + maxSales + ")";
    }
}