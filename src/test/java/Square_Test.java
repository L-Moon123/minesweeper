import org.example.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Square_Test {
    @Test
    public void testConstructor () {
        Square s = new Square();
        Assertions.assertEquals(false, s.isMined());

    }

}
