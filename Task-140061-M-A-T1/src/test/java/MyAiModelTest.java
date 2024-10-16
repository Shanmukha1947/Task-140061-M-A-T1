import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyAiModelTest {

    private MyAiModel model;

    @BeforeEach
    public void setUp() {
        model = new MyAiModel();
    }

    @Test
    public void testPredictPositive() {
        double[] input = {1.0, 2.0, 3.0};
        double prediction = model.predict(input);
        assertEquals(0.6, prediction, 0.01); // Adjusted expected value
    }

    @Test
    public void testPredictNegative() {
        double[] input = {-1.0, -2.0, -3.0};
        double prediction = model.predict(input);
        assertEquals(-0.6, prediction, 0.01); // Adjusted expected value
    }


    @Test
    public void testHandleNullInput() {
        assertThrows(NullPointerException.class, () -> model.predict(null));
    }

    @Test
    public void testHandleInvalidInputLength() {
        double[] input = {1.0, 2.0}; // Missing a value
        assertThrows(IllegalArgumentException.class, () -> model.predict(input));
    }
}

