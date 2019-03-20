package chaoyang.bawei.com.advancedelectricdealerprogram.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import chaoyang.bawei.com.advancedelectricdealerprogram.R;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.bean.GoodsBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHoder> {
        Context context;
    List<GoodsBean> result;
    ItemLisener itemLisener;
    public void setItemLisener(ItemLisener itemLisener){
        this.itemLisener=itemLisener;
    }
    public MyAdapter(Context context, List<GoodsBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_layout, viewGroup, false);
        ViewHoder hoder=new ViewHoder(view);
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, final int i) {
        viewHoder.home_item_img.setImageURI(result.get(i).getMasterPic());
        viewHoder.home_item_title.setText(result.get(i).getCommodityName());
        viewHoder.home_item_price.setText(result.get(i).getPrice()+"￥");
        if (itemLisener != null){
            viewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 这里利用回调来给RecyclerView设置点击事件
                    itemLisener.item(result.get(i).getCommodityId());
                }
            });
        }

    }

    public interface ItemLisener{
        void item(int position);
    }
    @Override
    public int getItemCount() {
        return result.size();
    }
    public class ViewHoder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView home_item_img;
        private final TextView home_item_title;
        private final TextView home_item_price;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            home_item_img = itemView.findViewById(R.id.home_item_img);
            home_item_title = itemView.findViewById(R.id.home_item_title);
            home_item_price = itemView.findViewById(R.id.home_item_price);
        }
    }
}
