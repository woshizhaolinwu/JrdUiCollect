package jrdcom.com.jrduicollect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jrdcom.com.jrduicollect.Fragment.BottomBar.JrdBottomBarFragment;
import jrdcom.com.jrduicollect.Fragment.JrdListFragment;
import jrdcom.com.jrduicollect.Util.JrdUtil;

public class MainActivity extends BaseActivity implements JrdListFragment.ListFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        /*添加fragment到mainScreen*/
        getFragmentManager().beginTransaction()
                .add(R.id.main_screen, new JrdListFragment())
                .addToBackStack(JrdListFragment.TAG)
                .commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void addListener() {

    }

    @Override
    public void onClick(int position) {
        switch (position)
        {
            case JrdUtil.BOTTOM_BAR:
                //进入Bottom bar
                getFragmentManager().beginTransaction()
                        .replace(R.id.main_screen, new JrdBottomBarFragment())
                        .addToBackStack(JrdBottomBarFragment.TAG)
                        .commit();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 1){
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
