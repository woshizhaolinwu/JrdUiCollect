package jrdcom.com.jrduicollect.Fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by dhcui on 2017/4/26.
 */

public class JrdListFragment extends ListFragment {
    private String[] listData = {"BottomBar"};
    private ListFragmentListener mListFragmentListener;
    public final static String TAG = JrdListFragment.class.getSimpleName();
    /*
    * 定义回调接口
    * */
    public interface ListFragmentListener{
        void onClick(int position);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置listadapter
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listData));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        /*
        * MainActivity实现ListFragmentListener接口
        * */
        mListFragmentListener = (ListFragmentListener )activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(mListFragmentListener != null){
            mListFragmentListener.onClick(position);

        }
    }
}
