package com.usedbook.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.usedbook.common.PageParam;
import com.usedbook.utils.GenerateSqlToBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 * 
 * @author zining
 * @email ${email}
 * @date 2019-11-12 10:46:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("f_order")
public class Order extends PageParam implements Serializable {
	@GenerateSqlToBean.NotGenerateSql
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private int id;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 实付金额
	 */
	private Double realFee;
	/**
	 * 支付时间
	 */
	private Date payTime;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 商品编号
	 */
	private String productId;
	/**
	 * 用户地址id
	 */
	private int addressId;

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

	public Double getRealFee() {
		return realFee;
	}

	public void setRealFee(Double realFee) {
		this.realFee = realFee;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", orderNo='" + orderNo + '\'' +
				", realFee=" + realFee +
				", payTime=" + payTime +
				", userId='" + userId + '\'' +
				", productId='" + productId + '\'' +
				", addressId=" + addressId +
				'}';
	}
}
