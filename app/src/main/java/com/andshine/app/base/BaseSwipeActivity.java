package com.andshine.app.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.lzy.okgo.OkGo;

import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

/**
 * Created by liu on 2017/12/13.
 */

public class BaseSwipeActivity extends SwipeBackActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {
        OkGo.getInstance().cancelTag(this);
        super.onDestroy();
    }

    public void finishNonTransition() {
        finish();
        overridePendingTransition(0, 0);
    }
}
