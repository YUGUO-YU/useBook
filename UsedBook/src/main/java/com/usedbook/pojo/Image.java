package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import com.usedbook.utils.GenerateSqlToBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 图片表
 *
 * @author zining
 * @email ${email}
 * @date 2019-11-12 10:46:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("f_image")
public class Image  extends PageParam implements Serializable {

    @GenerateSqlToBean.NotGenerateSql
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    private String id;
    /**
     * 图片用处（表名）
     */
    private String tableName;
    /**
     * 对应编号（对应ID）
     */
    private Integer tableId;
    /**
     * 图片URL
     */
    private String imgUrl;
    /**
     * 是否默认（0否，1默认）
     */
    private Integer isdetault;
    /**
     * 备注
     */
    private String about;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsdetault() {
        return isdetault;
    }

    public void setIsdetault(Integer isdetault) {
        this.isdetault = isdetault;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
