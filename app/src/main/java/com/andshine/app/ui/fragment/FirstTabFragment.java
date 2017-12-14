package com.andshine.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andshine.app.R;
import com.andshine.app.base.BaseFragment;
import com.andshine.app.event.StartBrotherEvent;
import com.andshine.app.event.TabSelectedEvent;
import com.blankj.utilcode.util.LogUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.Subscribe;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;

/**
 * Created by liu on 2017/12/14.
 */

public class FirstTabFragment extends BaseFragment {

    private RecyclerView mRcv;
    private SmartRefreshLayout mRefreshLayout;

    public static FirstTabFragment newInstance() {
        FirstTabFragment fragment = new FirstTabFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_first, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEvent();
    }

    private void initView(View view) {
        EventBusActivityScope.getDefault(_mActivity).register(this);
        QMUITopBar topBar = view.findViewById(R.id.topbar);
        topBar.setTitle("主页");
        // mRcv = view.findViewById(R.id.rcv);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        TextView mTvDesc = view.findViewById(R.id.tvDesc);
        mTvDesc.setOnClickListener(v -> EventBusActivityScope.getDefault(_mActivity).post(new StartBrotherEvent(TestFragment.newInstance("测试"))));
    }

    private void initEvent() {
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            // 刷新事件
            finishLoad();
        });

        mRefreshLayout.setOnLoadmoreListener(refreshlayout -> {
            // 加载更多事件
            finishLoad();
        });
        // 当没有更多时，设置
        // mRefreshLayout.setLoadmoreFinished(true);
    }

    /**
     * 结束刷新，结束加载更多
     */
    private void finishLoad() {
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadmore();
    }

    /**
     * Reselected Tab
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != MainFragment.FIRST) return;
        // 可设置重选tab逻辑，比如：如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
        LogUtils.dTag("FirstTab", "onTabSelectedEvent");
    }
}
