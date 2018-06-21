package com.twshop.entity.distribute;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "distribute_reward")
public class DistributeReward {
    /**
     * 分销奖励
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
     * 被提成的用户id
     */
    @Column(name = "lower_user_id")
    private Long lowerUserId;

    /**
     * 商户ID
     */
    @Column(name = "merchant_id")
    private Long merchantId;

    /**
     * 支付订单id
     */
    @Column(name = "web_order_id")
    private Long webOrderId;

    /**
     * 提成比例
     */
    private BigDecimal ratio;

    /**
     * 提成金额
     */
    private Integer money;

    /**
     * 提取金额
     */
    @Column(name = "extract_money")
    private BigDecimal extractMoney;

    /**
     * 提取记录id
     */
    @Column(name = "extract_id")
    private Long extractId;

    /**
     * 状态;0-未提取,1-部分提取,2-已提取,3-已退款
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 获取分销奖励
     *
     * @return id - 分销奖励
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置分销奖励
     *
     * @param id 分销奖励
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
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取被提成的用户id
     *
     * @return lower_user_id - 被提成的用户id
     */
    public Long getLowerUserId() {
        return lowerUserId;
    }

    /**
     * 设置被提成的用户id
     *
     * @param lowerUserId 被提成的用户id
     */
    public void setLowerUserId(Long lowerUserId) {
        this.lowerUserId = lowerUserId;
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
     * @param merchantId 商户ID
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取支付订单id
     *
     * @return web_order_id - 支付订单id
     */
    public Long getWebOrderId() {
        return webOrderId;
    }

    /**
     * 设置支付订单id
     *
     * @param webOrderId 支付订单id
     */
    public void setWebOrderId(Long webOrderId) {
        this.webOrderId = webOrderId;
    }

    /**
     * 获取提成比例
     *
     * @return ratio - 提成比例
     */
    public BigDecimal getRatio() {
        return ratio;
    }

    /**
     * 设置提成比例
     *
     * @param ratio 提成比例
     */
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    /**
     * 获取提成金额
     *
     * @return money - 提成金额
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置提成金额
     *
     * @param money 提成金额
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * 获取提取金额
     *
     * @return extract_money - 提取金额
     */
    public BigDecimal getExtractMoney() {
        return extractMoney;
    }

    /**
     * 设置提取金额
     *
     * @param extractMoney 提取金额
     */
    public void setExtractMoney(BigDecimal extractMoney) {
        this.extractMoney = extractMoney;
    }

    /**
     * 获取提取记录id
     *
     * @return extract_id - 提取记录id
     */
    public Long getExtractId() {
        return extractId;
    }

    /**
     * 设置提取记录id
     *
     * @param extractId 提取记录id
     */
    public void setExtractId(Long extractId) {
        this.extractId = extractId;
    }

    /**
     * 获取状态;0-未提取,1-部分提取,2-已提取,3-已退款
     *
     * @return status - 状态;0-未提取,1-部分提取,2-已提取,3-已退款
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态;0-未提取,1-部分提取,2-已提取,3-已退款
     *
     * @param status 状态;0-未提取,1-部分提取,2-已提取,3-已退款
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
     * @param createTime 创建时间
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