package com.twshop.entity.distribute;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "distribute_relation")
public class DistributeRelation {
	/**
	 * 分销关系
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 分享人
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 被分享人
	 */
	@Column(name = "lower_user_id")
	private Long lowerUserId;

	/**
	 * 商户ID
	 */
	@Column(name = "merchant_id")
	private Long merchantId;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取分销关系
	 *
	 * @return id - 分销关系
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置分销关系
	 *
	 * @param id
	 *            分销关系
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取分享人
	 *
	 * @return user_id - 分享人
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置分享人
	 *
	 * @param userId
	 *            分享人
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取被分享人
	 *
	 * @return lower_user_id - 被分享人
	 */
	public Long getLowerUserId() {
		return lowerUserId;
	}

	/**
	 * 设置被分享人
	 *
	 * @param lowerUserId
	 *            被分享人
	 */
	public void setLowerUserId(Long lowerUserId) {
		this.lowerUserId = lowerUserId;
	}

	/**
	 * 获取商户ID
	 *
	 * @return merchant_id - 商户ID
	 */
	public Long getMerchantId() {
		return merchantId;
	}

	/**
	 * 设置商户ID
	 *
	 * @param merchantId
	 *            商户ID
	 */
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
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

	/**
	 * @return modify_time
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}