package com.twshop.entity.mall;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;
import com.base.util.string.StringUtil;
import com.twshop.Constants;
import com.twshop.enums.mall.EnumMallSkuImgType;

@Table(name = "mall_sku_img")
public class MallSkuImg {
	/**
	 * 库存产品参数图片
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 所述skuId
	 */
	@Column(name = "sku_id")
	private Long skuId;

	/**
	 * 图片地址
	 */
	@Column(name = "img_url")
	private String imgUrl;

	@Transient
	private String imgUrlOutput;

	/**
	 * 图片类型;0-BANNER,1-详情
	 */
	@Column(name = "img_type")
	private Byte imgType;

	@Transient
	private String imgTypeOutput;

	/**
	 * 排序号
	 */
	@Column(name = "sort_no")
	private Integer sortNo;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	@Transient
	private String createTimeOutput;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取库存产品参数图片
	 *
	 * @return id - 库存产品参数图片
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置库存产品参数图片
	 *
	 * @param id
	 *            库存产品参数图片
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取所述skuId
	 *
	 * @return sku_id - 所述skuId
	 */
	public Long getSkuId() {
		return skuId;
	}

	/**
	 * 设置所述skuId
	 *
	 * @param skuId
	 *            所述skuId
	 */
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	/**
	 * 获取图片地址
	 *
	 * @return img_url - 图片地址
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * 设置图片地址
	 *
	 * @param imgUrl
	 *            图片地址
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * 获取图片类型;0-BANNER,1-详情
	 *
	 * @return img_type - 图片类型;0-BANNER,1-详情
	 */
	public Byte getImgType() {
		return imgType;
	}

	/**
	 * 设置图片类型;0-BANNER,1-详情
	 *
	 * @param imgType
	 *            图片类型;0-BANNER,1-详情
	 */
	public void setImgType(Byte imgType) {
		this.imgType = imgType;
	}

	/**
	 * 获取排序号
	 *
	 * @return sort_no - 排序号
	 */
	public Integer getSortNo() {
		return sortNo;
	}

	/**
	 * 设置排序号
	 *
	 * @param sortNo
	 *            排序号
	 */
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
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

	public String getImgUrlOutput() {
		if (StringUtil.isNotBlank(imgUrl)) {
			return Constants.SITE_NAME_IMG + imgUrl;
		}
		return "";
	}

	public void setImgUrlOutput(String imgUrlOutput) {
		this.imgUrlOutput = imgUrlOutput;
	}

	public String getImgTypeOutput() {
		EnumMallSkuImgType enumType = EnumMallSkuImgType.getEnum(imgType.intValue());
		if (null != enumType) {
			return enumType.getName();
		}
		return "";
	}

	public void setImgTypeOutput(String imgTypeOutput) {
		this.imgTypeOutput = imgTypeOutput;
	}

	public String getCreateTimeOutput() {
		if (createTime != null) {
			return DateUtil.formatDate(DateUtil._DATE_TIME_FORMAT1, createTime);
		}
		return "";
	}

	public void setCreateTimeOutput(String createTimeOutput) {
		this.createTimeOutput = createTimeOutput;
	}

}