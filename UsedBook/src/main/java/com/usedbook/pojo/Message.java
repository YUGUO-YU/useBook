package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import com.usedbook.utils.StringTool;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言接口
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("f_message")
public class Message extends PageParam implements Serializable {
    @TableId
    private String id;
    @TableField("t_id")
    private String tid;
    @TableField("f_id")
    private String fid;

    private String text;

    private Date time;

    public String getTime() {
        return StringTool.dataTool(time);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
