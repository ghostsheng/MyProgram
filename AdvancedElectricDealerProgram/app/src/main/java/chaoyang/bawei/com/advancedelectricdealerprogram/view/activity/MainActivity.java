package chaoyang.bawei.com.advancedelectricdealerprogram.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chaoyang.bawei.com.advancedelectricdealerprogram.R;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.base.BaseActivity;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.fragment.FragmentCircle;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.fragment.FragmentClassify;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.fragment.FragmentHome;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.fragment.FragmentMy;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.fragment.FragmentShoppingTrolley;

public class MainActivity extends BaseActivity {


    @BindView(R.id.ra1)
    RadioButton ra1;
    @BindView(R.id.ra2)
    RadioButton ra2;
    @BindView(R.id.ra3)
    RadioButton ra3;
    @BindView(R.id.ra4)
    RadioButton ra4;
    @BindView(R.id.ra5)
    RadioButton ra5;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int LayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.ra1, R.id.ra2, R.id.ra3, R.id.ra4, R.id.ra5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ra1:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl, new FragmentHome()).commit();
                break;
            case R.id.ra2:
                  transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl, new FragmentClassify()).commit();
                break;
            case R.id.ra3:
                  transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl, new FragmentShoppingTrolley()).commit();
                break;
            case R.id.ra4:
                  transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl, new FragmentCircle()).commit();
                break;
            case R.id.ra5:
                  transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl, new FragmentMy()).commit();
                break;
        }
    }
}
