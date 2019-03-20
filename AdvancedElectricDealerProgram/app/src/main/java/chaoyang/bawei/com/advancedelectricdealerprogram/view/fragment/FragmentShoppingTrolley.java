package chaoyang.bawei.com.advancedelectricdealerprogram.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;


import chaoyang.bawei.com.advancedelectricdealerprogram.R;

public class FragmentShoppingTrolley extends Fragment{

    private ExpandableListView elv;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentshoppingtrolley, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
    }
}
