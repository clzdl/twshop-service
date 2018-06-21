package com.twshop.entity.mall;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_item_sku")
public class MallItemSku {
    /**
     * 商品库存
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 产品id
     */
    @Column(name = "item_id")
    private Long itemId;

    /**
     * 库存数量
     */
    private Integer quantity;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片URL
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 价格(单位分)
     */
    private Integer price;

    /**
     * 市场价格(单位分)
     */
    @Column(name = "market_price")
    private Integer marketPrice;

    /**
     * 尺寸
     */
    private String size;

    /**
     * 颜色
     */
    private String color;

    /**
     * 体积
     */
    private String volume;

    /**
     * 重量
     */
    private String weight;

    /**
     * 数据版本,乐观锁
     */
    private Integer version;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 详情
     */
    private String detail;

    /**
     * 获取商品库存
     *
     * @return id - 商品库存
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置商品库存
     *
     * @param id 商品库存
     */
    public void setId(Long id) {
        this.id = id;
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
     * @param itemId 产品id
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取库存数量
     *
     * @return quantity - 库存数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置库存数量
     *
     * @param quantity 库存数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @param imgUrl 图片URL
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
     * @param price 价格(单位分)
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取市场价格(单位分)
     *
     * @return market_price - 市场价格(单位分)
     */
    public Integer getMarketPrice() {
        return marketPrice;
    }

    /**
     * 设置市场价格(单位分)
     *
     * @param marketPrice 市场价格(单位分)
     */
    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 获取尺寸
     *
     * @return size - 尺寸
     */
    public String getSize() {
        return size;
    }

    /**
     * 设置尺寸
     *
     * @param size 尺寸
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 获取颜色
     *
     * @return color - 颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置颜色
     *
     * @param color 颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取体积
     *
     * @return volume - 体积
     */
    public String getVolume() {
        return volume;
    }

    /**
     * 设置体积
     *
     * @param volume 体积
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * 获取重量
     *
     * @return weight - 重量
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 设置重量
     *
     * @param weight 重量
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * 获取数据版本,乐观锁
     *
     * @return version - 数据版本,乐观锁
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置数据版本,乐观锁
     *
     * @param version 数据版本,乐观锁
     */
    public void setVersion(Integer version) {
        this.version = version;
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

    /**
     * 获取详情
     *
     * @return detail - 详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置详情
     *
     * @param detail 详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}