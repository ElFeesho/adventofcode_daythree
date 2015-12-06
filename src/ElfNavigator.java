public class ElfNavigator {
    public void sendInstructions(String input, SantaMap... santaMaps) {
        int santaMapIndex = 0;
        for (char c : input.toCharArray()) {
            SantaMap santaMap = santaMaps[santaMapIndex];
            if(c == '>')
            {
                santaMap.moveEast();
            }
            else if(c == '<')
            {
                santaMap.moveWest();
            }
            else if(c == 'v')
            {
                santaMap.moveSouth();
            }
            else if(c == '^')
            {
                santaMap.moveNorth();
            }
            santaMapIndex++;
            if (santaMapIndex >= santaMaps.length)
            {
                santaMapIndex = 0;
            }
        }
    }
}
