package chaoyang.bawei.com.advancedelectricdealerprogram.view.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutID(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        initData();
        return view;
    }

    protected abstract int LayoutID();

    protected abstract void initView(View view);

    protected abstract void initData();


}
