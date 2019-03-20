package chaoyang.bawei.com.advancedelectricdealerprogram.view.model;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import chaoyang.bawei.com.advancedelectricdealerprogram.view.api.Api;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.api.ApiService;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.bean.GoodsBean;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.bean.GoodsJsonBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeShowModel {
    GetModelData getModelData;
    public void setGetModelData(GetModelData getModelData){
        this.getModelData=getModelData;
    }
        public void getData(String keyword){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.getGoods)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            ApiService apiService = retrofit.create(ApiService.class);
            Flowable<GoodsJsonBean> goods = apiService.getGoods(keyword, 1, 10);
            goods.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSubscriber<GoodsJsonBean>() {
                        @Override
                        public void onNext(GoodsJsonBean goodsJsonBean) {
                            Log.i("xxx", "onNext: "+goodsJsonBean.getResult().size());
                            List<GoodsBean> result = goodsJsonBean.getResult();
                            getModelData.modelData(result);
                        }

                        @Override
                        public void onError(Throwable t) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        };
public interface GetModelData{
    void modelData(List<GoodsBean> result);
}
}
