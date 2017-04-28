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

import java.util.ArrayList;
import java.util.List;

import jrdcom.com.jrduicollect.JrdSystemUtil;
import jrdcom.com.jrduicollect.R;

/**
 * Created by longcheng on 2017/4/27.
 */

public class JrdBottomBarContainer extends RelativeLayout {
    private Context mContext;
    private LinearLayout mBarContainerView;
    private ViewPager mViewPager;
    private List<JrdTab> tabList;

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
        tabList = new ArrayList<>();
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
        //添加viewpager change listener
        mViewPager.addOnPageChangeListener(mViewPagerChange);
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
        mBarContainerView.setBackgroundColor(getResources().getColor(R.color.colorGray));
        addView(mBarContainerView);
    }

    /*
    * 添加Listener
    * */
    /*点击Tab切换ViewPager通过这里执行*/
    public JrdTab.JrdTabClickListener mJrdTabClickListener  = new JrdTab.JrdTabClickListener() {
        @Override
        public void onClick(int index) {
            /*
            * Tab点击了， 然后执行ViewPager的切换
            * */
            mViewPager.setCurrentItem(index, true);
            SelectTab(index);
        }
    };

    /*切换Viewpager来切换tab的sel状态在这里执行*/
    public ViewPager.OnPageChangeListener mViewPagerChange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            SelectTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /*
    * 设置Adapter
    * */
    public void setAdapter(JrdBottomBarAdapter adapter){
        List<JrdTabItem> list = adapter.getJrdTabItems();
        /*根据adpter来设置Tab*/
        int count  = list.size();
        if(count == 0){
            return;
        }
        /*
        * 构建JrdTab
        * */
        for(int i = 0; i < count; i++){
            JrdTabItem jrdTabItem = list.get(i);
            JrdTab jrdTab = new JrdTab(jrdTabItem.getBarText(), jrdTabItem.getBarImage(), jrdTabItem.getBarSelImage());
            jrdTab.setTabIndex(i);
            //add函数放到JrdTab中去
            //addTab(jrdTab);
            jrdTab.addTab(mContext, mBarContainerView);
            jrdTab.setJrdTabClickListener(mJrdTabClickListener);
            tabList.add(jrdTab);
        }

        mViewPager.setAdapter(adapter);

        /*初始化把第一个作为高亮的*/
        SelectTab(0);
    }

    /*
    * 高亮选中的，取消高亮其他的
    * */
    private void SelectTab(int index){
        JrdTab jrdTab = tabList.get(index);

        /*如果该tab已经高亮， 直接返回*/
        if(jrdTab.getTabIsSelect() == true){
            return;
        }
        /*
        * 设置选中的菜单为高亮
        * */
        jrdTab.selectTab();

        /*
        * 设置非选中的菜单为普通
        * */
        for(int i =0; i < tabList.size(); i++){
            if(i == index)
            {
                continue;
            }
            JrdTab unSelTab = tabList.get(i);
            /*如果tab状态为选中状态，则需要取消高亮， 其他的不需要*/
            if(unSelTab.getTabIsSelect() == true){
                unSelTab.unSelectTab();
            }
        }
    }

}
