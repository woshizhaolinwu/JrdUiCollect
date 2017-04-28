package jrdcom.com.jrduicollect.Fragment.BottomBar.TestFile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jrdcom.com.jrduicollect.Fragment.BaseFragment;
import jrdcom.com.jrduicollect.Fragment.BottomBar.JrdBottomBarAdapter;
import jrdcom.com.jrduicollect.Fragment.BottomBar.JrdBottomBarContainer;
import jrdcom.com.jrduicollect.Fragment.BottomBar.JrdTab;
import jrdcom.com.jrduicollect.Fragment.BottomBar.JrdTabItem;
import jrdcom.com.jrduicollect.R;

/**
 * Created by dhcui on 2017/4/26.
 */

public class JrdBottomBarFragment extends BaseFragment {
    public static final String TAG = JrdBottomBarFragment.class.getSimpleName();
    private List<JrdTabItem> tabItemList = new ArrayList<>();

    @Override
    protected int getLayoutid() {
        return R.layout.bottombar_layout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        JrdBottomBarContainer jrdBottomBarContainer = new JrdBottomBarContainer(getActivity());
        Fragment fragment[] = {new JrdTestFragment(), new JrdTestFragment(), new JrdTestFragment(), new JrdTestFragment()};
        /*初始化test数据*/
        initTestData();
        /*BottomBar设置Adapter*/
        JrdBottomBarAdapter jrdBottomBarAdapter = new JrdBottomBarAdapter(((AppCompatActivity)getActivity()).getSupportFragmentManager(),tabItemList, fragment);
        jrdBottomBarContainer.setAdapter(jrdBottomBarAdapter);

        return jrdBottomBarContainer.getRootView();
    }

    private void initTestData() {
        JrdTabItem tabItem = new JrdTabItem("App", R.mipmap.icon_app, R.mipmap.icon_app_selected);
        JrdTabItem tabItem_main = new JrdTabItem("Main", R.mipmap.icon_main, R.mipmap.icon_main_selected);
        JrdTabItem tabItem_mine = new JrdTabItem("Mine", R.mipmap.icon_mine, R.mipmap.icon_mine_selected);
        JrdTabItem tabItem_work = new JrdTabItem("Work", R.mipmap.icon_work, R.mipmap.icon_work_selected);
        tabItemList.add(tabItem);
        tabItemList.add(tabItem_main);
        tabItemList.add(tabItem_mine);
        tabItemList.add(tabItem_work);
    }
}
