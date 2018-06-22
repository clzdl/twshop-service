package com.twshop.entity.distribute;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "distribute_ratio")
public class DistributeRatio {
	/**
	 * 商户应用分销比例参数
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 商户ID
	 */
	@Column(name = "merchant_id")
	private Long merchantId;

	/**
	 * 等级;0-一级，1-二级
	 */
	private Byte grade;

	/**
	 * 比例值
	 */
	private BigDecimal ratio;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取商户应用分销比例参数
	 *
	 * @return id - 商户应用分销比例参数
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置商户应用分销比例参数
	 *
	 * @param id
	 *            商户应用分销比例参数
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * 获取等级;0-一级，1-二级
	 *
	 * @return grade - 等级;0-一级，1-二级
	 */
	public Byte getGrade() {
		return grade;
	}

	/**
	 * 设置等级;0-一级，1-二级
	 *
	 * @param grade
	 *            等级;0-一级，1-二级
	 */
	public void setGrade(Byte grade) {
		this.grade = grade;
	}

	/**
	 * 获取比例值
	 *
	 * @return ratio - 比例值
	 */
	public BigDecimal getRatio() {
		return ratio;
	}

	/**
	 * 设置比例值
	 *
	 * @param ratio
	 *            比例值
	 */
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
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