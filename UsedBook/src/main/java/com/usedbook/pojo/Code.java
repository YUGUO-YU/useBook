package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 验证码
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("f_code")
public class Code extends PageParam implements Serializable {
    /**
     * 验证码id就是用户输入的邮箱
     */
    @TableId
    private String id;

    private String code;

    private Date codeTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCodeTime() {
        return codeTime;
    }

    public void setCodeTime(Date codeTime) {
        this.codeTime = codeTime;
    }
}
