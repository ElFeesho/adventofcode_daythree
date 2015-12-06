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


    @Test
    public void loopsDoNotCountAsUnique() {
        SantaMap santaMap = new SantaMap();
        santaMap.moveNorth();
        santaMap.moveEast();
        santaMap.moveSouth();
        santaMap.moveWest();
        assertThat(santaMap.uniquePlaces(), is(4));
    }

    @Test
    public void santaMapCanBeNavigatedByElf()
    {
        // Radio waves are an implementation detail.
        String input = ">v<<^>";
        SantaMap santaMap = new SantaMap();
        ElfNavigator elfNavigator = new ElfNavigator();
        elfNavigator.sendInstructions(input, santaMap);
        assertThat(santaMap.uniquePlaces(), is(6));
    }


    @Test
    public void multipleSantaMapsCanBeNavigatedByElfTakingTurnsOnInstruction()
    {
        // Radio waves are an implementation detail.
        String input = "><><";
        SantaMap santaMap = new SantaMap();
        SantaMap secondSantaMap = new SantaMap();
        ElfNavigator elfNavigator = new ElfNavigator();
        elfNavigator.sendInstructions(input, santaMap, secondSantaMap);
        assertThat(santaMap.uniquePlaces(), is(3));
        assertThat(secondSantaMap.uniquePlaces(), is(3));
    }

    @Test
    public void multipleSantaMapsCanBeCombinedToDetermineTotalUniquePlacesVisited()
    {

        // Radio waves are an implementation detail.
        String input = "><><";
        SantaMap santaMap = new SantaMap();
        SantaMap secondSantaMap = new SantaMap();
        ElfNavigator elfNavigator = new ElfNavigator();
        elfNavigator.sendInstructions(input, santaMap, secondSantaMap);
        assertThat(santaMap.uniquePlaces(), is(3));
        assertThat(secondSantaMap.uniquePlaces(), is(3));
        assertThat(santaMap.combinedWith(secondSantaMap).uniquePlaces(), is(5));
    }

}
