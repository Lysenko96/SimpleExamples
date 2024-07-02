package org.example.pattern.inerfacemarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Marker marker = new Marker();
        NotMarker marker1 = new NotMarker();
        List<Generic> objects = new ArrayList<>(Arrays.asList(marker, marker1));
        for (Generic obj : objects) {
            obj.marker();
        }
    }
}
