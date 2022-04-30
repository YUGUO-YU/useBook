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
 * 产品收藏表
 * 
 * @author zining
 * @email ${email}
 * @date 2019-11-12 10:46:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("f_favorites")
public class Favorites extends PageParam implements Serializable {
	@GenerateSqlToBean.NotGenerateSql
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private String id;
	/**
	 * 用户编号名
	 */
	private String userId;
	/**
	 * 产品编号
	 */
	private String productId;
	/**
	 * 收藏时间
	 */
	private Date createTime;

	public String getCreateTime() {
		return StringTool.dataTool(createTime);
	}

	/**
	 * 状态
	 */
	private Integer state;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
