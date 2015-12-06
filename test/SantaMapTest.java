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

    @Test
    public void whenSantaNavigatesEastAndThenWest_santaHasOnlyVisitedTwoUniquePlaces()
    {
        SantaMap santaMap = new SantaMap();
        santaMap.moveEast();
        santaMap.moveWest();
        assertThat(santaMap.uniquePlaces(), is(2));
    }
    @Test
    public void whenSantaNavigatesEastAndThenWestTwice_santaHasVisitedThreeUniquePlaces()
    {
        SantaMap santaMap = new SantaMap();
        santaMap.moveEast();
        santaMap.moveWest();
        santaMap.moveWest();
        assertThat(santaMap.uniquePlaces(), is(3));
    }

    public static class SantaMap {
        private static class Location
        {
            private Location north;
            private Location south;
            private Location west;
            private Location east;

            public static void fromLocationToWest(Location westernLocation) {
                Location location = new Location();
                westernLocation.east = location;
                location.west = westernLocation;
            }

            public static void fromLocationToEast(Location easternLocation) {
                Location location = new Location();
                easternLocation.west = location;
                location.east = easternLocation;
            }
        }

        private Location currentLocation = new Location();

        private int uniquePlaces = 1;
        public void moveEast() {
            if(currentLocation.east == null) {
                Location.fromLocationToWest(currentLocation);
                uniquePlaces++;
            }
            currentLocation = currentLocation.east;
        }

        public int uniquePlaces() {
            return uniquePlaces;
        }

        public void moveWest() {
            if(currentLocation.west == null) {
                Location.fromLocationToEast(currentLocation);
                uniquePlaces++;
            }
            currentLocation = currentLocation.west;
        }
    }
}
