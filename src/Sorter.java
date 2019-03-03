import java.io.StringReader;
import java.util.*;

public class Sorter {
    private ArrayList<Picture> vPics;
    private ArrayList<Picture> hPics;
    private Slide[] sortedSlides;


    public Sorter(Picture[] unsortedPics) {
        vPics = new ArrayList<>(unsortedPics.length/2);
        hPics = new ArrayList<>(unsortedPics.length/2);
        sortedSlides = sortSlides(createSlides(sortVPics(splitHVPics(unsortedPics))));
    }

    //#1) sorts array by putting vert pictures then horizontal in separate arraylists; then put into 2d arraylist
    public ArrayList<ArrayList> splitHVPics(Picture[] unsortedPics) {
        ArrayList<ArrayList> sortedPics = new ArrayList<>(unsortedPics.length);
        for(Picture picture: unsortedPics) {
            if(picture.getOrientation().equals("V")) {
                vPics.add(picture);
            }
            else hPics.add(picture);
        }
        sortedPics.add(vPics);
        sortedPics.add(hPics);
        return sortedPics;
    }

    //#2) sorts vertical pictures by amount of tags using insertion sort
    public ArrayList<ArrayList> sortVPics(ArrayList<ArrayList> sortedPics) {
        ArrayList<Picture> sortedVPics = new ArrayList<Picture>(vPics.size());
        for(int i = 0; i < vPics.size(); i++) {
            Picture picture = vPics.get(i);
            for(int n = 0; n < sortedVPics.size(); n++) {
                if(picture.getNumOfTags() <= sortedVPics.get(n).getNumOfTags()) {
                    sortedVPics.add(n,picture);
                    picture = null;
                    break;
                }
            }
            if(picture != null)sortedVPics.add(picture);
        }
        sortedPics.remove(vPics);
        sortedPics.add(0, sortedVPics);
        return sortedPics;
    }

    //#3) takes in 2d arraylist, grabs vertical pictures & pairs them; returns unsorted slide arraylist
    public ArrayList<Slide> createSlides (ArrayList<ArrayList> sortedPics) {
        ArrayList<Slide> unsortedSlides = new ArrayList<>(sortedPics.get(0).size()/2+sortedPics.get(1).size());
        int vPicCount = vPics.size();
        //creating slides of paired vertical pictures
        while(unsortedSlides.size() < vPicCount / 2) {
            if(vPics.get(0) != vPics.get(vPics.size()-1)) {
                Slide slide = new Slide(vPics.get(0), vPics.get(vPics.size()-1));
                unsortedSlides.add(slide);
                vPics.remove(0);
                vPics.remove(vPics.size()-1);
            }
        }
        //adding horizantal pics to slides
        for(int i = 0; i < hPics.size(); i++) {
            Slide slide = new Slide(hPics.get(i));
            unsortedSlides.add(slide);
        }
        return unsortedSlides;
    }

    //#4) sorts slides optimally (balanced num of shared and unshared tags)
    public Slide[] sortSlides(ArrayList<Slide> unsortedSlides) {
        Slide[] sortedSlides = new Slide[unsortedSlides.size()];
        //ArrayList<Slide> arls = new ArrayList<Slide>();
        int count = 0;
        sortedSlides[0] = (unsortedSlides.get(0));
        unsortedSlides.remove(0);
        Slide toBeAddedNext = unsortedSlides.get(0);
        for(int i = 0; i < sortedSlides.length-1; i++) {
            if(sortedSlides[i] != null) {
                Slide slide = sortedSlides[i];
                for (int n = 0; n < unsortedSlides.size(); n++) {
                    Slide temp = unsortedSlides.get(n);
                    int tempCount = 0;
                    if (i == 0) {
                        count = compareTags(slide, temp);
                    } else tempCount = compareTags(slide, temp);
                    //sets changes the next slide to be added if it is better choice
                    if (tempCount < count) {
                        toBeAddedNext = temp;
                    }
                }
                //arls.add(toBeAddedNext);
                sortedSlides[nextIndex(sortedSlides)] = toBeAddedNext;
                unsortedSlides.remove(toBeAddedNext);
            }
        }
        return sortedSlides;
    }
    //helper method to sort slides; returns a number describing how similar/different two slides tags are
    //the closer to 0 the num, the better
    public static int compareTags(Slide slide1, Slide slide2) {
        int count = 0;
        for(String tag1: slide1.getTags()) {
            int tempCount = 0;
            for(String tag2: slide2.getTags()) {
                if(tag1.equals(tag2) && !(tag2.equals(""))) {
                    tempCount++;
                    break;
                }
            }
            if(tempCount == 0) count--;
            else count++;
        }
        if(count == 0) return 0;
        else return count*count/count;
    }
    public static int nextIndex(Slide[] array) {
        int count = 0;
        for(Slide slide: array) {
            if(slide != null) {
                count++;
            }
            else break;
        }
        return count;
    }

    public Slide[] getSortedSlides() {
        return sortedSlides;
    }

}
