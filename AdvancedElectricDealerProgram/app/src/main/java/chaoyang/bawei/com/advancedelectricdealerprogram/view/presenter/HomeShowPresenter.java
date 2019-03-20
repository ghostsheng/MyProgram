package chaoyang.bawei.com.advancedelectricdealerprogram.view.presenter;

import java.util.List;

import chaoyang.bawei.com.advancedelectricdealerprogram.view.bean.GoodsBean;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.model.HomeShowModel;
import chaoyang.bawei.com.advancedelectricdealerprogram.view.view.HomeShowView;

public class HomeShowPresenter {
    private final HomeShowModel model;
    private final HomeShowView view;

    public HomeShowPresenter(HomeShowView view) {
        this.model = new HomeShowModel();
        this.view = view;
    }
    public void presenter(String keywork){
        model.getData(keywork);
        model.setGetModelData(new HomeShowModel.GetModelData() {
            @Override
            public void modelData(List<GoodsBean> result) {
                view.viewData(result);
            }
        });
    }
}
