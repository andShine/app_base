package com.andshine.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by liu on 2017/12/13.
 */

public class BaseSwipeFragment extends SwipeBackFragment{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setParallaxOffset(0.5f);
    }
}
