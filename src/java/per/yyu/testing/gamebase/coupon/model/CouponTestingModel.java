package per.yyu.testing.gamebase.coupon.model;

import java.util.ArrayList;
import java.util.List;

public class CouponTestingModel {
    private String couponTestingInfoFilePath;
    private String downloadedCouponListFilePath;

    private String toastProjectAppID;
    private String gamebaseUserID;
    private List<String> couponCodes;
    private int couponListSize;
    private String gamebaseServerAPIDomain;
    private String[][] gamebaseServerAPIHTTPHeaderOption;
    private List<String> gamebaseServerResponses;
//    private String gamebaseServerResponse;
    private List<String> couponConsumeIsSuccessful;
//    private boolean couponConsumeIsSuccessful;
    private int benefitItemSize;
    private List<String> couponConsumeTestResult;
//    private String couponConsumeTestResult;

    public CouponTestingModel() {
        this.couponTestingInfoFilePath = "D:\\A3YUIO\\src\\resource\\coupon\\CouponInfo.txt";
        this.downloadedCouponListFilePath = null;

        this.toastProjectAppID = null;
        this.gamebaseUserID = null;
        this.couponCodes = new ArrayList<>();
        this.couponListSize = 0;
        this.gamebaseServerAPIDomain = null;
        this.gamebaseServerAPIHTTPHeaderOption = new String[2][2];
        this.gamebaseServerResponses = new ArrayList<>();
//        this.gamebaseServerResponse = null;
        this.couponConsumeIsSuccessful = new ArrayList<>();
//        this.couponConsumeIsSuccessful = false;
        this.benefitItemSize = 0;
        this.couponConsumeTestResult = new ArrayList<>();
//        this.couponConsumeTestResult = null;
    }

    public String getCouponTestingInfoFilePath() {
        return this.couponTestingInfoFilePath;
    }

    public String getDownloadedCouponListFilePath() {
        return this.downloadedCouponListFilePath;
    }

    public void setDownloadedCouponListFilePath(String path) {
        this.downloadedCouponListFilePath = path;
    }

    public String getToastProjectAppID() {
        return this.toastProjectAppID;
    }

    public void setToastProjectAppID(String appID) {
        this.toastProjectAppID = appID;
    }

    public String getGamebaseUserID() {
        return this.gamebaseUserID;
    }

    public void setGamebaseUserID(String userID) {
        this.gamebaseUserID = userID;
    }

    public List<String> getCouponCodes() {
        return this.couponCodes;
    }

    public void setCouponCodes(List<String> couponCodes) {
        this.couponCodes = couponCodes;
    }

    public int getCouponListSize() {
        return this.couponListSize;
    }

    public void setCouponListSize(int size) {
        this.couponListSize = size;
    }

    public String getGamebaseServerAPIDomain() {
        return this.gamebaseServerAPIDomain;
    }

    public void setGamebaseServerAPIDomain(String url) {
        this.gamebaseServerAPIDomain = url;
    }

    public String getGamebaseServerAPIHTTPHeaderOptionName(int index) {
        return this.gamebaseServerAPIHTTPHeaderOption[index][0];
    }

    public void setGamebaseServerAPIHTTPHeaderOptionName(int index, String value) {
        this.gamebaseServerAPIHTTPHeaderOption[index][0] = value;
    }

    public String getGamebaseServerAPIHTTPHeaderOptionValue(int index) {
        return this.gamebaseServerAPIHTTPHeaderOption[index][1];
    }

    public void setGamebaseServerAPIHTTPHeaderOptionValue(int index, String value) {
        this.gamebaseServerAPIHTTPHeaderOption[index][1] = value;
    }

    public List<String> getGamebaseServerResponses() {
        return this.gamebaseServerResponses;
    }

    public void setGamebaseServerResponses(List<String> responses) {
        this.gamebaseServerResponses = responses;
    }

//    public String getGamebaseServerResponse() {
//        return this.gamebaseServerResponse;
//    }
//
//    public void setGamebaseServerResponse(String response) {
//        this.gamebaseServerResponse = response;
//    }

    public List<String> getCouponConsumeIsSuccessful() {
        return this.couponConsumeIsSuccessful;
    }

    public void setCouponConsumeIsSuccessful(List<String> successful) {
        this.couponConsumeIsSuccessful = successful;
    }

//    public boolean getCouponConsumeIsSuccessful() {
//        return this.couponConsumeIsSuccessful;
//    }
//
//    public void setCouponConsumeIsSuccessful(boolean successful) {
//        this.couponConsumeIsSuccessful = successful;
//    }

    public int getBenefitItemSize() {
        return this.benefitItemSize;
    }

    public void setBenefitItemSize(int size) {
        this.benefitItemSize = size;
    }

    public List<String> getCouponConsumeTestResult() {
        return this.couponConsumeTestResult;
    }

    public void setCouponConsumeTestResult(List<String> results) {
        this.couponConsumeTestResult = results;
    }

//    public String getCouponConsumeTestResult() {
//        return this.couponConsumeTestResult;
//    }
//
//    public void setCouponConsumeTestResult(String result) {
//        this.couponConsumeTestResult = result;
//    }
}