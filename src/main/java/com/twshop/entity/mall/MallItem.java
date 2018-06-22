package com.twshop.entity.mall;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;
import com.base.util.number.NumberFormatUtil;
import com.base.util.string.StringUtil;
import com.twshop.Constants;
import com.twshop.enums.common.EnumYesOrNo;
import com.twshop.enums.mall.EnumMallItemStatus;

@Table(name = "mall_item")
public class MallItem {
	/**
	 * 商品
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 商户ID
	 */
	@Column(name = "merchant_id")
	private Long merchantId;

	/**
	 * 产品名称
	 */
	private String name;

	/**
	 * 所属产品分类id
	 */
	@Column(name = "category_id")
	private Integer categoryId;

	/**
	 * 正方形图片
	 */
	@Column(name = "img_url")
	private String imgUrl;

	@Transient
	private String imgUrlOutput;

	/**
	 * 关键字
	 */
	@Column(name = "key_word")
	private String keyWord;

	/**
	 * 价格(单位分)
	 */
	private Integer price;

	@Transient
	private String priceOutput;

	/**
	 * 市场价格
	 */
	@Column(name = "market_price")
	private Integer marketPrice;

	@Transient
	private String marketPriceOutput;

	/**
	 * 销售数量
	 */
	@Column(name = "sale_count")
	private Integer saleCount;

	/**
	 * 排序
	 */
	@Column(name = "sort_no")
	private Integer sortNo;

	/**
	 * 是否免运费,0-否,1-是
	 */
	@Column(name = "free_postfee")
	private Byte freePostfee;

	@Transient
	private String freePostfeeOutput;

	/**
	 * 运费
	 */
	@Column(name = "post_fee")
	private Integer postFee;

	/**
	 * 是否推荐;0-否；1-是
	 */
	@Column(name = "recomend_tag")
	private Byte recomendTag;

	@Transient
	private String recomendTagOutput;

	/**
	 * 是否精品;0-否；1-是
	 */
	@Column(name = "soul_tag")
	private Byte soulTag;

	@Transient
	private String soulTagOutput;
	/**
	 * 是否参与分销;0-否；1-是
	 */
	@Column(name = "distribute_tag")
	private Byte distributeTag;

	@Transient
	private String distributeTagOutput;

	/**
	 * 状态;0-待上架，1-已上架；2-已下架
	 */
	private Byte status;

	@Transient
	private String statusOutput;

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
	 * 获取商品
	 *
	 * @return id - 商品
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置商品
	 *
	 * @param id
	 *            商品
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取产品名称
	 *
	 * @return name - 产品名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置产品名称
	 *
	 * @param name
	 *            产品名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取所属产品分类id
	 *
	 * @return category_id - 所属产品分类id
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置所属产品分类id
	 *
	 * @param categoryId
	 *            所属产品分类id
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 获取正方形图片
	 *
	 * @return img_url - 正方形图片
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * 设置正方形图片
	 *
	 * @param imgUrl
	 *            正方形图片
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * 获取关键字
	 *
	 * @return key_word - 关键字
	 */
	public String getKeyWord() {
		return keyWord;
	}

	/**
	 * 设置关键字
	 *
	 * @param keyWord
	 *            关键字
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * 获取价格(单位分)
	 *
	 * @return price - 价格(单位分)
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * 设置价格(单位分)
	 *
	 * @param price
	 *            价格(单位分)
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * 获取市场价格
	 *
	 * @return market_price - 市场价格
	 */
	public Integer getMarketPrice() {
		return marketPrice;
	}

	/**
	 * 设置市场价格
	 *
	 * @param marketPrice
	 *            市场价格
	 */
	public void setMarketPrice(Integer marketPrice) {
		this.marketPrice = marketPrice;
	}

	/**
	 * 获取销售数量
	 *
	 * @return sale_count - 销售数量
	 */
	public Integer getSaleCount() {
		return saleCount;
	}

	/**
	 * 设置销售数量
	 *
	 * @param saleCount
	 *            销售数量
	 */
	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	/**
	 * 获取排序
	 *
	 * @return sort_no - 排序
	 */
	public Integer getSortNo() {
		return sortNo;
	}

	/**
	 * 设置排序
	 *
	 * @param sortNo
	 *            排序
	 */
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * 获取是否免运费,0-否,1-是
	 *
	 * @return free_postfee - 是否免运费,0-否,1-是
	 */
	public Byte getFreePostfee() {
		return freePostfee;
	}

	/**
	 * 设置是否免运费,0-否,1-是
	 *
	 * @param freePostfee
	 *            是否免运费,0-否,1-是
	 */
	public void setFreePostfee(Byte freePostfee) {
		this.freePostfee = freePostfee;
	}

	/**
	 * 获取运费
	 *
	 * @return post_fee - 运费
	 */
	public Integer getPostFee() {
		return postFee;
	}

	/**
	 * 设置运费
	 *
	 * @param postFee
	 *            运费
	 */
	public void setPostFee(Integer postFee) {
		this.postFee = postFee;
	}

	/**
	 * 获取是否推荐;0-否；1-是
	 *
	 * @return recomend_tag - 是否推荐;0-否；1-是
	 */
	public Byte getRecomendTag() {
		return recomendTag;
	}

	/**
	 * 设置是否推荐;0-否；1-是
	 *
	 * @param recomendTag
	 *            是否推荐;0-否；1-是
	 */
	public void setRecomendTag(Byte recomendTag) {
		this.recomendTag = recomendTag;
	}

	/**
	 * 获取是否精品;0-否；1-是
	 *
	 * @return soul_tag - 是否精品;0-否；1-是
	 */
	public Byte getSoulTag() {
		return soulTag;
	}

	/**
	 * 设置是否精品;0-否；1-是
	 *
	 * @param soulTag
	 *            是否精品;0-否；1-是
	 */
	public void setSoulTag(Byte soulTag) {
		this.soulTag = soulTag;
	}

	/**
	 * 获取是否参与分销;0-否；1-是
	 *
	 * @return distribute_tag - 是否参与分销;0-否；1-是
	 */
	public Byte getDistributeTag() {
		return distributeTag;
	}

	/**
	 * 设置是否参与分销;0-否；1-是
	 *
	 * @param distributeTag
	 *            是否参与分销;0-否；1-是
	 */
	public void setDistributeTag(Byte distributeTag) {
		this.distributeTag = distributeTag;
	}

	/**
	 * 获取状态;0-待上架，1-已上架；2-已下架
	 *
	 * @return status - 状态;0-待上架，1-已上架；2-已下架
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * 设置状态;0-待上架，1-已上架；2-已下架
	 *
	 * @param status
	 *            状态;0-待上架，1-已上架；2-已下架
	 */
	public void setStatus(Byte status) {
		this.status = status;
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

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getFreePostfeeOutput() {
		EnumYesOrNo enumYes = EnumYesOrNo.getEnum(freePostfee.intValue());
		if (null != enumYes) {
			return enumYes.getName();
		}
		return "";
	}

	public void setFreePostfeeOutput(String freePostfeeOutput) {
		this.freePostfeeOutput = freePostfeeOutput;
	}

	public String getRecomendTagOutput() {
		EnumYesOrNo enumYes = EnumYesOrNo.getEnum(recomendTag.intValue());
		if (null != enumYes) {
			return enumYes.getName();
		}
		return "";
	}

	public void setRecomendTagOutput(String recomendTagOutput) {
		this.recomendTagOutput = recomendTagOutput;
	}

	public String getSoulTagOutput() {
		EnumYesOrNo enumYes = EnumYesOrNo.getEnum(soulTag.intValue());
		if (null != enumYes) {
			return enumYes.getName();
		}
		return "";
	}

	public void setSoulTagOutput(String soulTagOutput) {
		this.soulTagOutput = soulTagOutput;
	}

	public String getDistributeTagOutput() {
		EnumYesOrNo enumYes = EnumYesOrNo.getEnum(distributeTag.intValue());
		if (null != enumYes) {
			return enumYes.getName();
		}
		return "";
	}

	public void setDistributeTagOutput(String distributeTagOutput) {
		this.distributeTagOutput = distributeTagOutput;
	}

	public String getStatusOutput() {
		EnumMallItemStatus enumStatus = EnumMallItemStatus.getEnum(status.intValue());
		if (null != enumStatus) {
			return enumStatus.getName();
		}
		return "";
	}

	public void setStatusOutput(String statusOutput) {
		this.statusOutput = statusOutput;
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

	public String getImgUrlOutput() {
		if (StringUtil.isNotBlank(imgUrl)) {
			return Constants.SITE_NAME_IMG + imgUrl;
		}
		return "";
	}

	public void setImgUrlOutput(String imgUrlOutput) {
		this.imgUrlOutput = imgUrlOutput;
	}

	public String getPriceOutput() {
		if (null != price) {
			return NumberFormatUtil.format(price);
		}
		return "";
	}

	public void setPriceOutput(String priceOutput) {
		this.priceOutput = priceOutput;
	}

	public String getMarketPriceOutput() {
		if (null != marketPrice) {
			return NumberFormatUtil.format(marketPrice);
		}
		return "";
	}

	public void setMarketPriceOutput(String marketPriceOutput) {
		this.marketPriceOutput = marketPriceOutput;
	}

}