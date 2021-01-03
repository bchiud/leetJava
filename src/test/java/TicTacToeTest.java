import com.bradychiu.TicTacToe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void one() {
        TicTacToe obj = new TicTacToe(3);
        assertEquals(0, obj.move(0, 0, 1));
        assertEquals(0, obj.move(0, 2, 2));
        assertEquals(0, obj.move(2, 2, 1));
        assertEquals(0, obj.move(1, 1, 2));
        assertEquals(0, obj.move(2, 0, 1));
        assertEquals(0, obj.move(1, 0, 2));
        assertEquals(1, obj.move(2, 1, 1));
    }

}