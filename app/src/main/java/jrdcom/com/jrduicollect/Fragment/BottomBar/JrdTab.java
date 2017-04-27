package jrdcom.com.jrduicollect.Fragment.BottomBar;

/**
 * Created by longcheng on 2017/4/27.
 */

public class JrdTab {

    private String tabText;
    private int tabImage;
    private int tabIndex;

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

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public int getTabIndex() {
        return tabIndex;
    }
}
