package jrdcom.com.jrduicollect.Fragment.BottomBar;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import jrdcom.com.jrduicollect.JrdSystemUtil;

/**
 * Created by longcheng on 2017/4/27.
 */

public class JrdTab {

    private String tabText;
    private int tabImage;
    private int tabIndex;
    private int tabSelImage;
    private ViewGroup mRootView;

    public JrdTab(String text, int image, int selImage){
        tabText = text;
        tabImage = image;
        tabSelImage = selImage;
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

    public ViewGroup getRootView(){
        return mRootView;
    }

    public void addTab(Context context, ViewGroup ContainerView){
        /*构建tab的布局*/
        mRootView = new LinearLayout(context);
        ((LinearLayout)mRootView).setOrientation(LinearLayout.VERTICAL);
        //tabLinearLayout.setWeightSum(1);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        mRootView.setLayoutParams(params);
        ContainerView.addView(mRootView);

        /*
        * 添加Image和Text
        * */
        ImageView imageView = new ImageView(context);
        int des = (int) JrdSystemUtil.getDesity();
        LinearLayout.LayoutParams imageParent = new LinearLayout.LayoutParams(30*des, 30*des);
        imageParent.topMargin = 5*des;
        imageParent.gravity= Gravity.CENTER_HORIZONTAL;
        imageView.setLayoutParams(imageParent);
        imageView.setImageResource(getTabImage());
        mRootView.addView(imageView);

        /*
        * 添加Text
        * */
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParam.gravity= Gravity.CENTER_HORIZONTAL;
        textParam.topMargin= 2*des;
        textView.setLayoutParams(textParam);
        textView.setTextSize(16);
        textView.setText(getTabText());
        mRootView.addView(textView);
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                *  这里添加回调
                * */
                /*if(mJrdBottomBarListener != null){
                    mJrdBottomBarListener.onClick(tab.getTabIndex());
                }*/
                selectTab();
            }
        });
    }

    private void selectTab(){
        ImageView imageView = (ImageView)mRootView.getChildAt(0);
        imageView.setImageResource(tabSelImage);
    }
}
