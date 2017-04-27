package jrdcom.com.jrduicollect.Fragment.BottomBar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by longcheng on 2017/4/27.
 * 这个Adapter集合了FragmentViewpage Adapter
 */

public class JrdBottomBarAdapter extends FragmentPagerAdapter{
    public String[] BarText;
    public int[]  BarImage;
    public int[] BarSelImage;
    public Fragment[] BarFragments;

    public JrdBottomBarAdapter(FragmentManager fm, String[] text, int[] barImage, int[] barSelImage, Fragment[] fragments){
        super(fm);

        BarText = text;
        BarImage = barImage;
        BarFragments = fragments;
        BarSelImage = barSelImage;
    }

    public void setBarImage(int[] barImage) {
        BarImage = barImage;
    }

    public void setBarText(String[] barText) {
        BarText = barText;
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
