package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import com.usedbook.utils.GenerateSqlToBean;
import com.usedbook.utils.StringTool;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品表
 *
 * @author zining
 * @email ${email}
 * @date 2019-11-12 10:46:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("f_product")
public class Product extends PageParam implements Serializable {
    @GenerateSqlToBean.NotGenerateSql
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 商品内容
     */
    private String content;
    /**
     * 原价
     */
    private Double bprice;
    /**
     * 出售价格
     */
    private Double price;
    /**
     * 销售次数
     */
    private Integer times;
    /**
     * 添加时间
     */
    private Date createTime;
    /**
     * 添加人
     */
    private String userId;
    /**
     * 上下架（0否 1是）
     */
    private Integer isShow;
    /**
     * 是否删除（0否 1是）
     */
    private Integer isDel;
    /**
     * 浏览次数
     */
    private Integer count;
    /**
     * 收藏次数
     */
    private Integer sc;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 发布者姓名
     */
    private String userName;
    /**
     * 学院id
     */
    private int collegeId;
    /**
     * 专业id
     */
    private int majorId;
    /**
     * 年级Id
     */
    private int gradeId;
    /**
     * 售出状态 0 未售出 1已售出
     */
    private int isNot;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getBprice() {
        return bprice;
    }

    public void setBprice(Double bprice) {
        this.bprice = bprice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSc() {
        return sc;
    }

    public void setSc(Integer sc) {
        this.sc = sc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCreateTime() {
        return StringTool.dataTool(createTime);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getIsNot() {
        return isNot;
    }

    public void setIsNot(int isNot) {
        this.isNot = isNot;
    }
}
