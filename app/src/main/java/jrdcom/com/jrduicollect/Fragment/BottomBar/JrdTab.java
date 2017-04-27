package jrdcom.com.jrduicollect.Fragment.BottomBar;

/**
 * Created by longcheng on 2017/4/27.
 */

public class JrdTab {

    private String tabText;
    private int tabImage;

    public JrdTab(String text, int image){
        tabText = text;
        tabImage = image;
    }
    public void setTabImage(int tabImage) {
        this.tabImage = tabImage;
    }

    public int getTabImage() {
        return tabImage;
    }

    public void setTabText(String tabText) {
        this.tabText = tabText;
    }

    public String getTabText() {
        return tabText;
    }
}
