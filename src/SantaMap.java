import java.util.HashSet;
import java.util.Set;

public class SantaMap {


    public SantaMap combinedWith(SantaMap secondSantaMap) {
        SantaMap newMap = new SantaMap();
        newMap.knownLocations.addAll(knownLocations);
        newMap.knownLocations.addAll(secondSantaMap.knownLocations);
        return newMap;
    }

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
