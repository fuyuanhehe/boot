package time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class time1 {

    public static void main(String[] args) {
        // 格式化
        String time = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println(time);

        Date d = new Date();
        System.out.println(d.getTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d));


        // 使用默认时区和语言环境获得一个日历
        Calendar cal = Calendar.getInstance();
        // 赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));

    }

    /**
     * @author YoonaLt
     * LocalDateTime 与 LocalDate ,LocalTime 都提供了 plus***(加),minus***(减)等方法,
     * 可以方便的获取与目标日期相距几年,几月,几星期,几天,几小时,几分,几秒的时间.
     */


        private static String DETAIL_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

        private static String PROBABLY_FORMAT_STRING = "yyyy-MM-dd";

        private static String TIME_FORMAT_STRING = "HH:mm:ss";

        private static String DETAIL_REGEX = "(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[1-5][0-9]):(0[0-9]|[1-5][0-9])";

        private static String PROBABLY_REGEX = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0|1])";

        /**
         * 格式化 LocalDateTime
         *
         * @param localDateTime 将要格式化的日期
         * @return 例如,  2020-04-03 14:12:02
         */
        public static String localDateTimeToString(LocalDateTime localDateTime) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DETAIL_FORMAT_STRING);
            return localDateTime == null ? null : dateTimeFormatter.format(localDateTime);
        }

        /**
         * 格式化 LocalDate
         *
         * @param localDate 将要格式化的日期
         * @return 例如,  2020-04-03
         */
        public static String localDateToString(LocalDate localDate) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PROBABLY_FORMAT_STRING);
            return localDate == null ? null : dateTimeFormatter.format(localDate);
        }

        /**
         * 格式化 LocalTime
         *
         * @param localTime 将要格式化的时间
         * @return 例如, 09:28:28
         */
        public static String localTimeToString(LocalTime localTime) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT_STRING);
            return localTime == null ? null : dateTimeFormatter.format(LocalTime.now());
        }

        /**
         * 字符串格式化,字符串必须符合 "yyyy-MM-dd HH:mm:ss" 格式,当字符串非法时,返回 null
         * yyyy-MM-dd 24:00:00 格式的字符串也视为非法
         *
         * @param s 将要 LocalDateTime 化的字符串
         * @return LocalDateTime
         */
        public static LocalDateTime stringToLocalDateTime(String s) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DETAIL_FORMAT_STRING);
            return s == null || "".equals(s) || !Pattern.matches(PROBABLY_REGEX + " " + DETAIL_REGEX, s) ?
                    null : LocalDateTime.parse(s, dateTimeFormatter);
        }

        /**
         * 字符串格式化,字符串必须符合 yyyy-MM-dd 格式,当字符串非法时,例如 201s-00-35 时,返回 null
         *
         * @param s 将要 LocalDate 化的字符串
         * @return LocalDate
         */
        public static LocalDate stringToLocalDate(String s) {

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PROBABLY_FORMAT_STRING);
            return s == null || "".equals(s) || !Pattern.matches(PROBABLY_REGEX, s) ?
                    null : LocalDate.parse(s, dateTimeFormatter);
        }

        /**
         * 字符串格式化,字符串必须符合 HH:mm:ss 格式,当字符串非法时,返回 null
         *
         * @param s 将要 LocalTime 化的字符串
         * @return LocalTime
         */
        public static LocalTime stringToLocalTime(String s) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT_STRING);
            return s == null || "".equals(s) || !Pattern.matches(DETAIL_REGEX, s) ?
                    null : LocalTime.parse(s, dateTimeFormatter);
        }



}
