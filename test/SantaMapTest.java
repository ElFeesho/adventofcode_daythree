import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SantaMapTest {

    @Test
    public void whenSantaNavigatesEast_santaHasVisitedTwoUniquePlaces()
    {
        SantaMap santaMap = new SantaMap();
        santaMap.moveEast();
        assertThat(santaMap.uniquePlaces(), is(2));
    }

    public class SantaMap {
        private int uniquePlaces = 1;
        public void moveEast() {
            uniquePlaces++;
        }

        public int uniquePlaces() {
            return uniquePlaces;
        }
    }
}
