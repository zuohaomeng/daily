package com.meng.spbnodependence.component;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-04 17:20
 */

public enum OrderEnum {
    IPHONE(5999, "苹果"),
    MAC_PRO(14000, "电脑");
    private Integer status;
    private String desc;

    OrderEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
