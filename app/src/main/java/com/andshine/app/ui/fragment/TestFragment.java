package com.andshine.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andshine.app.R;
import com.andshine.app.base.BaseSwipeFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

/**
 * Created by liu on 2017/12/14.
 */

public class TestFragment extends BaseSwipeFragment{

    private String mTitle;
    private QMUITopBar mTopbar;

    public static TestFragment newInstance(String title){
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container,false);
        initView(view);
        return attachToSwipeBack(view);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTitle = getArguments().getString("title");
        initEvent();
    }

    private void initView(View view) {
        mTopbar = view.findViewById(R.id.topbar);
    }

    private void initEvent(){
        mTopbar.addLeftBackImageButton().setOnClickListener(v -> pop());
        mTopbar.setTitle(mTitle);
    }
}
