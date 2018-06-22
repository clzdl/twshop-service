package com.twshop.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "base_mall_collect")
public class BaseMallCollect {
	/**
	 * 商品收藏
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 用户ID
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 商品ID
	 */
	@Column(name = "item_id")
	private Long itemId;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取商品收藏
	 *
	 * @return id - 商品收藏
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置商品收藏
	 *
	 * @param id
	 *            商品收藏
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户ID
	 *
	 * @return user_id - 用户ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置用户ID
	 *
	 * @param userId
	 *            用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取商品ID
	 *
	 * @return item_id - 商品ID
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * 设置商品ID
	 *
	 * @param itemId
	 *            商品ID
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
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