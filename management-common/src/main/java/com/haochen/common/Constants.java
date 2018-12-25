package com.haochen.common;


/**
 * @author YangChao
 */
public class Constants {
    public static final String CURRENT_USER = "user";



    /**
     * 图片类型正则表达式
     */
    public static String PIC_REG = ".+(.JPEG|.jpeg|.JPG|.jpg|.png|.PNG)$";

    public static final String SERVER_APP_KEY = "645ba616-370a-43a8-a8e0-993e7a590cf0";

    public static final String BAIDU_API_KEY = "Gs9P4MEqonYYiM3wqPNNOobG";

    public static final String MENU = "00040003";
    public static final String BUTTON = "00040004";

    public static final String DEFAULT_PIC_URL = "/static/pub/defaultImg/";

    /**
     * 平台code
     */
    public static final String PLATFORM_SUBSY_CODE = "fangsu";
    public static final String BABYSKY_GROUP = "BABYSKYGROUP";

    //会话过期
    public static final String AJAX_ERROR_300 = "300";
    //踢下线
    public static final String AJAX_ERROR_330 = "330";


    public static final String BABY_SKY_JOIN_CODE = "3";

    //会所审核状态
    /**
     * 01，待提交
     */
    public static final String SUBSY_AUDIT_STATUS_01 = "00660001";
    /**
     * 02，待审核
     */
    public static final String SUBSY_AUDIT_STATUS_02 = "00660002";
    /**
     * 03，同意
     */
    public static final String SUBSY_AUDIT_STATUS_03 = "00660003";
    /**
     * 04，拒绝
     */
    public static final String SUBSY_AUDIT_STATUS_04 = "00660004";

    //产品审核状态
//    /**
//     * 01，待提交
//     */
//    public static final String PROD_AUDIT_STATUS_01 = "00840001";
    /**
     * 02，待审核
     */
    public static final String PROD_AUDIT_STATUS_02 = "00840002";
    /**
     * 03，同意
     */
    public static final String PROD_AUDIT_STATUS_03 = "00840003";
    /**
     * 04，拒绝
     */
    public static final String PROD_AUDIT_STATUS_04 = "00840004";

    /**
     * 02，待审核
     */
    public static final String SUBSY_CLOSE_AUDIT_STATUS_02 = "00880002";
    /**
     * 03，同意
     */
    public static final String SUBSY_CLOSE_AUDIT_STATUS_03 = "00880003";
    /**
     * 04，拒绝
     */
    public static final String SUBSY_CLOSE_AUDIT_STATUS_04 = "00880004";



    public static final String MMATRON_H = "H";

    public static final Integer THREE_DIGIT_LENGTH = 1000;
    public static final Integer FOUR_DIGIT_LENGTH = 1000;


    /**
     * 月嫂待审核状态
     */
    public static String MMATRON_STATUS_01 = "00760001";
    /**
     * 月嫂上岗状态
     */
    public static String MMATRON_STATUS_02 = "00760002";

    /**
     * 初始密码
     */
    public static String DEFAULT_PWD = "abc123";

    /**
     * 集团公司代码
     */
    public static final String SUBSY_CODE_BABYSKYGROUP = "BABYSKYGROUP";
    /**
     * 集团管理员角色代码
     */
    public static final String ROLL_CODE_GROUPADMIN="ROLL999";

    /**
     * 品牌代码
     */
    public static final String BRAND_CODE_LANGYUE = "00030001";
    public static final String BRAND_CODE_BEIRUIJIA = "00030002";
    public static final String BRAND_CODE_YUEYUEMAN = "00030003";
    public static final String BRAND_CODE_DERUIMA = "00030004";

    //事业部总监
    public static final String ROLL_PART_MRB_BABYSKYGROUP_BIZDIRECTOR = "MRB_BABYSKYGROUP_BIZDIRECTOR";
    //品牌事业部经理
    public static final String ROLL_PART_MRB_BABYSKYGROUP_BIZMNGR = "MRB_BABYSKYGROUP_BIZMNGR";


    /**
     * 品牌事业部总监
     */
    public static final String ROLL_CODE_MRB_BABYSKYGROUP_BIZDIRECTOR_LANGYUE = "MRB_BABYSKYGROUP_BIZDIRECTOR_00030001";
    public static final String ROLL_CODE_MRB_BABYSKYGROUP_BIZDIRECTOR_BEIRUIJIA = "MRB_BABYSKYGROUP_BIZDIRECTOR_00030002";
    public static final String ROLL_CODE_MRB_BABYSKYGROUP_BIZDIRECTOR_YUEYUEMAN = "MRB_BABYSKYGROUP_BIZDIRECTOR_00030003";

    /**
     * 品牌事业部经理
     */
    public static final String ROLL_CODE_MRB_BABYSKYGROUP_BIZMNGR_LANGYUE = "MRB_BABYSKYGROUP_BIZMNGR_00030001";
    public static final String ROLL_CODE_MRB_BABYSKYGROUP_BIZMNGR_BEIRUIJIA = "MRB_BABYSKYGROUP_BIZMNGR_00030002";
    public static final String ROLL_CODE_MRB_BABYSKYGROUP_BIZMNGR_YUEYUEMAN = "MRB_BABYSKYGROUP_BIZMNGR_00030003";

    /**
     * 品牌管理部经理
     */
    public static final String ROLL_CODE_MRB_BABYSKYGROUP_BRANDMNG = "MRB_BABYSKYGROUP_BRANDMNG";
    /**
     * 贝瑞佳集团财务总监
     */
    public static final String ROLL_CODE_MRB_BABYSKYGROUP_FINANCEDIRECTOR = "MRB_BABYSKYGROUP_FINANCEDIRECTOR";



    public static final String ROLL_CODE_MRB_SUBSYADMIN = "MRB17121116442776C48064D4D74A9A94462BF9B8456DAC";

    /**
     * 会所类型- 会所
     */
    public static final String ROLL_CODE_SUBSYTYPE_SUBSY = "00790001";

    /**
     * 产品类型护理师
     */
    public static final String ORDER_PROD_TYPE_MMATRON_SUBSY = "00110002";
    /**
     * 产品类型住家护理师
     */
    public static final String ORDER_PROD_TYPE_MMATRON_HOME = "00110008";

    /**
     * 系统用户
     */
    public static final String DEFAULT_SYS_USER = "DEFAULT_SYS_USER";


    /**
     * 护理师服务类型
     */
    public static final String MMATRON_SERVER_TYPE_HOME = "住家月嫂";
    public static final String MMATRON_SERVER_TYPE_SUBSY = "会所月嫂";
    public static final String MMATRON_SERVER_TYPE_BABY = "育儿嫂";

    /**
     * 月月满住家会所code
     */
    public static final String YUEYUEMANHOME = "YUEYUEMANHOME";

}
