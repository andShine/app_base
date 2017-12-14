package com.andshine.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andshine.app.R;
import com.andshine.app.base.BaseFragment;
import com.squareup.picasso.Picasso;

/**
 * Created by liu on 2017/12/14.
 */

public class SecondTabFragment extends BaseFragment{

    public static SecondTabFragment newInstance() {
        SecondTabFragment fragment = new SecondTabFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_second,container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ImageView mImage = view.findViewById(R.id.ivTest);
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513250710790&di=ba2ff0be7f7558fe690524cdfb3b8210&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F1e30e924b899a9013f6dc6d41f950a7b0308f5fc.jpg";
        Picasso.with(_mActivity).load(url).into(mImage);
    }
}
