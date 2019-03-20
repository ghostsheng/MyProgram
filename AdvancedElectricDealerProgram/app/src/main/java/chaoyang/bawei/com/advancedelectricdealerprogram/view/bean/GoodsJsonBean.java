package chaoyang.bawei.com.advancedelectricdealerprogram.view.bean;

import java.util.List;

public class GoodsJsonBean {

    private String message;
    private String status;
    private List<GoodsBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GoodsBean> getResult() {
        return result;
    }

    public void setResult(List<GoodsBean> result) {
        this.result = result;
    }

}
