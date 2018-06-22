package com.twshop.entity.finance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;
import com.base.util.number.NumberFormatUtil;
import com.twshop.enums.finance.EnumWebOrderExpressType;
import com.twshop.enums.finance.EnumWebOrderObjType;
import com.twshop.enums.finance.EnumWebOrderPayMethod;
import com.twshop.enums.finance.EnumWebOrderPayStatus;
import com.twshop.enums.finance.EnumWebOrderStatus;

@Table(name = "web_order")
public class WebOrder {
	/**
	 * 费用支付订单
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	 * 支付方式；0-微信；1-支付宝
	 */
	@Column(name = "pay_method")
	private Byte payMethod;

	@Transient
	private String payMethodOutput;

	/**
	 * 对象类型:0-普通商品
	 */
	@Column(name = "obj_type")
	private Byte objType;

	@Transient
	private String objTypeOutput;

	/**
	 * 对象ID
	 */
	@Column(name = "obj_id")
	private Long objId;

	/**
	 * 总金额(单位分)
	 */
	@Column(name = "total_fee")
	private Integer totalFee;

	@Transient
	private String totalFeeOutput;

	/**
	 * 总优惠金额
	 */
	@Column(name = "discount_fee")
	private Integer discountFee;

	@Transient
	private String discountFeeOutput;

	/**
	 * 实际支付金额
	 */
	@Column(name = "pay_fee")
	private Integer payFee;

	@Transient
	private String payFeeOutput;

	/**
	 * 支付状态；0-未支付；1-已支付；2-已退款
	 */
	@Column(name = "pay_status")
	private Byte payStatus;

	@Transient
	private String payStatusOutput;

	/**
	 * 支付时间
	 */
	@Column(name = "pay_time")
	private Date payTime;

	@Transient
	private String payTimeOutput;

	/**
	 * 用户邮寄地址
	 */
	@Column(name = "deliver_addr")
	private String deliverAddr;

	/**
	 * 快递类型
	 */
	@Column(name = "express_type")
	private Byte expressType;

	@Transient
	private String expressTypeOutput;

	/**
	 * 快递单号
	 */
	@Column(name = "express_no")
	private String expressNo;

	/**
	 * 备忘录
	 */
	private String remark;

	/**
	 * ip
	 */
	private String ip;

	/**
	 * 订单状态:0-待支付,1-待发货,2-待收货,3-已签收,4-申请退货,5-已退货,6-订单结束
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
	 * 获取费用支付订单
	 *
	 * @return id - 费用支付订单
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置费用支付订单
	 *
	 * @param id
	 *            费用支付订单
	 */
	public void setId(Long id) {
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
	 * 获取支付方式；0-微信；1-支付宝
	 *
	 * @return pay_method - 支付方式；0-微信；1-支付宝
	 */
	public Byte getPayMethod() {
		return payMethod;
	}

	/**
	 * 设置支付方式；0-微信；1-支付宝
	 *
	 * @param payMethod
	 *            支付方式；0-微信；1-支付宝
	 */
	public void setPayMethod(Byte payMethod) {
		this.payMethod = payMethod;
	}

	/**
	 * 获取对象类型:0-普通商品
	 *
	 * @return obj_type - 对象类型:0-普通商品
	 */
	public Byte getObjType() {
		return objType;
	}

	/**
	 * 设置对象类型:0-普通商品
	 *
	 * @param objType
	 *            对象类型:0-普通商品
	 */
	public void setObjType(Byte objType) {
		this.objType = objType;
	}

	/**
	 * 获取对象ID
	 *
	 * @return obj_id - 对象ID
	 */
	public Long getObjId() {
		return objId;
	}

	/**
	 * 设置对象ID
	 *
	 * @param objId
	 *            对象ID
	 */
	public void setObjId(Long objId) {
		this.objId = objId;
	}

	/**
	 * 获取总金额(单位分)
	 *
	 * @return total_fee - 总金额(单位分)
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	/**
	 * 设置总金额(单位分)
	 *
	 * @param totalFee
	 *            总金额(单位分)
	 */
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * 获取总优惠金额
	 *
	 * @return discount_fee - 总优惠金额
	 */
	public Integer getDiscountFee() {
		return discountFee;
	}

	/**
	 * 设置总优惠金额
	 *
	 * @param discountFee
	 *            总优惠金额
	 */
	public void setDiscountFee(Integer discountFee) {
		this.discountFee = discountFee;
	}

	/**
	 * 获取实际支付金额
	 *
	 * @return pay_fee - 实际支付金额
	 */
	public Integer getPayFee() {
		return payFee;
	}

	/**
	 * 设置实际支付金额
	 *
	 * @param payFee
	 *            实际支付金额
	 */
	public void setPayFee(Integer payFee) {
		this.payFee = payFee;
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
	 * 获取用户邮寄地址
	 *
	 * @return deliver_addr - 用户邮寄地址
	 */
	public String getDeliverAddr() {
		return deliverAddr;
	}

	/**
	 * 设置用户邮寄地址
	 *
	 * @param deliverAddr
	 *            用户邮寄地址
	 */
	public void setDeliverAddr(String deliverAddr) {
		this.deliverAddr = deliverAddr;
	}

	/**
	 * 获取快递类型
	 *
	 * @return express_type - 快递类型
	 */
	public Byte getExpressType() {
		return expressType;
	}

	/**
	 * 设置快递类型
	 *
	 * @param expressType
	 *            快递类型
	 */
	public void setExpressType(Byte expressType) {
		this.expressType = expressType;
	}

	/**
	 * 获取快递单号
	 *
	 * @return express_no - 快递单号
	 */
	public String getExpressNo() {
		return expressNo;
	}

	/**
	 * 设置快递单号
	 *
	 * @param expressNo
	 *            快递单号
	 */
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}

	/**
	 * 获取备忘录
	 *
	 * @return remark - 备忘录
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备忘录
	 *
	 * @param remark
	 *            备忘录
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取ip
	 *
	 * @return ip - ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 设置ip
	 *
	 * @param ip
	 *            ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取订单状态:0-待支付,1-待发货,2-待收货,3-已签收,4-申请退货,5-已退货,6-订单结束
	 *
	 * @return status - 订单状态:0-待支付,1-待发货,2-待收货,3-已签收,4-申请退货,5-已退货,6-订单结束
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * 设置订单状态:0-待支付,1-待发货,2-待收货,3-已签收,4-申请退货,5-已退货,6-订单结束
	 *
	 * @param status
	 *            订单状态:0-待支付,1-待发货,2-待收货,3-已签收,4-申请退货,5-已退货,6-订单结束
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

	public String getPayMethodOutput() {
		EnumWebOrderPayMethod enumMethod = EnumWebOrderPayMethod.getEnum(payMethod.intValue());
		if (null != payMethod) {
			return enumMethod.getName();
		}
		return "";
	}

	public void setPayMethodOutput(String payMethodOutput) {
		this.payMethodOutput = payMethodOutput;
	}

	public String getObjTypeOutput() {
		EnumWebOrderObjType enumType = EnumWebOrderObjType.getEnum(objType.intValue());
		if (null != enumType) {
			return enumType.getName();
		}
		return "";
	}

	public void setObjTypeOutput(String objTypeOutput) {
		this.objTypeOutput = objTypeOutput;
	}

	public String getTotalFeeOutput() {
		if (null != totalFee) {
			return NumberFormatUtil.format(totalFee);
		}
		return "";
	}

	public void setTotalFeeOutput(String totalFeeOutput) {
		this.totalFeeOutput = totalFeeOutput;
	}

	public String getDiscountFeeOutput() {
		if (null != discountFee) {
			return NumberFormatUtil.format(discountFee);
		}
		return "";
	}

	public void setDiscountFeeOutput(String discountFeeOutput) {
		this.discountFeeOutput = discountFeeOutput;
	}

	public String getPayFeeOutput() {
		if (null != payFee) {
			return NumberFormatUtil.format(payFee);
		}
		return "";
	}

	public void setPayFeeOutput(String payFeeOutput) {
		this.payFeeOutput = payFeeOutput;
	}

	public String getPayStatusOutput() {
		EnumWebOrderPayStatus enumPay = EnumWebOrderPayStatus.getEnum(payStatus.intValue());
		if (null != enumPay) {
			return enumPay.getName();
		}
		return "";
	}

	public void setPayStatusOutput(String payStatusOutput) {
		this.payStatusOutput = payStatusOutput;
	}

	public String getPayTimeOutput() {
		if (payTime != null) {
			return DateUtil.formatDate(DateUtil._DATE_TIME_FORMAT1, payTime);
		}
		return "";
	}

	public void setPayTimeOutput(String payTimeOutput) {
		this.payTimeOutput = payTimeOutput;
	}

	public String getExpressTypeOutput() {
		EnumWebOrderExpressType enumType = EnumWebOrderExpressType.getEnum(expressType.intValue());
		if (null != enumType) {
			return enumType.getName();
		}
		return "";
	}

	public void setExpressTypeOutput(String expressTypeOutput) {
		this.expressTypeOutput = expressTypeOutput;
	}

	public String getStatusOutput() {
		EnumWebOrderStatus enumStatus = EnumWebOrderStatus.getEnum(status.intValue());
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

};
