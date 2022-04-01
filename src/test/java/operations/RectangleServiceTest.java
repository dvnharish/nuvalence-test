package operations;


import com.nuvalence.rectangle.operations.Point;
import com.nuvalence.rectangle.operations.Rectangle;
import com.nuvalence.rectangle.operations.RectangleService;
import com.nuvalence.rectangle.operations.RectangleServiceImplementation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RectangleServiceTest {



    @DisplayName("Test RectangleService.get()")
    @Test
    void testGet() {
        assertEquals("Hello", RectangleService.get());
    }



}
