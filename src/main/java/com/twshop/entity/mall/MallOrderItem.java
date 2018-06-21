package com.twshop.entity.mall;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_order_item")
public class MallOrderItem {
    /**
     * 商品订单项
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品订单Id
     */
    @Column(name = "mall_order_id")
    private Long mallOrderId;

    /**
     * 产品ID
     */
    @Column(name = "item_id")
    private Long itemId;

    /**
     * sku_id
     */
    @Column(name = "sku_id")
    private Long skuId;

    /**
     * 产品名称
     */
    private String title;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 价格(单位分)
     */
    private Integer price;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 获取商品订单项
     *
     * @return id - 商品订单项
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品订单项
     *
     * @param id 商品订单项
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品订单Id
     *
     * @return mall_order_id - 商品订单Id
     */
    public Long getMallOrderId() {
        return mallOrderId;
    }

    /**
     * 设置商品订单Id
     *
     * @param mallOrderId 商品订单Id
     */
    public void setMallOrderId(Long mallOrderId) {
        this.mallOrderId = mallOrderId;
    }

    /**
     * 获取产品ID
     *
     * @return item_id - 产品ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置产品ID
     *
     * @param itemId 产品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取sku_id
     *
     * @return sku_id - sku_id
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 设置sku_id
     *
     * @param skuId sku_id
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取产品名称
     *
     * @return title - 产品名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置产品名称
     *
     * @param title 产品名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取数量
     *
     * @return quantity - 数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置数量
     *
     * @param quantity 数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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