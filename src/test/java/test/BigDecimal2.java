package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class BigDecimal2 {
    //  return b1.multiply(b2).toString();
    // 除法
    //   return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);

    // b1.subtract(b2).toString();

    public static void main(String[] args) {
        double dayDiff2 = 5.06835778;
        BigDecimal usedM = new BigDecimal(dayDiff2);
        //保留两位小数且四舍五入
        BigDecimal usedM2 = usedM.setScale(2, BigDecimal.ROUND_HALF_UP);

        System.out.println(usedM2);


        int[] arr = new int[]{1, 3, 4, 5, 6};

// 2 has to be inserted
        int pos = Arrays.binarySearch(arr, 3);
        System.out.println(pos);

        int n = 2;
        n = n << 3;   // Multiply n with 2
        System.out.println(n);

        int q = 100;
        q = q >> 2;   // Divide n by 2
        System.out.println(q);


        java.math.BigDecimal bd = new java.math.BigDecimal("3.14159265");
        double bds = bd.setScale(4, 1).doubleValue();
        System.out.println("BigDecimal BigDecimal");
        System.out.println(bds);


        DecimalFormat df = new DecimalFormat("#.##");
        double d = 3.14159;
        System.out.println(df.format(d));


        double pi = 3.1415927;//圆周率
//取一位整数
        System.out.println(new DecimalFormat("0").format(pi));//3
//取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
//取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));//03.142
//取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3
//以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%

        long c = 299792458;//光速
//显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(c));//2.99792E8
//显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(c));//29.9792E7
//每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(c));//299,792,458
//将格式嵌入文本
        System.out.println(new DecimalFormat("光速大小为每秒,###米").format(c));
        //光速大小为每秒299,792,458米


    }

}
