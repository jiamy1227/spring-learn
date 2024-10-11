package com.jiamy;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/10/8 16:59
 **/
public class MedicineDistributeResultForm {

    private Integer bedDisporder;

    /**
     * 药品组合code
     */
    private String medicineGroupCode;

    /**
     * 是否为主药剂
     */
    private String mainFlag;

    public Integer getBedDisporder() {
        return bedDisporder;
    }

    public void setBedDisporder(Integer bedDisporder) {
        this.bedDisporder = bedDisporder;
    }

    public String getMedicineGroupCode() {
        return medicineGroupCode;
    }

    public void setMedicineGroupCode(String medicineGroupCode) {
        this.medicineGroupCode = medicineGroupCode;
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }

    @Override
    public String toString() {
        return "MedicineDistributeResultForm{" +
                "bedDisporder=" + bedDisporder +
                ", medicineGroupCode='" + medicineGroupCode + '\'' +
                ", mainFlag='" + mainFlag + '\'' +
                '}';
    }
}
