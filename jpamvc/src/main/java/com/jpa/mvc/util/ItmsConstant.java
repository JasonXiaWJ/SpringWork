package com.jpa.mvc.util;

import java.math.BigDecimal;

public final class ItmsConstant {

    /**
     * Name of locale cookie
     */
    public static final String LOCALE_COOKIE_NAME = "itms_locale";

    /**
     * Message key for unique field violation
     */
    public static final String UNIQUE_VIOLATION_MSG_KEY = "exception_unique_field_violation";

    /**
     * Message key for unique constraint violation
     */
    public static final String UNIQUE_CONSTRAINT_VIOLATION_MSG_KEY = "exception_unique_constraint_violation";

    /**
     * Message key for invalid file uploaded
     */
    public static final String UPLOAD_FILE_INVALID_MSG_KEY = "validation_upload_xlsx_read_failed";

    /**
     * Message key for no detail in uploaded XLSX file
     */
    public static final String XLSX_NO_DETAIL_MSG_KEY = "validation_upload_xlsx_parse_failed_detail_not_exist";

    /**
     * Message key for forecast invalid date length
     */
    public static final String XLSX_FORECAST_DATE_LEN_MSG_KEY = "validation_upload_xlsx_forecastDateLength_failed";

    /**
     * Message key for file whose size exceed the max acceptable value
     */
    public static final String FILE_OVER_SIZED_MSG_KEY = "validation_attachment_size";

    /**
     * Message key for remote file operation exception
     */
    public static final String FILE_OPERATION_EXCEPTION_MSG_KEY = "exception_remote_file_operation";

    /**
     * Message key for order file copy exception
     */
    public static final String ORDER_FILE_COPY_EXCEPTION_MSG_KEY = "exception_order_file_copy";

    /**
     * Max age of locale cookie
     */
    public static final int LOCALE_COOKIE_AGE = Integer.MAX_VALUE;

    /**
     * Max integer for amount field
     */
    public static final int AMOUNT_INTEGER = 8;
    public static final int TOTAL_AMOUNT_INTEGER = 12;

    /**
     * Max fraction for amount field
     */
    public static final int AMOUNT_FRACTION = 2;
    public static final int AMOUNT_ROUND = BigDecimal.ROUND_HALF_UP;

    /**
     * Min value for amount field
     */
    public static final String AMOUNT_DECIMAL_MIN = "0.01";
    /**
     * Max integer for rate field
     */
    public static final int RATE_INTEGER = 5;
    /**
     * Max fraction for rate number field
     */
    public static final int RATE_FRACTION = 5;
    /**
     * fraction(2) for rate number field
     */
    public static final int RATE_FRACTION_2 = 2;

    /**
     * Min value for rate number field
     */
    public static final String RATE_DECIMAL_MIN = "0.001";

    /**
     * Max integer for quantity field
     */
    public static final int QUANTITY_INTEGER = 6;

    /**
     * Min value for quantity field
     */
    public static final int QUANTITY_MIN = 1;

    /**
     * Min size for name/description field
     */
    public static final int NAME_FIELD_MIN_SIZE = 3;

    /**
     * Max size for String field
     */
    public static final int NORMAL_FIELD_SIZE = 100;

    /**
     * Max size for large text field
     */
    public static final int LARGE_FIELD_SIZE = 150;

    /**
     * Max size for text field
     */
    public static final int TEXT_FIELD_SIZE = 255;

    /**
     * Max size for path field
     */
    public static final int PATH_FIELD_SIZE = 1000;

    /**
     * Max size for short field
     */
    public static final int SHORT_FIELD_SIZE = 20;

    /**
     * Max size for short+ field
     */
    public static final int SHORT_PLUS_FIELD_SIZE = 30;
    
    public static final String DEFAULT_PASSWORD = "123456";

    /**
     * Max size for medium field
     */
    public static final int MEDIUM_FIELD_SIZE = 50;

    public static final int CLAIM_INVOICE_AUTOMATIC_RECEIVE_DAYS = 30;

    public static final String SAP_INTERFACE_MATERIAL_NAME = "ZMMI1101_MATERIALS";
    public static final String SAP_INTERFACE_MATERIAL_TABLE = "MAT_TAB";

    public static final String SAP_INTERFACE_MATERIAL_PART_NO = "MATNR";
    public static final String SAP_INTERFACE_MATERIAL_ENGLISH_DESC = "ENDESC";
    public static final String SAP_INTERFACE_MATERIAL_CHINESE_DESC = "CHDESC";
    public static final String SAP_INTERFACE_MATERIAL_OTHER_DESC = "OTDESC";
    public static final String SAP_INTERFACE_MATERIAL_UOM = "MEINS";
    public static final String SAP_INTERFACE_MATERIAL_NETWEIGHT = "NTGEW";
    public static final String SAP_INTERFACE_MATERIAL_GROSSWEIGHT = "BRGEW";
    public static final String SAP_INTERFACE_MATERIAL_VOLUME = "VOLUM";
    public static final String SAP_INTERFACE_MATERIAL_HS_CODE = "EAN11";
    public static final String SAP_INTERFACE_MATERIAL_COC = "MTART";
    public static final String SAP_INTERFACE_MATERIAL_COC_VALUE = "ZZCH";

    public static final String SAP_INTERFACE_MATERIAL_DATE_LOW = "DATE_LOW";
    public static final String SAP_INTERFACE_MATERIAL_DELETE = "LVORM";
    public static final String SAP_INTERFACE_MATERIAL_DELETE_VALUE = "X";

    public static final String SAP_INTERFACE_PRICE_NAME = "ZSDI1102_PRICE";
    public static final String SAP_INTERFACE_PRICE_TABLE = "MAT_PRICE";
    public static final String SAP_INTERFACE_PRICE_PART_NO = "MATNR";
    public static final String SAP_INTERFACE_PRICE_UOM_VALUE = "PC";
    public static final String SAP_INTERFACE_PRICE_COC_CODE = "MATNR";
    public static final String SAP_INTERFACE_PRICE_CUSTOMER = "KUNNR";
    public static final String SAP_INTERFACE_PRICE_VALID_FROM = "DATAB";
    public static final String SAP_INTERFACE_PRICE_VALID_TO = "DATBI";
    public static final String SAP_INTERFACE_PRICE_PRICE = "KBETR";
    public static final String SAP_INTERFACE_PRICE_TYPE = "KSCHL";
    public static final String SAP_INTERFACE_PRICE_MODEL = "NORMT";
    public static final String SAP_INTERFACE_PRICE_CURRENCY = "KONWA";

    public static final String SAP_INTERFACE_PRICE_TYPE_SPARE_PART_VALUE = "ZB00";
    public static final String SAP_INTERFACE_PRICE_TYPE_KD_VALUE = "ZMIN";
    public static final String SAP_INTERFACE_PRICE_TYPE_SALES_VALUE = "ZK00";
    public static final String SAP_INTERFACE_PRICE_TYPE_SALES_VALUE2 = "ZKSP";
    public static final String SAP_INTERFACE_PRICE_TYPE_PBP_VALUE = "ZPBP";

    public static final String SAP_INTERFACE_PRICE_DELETE = "LOEVM";
    public static final String SAP_INTERFACE_PRICE_DELETE_VALUE = "X";

    public static final String SAP_INTERFACE_PRICE_I_MATERIAL = "I_MATNR";
    public static final String SAP_INTERFACE_PRICE_I_CUSTOMER = "I_KUNNR";
    public static final String SAP_INTERFACE_PRICE_I_DATE = "I_DATE";
    public static final String SAP_INTERFACE_PRICE_I_TYPE = "I_KSCHL";

    public static final String SAP_INTERFACE_INVOICE_NAME = "ZFII1003_XJSP";
    public static final String SAP_INTERFACE_INVOICE_TABLE = "ZSPKH";
    public static final String SAP_INTERFACE_INVOICE_SUBMIT_DATE = "BUDAT";
    public static final String SAP_INTERFACE_INVOICE_NO = "ZSPNO";
    public static final String SAP_INTERFACE_INVOICE_CUSTOEMR = "KUNNR";
    public static final String SAP_INTERFACE_INVOICE_CLAIM_NO = "ZSPLSH";
    public static final String SAP_INTERFACE_INVOICE_MODEL = "GROES";
    public static final String SAP_INTERFACE_INVOICE_CURRENCY = "WAERS";
    public static final String SAP_INTERFACE_INVOICE_CHNAGEBACK = "ZKKF";
    public static final String SAP_INTERFACE_INVOICE_AMOUNT = "ZSPJE";
    public static final String SAP_INTERFACE_INVOICE_ORDER_NO = "ZYKD";

    public static final String SAP_INTERFACE_PACKAGE_PRICE_INTERFACE = "ZSDI1102_PRICE_ID";
    public static final String SAP_INTERFACE_PACKAGE_PRICE_TAB = "MAT_PRICE";
    public static final String SAP_INTERFACE_PACKAGE_PRICE_PACK_ID = "ZID";
    public static final String SAP_INTERFACE_PACKAGE_PRICE_BAS_PRI = "ZMID";
    public static final String SAP_INTERFACE_PACKAGE_PRICE_SALE_PRI = "ZKID";
    public static final String SAP_INTERFACE_PACKAGE_PRICE_CURRENCY = "ZBZ";

    public static final String SP_ORDER_CURRENCY = "USD";

    public static final String SAP_SP_EXCHANGE_FUNCTION = "ZSPPI_RATE";
    public static final String SAP_SP_EXCHANGE_TABLE = "ITAB";

    public static final String SAP_SP_EXCHANGE_CURRENCY_FROM = "FCURR";
    public static final String SAP_SP_EXCHANGE_CURRENCY_TO = "TCURR";
    public static final String SAP_SP_EXCHANGE_START_DATE = "GDATU";
    public static final String SAP_SP_EXCHANGE_RATE = "UKURS";

    public static final String ESB_DATE_FORMAT = "yyyy-MM-dd";

    public static final String COST_TYPE_CLAIM_FREIGHT = "ZT62";
    public static final String COST_TYPE_CLAIM_INSURANCE = "ZT64";

    /**
     * The company code for HongKong company for DOCU KD shipment
     */
    public static final String DOCU_KD_HK_COMPANY_CODE = "GI53";

    /**
     * 备件体积小数位数
     */
    public static final int DOCU_SP_CUM_FRACTION = 3;

    /**
     * 备件预估体积小数位数
     */
    public static final int SP_CUM_FRACTION = 2;

    /**
     * 合同章图片存放路径
     */
    public static final String CONTRACT_SIGNATURE_PATH = "/docgen/pdf/img/contract_signature.png";

    /**
     * Private constructor
     */
    private ItmsConstant() {
        // avoid instantiation
    }
}
