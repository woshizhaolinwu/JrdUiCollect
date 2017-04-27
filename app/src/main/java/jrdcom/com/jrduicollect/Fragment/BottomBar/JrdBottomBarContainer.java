package jrdcom.com.jrduicollect.Fragment.BottomBar;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jrdcom.com.jrduicollect.JrdSystemUtil;
import jrdcom.com.jrduicollect.R;

/**
 * Created by longcheng on 2017/4/27.
 */

public class JrdBottomBarContainer extends RelativeLayout {
    private Context mContext;
    private LinearLayout mBarContainerView;
    private ViewPager mViewPager;
    public JrdBottomBarContainer(Context context){
        super(context);
        mContext = context;
        initView();
    }

    public View getRootView(){
        return (View)this;
    }
    public JrdBottomBarContainer(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mContext = context;
        //初始化rootView,
        initView();
    }

    private void initView(){
        /*初始化TabContainview*/
        initTabContainView();
        /*初始化ViewPager*/
        initViewPager();
    }

    private void initViewPager(){
        mViewPager = new ViewPager(mContext);

        //布局
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(ABOVE,R.id.bottom_bar_container);
        mViewPager.setLayoutParams(params);
        mViewPager.setId(R.id.bottom_bar_viewpager);
        addView(mViewPager);
    }

    private void initTabContainView(){
        mBarContainerView = new LinearLayout(mContext);
        mBarContainerView.setOrientation(LinearLayout.HORIZONTAL);
        mBarContainerView.setId(R.id.bottom_bar_container);
        int des = (int)JrdSystemUtil.getDesity();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, des*60);
        params.addRule(ALIGN_PARENT_BOTTOM);
        mBarContainerView.setLayoutParams(params);
        mBarContainerView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        addView(mBarContainerView);
    }


    public void setAdapter(JrdBottomBarAdapter adapter){
        /*根据adpter来设置Tab*/
        int count  = adapter.BarText.length;
        /*
        * 构建JrdTab
        * */
        if(adapter.BarImage.length != adapter.BarText.length){
            return;
        }
        for(int i = 0; i < count; i++){
            JrdTab jrdTab = new JrdTab(adapter.BarText[i], adapter.BarImage[i]);
            addTab(jrdTab);
        }

        mViewPager.setAdapter(adapter);
    }

    private void addTab(JrdTab tab){
        /*构建tab的布局*/
        LinearLayout tabLinearLayout = new LinearLayout(mContext);
        tabLinearLayout.setOrientation(LinearLayout.VERTICAL);
        //tabLinearLayout.setWeightSum(1);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        tabLinearLayout.setLayoutParams(params);
        mBarContainerView.addView(tabLinearLayout);

        /*
        * 添加Image和Text
        * */
        ImageView imageView = new ImageView(mContext);
        int des = (int)JrdSystemUtil.getDesity();
        LinearLayout.LayoutParams imageParent = new LinearLayout.LayoutParams(30*des, 30*des);
        imageParent.topMargin = 5*des;
        imageParent.gravity= Gravity.CENTER_HORIZONTAL;
        imageView.setLayoutParams(imageParent);
        imageView.setImageResource(tab.getTabImage());
        tabLinearLayout.addView(imageView);

        /*
        * 添加Text
        * */
        TextView textView = new TextView(mContext);
        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParam.gravity= Gravity.CENTER_HORIZONTAL;
        textParam.topMargin= 2*des;
        textView.setLayoutParams(textParam);
        textView.setTextSize(16);
        textView.setText(tab.getTabText());
        tabLinearLayout.addView(textView);
        
    }



}
