package per.yyu.testing.gamebase.coupon.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;

import java.util.ArrayList;
import java.util.List;

public class JSONUtil {
    private JSONParser jsonParser;
    private JSONObject originObj;
    private JSONObject headerObj;
    private JSONObject resultObj;
    private JSONArray benefitsArray;
    private JSONObject benefitsObj;

    public JSONUtil() {
        this.jsonParser = new JSONParser();
    }

    public void analysisCouponConsumeResult(CouponTestingModel couponTestingModel) {
        List<String> consumeResults = couponTestingModel.getGamebaseServerResponses();
        List<String> analysisSuccessful = new ArrayList<>();
        List<String> testResults = new ArrayList<>();
        List<String> benefitItems = new ArrayList<>();

        try {
            for (int analysisCount = 0; analysisCount < couponTestingModel.getCouponListSize() - 1; analysisCount++) {
                originObj = (JSONObject) jsonParser.parse(consumeResults.get(analysisCount));
                headerObj = (JSONObject) originObj.get("header");

                if(headerObj.get("isSuccessful").equals(true)) {
                    analysisSuccessful.add(analysisCount, "PASS");

                    resultObj = (JSONObject) originObj.get("result");
                    benefitsArray = (JSONArray) resultObj.get("benefits");
                    couponTestingModel.setBenefitItemSize(benefitsArray.size());

                    for(int itemCount = 0; itemCount < couponTestingModel.getBenefitItemSize(); itemCount++) {
                        benefitsObj = (JSONObject) benefitsArray.get(itemCount);
                        benefitItems.add(itemCount, benefitsObj.get("itemId") + " : " + benefitsObj.get("amount") + "\n");
                    }
                    testResults.add(analysisCount, benefitItems.toString());
                    benefitItems.clear();
                } else {
                    analysisSuccessful.add(analysisCount, "FAIL");
                    testResults.add(analysisCount, headerObj.get("resultCode") + " : " + headerObj.get("resultMessage"));
                }
            }
            couponTestingModel.setCouponConsumeIsSuccessful(analysisSuccessful);
            couponTestingModel.setCouponConsumeTestResult(testResults);

            System.out.println(couponTestingModel.getCouponConsumeIsSuccessful());
            System.out.println(couponTestingModel.getCouponConsumeTestResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
