package jrdcom.com.jrduicollect.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dhcui on 2017/4/26.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(getLayoutid(), container, false);
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }


    /*
    * 定义抽象函数
    * */
    protected abstract int getLayoutid();

}
