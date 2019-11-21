package per.yyu.testing.gamebase.coupon.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class POIUtil {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private HSSFWorkbook hssfWorkbook;
    private HSSFSheet hssfSheet;
    private HSSFRow hssfRow;
    private HSSFCell hssfCell;
    private Row row;

    public void readCouponCodes(CouponTestingModel couponTestingModel, String couponListFilePath) {
        try {
            fileInputStream = new FileInputStream(couponListFilePath);
            hssfWorkbook = new HSSFWorkbook(fileInputStream);
            hssfSheet = hssfWorkbook.getSheetAt(0);
            couponTestingModel.setCouponListSize(hssfSheet.getPhysicalNumberOfRows());

            List<String> couponCodesInExcel = new ArrayList<>();

            for(int i = 1; i < couponTestingModel.getCouponListSize(); i++) {
                hssfRow = hssfSheet.getRow(i);
                hssfCell = hssfRow.getCell(0);

                switch (hssfCell.getCellType()) {
                    case XSSFCell.CELL_TYPE_FORMULA:
                        couponCodesInExcel.add(i - 1, hssfCell.getCellFormula());
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        couponCodesInExcel.add(i - 1, hssfCell.getNumericCellValue() + "");
                        break;
                    case XSSFCell.CELL_TYPE_STRING:
                        couponCodesInExcel.add(i - 1, hssfCell.getStringCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        couponCodesInExcel.add(i - 1, hssfCell.getBooleanCellValue() + "");
                        break;
                    case XSSFCell.CELL_TYPE_ERROR:
                        couponCodesInExcel.add(i - 1, hssfCell.getErrorCellValue() + "");
                        break;
                }
            }

            couponTestingModel.setCouponCodes(couponCodesInExcel);
            System.out.println(couponTestingModel.getCouponCodes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recordTestResult(CouponTestingModel couponTestingModel) {
        try {
            List<String> couponCodes = couponTestingModel.getCouponCodes();
            List<String> consumeIsSuccessful = couponTestingModel.getCouponConsumeIsSuccessful();
            List<String> consumeResult = couponTestingModel.getCouponConsumeTestResult();
            List<String> items = new ArrayList<>();
            for (int i = 1; i < couponTestingModel.getCouponListSize(); i++) {
                row = hssfSheet.createRow(i);
                row.createCell(0).setCellValue(couponCodes.get(i - 1));
                row.createCell(1).setCellValue(consumeIsSuccessful.get(i - 1));
                row.createCell(2).setCellValue(consumeResult.get(i - 1));
            }

            fileOutputStream = new FileOutputStream(new File(couponTestingModel.getDownloadedCouponListFilePath()));
            hssfWorkbook.write(fileOutputStream);

            hssfWorkbook.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}