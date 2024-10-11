package com.jiamy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/10/8 16:59
 **/
public class Test {
    public static void main(String[] args) {
        MedicineDistributeResultForm form1 = new MedicineDistributeResultForm();
        MedicineDistributeResultForm form2 = new MedicineDistributeResultForm();
        MedicineDistributeResultForm form3 = new MedicineDistributeResultForm();
        form1.setBedDisporder(3);
        form2.setBedDisporder(3);
        form3.setBedDisporder(3);
        form1.setMedicineGroupCode("73b8463eb2fd4e4");
        form2.setMedicineGroupCode("12c49cdea9644d0");
        form3.setMedicineGroupCode("73b8463eb2fd4e4");

        form1.setMainFlag("1");
        form2.setMainFlag("1");
        form3.setMainFlag("0");

        List<MedicineDistributeResultForm> returnList = new ArrayList<>();
        returnList.add(form1);
        returnList.add(form2);
        returnList.add(form3);

        returnList = returnList.stream().sorted(Comparator.comparingInt(MedicineDistributeResultForm::getBedDisporder)
                .thenComparing(MedicineDistributeResultForm::getMedicineGroupCode)
                .thenComparing((e1, e2) -> Integer.parseInt(e2.getMainFlag()) - Integer.parseInt(e1.getMainFlag()))).collect(Collectors.toList());

        returnList.forEach(e-> System.out.println(e.toString()));
    }
}
