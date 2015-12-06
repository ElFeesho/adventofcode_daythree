import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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


    @Test
    public void loopsDoNotCountAsUnique() {
        SantaMap santaMap = new SantaMap();
        santaMap.moveNorth();
        santaMap.moveEast();
        santaMap.moveSouth();
        santaMap.moveWest();
        assertThat(santaMap.uniquePlaces(), is(4));
    }

    public static class SantaMap {


        private static class Location {
            private int originX = 0;
            private int originY = 0;

            @Override
            public int hashCode() {
                return (originX + "," + originY).hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return obj instanceof Location && ((Location) obj).originX == originX && ((Location) obj).originY == originY;
            }

            public Location east() {
                Location location = new Location();
                location.originX = originX + 1;
                location.originY = originY;
                return location;
            }

            public Location west() {
                Location location = new Location();
                location.originX = originX - 1;
                location.originY = originY;
                return location;
            }

            public Location north() {
                Location location = new Location();
                location.originX = originX;
                location.originY = originY + 1;
                return location;
            }

            public Location south() {
                Location location = new Location();
                location.originX = originX;
                location.originY = originY - 1;
                return location;
            }
        }

        private Location currentLocation = new Location();

        private Set<Location> knownLocations = new HashSet<>();

        public SantaMap() {
            knownLocations.add(currentLocation);
        }

        public void moveEast() {
            currentLocation = currentLocation.east();
            knownLocations.add(currentLocation);
        }

        public int uniquePlaces() {
            return knownLocations.size();
        }

        public void moveWest() {
            currentLocation = currentLocation.west();
            knownLocations.add(currentLocation);
        }

        public void moveNorth() {
            currentLocation = currentLocation.north();
            knownLocations.add(currentLocation);
        }

        public void moveSouth() {
            currentLocation = currentLocation.south();
            knownLocations.add(currentLocation);
        }
    }
}
