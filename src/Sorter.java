import java.io.StringReader;
import java.util.*;

public class Sorter {

    //sorts array by putting vert pictures then horizontal in separate arraylists; then put into 2d arraylist
    public static ArrayList<ArrayList> splitHVPics(String[] unsortedPics) {
        ArrayList<String> vPics = new ArrayList<>();
        ArrayList<String> hPics = new ArrayList<>();
        ArrayList<ArrayList> sortedPics = new ArrayList<>();
        for(int i = 0; i < unsortedPics.length; i++) {
            if(unsortedPics[i].charAt(0) == 'V') {
                vPics.add(i +" "+ unsortedPics[i]);
            }
            else hPics.add(i +" "+ unsortedPics[i]);
        }
        sortedPics.add(vPics);
        sortedPics.add(hPics);
        return sortedPics;
    }

    //takes in 2d arraylist, grabs vertical pictures & pairs them optimally; returns unsorted slide array
    public static void createSlides (ArrayList<ArrayList> sortedPics) {
        Slide[] unsortedSlides = new Slide[sortedPics.get(0).size()/2 + sortedPics.get(1).size()];
        String str = "";
        for(int i = 0; i < sortedPics.get(0).size(); i++) {
            str = sortedPics.get(0).get(i).toString();
            for(String temp: str.split("//s+")) {

            }

        }
        for(int i = 0; i < sortedPics.get(1).size(); i++) {
            str = sortedPics.get(1).get(i).toString();
            System.out.println(str);
        }
    }
}
