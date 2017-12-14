package com.andshine.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andshine.app.R;
import com.andshine.app.base.BaseFragment;

/**
 * Created by liu on 2017/12/14.
 */

public class ThirdTabFragment extends BaseFragment{

    public static ThirdTabFragment newInstance() {
        ThirdTabFragment fragment = new ThirdTabFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_third,container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }
}
