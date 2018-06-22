package com.twshop.entity.finance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "web_order_cache")
public class WebOrderCache {
	/**
	 * 订单详情Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 状态;0-待支付订单;
	 */
	@Column(name = "rec_type")
	private Byte recType;

	/**
	 * 订单ID
	 */
	@Column(name = "obj_id")
	private Long objId;

	/**
	 * 订单过期时间
	 */
	@Column(name = "expire_time")
	private String expireTime;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	/**
	 * 获取订单详情Id
	 *
	 * @return id - 订单详情Id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置订单详情Id
	 *
	 * @param id
	 *            订单详情Id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取状态;0-待支付订单;
	 *
	 * @return rec_type - 状态;0-待支付订单;
	 */
	public Byte getRecType() {
		return recType;
	}

	/**
	 * 设置状态;0-待支付订单;
	 *
	 * @param recType
	 *            状态;0-待支付订单;
	 */
	public void setRecType(Byte recType) {
		this.recType = recType;
	}

	/**
	 * 获取订单ID
	 *
	 * @return obj_id - 订单ID
	 */
	public Long getObjId() {
		return objId;
	}

	/**
	 * 设置订单ID
	 *
	 * @param objId
	 *            订单ID
	 */
	public void setObjId(Long objId) {
		this.objId = objId;
	}

	/**
	 * 获取订单过期时间
	 *
	 * @return expire_time - 订单过期时间
	 */
	public String getExpireTime() {
		return expireTime;
	}

	/**
	 * 设置订单过期时间
	 *
	 * @param expireTime
	 *            订单过期时间
	 */
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}