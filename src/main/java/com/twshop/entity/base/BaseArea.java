package com.twshop.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.twshop.enums.base.EnumAreaType;

@Table(name = "base_area")
public class BaseArea {
	/**
	 * 行政区域信息
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 父ID
	 */
	@Column(name = "parent_id")
	private Long parentId;

	/**
	 * 父code
	 */
	@Column(name = "parent_code")
	private String parentCode;

	/**
	 * 区域编码
	 */
	@Column(name = "area_code")
	private String areaCode;

	/**
	 * 区域名称
	 */
	@Column(name = "area_name")
	private String areaName;

	/**
	 * 1省2市3区县
	 */
	@Column(name = "area_type")
	private Integer areaType;

	@Transient
	private String areaTypeOutput;
	/**
	 * 排序号
	 */
	@Column(name = "sort_no")
	private Integer sortNo;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取行政区域信息
	 *
	 * @return id - 行政区域信息
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置行政区域信息
	 *
	 * @param id
	 *            行政区域信息
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取父ID
	 *
	 * @return parent_id - 父ID
	 */
	public Long getParentId() {
		return parentId;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * 设置父ID
	 *
	 * @param parentId
	 *            父ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取区域编码
	 *
	 * @return area_code - 区域编码
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * 设置区域编码
	 *
	 * @param areaCode
	 *            区域编码
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * 获取区域名称
	 *
	 * @return area_name - 区域名称
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置区域名称
	 *
	 * @param areaName
	 *            区域名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 获取1省2市3区县
	 *
	 * @return area_type - 1省2市3区县
	 */
	public Integer getAreaType() {
		return areaType;
	}

	/**
	 * 设置1省2市3区县
	 *
	 * @param areaType
	 *            1省2市3区县
	 */
	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
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

	public String getAreaTypeOutput() {

		EnumAreaType enumType = EnumAreaType.getEnum(areaType);
		if (null != enumType) {
			return enumType.getName();
		}
		return "";
	}

	public void setAreaTypeOutput(String areaTypeOutput) {
		this.areaTypeOutput = areaTypeOutput;
	}

}