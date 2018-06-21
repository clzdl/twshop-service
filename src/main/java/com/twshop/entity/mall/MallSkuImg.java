package com.twshop.entity.mall;

import java.util.Date;
import javax.persistence.*;

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

    /**
     * 图片类型;0-BANNER,1-详情
     */
    @Column(name = "img_type")
    private Byte imgType;

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
     * @param id 库存产品参数图片
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
     * @param skuId 所述skuId
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
     * @param imgUrl 图片地址
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
     * @param imgType 图片类型;0-BANNER,1-详情
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
     * @param sortNo 排序号
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