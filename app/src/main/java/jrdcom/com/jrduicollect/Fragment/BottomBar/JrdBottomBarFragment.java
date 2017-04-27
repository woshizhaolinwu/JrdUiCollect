package jrdcom.com.jrduicollect.Fragment.BottomBar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jrdcom.com.jrduicollect.Fragment.BaseFragment;
import jrdcom.com.jrduicollect.R;

/**
 * Created by dhcui on 2017/4/26.
 */

public class JrdBottomBarFragment extends BaseFragment {
    public static final String TAG = JrdBottomBarFragment.class.getSimpleName();
    String[] barText = {"test1","test2","test3","test4"};
    int[] barImage = {R.mipmap.icon_app, R.mipmap.icon_main, R.mipmap.icon_mine, R.mipmap.icon_work};

    @Override
    protected int getLayoutid() {
        return R.layout.bottombar_layout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        JrdBottomBarContainer jrdBottomBarContainer = new JrdBottomBarContainer(getActivity());
        Fragment fragment[] = {new JrdTestFragment(), new JrdTestFragment(), new JrdTestFragment(), new JrdTestFragment()};
        JrdBottomBarAdapter jrdBottomBarAdapter = new JrdBottomBarAdapter(((AppCompatActivity)getActivity()).getSupportFragmentManager(),barText, barImage, fragment);
        jrdBottomBarContainer.setAdapter(jrdBottomBarAdapter);
        return jrdBottomBarContainer.getRootView();
    }


}
