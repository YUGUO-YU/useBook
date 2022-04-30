package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@TableName("college")
public class College extends PageParam implements Serializable {
    /**
     * 院校
     */
    @TableId(type = IdType.AUTO)
    private int cId;

    private String cName;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "College{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
