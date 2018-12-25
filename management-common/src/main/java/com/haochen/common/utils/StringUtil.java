package com.haochen.common.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author YangChao
 * @version v2.0
 * @date 15/11/23
 * @since v2.0
 */


public class StringUtil extends StringUtils {
    public final static Logger logger = LogManager.getLogger(StringUtil.class);

    public static boolean matches(String src, String reg) {
        return Pattern.compile(reg).matcher(src).find();
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }


    public static List<String> getArrayFromStrings(String strings) {
        String[] sp = strings.split("\\|");
        if (sp.length == 0) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>();
        for (String s : sp) {
            if (StringUtil.isEmpty(s)) {
                continue;
            }
            resultList.add(s);
        }
        return resultList;
    }

    /**
     * 把json字符串转换成ArrayList
     * [{\"500040004\":\"4\"},{\"500040001\":\"1\"},{\"500040002\":\"2\"}]  to : 500040004:4,500040001:1,500040002:2
     *
     * @param json
     * @return
     */
    public static ArrayList getArrayFromJson(String json) {
        ArrayList list = new ArrayList();
        json = json.replace(" ", "");
        json = json.replace("　", "");
        json = json.replace("[{\"", "");
        json = json.replace("\":\"", ":");
        json = json.replace("\"},{\"", ",");
        json = json.replace("\"}]", "");

        if (json != null && !"".equals(json) && json.contains(":")) {
            String[] sp = json.split(",");
            for (String s : sp) {
                list.add(new String[]{s.split(":")[0], s.split(":")[1]});
            }
        }
        return list;
    }

    /**
     * 根据args生成新ArrayList
     *
     * @param args
     * @return
     */
    public static ArrayList getNewArrayList(String... args) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : args) {
            if (StringUtils.hasText(s)) {
                list.add(s);
            }
        }
        return list;
    }


    public static String getNoDupString(String... args) {
        StringBuffer sb = new StringBuffer();
        ArrayList<String> list = new ArrayList<>();
        for (String s : args) {
            if (StringUtils.hasText(s)) {
                if (!list.contains(s)) {
                    list.add(s);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
        }
        return sb.toString().trim();
    }

    /**
     * 判断字符串B是否在字符串A中（字符串A是逗号分割的）
     *
     * @param source
     * @param str
     * @return
     */
    public static boolean isStrInStringSplit(String source, String str) {
        String[] sp = source.split(",");
        for (String s : sp) {
            if (StringUtil.isEmpty(s)) {
                continue;
            }
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 蠢办法，判断字符串分割A和B是否完全包含对方的值
     *
     * @param strA
     * @param strB
     * @return
     */
    public static boolean isStringSplitArrayEquals(String strA, String strB) {
        if (StringUtil.isEmpty(strA) || StringUtil.isEmpty(strB)) {
            return false;
        }
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        String[] sp1 = strA.split(",");
        Collections.addAll(list1, sp1);
        String[] sp2 = strB.split(",");
        Collections.addAll(list2, sp2);
        for (String s : list1) {
            if (!list2.contains(s)) {
                return false;
            }
        }
        for (String s : list2) {
            if (!list1.contains(s)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 把字符串（带分隔符）转换成list
     *
     * @param source
     * @param splitChar
     * @return
     */
    public static List<String> getListFromSplitString(String source, String splitChar) {
        String[] sp = source.split(splitChar);
        List<String> result = new ArrayList<>();
        for (String s : sp) {
            result.add(s);
        }
        return result;
    }

    /**
     * 把list字符串列表转换成string
     *
     * @param sourceList
     * @param splitChar
     * @return
     */
    public static String getSplitStringFromList(List<String> sourceList, String splitChar) {
        StringBuilder sb = new StringBuilder();
        if (!CollectionUtils.isEmpty(sourceList)) {
            for (String s : sourceList) {
                if (sb.length() == 0) {
                    sb.append(s);
                } else {
                    sb.append(splitChar).append(s);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 获取千分位的数字
     *
     * @param rawNumber
     * @return
     */
    public static String getMoneyFormat(String rawNumber) {
        BigDecimal bigDecimal = new BigDecimal(rawNumber);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        NumberFormat numberFormat1 = NumberFormat.getNumberInstance();
        numberFormat1.setMinimumFractionDigits(2);
        return "￥" + numberFormat1.format(bigDecimal);
    }


    /**
     * 验证字符串是否是int数字
     *
     * @param number
     * @return
     */
    public static boolean isIntNumber(String number) {
        if (StringUtil.isEmpty(number)) {
            return false;
        }
        try {
            int a = Integer.parseInt(number);
        } catch (Exception e1) {
            return false;
        }
        return true;
    }

    public static Integer getSubStringInt(Integer dateInt, int startIndex, int length) {
        if (dateInt == null) {
            return null;
        }
        try {
            String s = dateInt.toString();
            String result = s.substring(startIndex, length);
            return Integer.parseInt(result);
        } catch (Exception e1) {
            logger.error(e1);
            e1.printStackTrace();
            return dateInt;
        }
    }


    public static String concat(String... strings) {
        StringBuilder sb = new StringBuilder();
        if (strings == null || strings.length == 0) {
            return "";
        } else {
            for (String s : strings) {
                if (!StringUtil.isEmpty(s)) {
                    sb.append(s);
                }
            }
        }
        return sb.toString();
    }

    public static String concatWithSplit(String splitString, String... strings) {
        StringBuilder sb = new StringBuilder();
        if (strings == null || strings.length == 0) {
            return "";
        } else {
            for (String s : strings) {
                if (!StringUtil.isEmpty(s)) {
                    if (sb.length() == 0) {
                        sb.append(s);
                    } else {
                        sb.append(splitString + s);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String valueOf(Integer i) {
        if (i == null) {
            return "";
        } else {
            return i.toString();
        }
    }

    public static Boolean isBiggerOrSmallOrEqual(BigDecimal b1, BigDecimal b2) {
        Integer result = b1.compareTo(b2);
        if (result == -1) {
            return false;
        } else if (result == 1) {
            return true;
        } else {
            return null;
        }
    }

    /**
     * 取得字符串中，最后一个小数点后的字符数量
     *
     * @param number
     * @return
     */
    public static Integer getNumbersAfterPoint(String number) {
        if (!number.contains(".")) {
            return 0;
        } else {
            String a = number.substring(number.lastIndexOf(".") + 1);
            return a.length();
        }
    }
}

