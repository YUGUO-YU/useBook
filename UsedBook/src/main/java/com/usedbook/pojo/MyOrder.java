package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@TableName("myorder")
public class MyOrder extends PageParam implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;

    private String orderNo;

    private Date createTime;

    private int addressId;

    private String Title;

    private String imgUrl;

    private Double realFee;

    private String Content;

    private String Address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getRealFee() {
        return realFee;
    }

    public void setRealFee(Double realFee) {
        this.realFee = realFee;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", createTime=" + createTime +
                ", addressId=" + addressId +
                ", Title='" + Title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", realFee=" + realFee +
                ", Content='" + Content + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
