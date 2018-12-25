package com.haochen.common;


public interface BizConstants {

    /**
     * 活动分类(活动,课程)
     */
    String MST_GEN_ACTIV_CATE = "0021";
    /**
     * 课程类型(文字,音频,视频)
     */
    String MST_GEN_COURSE_TYPE = "0022";
    /**
     * 课程分类(宝宝护理,早教课程,新手妈妈)
     */
    String MST_GEN_COURSE_CATE = "0058";
    /**
     * 活动类型(线上，线下)
     */
    String MST_GEN_ACTIV_TYPE = "0055";
    /**
     * 活动状态(报名中，已结束)
     */
    String MST_GEN_ACTIV_STATUS = "0035";
    /**
     * 活动目标人群(妈妈,宝宝,妈妈和宝宝)
     */
    String MST_GEN_ACTIV_TARGET_POPULATION ="0056";


    /**
     * wangtao 20180306 月嫂产品默认最小折扣率
     */
    Integer PRODUCT_MMATRON_DEFAULT_MIN_DISCOUNT_RATE=9;






    /**
     * 数据权限：个人
     */
    String DATA_PERMIS_CODE_PERSON = "001";
    /**
     * 数据权限：部门
     */
    String DATA_PERMIS_CODE_DEPT = "011";
    /**
     * 数据权限：会所
     */
    String DATA_PERMIS_CODE_SUBSY = "111";


    /**
     * 任务状态 0001	已创建
     */
    String TASK_STATUS_CODE_CREATED = "00130001";
    /**
     * 任务状态 0002	已受领
     */
    String TASK_STATUS_CODE_ACCEPTED = "00130002";
    /**
     * 任务状态 0003	已处理
     */
    String TASK_STATUS_CODE_PROCESSED = "00130003";
    /**
     * 任务状态 0004	已评价
     */
    String TASK_STATUS_CODE_EVALUATED = "00130004";


    /**
     * 任务处理类型 0001	提交
     */
    String TASK_EXE_TYPE_CODE_SUBMITED = "00140001";
    /**
     * 任务处理类型 0002	分派
     */
    String TASK_EXE_TYPE_CODE_ASSIGNED = "00140002";
    /**
     * 任务处理类型 0003	交接
     */
    String TASK_EXE_TYPE_CODE_HANDOVER = "00140003";


    /**
     * 服务请求状态 0001已创建
     */
    String SERV_REQ_STATUS_CODE_CREATED = "00150001";
    /**
     * 服务请求状态 0002已受领
     */
    String SERV_REQ_STATUS_CODE_ACCEPTED = "00150002";
    /**
     * 服务请求状态 0003已处理
     */
    String SERV_REQ_STATUS_CODE_PROCESSED = "00150003";
    /**
     * 服务请求状态 0004已评价
     */
    String SERV_REQ_STATUS_CODE_EVALUATED = "00150004";


    /**
     * 投诉状态 0001已创建
     */
    String COMPL_BILL_STATUS_CODE_CREATED = "00200001";
    /**
     * 投诉状态 0002已受领
     */
    String COMPL_BILL_STATUS_CODE_ACCEPTED = "00200002";
    /**
     * 投诉状态 0003已处理
     */
    String COMPL_BILL_STATUS_CODE_PROCESSED = "00200003";
    /**
     * 投诉状态 0004已评价
     */
    String COMPL_BILL_STATUS_CODE_EVALUATED = "00200004";

    /**
     * 活动类型 0001活动
     */
    String ACTIV_TYPE_ACTIV = "00210001";
    /**
     * 活动类型 0002课程
     */
    String ACTIV_TYPE_LESSON = "00210002";
    /**
     * 活动状态 0001报名中
     */
    String ACTIV_STATUS_CODE_ENROLLMENT = "00350001";
    /**
     * 活动状态 0002已结束
     */
    String ACTIV_STATUS_CODE_END = "00350002";
    /**
     * 活动预约状态 0001已预约
     */
    String ACTIV_RESV_STATUS_CODE_RESERVATION = "00240001";
    /**
     * 活动预约状态 0002已参加
     */
    String ACTIV_RESV_STATUS_CODE_JOINED = "00240002";


    /**
     * 房态分类 0001 预定
     */
    String TRAN_ROOSER_STATUS_CATE_CODE_BOOK = "00330002";

    /**
     * 房态分类 0002 入住
     */
    String TRAN_ROOSER_STATUS_CATE_CODE_CIN = "00330002";

    /**
     * 销售阶段 0001 意向微弱
     */
    String MST_SALES_PHASE_CODE_FAINT = "00070001";

    /**
     * 销售阶段 0002 意向一般
     */
    String MST_SALES_PHASE_CODE_JUST = "00070002";

    /**
     * 销售阶段 0003 意向强烈
     */
    String MST_SALES_PHASE_CODE_INTENSE = "00070003";

    /**
     * 销售阶段 0004 签约
     */
    String MST_SALES_PHASE_CODE_SIGN = "00070004";
    /**
     * 销售阶段 0005 无意向
     */
    String MST_SALES_PHASE_CODE_NOINTENTION = "00070005";


    /**
     * 客户状态 0001 咨询客户
     */
    String MST_EXTER_USER_DTL_STATUS_CATE_CODE_JUST = "00010001";

    /**
     * 客户状态 0002 参观客户
     */
    String MST_EXTER_USER_DTL_STATUS_CATE_CODE_VIEW = "00010002";

    /**
     * 客户状态 0003 签约用户
     */
    String MST_EXTER_USER_DTL_STATUS_CATE_CODE_SIGN = "00010003";

    /**
     * 客户状态 0004 入住用户
     */
    String MST_EXTER_USER_DTL_STATUS_CATE_CODE_VIP = "00010004";

    /**
     * 客户状态 0005 离所用户
     */
    String MST_EXTER_USER_DTL_STATUS_CATE_CODE_LEAVE = "00010005";


    /**
     * 订单状态：审核中
     */
    String ORDER_STATUS_APPROVING = "00100001";
    /**
     * 订单状态：已审核
     */
    String ORDER_STATUS_APPROVE_AGREE = "00100002";
    /**
     * 订单状态：已作废
     */
    String ORDER_STATUS_CANCELED = "00100003";
    /**
     * 订单状态：进行中
     */
    String ORDER_STATUS_INPROGRESS = "00100004";
    /**
     * 订单状态：已完成
     */
    String ORDER_STATUS_FINISH = "00100005";
    /**
     * 订单状态：已退回
     */
    String ORDER_STATUS_APPROVE_DISAGREE = "00100006";


    /**
     * 订单操作类型 新建订单
     */
    String ORDER_OPER_CREATE="00630001";
    /**
     * 订单操作类型 编辑订单
     */
    String ORDER_OPER_EDIT="00630002";
    /**
     * 订单操作类型 取消订单
     */
    String ORDER_OPER_CANCEL="00630003";
    /**
     * 订单操作类型 选择审核人
     */
    String ORDER_OPER_TOHANDLER="00630004";
    /**
     * 订单操作类型 审核同意
     */
    String ORDER_OPER_APPROVEAGREE="00630005";
    /**
     * 订单操作类型 审核拒绝
     */
    String ORDER_OPER_APPROVEDISAGREE="00630006";
    /**
     * 订单操作类型 完成订单
     */
    String ORDER_OPER_FINISH="00630007";


    /**
     * 产品类型： 00110001 房型
     */
    String PROD_TYPE_CODE_ROOM = "00110001";

    /**
     * 产品类型： 00110002	月嫂
     */
    String PROD_TYPE_CODE_AUNT = "00110002";
    /**
     * 产品类型： 00110003	月子餐
     */
    String PROD_TYPE_CODE_CONFINEMENTMEAL = "00110003";
    /**
     * 产品类型： 00110004	妈妈护理
     */
    String PROD_TYPE_CODE_MOTHERCARE = "00110004";
    /**
     * 产品类型： 00110005	宝宝护理
     */
    String PROD_TYPE_CODE_BABYCARE = "00110005";
    /**
     * 产品类型： 00110006	增值服务
     */
    String PROD_TYPE_CODE_VALUESERVICE = "00110006";
    /**
     * 产品类型： 00110007	产后修复
     */
    String PROD_TYPE_CODE_CHANHOUXIUFU = "00110007";
    /**
     * 产品类型： 00110008	住家月嫂
     */
    String PROD_TYPE_CODE_HOME_AUNT = "00110008";
    /**
     * 产品类型： 00110009   母婴商品
     */
    String PROD_TYPE_CODE_MOMBABY_GOODS = "00110009";


    /**
     * 会所订单
     */
    String ORDER_TYPE_CODE_SUBSYORDER = "00410001";
    /**
     * 月嫂订单
     */
    String ORDER_TYPE_CODE_MOMORDER = "00410002";
    /**
     * 产后修复订单
     */
    String ORDER_TYPE_CODE_AFTERORDER = "00410003";

    /**
     * 资源模块类型0048
     * 00480001 会所banner类型
     */
    String RESP_CATE_TYPE_BANNER_CODE = "00480001";
    /**
     * 资源模块类型0048
     * 00480002 附件图片类型
     */
    String RESP_CATE_TYPE_PIC_CODE = "00480002";
    /**
     * 资源模块类型0048
     * 00480003 头像类型
     */
    String RESP_CATE_TYPE_AVTR_CODE = "00480003";
    /**
     * 资源模块类型0048
     * 00480005 投诉图片
     */
    String RESP_CATE_TYPE_COMPL_CODE = "00480005";
    /**
     * 资源模块类型0048
     * 00480004 产品缩略图
     */
    String RESP_CATE_TYPE_PROD_THUMB_IMAGE = "00480004";
    /**
     * 资源模块类型0048
     * 00480006 产品Banner图片
     */
    String RESP_CATE_TYPE_PROD_BANNER_IMAGE = "00480006";
    /**
     * 资源模块类型0048
     * 00480007 产品详情图片
     */
    String RESP_CATE_TYPE_PROD_DETAIL_IMAGE = "00480007";
    /**
     * 资源模块类型0048
     * 00480030 销售行动录音
     */
    String RESP_CATE_TYPE_SALESACT_RECORD_CODE = "00480030";
    /**
     * 资源模块类型0048
     * 00480007 活动缩略图
     */
    String RESP_CATE_TYPE_ACTIV_THUMB_IMAGE="00480008";
    /**
     * 资源模块类型0048
     * 00480007 活动Banner图片
     */
    String RESP_CATE_TYPE_ACTIV_BANNER_IMAGE="00480009";
    /**
     * 资源模块类型0048
     * 00480007 活动详情图片
     */
    String RESP_CATE_TYPE_ACTIV_DETAIL_IMAGE="00480010";
    /**
     * 资源模块类型0048
     * 00480011 妈妈宝宝健康档案图片
     */
    String RESP_CATE_TYPE_UER_NCARE_IMG = "00480011";
    /**
     * 资源模块类型0048
     * 00480012 B订单-房型产品默认大图片
     */
    String RESP_CATE_TYPE_DEFAULT_HOUSE_BIG_CODE = "00480012";
    /**
     * 资源模块类型0048
     * 00480013 B订单-房型产品默认小图片
     */
    String RESP_CATE_TYPE_DEFAULT_HOUSE_SMALL_CODE = "00480013";
    /**
     * 资源模块类型0048
     * 00480014 B订单-月嫂产品默认大图片
     */
    String RESP_CATE_TYPE_DEFAULT_MMATRON_BIG_CODE = "00480014";
    /**
     * 资源模块类型0048
     * 00480015 B订单-月嫂产品默认小图片
     */
    String RESP_CATE_TYPE_DEFAULT_MMATRON_SMALL_CODE = "00480015";
    /**
     * 资源模块类型0048
     * 00480016 B订单-月子餐产品默认大图片
     */
    String RESP_CATE_TYPE_DEFAULT_BDINNER_BIG_CODE = "00480016";
    /**
     * 资源模块类型0048
     * 00480017 B订单-月子餐产品默认小图片
     */
    String RESP_CATE_TYPE_DEFAULT_BDINNER_SMALL_CODE = "00480017";
    /**
     * 资源模块类型0048
     * 00480018 B订单-母婴产品默认大图片
     */
    String RESP_CATE_TYPE_DEFAULT_BMAB_BIG_CODE = "00480018";
    /**
     * 资源模块类型0048
     * 00480019 B订单-母婴产品默认小图片
     */
    String RESP_CATE_TYPE_DEFAULT_BMAB_SMALL_CODE = "00480019";
    /**
     * 资源模块类型0048
     * 00480020 B订单-产后修复默认大图片
     */
    String RESP_CATE_TYPE_DEFAULT_BREPAIR_BIG_CODE = "00480020";
    /**
     * 资源模块类型0048
     * 00480021 B订单-产后修复默认小图片
     */
    String RESP_CATE_TYPE_DEFAULT_BREPAIR_SMALL_CODE = "00480021";
    /**
     * 资源模块类型0048
     * 00480022 B订单-增值服务默认大图片
     */
    String RESP_CATE_TYPE_DEFAULT_BSERVICE_BIG_CODE = "00480022";
    /**
     * 资源模块类型0048
     * 00480023 B订单-增值服务默认小图片
     */
    String RESP_CATE_TYPE_DEFAULT_BSERVICE_SMALL_CODE = "00480023";

    /**
     * 资源模块类型0048
     * 00480018 C-（00480003）默认头像
     */
    String RESP_CATE_TYPE_DEFAULT_CAVTR_CODE = "00480024";
    /**
     * 资源模块类型0048
     * 00480019 B-（00480003）默认头像
     */
    String RESP_CATE_TYPE_DEFAULT_BAVTR_CODE = "00480025";

    /**
     * 资源模块类型0048
     * 00480026 会所LISTbanner
     */
    String RESP_CATE_TYPE_SUBSYLISTBANNER_CODE = "00480026";

    /**
     * 资源模块类型0048
     * 00480031 房间列表图片
     */
    String RESP_CATE_TYPE_ROOM_LIST_CODE = "00480031";

    /**
     * 用户列表筛选 所有用户
     */
    String MST_GEN_USERLIST_ALLUSER = "00490001";

    /**
     * 用户列表筛选 已入住用户
     */
    String MST_GEN_USERLIST_CHECKINUSER = "00490002";

    /**
     * 房间状态 空房
     */
    String MST_GEN_ROOM_STATUS_EMPTY = "00280001";
    /**
     * 房间状态 坏房
     */
    String MST_GEN_ROOM_STATUS_DAMAGE = "00280002";
    /**
     * 房间状态 已入住
     */
    String MST_GEN_ROOM_STATUS_CHECKED = "00280003";

    /**
     * 押金操作业务code:{mst_gen 0059}
     * 00590001 餐饮
     */
    String DPST_OPER_TRAN_CODE_DINNER = "00590001";
    /**
     * 押金操作业务code:{mst_gen 0059}
     * 00590002 充值
     */
    String DPST_OPER_TRAN_CODE_RECHARGE = "00590002";

    /**
     * 销售阶段类型code:{mst_gen 0062}
     * 00620001 初始阶段
     */
    String SALES_PHASE_CODE_INITAL = "00620001";
    /**
     * 销售阶段类型code:{mst_gen 0062}
     * 00620002 意向阶段
     */
    String SALES_PHASE_CODE_WILL = "00620002";
    /**
     * 销售阶段类型code:{mst_gen 0062}
     * 00620003 签单阶段
     */
    String SALES_PHASE_CODE_SIGNING = "00620003";

    // 销售行动类型
    String MST_GEN_TYPE_CODE_SALES_ACTION = "0008";

    // 服务分类
    String MST_GEN_TYPE_CODE_SERV_TYPE = "0029";

    /**
     *
     */
    String MST_SALES_ACTION_MODEL_CODE = "salesAction";

    /**
     * 角色code：执行董事
     */
    String ROLL_CODE_SUBSY_GM = "ROLL001";
    /**
     * 角色code：会所经理
     */
    String ROLL_CODE_SUBSY_MNGR = "ROLL002";
    /**
     * 角色code：财务主管
     */
    String ROLL_CODE_FINANCE_MNGR = "ROLL003";

    /**
     * 角色code：客服主管
     */
    String ROLL_CUSTOMER_SERVICE_MNGR = "ROLL005";
    /**
     * 角色code：客服专员
     */
    String ROLL_CUSTOMER_SERVICE_EMPLOYEE = "ROLL006";

    /**
     * 角色code：销售主管
     */
    String ROLL_CODE_SALES_MNGR = "ROLL007";
    /**
     * 角色code：销售顾问
     */
    String ROLL_CODE_SALES_EMPLOYEE = "ROLL008";
    /**
     * 角色code：房务主管
     */
    String ROLL_CODE_ROO_MNGR = "ROLL009";
    /**
     * 角色code：客房服务员
     */
    String ROLL_CODE_ROO_EMPLOYEE = "ROLL010";
    /**
     * 角色code：护士长
     */
    String ROLL_CODE_NURSER_MNGR = "ROLL011";
    /**
     * 角色code：护士
     */
    String ROLL_CODE_NURSER = "ROLL012";

    /**
     * 护理师
     */
    String ROLL_MMATRON = "ROLL013";

    /**
     * 医生
     */
    String ROLL_DOCTOR="ROLL014";
    /**
     * 角色code：厨师长
     */
    String ROLL_HEAD_CHEF = "ROLL015";
    /**
     * 角色code：门店产后修复主管
     */
    String ROLL_CODE_RECVY_MNGR = "ROLL019";
    /**
     * 角色code：门店产后修复人员
     */
    String ROLL_CODE_RECVY_STAFF = "ROLL020";
    /**
     * 角色code：门店产后修复总监
     */
    String ROLL_CODE_RECVY_DIRECTOR = "ROLL021";

    /**
     *  新客户来电创建客户信息短信模板
     */
    String SMS_TEMP_CREATE_USER = "P00023";

    /**
     *  邀约客户参观会所短信模板
     */
    String SMS_TEMP_INVITE_USER_VIEW = "P00024";

    /**
     *  向客户推送会所品牌营销软文
     */
    String SMS_TEMP_SUBSY_BRANDMARK_ADVERTORIAL = "P00025";

    /**
     *  邀约客户试吃月子餐
     */
    String SMS_TEMP_INVITE_USER_MEAL = "P00026";

    /**
     *  向客户推送会所促销软文
     */
    String SMS_TEMP_SUBSY_PROMOTION_ADVERTORIAL = "P00027";

    /**
     *  电话回访客户入住意向
     */
    String SMS_TEMP_USER_INTENT = "P00028";

    /**
     *  向客户推送签约礼包
     */
    String SMS_TEMP_SIGN_PACKAGE = "P00029";


    /**
     *  客户入住服务-护理团队-待办
     */
    String TP00031 = "P00031";


    /**
     *  客户入住服务-客服团队-待办
     */
    String TP00032 = "P00032";


    /**
     *  客户入住服务-客房团队-待办
     */
    String TP00033 = "P00033";


    /**
     *  客户入住服务-餐饮团队-待办
     */
    String TP00034 = "P00034";

    /**
     *  客户离店服务-护理团队-待办
     */
    String TP00035 = "P00035";


    /**
     *  客户离店服务-客服团队-待办
     */
    String TP00036 = "P00036";


    /**
     *  客户离店服务-客房团队-待办
     */
    String TP00037 = "P00037";


    /**
     *  客户离店服务-餐饮团队-待办
     */
    String TP00038 = "P00038";

    /**
     *  客户入住前准备-护理团队-待办
     */
    String P00039 = "P00039";

    /**
     *  客户入住前准备-客服团队-待办
     */
    String P00040 = "P00040";

    /**
     *  客户入住前准备-客房团队-待办
     */
    String P00041 = "P00041";

    /**
     *  客户入住前准备-餐饮团队-待办
     */
    String P00042 = "P00042";

    /**
     *  客户入住前准备-护理团队-预警
     */
    String P00043 = "P00043";

    /**
     *  客户入住前准备-客服团队-预警
     */
    String P00044 = "P00044";

    /**
     *  客户入住前准备-客房团队-预警
     */
    String P00045 = "P00045";

    /**
     *  客户入住前准备-餐饮团队-预警
     */
    String P00046 = "P00046";

    /**
     *  客户离店前准备-护理团队-预警
     */
    String P00047 = "P00047";

    /**
     *  客户离店前准备-客服团队-预警
     */
    String P00048 = "P00048";

    /**
     *  客户离店前准备-客房团队-预警
     */
    String P00049 = "P00049";

    /**
     *  客户离店前准备-餐饮团队-预警
     */
    String P00050 = "P00050";

    /**
     *  月嫂满意度调查
     */
    String SMS_TEMP_MMATRON_SATIS = "S00004";

    /**
     *  会所满意度调查
     */
    String SMS_TEMP_SUBSY_SATIS = "S00005";
    /**
     *  抑郁量测试
     */
    String SMS_TEMP_DEPRESSION_TEST = "S00006";
    /**
     *  投诉已处理，推送用户可以评价
     */
    String SMS_TEMP_COMPL_PROCESSED = "A00202";
    /**
     * 新增护理参数的妈妈异常模板标题
     */
    String SMS_MOM_NCARE_INSERT_TEMPLATE="A00228";
    /**
     * 新增护理参数的妈妈异常模板内容
     */
    String SMS_MOM_NCARE_INSERT_CONTENT_TEMPLATE="A00229";
    /**
     * 新增护理参数妈妈代办标题
     */
    String SMS_MOM_NCARE_INSERT_UNDO_TEMPLATE="A00230";
    /**
     * 新增护理参数妈妈代办内容
     */
    String SMS_MOM_NCARE_INSERT_UNDO_CONTENT_TEMPLATE="A00231";
    /**
     * 新增护理参数的宝宝异常模板标题
     */
    String SMS_BABY_NCARE_INSERT_TEMPLATE="A00232";
    /**
     * 新增护理参数的宝宝异常模板内容
     */
    String SMS_BABY_NCARE_INSERT_CONTENT_TEMPLATE="A00233";
    /**
     * 新增护理参数宝宝代办标题
     */
    String SMS_BABY_NCARE_INSERT_UNDO_TEMPLATE="A00235";
    /**
     * 新增护理参数宝宝代办内容
     */
    String SMS_BABY_NCARE_INSERT_UNDO_CONTENT_TEMPLATE="A00234";
    /**
     * 健康顾问group
     */
    String ROLL_GROUP_SALES = "ROLL_GROUP_SALES";

    /**
     * 护理团队group
     */
    String ROLL_GROUP_NURSER = "ROLL_GROUP_NURSER";

    /**
     * 客服团队group
     */
    String ROLL_GROUP_CUSTOMER = "ROLL_GROUP_CUSTOMER";

    /**
     * 客房团队group
     */
    String ROLL_GROUP_ROOM = "ROLL_GROUP_ROOM";

    /**
     * 餐饮团队group
     */
    String ROLL_GROUP_LUNCH = "ROLL_GROUP_LUNCH";


    String OAUTH_EXPIRES_IN = "2592000"; //1天 86400   token失效时间   目前30天

    String OAUTH_REFRESH_EXPIRES_IN_PARAM = "refresh_expires_in";

    String OAUTH_REFRESH_EXPIRES_IN = "7776000"; //7天 604800 可刷新refresh_token时间   目前3个月

    String APPLICATION_JSON = "application/json;charset=utf-8";

    String ORDER_MEAL_TMP_ORDER_PROD_CODE = "999999";

    String ORDER_MEAL_TMP_ORDER_PROD_NAME = "零点餐";


}
