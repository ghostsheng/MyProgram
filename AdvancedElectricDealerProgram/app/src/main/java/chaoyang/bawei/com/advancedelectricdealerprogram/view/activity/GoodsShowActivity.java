package chaoyang.bawei.com.advancedelectricdealerprogram.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import chaoyang.bawei.com.advancedelectricdealerprogram.R;

public class GoodsShowActivity extends AppCompatActivity {


    @BindView(R.id.show_sdv)
    SimpleDraweeView showSdv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_show);
        ButterKnife.bind(this);
        showSdv.setImageURI("http://172.17.8.100/images/small/commodity/nx/nbx/6/1.jpg");
    }

}
