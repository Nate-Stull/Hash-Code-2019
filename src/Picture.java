import java.util.ArrayList;

public class Picture {
    private int picNum;
    private String orientation;
    private int numOfTags;
    private ArrayList<String> tags = new ArrayList<String>();

    public Picture (int picNum, String orientation, String numOfTags, String tags) {
        this.picNum = picNum;
        this.orientation = orientation;
        this.numOfTags = Integer.parseInt(numOfTags);
        //converts string of tags into array of tags
        String currentTag = "";
        for(String character: tags.split("")) {
            if(character.equals(" ")) {
                this.tags.add(currentTag);
                currentTag = "";
            }
            else currentTag += character;
        }
    }

    public int getPicNum() {
        return picNum;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getNumOfTags() {
        return numOfTags;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
