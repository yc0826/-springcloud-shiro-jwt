package com.haochen.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author zhaohanmin
 * @date 2017/9/14
 */
public class BizCodeGeneratorUtil {
    public static enum TblNameIntiEnum {
        /**
         *
         */
        CFG_SYS_RESO("CSR"),
        TRAN_NCAEW_ROOM_ALLOCA("TNRA"),
        TRAN_NCAEW_USER_CLOCK("TNUC"),
        TRAN_NCAEW_DATA_BASE("TNDB"),
        TRAN_NCAEW_DATA_DTL("TNDD"),
        TRAN_CS_SERV_REQ("TCSR"),
        TRAN_TASK_BASE("TTB"),
        TRAN_TASK_EXE_DTL("TTED"),
        TRAN_CS_SERV_COMMENT("TCSC"),
        TRAN_COMPL_BILL("TCB"),
        TRAN_COMPL_COMMENT("TCC"),
        TRAN_CS_ITEM_DTL("TCID"),
        MST_EXTER_USER_DTL("MEUD"),
        TRAN_ROOSER_CUST_CIN_INFO("TRCCI"),
        TRAN_ROOSER_CUST_EXCH_ROOM_INFO("TRCERI"),
        TRAN_ROOSER_ROO_STATE("TRRS"),
        MST_EXTER_USER_BASE("MEUB"),
        TRAN_RESO_FILE_MNG("TRFM"),
        TRAN_MMATRON_COMMENT_DTL("TMCD"),
        TRAN_ORDER_BASE("TOB"),
        TRAN_SALES_CUST_ACT("TSCA"),
        TRAN_SALES_ORDER_DTL("TSOD"),
        TRAN_SATIS_USER_BASE("TSUB"),
        TRAN_SATIS_USER_DTL("TSUD"),
        NCAEW_TRAN_DATA("NTD"),
        NCAEW_TRAN_BATCH("NTB"),
        NCAEW_NURSE_SHIFT("NNS"),
        NCAEW_NURSE_SHIFT_DTL("NSD"),
        TASK_EXE_DTL("TED"),
        TRAN_ACTIV_RESV("TAR"),
        TRAN_INTER_USER_SHORTCUT("TIUS"),
        TRAN_EXTER_USER_DPST_DTL("TUDD"),
        TRAN_EXTER_USER_DPST_MNG("TUDM"),
        MST_EXTER_USER_BABY("MEUBB"),
        MST_INTER_USER_BASE("MIUB"),
        MST_ROLL_BASE("MRB"),
        MST_ORDER_PROD("MOP"),
        MST_ROOSER_FLOOR("MRF"),
        MST_ROOSER_ROOM("MRR"),
        MST_ROOSER_ROOM_TYPE("MRRT"),
        TRAN_STATIS_CNTRCT_INCOME("TSCI"),
        TRAN_ACTIV_BASE("TAB"),
        TRAN_SUBSY_AUDIT("TRAN_SUBSY_AUDIT"),
        TRAN_ACTIV_COURSE("TAC"),
        MST_SERV_ITEM_CODE("SIC"),
        MST_COMPL_ITEM_CODE("CI"),
        MST_BRAND_SERV_ITEM_CODE("BSIC"),
        MST_MMATRON_LICENSE("MML"),
        MST_SALES_ACT_TYPE("MSAT"),
        MST_SALES_ACT_TYPE_DTL("MSATD"),
        TRAN_SALES_TARGET("TST"),
        MST_BRAND_COMPL_ITEM_CODE("BCI"),
        MST_NCARE_ROLL_ITEM_CODE("NRI"),
        MST_NCARE_ITEM("NI"),
        MST_NCARE_ROLL_ITEM("NRI"),
        MST_NCARE_ITEM_VALI("NIV"),
        MST_NCARE_ITEM_RULE("NIRC"),
        MST_NCARE_ITEM_OPTION("NIO"),
        CFG_UNIT("UNIT"),
        TRAN_WORK_FLOW_COMMENT("TWFC")
        ;

        private String code; // 枚举说明

        /**
         * 私有的构造方法
         */
        TblNameIntiEnum(String code) {
            this.code = code;
        }

        public String getInit() {
            return code;
        }
    }

    public static String getBizCode(TblNameIntiEnum tblNameIntiEnum) {
        Date now = new Date();
        StringBuilder bizCode = new StringBuilder();
        // 头文字
        bizCode.append(tblNameIntiEnum.getInit());
        // 中间yymmddhhMMss
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMddHHmmss");
        bizCode.append(sdfDate.format(now));
//        // 加4位UUID
        String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
//        String randomStr = uuid.substring(uuid.length() - 4, uuid.length());
        bizCode.append(uuid);
        return bizCode.toString();
    }

    public static String getUserCode(TblNameIntiEnum tblNameIntiEnum) {
        StringBuilder bizCode = new StringBuilder();
        // 头文字
        bizCode.append(tblNameIntiEnum.getInit());
        // 中间yymmddhhMMss
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMddHHmmss");
        // 时间戳
        bizCode.append(System.nanoTime());
        // 加4位UUID
        String uuid = UUID.randomUUID().toString().toUpperCase();
        String randomStr = uuid.substring(uuid.length() - 4, uuid.length());
        bizCode.append(randomStr);
        return bizCode.toString();
    }
}
