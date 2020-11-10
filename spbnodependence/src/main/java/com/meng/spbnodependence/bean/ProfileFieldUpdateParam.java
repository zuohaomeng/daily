package com.meng.spbnodependence.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-07 15:41
 */
public class ProfileFieldUpdateParam implements Serializable {

    private static final long serialVersionUID = -5107348056695730144L;
    private long memberId;
    /**
     * 修改字段集合,field
     */
    private List<String> fields;

    private int platForm = -1;

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public int getPlatForm() {
        return platForm;
    }

    public void setPlatForm(int platForm) {
        this.platForm = platForm;
    }


}
