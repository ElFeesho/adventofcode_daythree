public class ElfNavigator {
    public void sendInstructions(String input, SantaMap santaMap) {
        for (char c : input.toCharArray()) {
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
        }
    }
}
