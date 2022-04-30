package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@TableName("address")
public class Address extends PageParam implements Serializable {

    @TableId(type = IdType.AUTO)
    private int aId;
    /**
     * 详细地址
     */
    private String aAddress;
    /**
     * 电话
     */
    private String aTel;
    /**
     * 姓名
     */
    private String aName;
    /**
     * 用户id
     */
    private String aUserId;


    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public String getaTel() {
        return aTel;
    }

    public void setaTel(String aTel) {
        this.aTel = aTel;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaUserId() {
        return aUserId;
    }

    public void setaUserId(String aUserId) {
        this.aUserId = aUserId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aId=" + aId +
                ", aAddress='" + aAddress + '\'' +
                ", aTel='" + aTel + '\'' +
                ", aName='" + aName + '\'' +
                ", aUserId='" + aUserId + '\'' +
                '}';
    }
}
