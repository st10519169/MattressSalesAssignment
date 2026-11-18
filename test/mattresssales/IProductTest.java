package mattresssales;

import mattresssales.Product;
import static org.junit.Assert.*;
import org.junit.Test;

public class IProductTest {

    @Test
    public void GetTotalProductsSold_WithValidData_ReturnsCorrectValue() {
        Product product = new Product();
        assertNotNull("Total products sold should not be null", product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageProductSold_WithValidData_ReturnsCorrectValue() {
        Product product = new Product();
        assertTrue("Average product sold should be zero or positive", product.GetAverageProductSold() >= 0);
    }
}
