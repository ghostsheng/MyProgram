package chaoyang.bawei.com.advancedelectricdealerprogram.view.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import chaoyang.bawei.com.advancedelectricdealerprogram.R;

public class MyCalputer  extends LinearLayout {

    private Button btn_jian;
    private Button btn_jia;
    private EditText et_num;
    Claputer claputer;
    private String s;
    int i=1;
    private int num;

    public void setClaputer(Claputer claputer){
        this.claputer=claputer;
    }

    public MyCalputer(Context context) {
        super(context);
    }

    public MyCalputer(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.myview_mycalputer,this);
        btn_jian = findViewById(R.id.btn_jian);
        btn_jia = findViewById(R.id.btn_jia);
        et_num = findViewById(R.id.et_num);
        s = et_num.getText().toString();
        num = new Integer(s);
        if (num<2){
            btn_jian.setVisibility(View.GONE);
        }else{
            btn_jian.setVisibility(View.VISIBLE);
        }
        btn_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                claputer.getJIan();
                num--;
                String a=String.valueOf(num);
                if (num<2){
                    btn_jian.setVisibility(View.GONE);
                }else{
                    btn_jian.setVisibility(View.VISIBLE);
                }
               et_num.setText(a);
            }
        });
        btn_jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                claputer.getjia();
                num++;
                String a=String.valueOf(num);
                if (num<2){
                    btn_jian.setVisibility(View.GONE);
                }else{
                    btn_jian.setVisibility(View.VISIBLE);
                }
                Toast.makeText(context, ""+a, Toast.LENGTH_SHORT).show();
                et_num.setText(a);
            }
        });
    }

    public MyCalputer(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public interface Claputer{
        void getJIan();
        void getjia();
    }
}
