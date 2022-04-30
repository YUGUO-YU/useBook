package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@TableName("college")
public class Major extends PageParam implements Serializable {
    /**
     * 系专业类别
     */
    @TableId(type = IdType.AUTO)
    private int mId;

    private String mName;

    private int mFatherId;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmFatherId() {
        return mFatherId;
    }

    public void setmFatherId(int mFatherId) {
        this.mFatherId = mFatherId;
    }

    @Override
    public String toString() {
        return "Major{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mFatherId=" + mFatherId +
                '}';
    }
}
