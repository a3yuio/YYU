package per.yyu.testing.gamebase.coupon.testing;

import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;
import per.yyu.testing.gamebase.coupon.util.FileUtil;
import per.yyu.testing.gamebase.coupon.util.HTTPUtil;
import per.yyu.testing.gamebase.coupon.util.JSONUtil;
import per.yyu.testing.gamebase.coupon.util.POIUtil;

public class CouponTesting {
    private CouponTestingModel couponTestingModel = new CouponTestingModel();
    private FileUtil fileUtil;
    private POIUtil poiUtil;
    private JSONUtil jsonUtil;
    private HTTPUtil httpUtil;

    public void couponAutoConsumer() {
        fileUtil = new FileUtil();
        fileUtil.readAndSetCouponTestingInfoFile(couponTestingModel);

        poiUtil = new POIUtil();
        poiUtil.readCouponCodes(couponTestingModel, couponTestingModel.getDownloadedCouponListFilePath());

        httpUtil = new HTTPUtil();
        httpUtil.postSendForCouponConsume(couponTestingModel);
    }
}
