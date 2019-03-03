import java.util.*;
import java.io.*;

/*
My revised solution to the Google's Hash Code 2019 challenge problem.
~Initial submission points: 13
~Latest submission points: 1
 */

public class ReaderWriter {

    //would like to have it so user can pass in
    public static void main (String[] args) {
        new ReaderWriter("a_example.txt");
    }

    public ReaderWriter (String picturesFile) {
        try {
            Scanner reader = new Scanner(new File (picturesFile));
            Sorter sorter = new Sorter(readFile(reader));
            writeFile(sorter.getSortedSlides());

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    //reads file, creating new picture object for each picture, and adding it to a picture array
    public Picture[] readFile (Scanner reader) {
        Picture[] unsortedPics = new Picture[Integer.parseInt(reader.nextLine())];
        int i = 0;
        while (reader.hasNextLine()) {
            Picture picture = new Picture(i, reader.next(), reader.next(), reader.nextLine());
            unsortedPics[i] = picture;
            i++;
        }
        return unsortedPics;
    }

    public void writeFile(Slide[] sortedSlides) {
        System.out.println(sortedSlides.length);
        for(Slide slide: sortedSlides) {
            System.out.println(slide.getPicNums());
        }
    }
}
