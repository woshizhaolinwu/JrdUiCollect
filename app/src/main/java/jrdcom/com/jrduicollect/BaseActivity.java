package jrdcom.com.jrduicollect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dhcui on 2017/4/26.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData();
        initView();
        addListener();
    }

    /*
    * 抽象函数
    * */
    protected abstract void initData();
    protected abstract void initView();
    protected abstract void addListener();
    protected abstract int getLayoutId();
}
