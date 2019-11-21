package per.yyu.testing.gamebase.coupon.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;

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

            List<String> temp = new ArrayList<>();

            for(int i = 1; i < couponTestingModel.getCouponListSize(); i++) {
                hssfRow = hssfSheet.getRow(i);
                hssfCell = hssfRow.getCell(0);

                switch (hssfCell.getCellType()) {
                    case XSSFCell.CELL_TYPE_FORMULA:
                        temp.add(i - 1, hssfCell.getCellFormula());
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        temp.add(i - 1, hssfCell.getNumericCellValue() + "");
                        break;
                    case XSSFCell.CELL_TYPE_STRING:
                        temp.add(i - 1, hssfCell.getStringCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        temp.add(i - 1, hssfCell.getBooleanCellValue() + "");
                        break;
                    case XSSFCell.CELL_TYPE_ERROR:
                        temp.add(i - 1, hssfCell.getErrorCellValue() + "");
                        break;
                }
            }

            couponTestingModel.setCouponCodes(temp);
            System.out.println(couponTestingModel.getCouponCodes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}