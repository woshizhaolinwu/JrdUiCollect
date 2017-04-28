package jrdcom.com.jrduicollect.Fragment.BottomBar;

/**
 * Created by longcheng on 2017/4/28.
 */

public class JrdTabItem {
    public String BarText;
    public int  BarImage;
    public int BarSelImage;

    public JrdTabItem(String text, int imageId, int imageSelId){
        BarText = text;
        BarImage = imageId;
        BarSelImage = imageSelId;
    }

    public int getBarImage() {
        return BarImage;
    }

    public int getBarSelImage() {
        return BarSelImage;
    }

    public String getBarText() {
        return BarText;
    }
}
