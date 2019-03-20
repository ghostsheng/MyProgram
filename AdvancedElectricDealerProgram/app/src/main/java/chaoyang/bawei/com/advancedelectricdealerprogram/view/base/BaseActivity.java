package chaoyang.bawei.com.advancedelectricdealerprogram.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutID());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract int LayoutID();

    protected abstract void initView();

    protected abstract void initData();


}
