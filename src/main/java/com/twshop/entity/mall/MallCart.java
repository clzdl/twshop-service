package com.twshop.entity.mall;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mall_cart")
public class MallCart {
	/**
	 * 购物车
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 用户ID
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * 产品id
	 */
	@Column(name = "item_id")
	private Long itemId;

	/**
	 * 产品参数id
	 */
	@Column(name = "sku_id")
	private Long skuId;

	/**
	 * 商户ID
	 */
	@Column(name = "merchant_id")
	private Long merchantId;

	/**
	 * 数量
	 */
	private Integer quantity;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取购物车
	 *
	 * @return id - 购物车
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置购物车
	 *
	 * @param id
	 *            购物车
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户ID
	 *
	 * @return user_id - 用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 设置用户ID
	 *
	 * @param userId
	 *            用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取产品id
	 *
	 * @return item_id - 产品id
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * 设置产品id
	 *
	 * @param itemId
	 *            产品id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * 获取产品参数id
	 *
	 * @return sku_id - 产品参数id
	 */
	public Long getSkuId() {
		return skuId;
	}

	/**
	 * 设置产品参数id
	 *
	 * @param skuId
	 *            产品参数id
	 */
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
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
	 * 获取数量
	 *
	 * @return quantity - 数量
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 设置数量
	 *
	 * @param quantity
	 *            数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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