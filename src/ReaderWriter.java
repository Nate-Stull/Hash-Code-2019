import java.util.*;
import java.io.*;

/*
My revised solution to the Google's Hash Code 2019 challenge problem.
~Initial submission points: 13
~Latest submission points:
 */

public class ReaderWriter {

    //would like to have it so user can pass in
    public static void main (String[] args) {
        new ReaderWriter("c_memorable_moments.txt");
    }

    public ReaderWriter (String picturesFile) {
        try {
            Scanner reader = new Scanner(new File (picturesFile));
            //writeFile(Sorter.pairSlides(Sorter.pairVPics(Sorter.splitHVPics(readFile(reader)))));
            for(Picture picture: readFile(reader)) {
                for(String str: picture.getTags()) {
                    System.out.print(str);
                }
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    //reads file, creating new picture object for each picture, and adding it to a picture array
    public Picture[] readFile (Scanner reader) {
        Picture[] allPics = new Picture[Integer.parseInt(reader.nextLine())];
        int i = 0;
        while (reader.hasNextLine()) {
            Picture picture = new Picture(i, reader.next(), reader.next(), reader.nextLine());
            allPics[i] = picture;
            i++;
        }
        return allPics;
    }

    //writes to a solution file
    public void writeFile(Slide[] sortedSlides) {
        //write sortedSlides.length;
        for(Slide slide: sortedSlides) {
            //write slide.getPicNums();
        }
    }
}
