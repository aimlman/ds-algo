package algorithm;

import java.util.*;

public class ClassPhotos {

    public boolean classPhotos(
        ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        int redMax = redShirtHeights.get(redShirtHeights.size()-1);
        int blueMax = blueShirtHeights.get(blueShirtHeights.size()-1);
        ArrayList<Integer> backRow = redMax > blueMax ? redShirtHeights : blueShirtHeights;
        ArrayList<Integer> frontRow = redMax < blueMax ? redShirtHeights : blueShirtHeights;

        for (int index = backRow.size()-1; index >=0; index--) {
            if (frontRow.get(index) >= backRow.get(index)) {
                return false;
            }
        }

        return true;
    }
    
}
