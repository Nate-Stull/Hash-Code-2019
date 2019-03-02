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
        for(String tag: tags.split("//s+")) {
            this.tags.add(tag);
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
