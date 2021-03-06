package com.andshine.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lzy.okgo.OkGo;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by liu on 2017/12/13.
 */

public class BaseFragment extends SupportFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        OkGo.getInstance().cancelTag(this);
        super.onDestroy();
    }
}
