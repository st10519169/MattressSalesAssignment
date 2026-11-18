package mattresssales;

import mattresssales.ProductCalculations;
import mattresssales.ProductCalculations;
import static org.junit.Assert.*;
import org.junit.Test;

public class IProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(1000.0);
        // 15% of 1000 is 150.0
        assertEquals(150.0, calc.GetVat(), 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(1000.0);
        // Price (1000) + VAT (150) + Commission (50) = 1200.0
        assertEquals(1200.0, calc.GetTotal(), 0.001);
    }
}
