import java.util.ArrayList;

public class Slide {
    private ArrayList<String> tags = new ArrayList<String>();
    private String picNums;

    //creates slide with two v pics
    public Slide(Picture vPic1, Picture vPic2) {
        //combines tags into one list
        tags.addAll(vPic1.getTags());
        tags.addAll(vPic2.getTags());
        //removes duplicate tags
        for(int i = 0; i < tags.size(); i++) {
            if(tags.indexOf(tags.get(i)) != tags.lastIndexOf(tags.get(i))) {
                tags.remove(tags.lastIndexOf(tags.get(i)));
            }
        }
        //gets numbers associated with photos so they can be written into file
        picNums = vPic1.getPicNum()+" "+vPic2.getPicNum();
    }

    //creates slide with one h pic
    public Slide(Picture hPic) {
        tags.addAll(hPic.getTags());
        picNums = ""+hPic.getPicNum();
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getPicNums() {
        return picNums;
    }
}
