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

@Table(name = "mall_category")
public class MallCategory {
	/**
	 * 商品分类
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 分类名称
	 */
	private String name;

	/**
	 * 父类Id
	 */
	@Column(name = "parent_id")
	private Long parentId;

	/**
	 * 图片URL
	 */
	@Column(name = "img_url")
	private String imgUrl;

	@Transient
	private String imgUrlOutput;

	/**
	 * 节点路径id串;如: 0,1,2
	 */
	@Column(name = "path_ids")
	private String pathIds;

	/**
	 * 排序号
	 */
	@Column(name = "sort_no")
	private Integer sortNo;

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

	@Transient
	private String createTimeOutput;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取商品分类
	 *
	 * @return id - 商品分类
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置商品分类
	 *
	 * @param id
	 *            商品分类
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取分类名称
	 *
	 * @return name - 分类名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置分类名称
	 *
	 * @param name
	 *            分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取父类Id
	 *
	 * @return parent_id - 父类Id
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置父类Id
	 *
	 * @param parentId
	 *            父类Id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取图片URL
	 *
	 * @return img_url - 图片URL
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * 设置图片URL
	 *
	 * @param imgUrl
	 *            图片URL
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * 获取节点路径id串;如: 0,1,2
	 *
	 * @return path_ids - 节点路径id串;如: 0,1,2
	 */
	public String getPathIds() {
		return pathIds;
	}

	/**
	 * 设置节点路径id串;如: 0,1,2
	 *
	 * @param pathIds
	 *            节点路径id串;如: 0,1,2
	 */
	public void setPathIds(String pathIds) {
		this.pathIds = pathIds;
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

	public String getImgUrlOutput() {
		if (StringUtil.isNotBlank(imgUrl)) {
			return Constants.SITE_NAME_IMG + imgUrl;
		}
		return "";
	}

	public void setImgUrlOutput(String imgUrlOutput) {
		this.imgUrlOutput = imgUrlOutput;
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