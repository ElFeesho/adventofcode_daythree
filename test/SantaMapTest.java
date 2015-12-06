import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SantaMapTest {

    @Test
    public void whenSantaNavigatesEast_santaHasVisitedTwoUniquePlaces() {
        SantaMap santaMap = new SantaMap();
        santaMap.moveEast();
        assertThat(santaMap.uniquePlaces(), is(2));
    }

    @Test
    public void whenSantaNavigatesEastAndThenWest_santaHasOnlyVisitedTwoUniquePlaces() {
        SantaMap santaMap = new SantaMap();
        santaMap.moveEast();
        santaMap.moveWest();
        assertThat(santaMap.uniquePlaces(), is(2));
    }

    @Test
    public void whenSantaNavigatesEastAndThenWestTwice_santaHasVisitedThreeUniquePlaces() {
        SantaMap santaMap = new SantaMap();
        santaMap.moveEast();
        santaMap.moveWest();
        santaMap.moveWest();
        assertThat(santaMap.uniquePlaces(), is(3));
    }

    @Test
    public void whenSantaNavigatesNorth_andThenSouth_santaHasOnlyVisitedTwoPlaces() {
        SantaMap santaMap = new SantaMap();
        santaMap.moveNorth();
        santaMap.moveSouth();
        assertThat(santaMap.uniquePlaces(), is(2));
    }

    @Test
    public void whenSantaNavigatesNorth_andThenSouthTwice_santaHasVisitedThreePlaces() {
        SantaMap santaMap = new SantaMap();
        santaMap.moveNorth();
        santaMap.moveSouth();
        santaMap.moveSouth();
        assertThat(santaMap.uniquePlaces(), is(3));
    }

    public static class SantaMap {


        private static class Location {
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

            public static void fromLocationToSouth(Location southernLocation) {
                Location location = new Location();
                southernLocation.north = location;
                location.south = southernLocation;
            }

            public static void fromLocationToNorth(Location northernLocation) {
                Location location = new Location();
                northernLocation.south = location;
                location.north = northernLocation;
            }
        }

        private Location currentLocation = new Location();

        private int uniquePlaces = 1;

        public void moveEast() {
            if (currentLocation.east == null) {
                Location.fromLocationToWest(currentLocation);
                uniquePlaces++;
            }
            currentLocation = currentLocation.east;
        }

        public int uniquePlaces() {
            return uniquePlaces;
        }

        public void moveWest() {
            if (currentLocation.west == null) {
                Location.fromLocationToEast(currentLocation);
                uniquePlaces++;
            }
            currentLocation = currentLocation.west;
        }

        public void moveNorth() {
            if (currentLocation.north == null) {
                Location.fromLocationToSouth(currentLocation);
                uniquePlaces++;
            }
            currentLocation = currentLocation.north;
        }

        public void moveSouth() {
            if (currentLocation.south == null) {
                Location.fromLocationToNorth(currentLocation);
                uniquePlaces++;
            }
            currentLocation = currentLocation.south;
        }
    }
}
