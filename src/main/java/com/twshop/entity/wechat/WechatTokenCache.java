package com.twshop.entity.wechat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wechat_token_cache")
public class WechatTokenCache {
    /**
     * 微信token缓存
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * wechat_account表的id
     */
    @Column(name = "account_id")
    private Long accountId;

    /**
     * 拉取的token串
     */
    private String token;

    /**
     * 类型；0-jsapi
     */
    @Column(name = "token_type")
    private Byte tokenType;

    /**
     * 票据过期时间
     */
    @Column(name = "expires_in")
    private String expiresIn;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取微信token缓存
     *
     * @return id - 微信token缓存
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置微信token缓存
     *
     * @param id 微信token缓存
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取wechat_account表的id
     *
     * @return account_id - wechat_account表的id
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 设置wechat_account表的id
     *
     * @param accountId wechat_account表的id
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取拉取的token串
     *
     * @return token - 拉取的token串
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置拉取的token串
     *
     * @param token 拉取的token串
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取类型；0-jsapi
     *
     * @return token_type - 类型；0-jsapi
     */
    public Byte getTokenType() {
        return tokenType;
    }

    /**
     * 设置类型；0-jsapi
     *
     * @param tokenType 类型；0-jsapi
     */
    public void setTokenType(Byte tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * 获取票据过期时间
     *
     * @return expires_in - 票据过期时间
     */
    public String getExpiresIn() {
        return expiresIn;
    }

    /**
     * 设置票据过期时间
     *
     * @param expiresIn 票据过期时间
     */
    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
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
}