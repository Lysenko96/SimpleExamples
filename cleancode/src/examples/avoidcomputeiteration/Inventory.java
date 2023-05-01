package examples.avoidcomputeiteration;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    List<Supply> find(String regex){
        List<Supply> result = new LinkedList<>();
        // if (Pattern.matches(regex, supply.toString()))
        Pattern pattern = Pattern.compile(regex); // compute not in for each
        for(Supply supply : supplies) {
            if (pattern.matcher(supply.toString()).matches()) result.add(supply);
        }
        return result;
    }
}

class Supply {

}
