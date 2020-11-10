package com.meng.daily.basejava.work;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-07 18:20
 */
public enum ProfileFieldUpdateEnum {
    HEIGHT("height","身高"),
    SALARY("salary","月收入"),
    WORK_CITY("workcity","工作地区"),
    EDUCATION("education","学历"),
    MARRIAGE("marriage","婚姻状况"),
    OCCUPATION("occupation","职业"),
    HOUSE("house","买房情况"),
    VEHICLE("vehicle","是否有车"),
    HOMETOWN("hometown","籍贯")

    ;

    private String name;

    private String desc;

    ProfileFieldUpdateEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
