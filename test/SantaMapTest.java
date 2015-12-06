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
        public void moveEast() {

        }

        public int uniquePlaces() {
            return 0;
        }
    }
}
