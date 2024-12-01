package org.ybichbich.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;

public class Advent1 {
    public int computeDistance(String filename)  {
        try {
            var reader = new BufferedReader(new FileReader(getClass().getResource(filename).getFile()));
            String line = reader.readLine();
            var leftList = new ArrayList<Integer>();
            var rightList = new ArrayList<Integer>();
            while (line != null) {
                String[] fields = line.split("  ");
                leftList.add(Integer.valueOf(fields[0].trim()));
                rightList.add(Integer.valueOf(fields[1].trim()));
                // read next line
                line = reader.readLine();
            }
            reader.close();

            leftList.sort((o1, o2) -> o1.compareTo(o2));
            rightList.sort((o1, o2) -> o1.compareTo(o2));

            int sum = 0;
            for(int i=0; i<leftList.size(); i++) {
                var delta = diff(leftList.get(i), rightList.get(i));
                sum += delta;
            }

            System.out.println("total distance: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int diff(Integer item1, Integer item2) {
        return (item1 >= item2) ? item1 - item2 : item2 - item1;
    }

}
