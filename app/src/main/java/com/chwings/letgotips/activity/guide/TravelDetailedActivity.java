package com.chwings.letgotips.activity.guide;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chwings.letgotips.R;
import com.chwings.letgotips.activity.BaseActivity;
import com.chwings.letgotips.view.FullyGridLayoutManager;
import com.chwings.letgotips.view.FullyLinearLayoutManager;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadmoreWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * 游记详情
 */
public class TravelDetailedActivity extends BaseActivity {

    @BindView(R.id.rv_timeline)
    RecyclerView rv_timeline;

    private List<Integer[]> mDatas = new ArrayList<>();
    private CommonAdapter<Integer[]> mAdapter;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    private LoadmoreWrapper mLoadMoreWrapper;


    @Override
    public int getLayoutId() {
        return R.layout.activity_travel_detailed;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        rv_timeline.setLayoutManager(new FullyLinearLayoutManager(this));
        mAdapter = new CommonAdapter<Integer[]>(this , R.layout.item_travel_detailed, mDatas) {
            @Override
            protected void convert(ViewHolder holder, Integer[] integers, int position) {
            }


        };
        rv_timeline.setAdapter(mAdapter);
//        initHeaderAndFooter();
//        mLoadMoreWrapper = new LoadmoreWrapper(mHeaderAndFooterWrapper);
//        mLoadMoreWrapper.setLoadMoreView(R.layout.item_guide_fun);
//        mLoadMoreWrapper.setOnLoadMoreListener(new LoadmoreWrapper.OnLoadMoreListener()
//        {
//            @Override
//            public void onLoadMoreRequested()
//            {
//                new Handler().postDelayed(new Runnable()
//                {
//                    @Override
//                    public void run()
//                    {
//                        for (int i = 0; i < 10; i++)
//                        {
//                            mDatas.add("Add:" + i);
//                        }
//                        mLoadMoreWrapper.notifyDataSetChanged();
//
//                    }
//                }, 3000);
//            }
//        });
//        rv_timeline.setAdapter(mLoadMoreWrapper);
    }

    private void initData(){
        mDatas.add(new Integer[]{R.drawable.i11111111 , R.drawable.i11111111 , R.drawable.i11111111});
        mDatas.add(new Integer[]{R.drawable.i11111111 , R.drawable.i11111111 , R.drawable.i11111111});
        mDatas.add(new Integer[]{R.drawable.i11111111 , R.drawable.i11111111 , R.drawable.i11111111});
        mDatas.add(new Integer[]{R.drawable.i11111111 , R.drawable.i11111111 , R.drawable.i11111111});
        mDatas.add(new Integer[]{R.drawable.i11111111 , R.drawable.i11111111 , R.drawable.i11111111});
    }

    private void initHeaderAndFooter()
    {
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mAdapter);
        View view = LayoutInflater.from(this).inflate(R.layout.item_travel_detailed_num , null);
        mHeaderAndFooterWrapper.addHeaderView(view);
    }
}
