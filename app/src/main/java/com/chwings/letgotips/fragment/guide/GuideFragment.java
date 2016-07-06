package com.chwings.letgotips.fragment.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.brianLin.view.TitleBarView;
import com.chwings.letgotips.R;
import com.chwings.letgotips.adapter.GuiTabPageIndicatorAdapter;
import com.chwings.letgotips.fragment.BaseFragment;
import com.chwings.letgotips.view.ViewPagerIndicator;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * 指南 大模块
 */
public class GuideFragment extends BaseFragment{

    @BindView(R.id.indicator)
    ViewPagerIndicator indicator;

    @BindView(R.id.title)
    TitleBarView title;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private GuiTabPageIndicatorAdapter mTabAdapter ;

    private List<String> mTitles = Arrays.asList("吃", "LET GO", "喝", "玩",
            "乐", "购");

    @Override
    public int getLayoutId() {
        return R.layout.fragment_guide;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTabAdapter = new GuiTabPageIndicatorAdapter(getChildFragmentManager());
        viewPager.setAdapter(mTabAdapter);
        indicator.setTabItemTitles(mTitles);
        indicator.setViewPager(viewPager , 1);
    }

}
