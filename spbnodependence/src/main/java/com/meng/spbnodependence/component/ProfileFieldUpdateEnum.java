package com.meng.spbnodependence.component;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-07 18:20
 */
public enum ProfileFieldUpdateEnum {
    HEIGHT("height", "身高", true, true),
    SALARY("salary", "月收入", true, true),
    WORK_CITY("workCity", "工作地区", true, true),
    EDUCATION("education", "学历", true, true),
    MARRIAGE("marriage", "婚姻状况", true, false),
    OCCUPATION("occupation", "职业", true, true),
    HOUSE("house", "买房情况", true, false),
    VEHICLE("vehicle", "是否有车", true, true),
    HOMETOWN("hometown", "籍贯", true, true);


    //name保存
    private String name;

    private String desc;
    //Crm发消息使用字段
    private boolean fromCrm;
    //珍爱给Crm数据同步字段，
    private boolean toCrm;

    ProfileFieldUpdateEnum(String name, String desc, boolean fromCrm, boolean toCrm) {
        this.name = name;
        this.desc = desc;
        this.fromCrm = fromCrm;
        this.toCrm = toCrm;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isFromCrm() {
        return fromCrm;
    }

    public boolean isToCrm() {
        return toCrm;
    }

    public static ProfileFieldUpdateEnum of(String value) {
        if (value == null) {
            return null;
        }
        for (ProfileFieldUpdateEnum e : values()) {
            if (e.getName().equals(value)) {
                return e;
            }
        }
        return null;
    }
}
