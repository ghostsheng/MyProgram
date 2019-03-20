package chaoyang.bawei.com.advancedelectricdealerprogram.view.api;

import chaoyang.bawei.com.advancedelectricdealerprogram.view.bean.GoodsJsonBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    //    http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=?&page=?&count=?
    @GET("findCommodityByKeyword")
    Flowable<GoodsJsonBean> getGoods(@Query("keyword")String keyword, @Query("page")int page, @Query("count")int count);
}
