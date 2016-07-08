package com.chwings.letgotips.activity.guide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chwings.letgotips.R;
import com.chwings.letgotips.activity.BaseActivity;
import com.chwings.letgotips.adapter.guide.CommentQuestionAdapter;
import com.chwings.letgotips.adapter.guide.NotesDetailedViewPagerAdapter;
import com.chwings.letgotips.fragment.BaseFragment;
import com.chwings.letgotips.fragment.guide.NotesLabelFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 笔记详情
 */
public class NotesDetailedActivity extends BaseActivity{

    @BindView(R.id.imViewPager)
    ViewPager imViewPager;

    @BindView(R.id.fmViewPager)
    ViewPager fmViewPager;

    @BindView(R.id.rl_backup)
    RelativeLayout rl_backup;

    @BindView(R.id.rl_native)
    RelativeLayout rl_native;

    @BindView(R.id.tv_total_num)
    TextView tv_total_num;

    @BindView(R.id.tv_index)
    TextView tv_index;

    @BindView(R.id.rl_indicator)
    RelativeLayout rl_indicator;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private NotesDetailedViewPagerAdapter mViewPagerAdapter ;

    private CommentQuestionAdapter mCommentQuestionAdapter ;

    @Override
    public int getLayoutId() {
        return R.layout.activity_notes_detailed;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewPagerData();
        initCommentQuestionViewPagerData();
    }

    private void initCommentQuestionViewPagerData(){
        mCommentQuestionAdapter = new CommentQuestionAdapter(getSupportFragmentManager());
        fmViewPager.setAdapter(mCommentQuestionAdapter);
        fmViewPager.addOnPageChangeListener(onFmPageChangeListener);
        tabLayout.setupWithViewPager(fmViewPager);
    }

    private void initViewPagerData(){
        List<BaseFragment> data = new ArrayList<>();
        data.add(new NotesLabelFragment());
        data.add(new NotesLabelFragment());
        data.add(new NotesLabelFragment());
        mViewPagerAdapter = new NotesDetailedViewPagerAdapter(getSupportFragmentManager() , data);
        imViewPager.setAdapter(mViewPagerAdapter);
        tv_total_num.setText(data.size() + "");
        imViewPager.addOnPageChangeListener(onImPageChangeListener);
    }

    ViewPager.OnPageChangeListener onImPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            tv_index.setText( (position + 1) + "" );
        }

        @Override
        public void onPageSelected(int position) {
            tv_index.setText( (position + 1) + "" );
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    ViewPager.OnPageChangeListener onFmPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //动态计算高度
            View view = fmViewPager.getChildAt(position);
            int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
            int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
            view.measure(w, h);
            int childViewHeight = view.getMeasuredHeight();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, childViewHeight );//这里设置params的高度。
            fmViewPager.setLayoutParams(params);
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
