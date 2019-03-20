package chaoyang.bawei.com.advancedelectricdealerprogram.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import chaoyang.bawei.com.advancedelectricdealerprogram.R;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.activity.GoodsShowActivity;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.adapter.MyAdapter;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.base.BaseFragment;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.bean.GoodsBean;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.myview.HomeTitle;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.presenter.HomeShowPresenter;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.view.HomeShowView;

public class FragmentHome extends BaseFragment implements HomeShowView {

    @BindView(R.id.ht)
    HomeTitle ht;
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    @BindView(R.id.sssb)
    ImageView sssb;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    private HomeShowPresenter presenter;


    @Override
    protected int LayoutID() {
        return R.layout.fragmenthome;
    }

    @Override
    protected void initView(View view) {
        ht = view.findViewById(R.id.ht);
    }

    @Override
    protected void initData() {
        presenter = new HomeShowPresenter(this);
        ht.setMyHomeTitleListener(new HomeTitle.MyHomeTitleListener() {

            @Override
            public void getClassify() {
                Toast.makeText(getActivity(), "点击了分类", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void getGoods(String t) {
                presenter.presenter(t);
            }
        });
    }

    @Override
    public void viewData(List<GoodsBean> result) {
        if (result.size() == 0) {
            sssb.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
            srl.setVisibility(View.GONE);
        } else {
            sssb.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
            srl.setVisibility(View.VISIBLE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            rv.setLayoutManager(linearLayoutManager);
            MyAdapter adapter = new MyAdapter(getActivity(), result);
            rv.setAdapter(adapter);
//设置下拉时圆圈的颜色（可以由多种颜色拼成）
            srl.setColorSchemeResources(
                    android.R.color.holo_orange_light);

            //设置下拉时圆圈的背景颜色（这里设置成白色）
            srl.setProgressBackgroundColorSchemeResource(android.R.color.white);
            srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "刷新了", Toast.LENGTH_SHORT).show();
                            srl.setRefreshing(false);
                        }
                    }, 3000);
                }
            });
            adapter.setItemLisener(new MyAdapter.ItemLisener() {
                @Override
                public void item(int position) {
                    EventBus.getDefault().postSticky(position);
                    Intent intent = new Intent(getActivity(), GoodsShowActivity.class);
                   startActivity(intent);
                }
            });
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
