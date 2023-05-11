package examples.boolexpressions;

public class Astronaut {

    private String name;
    private int missions;

    boolean isValid(){
        boolean isValidMissions = missions >= 0;
        boolean isValidName = name != null && !name.trim().isEmpty();
        return isValidMissions && isValidName; // use boolean expressions
    }
}
