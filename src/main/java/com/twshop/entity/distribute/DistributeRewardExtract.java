package com.twshop.entity.distribute;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "distribute_reward_extract")
public class DistributeRewardExtract {
	/**
	 * 分销奖励提取记录
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 用户id
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 商户ID
	 */
	@Column(name = "merchant_id")
	private Long merchantId;

	/**
	 * 提取金额
	 */
	private Integer money;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取分销奖励提取记录
	 *
	 * @return id - 分销奖励提取记录
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置分销奖励提取记录
	 *
	 * @param id
	 *            分销奖励提取记录
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户id
	 *
	 * @return user_id - 用户id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置用户id
	 *
	 * @param userId
	 *            用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * 获取提取金额
	 *
	 * @return money - 提取金额
	 */
	public Integer getMoney() {
		return money;
	}

	/**
	 * 设置提取金额
	 *
	 * @param money
	 *            提取金额
	 */
	public void setMoney(Integer money) {
		this.money = money;
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