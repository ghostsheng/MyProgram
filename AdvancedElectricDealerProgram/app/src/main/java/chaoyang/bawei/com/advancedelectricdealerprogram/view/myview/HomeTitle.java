package chaoyang.bawei.com.advancedelectricdealerprogram.view.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import chaoyang.bawei.com.advancedelectricdealerprogram.R;


public class HomeTitle extends LinearLayout {

    private ImageView btn_img;
    private EditText et_ssk;
    private Button btn_ssj;
    MyHomeTitleListener myHomeTitleListener;
    public void setMyHomeTitleListener(MyHomeTitleListener myHomeTitleListener){
        this.myHomeTitleListener=myHomeTitleListener;
    }

    public HomeTitle(Context context) {
        super(context);
    }

    public HomeTitle(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.myview_title,this);
        btn_img = findViewById(R.id.btn_img);
        et_ssk = findViewById(R.id.et_ssk);
        btn_ssj = findViewById(R.id.btn_ssj);
        btn_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myHomeTitleListener.getClassify();
            }
        });
        btn_ssj.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et_ssk.getText().toString();
                if (!s.isEmpty()){
                    myHomeTitleListener.getGoods(s);
                }else{
                    Toast.makeText(context, "请输入搜索内容", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public HomeTitle(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public interface MyHomeTitleListener {
        void getClassify();
        void getGoods(String t);

    }
    }
