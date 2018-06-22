package com.twshop.entity.mall;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mall_order")
public class MallOrder {
	/**
	 * 商品订单
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 用户Id
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 商户ID
	 */
	@Column(name = "merchant_id")
	private Long merchantId;

	/**
	 * 总数量
	 */
	private Integer amount;

	/**
	 * 支付状态；0-未支付；1-已支付；2-已退款
	 */
	@Column(name = "pay_status")
	private Byte payStatus;

	/**
	 * 支付时间
	 */
	@Column(name = "pay_time")
	private Date payTime;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取商品订单
	 *
	 * @return id - 商品订单
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置商品订单
	 *
	 * @param id
	 *            商品订单
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户Id
	 *
	 * @return user_id - 用户Id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置用户Id
	 *
	 * @param userId
	 *            用户Id
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
	 * 获取总数量
	 *
	 * @return amount - 总数量
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * 设置总数量
	 *
	 * @param amount
	 *            总数量
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * 获取支付状态；0-未支付；1-已支付；2-已退款
	 *
	 * @return pay_status - 支付状态；0-未支付；1-已支付；2-已退款
	 */
	public Byte getPayStatus() {
		return payStatus;
	}

	/**
	 * 设置支付状态；0-未支付；1-已支付；2-已退款
	 *
	 * @param payStatus
	 *            支付状态；0-未支付；1-已支付；2-已退款
	 */
	public void setPayStatus(Byte payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * 获取支付时间
	 *
	 * @return pay_time - 支付时间
	 */
	public Date getPayTime() {
		return payTime;
	}

	/**
	 * 设置支付时间
	 *
	 * @param payTime
	 *            支付时间
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
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