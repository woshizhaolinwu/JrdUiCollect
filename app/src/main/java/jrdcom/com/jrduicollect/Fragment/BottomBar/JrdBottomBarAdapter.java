package jrdcom.com.jrduicollect.Fragment.BottomBar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by longcheng on 2017/4/27.
 * 这个Adapter集合了FragmentViewpage Adapter
 */

public class JrdBottomBarAdapter extends FragmentPagerAdapter{
    private List<JrdTabItem> jrdTabItems;
    public Fragment[] BarFragments;

    public JrdBottomBarAdapter(FragmentManager fm, List<JrdTabItem> itemList, Fragment[] fragments){
        super(fm);
        BarFragments = fragments;
        jrdTabItems = itemList;
    }

    /*TabItem的适配*/
    public List<JrdTabItem> getJrdTabItems() {
        return jrdTabItems;
    }

    /*FragmentPager的适配*/
    @Override
    public Fragment getItem(int position) {
        return BarFragments[position];
    }

    @Override
    public int getCount() {
        return BarFragments.length;
    }
}
