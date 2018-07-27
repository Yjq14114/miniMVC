package com.miniMvc.chapter4.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yjq14 on 2018/7/27.
 */
@Entity
@Table(name = "BOSS_COUPON", schema = "ERKUAI", catalog = "")
public class BossCouponEntity {
    private int id;
    private String tradeNo;
    private String telephone;
    private String batchNo;
    private String merchant;
    private Long price;
    private String couponName;
    private String bossGoodsNo;
    private Long status;
    private String remark;
    private Timestamp createTime;
    private Timestamp dealTime;
    private Long signType;
    private Long signtStatus;
    private String serialNumber;
    private String merchantNo;
    private String modelNo;
    private String modelName;
    private String dealNo;
    private String dealChannel;
    private String dealCity;
    private String broadbandNo;
    private String consumerType;
    private String remark1;
    private String filed1;
    private String filed2;
    private String filed3;
    private String filed4;
    private String filed5;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TRADE_NO")
    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Basic
    @Column(name = "TELEPHONE")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "BATCH_NO")
    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    @Basic
    @Column(name = "MERCHANT")
    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    @Basic
    @Column(name = "PRICE")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "COUPON_NAME")
    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    @Basic
    @Column(name = "BOSS_GOODS_NO")
    public String getBossGoodsNo() {
        return bossGoodsNo;
    }

    public void setBossGoodsNo(String bossGoodsNo) {
        this.bossGoodsNo = bossGoodsNo;
    }

    @Basic
    @Column(name = "STATUS")
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Basic
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "DEAL_TIME")
    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    @Basic
    @Column(name = "SIGN_TYPE")
    public Long getSignType() {
        return signType;
    }

    public void setSignType(Long signType) {
        this.signType = signType;
    }

    @Basic
    @Column(name = "SIGNT_STATUS")
    public Long getSigntStatus() {
        return signtStatus;
    }

    public void setSigntStatus(Long signtStatus) {
        this.signtStatus = signtStatus;
    }

    @Basic
    @Column(name = "SERIAL_NUMBER")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "MERCHANT_NO")
    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    @Basic
    @Column(name = "MODEL_NO")
    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    @Basic
    @Column(name = "MODEL_NAME")
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Basic
    @Column(name = "DEAL_NO")
    public String getDealNo() {
        return dealNo;
    }

    public void setDealNo(String dealNo) {
        this.dealNo = dealNo;
    }

    @Basic
    @Column(name = "DEAL_CHANNEL")
    public String getDealChannel() {
        return dealChannel;
    }

    public void setDealChannel(String dealChannel) {
        this.dealChannel = dealChannel;
    }

    @Basic
    @Column(name = "DEAL_CITY")
    public String getDealCity() {
        return dealCity;
    }

    public void setDealCity(String dealCity) {
        this.dealCity = dealCity;
    }

    @Basic
    @Column(name = "BROADBAND_NO")
    public String getBroadbandNo() {
        return broadbandNo;
    }

    public void setBroadbandNo(String broadbandNo) {
        this.broadbandNo = broadbandNo;
    }

    @Basic
    @Column(name = "CONSUMER_TYPE")
    public String getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    @Basic
    @Column(name = "REMARK1")
    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    @Basic
    @Column(name = "FILED1")
    public String getFiled1() {
        return filed1;
    }

    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    @Basic
    @Column(name = "FILED2")
    public String getFiled2() {
        return filed2;
    }

    public void setFiled2(String filed2) {
        this.filed2 = filed2;
    }

    @Basic
    @Column(name = "FILED3")
    public String getFiled3() {
        return filed3;
    }

    public void setFiled3(String filed3) {
        this.filed3 = filed3;
    }

    @Basic
    @Column(name = "FILED4")
    public String getFiled4() {
        return filed4;
    }

    public void setFiled4(String filed4) {
        this.filed4 = filed4;
    }

    @Basic
    @Column(name = "FILED5")
    public String getFiled5() {
        return filed5;
    }

    public void setFiled5(String filed5) {
        this.filed5 = filed5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BossCouponEntity that = (BossCouponEntity) o;

        if (id != that.id) return false;
        if (tradeNo != null ? !tradeNo.equals(that.tradeNo) : that.tradeNo != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (batchNo != null ? !batchNo.equals(that.batchNo) : that.batchNo != null) return false;
        if (merchant != null ? !merchant.equals(that.merchant) : that.merchant != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (couponName != null ? !couponName.equals(that.couponName) : that.couponName != null) return false;
        if (bossGoodsNo != null ? !bossGoodsNo.equals(that.bossGoodsNo) : that.bossGoodsNo != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (dealTime != null ? !dealTime.equals(that.dealTime) : that.dealTime != null) return false;
        if (signType != null ? !signType.equals(that.signType) : that.signType != null) return false;
        if (signtStatus != null ? !signtStatus.equals(that.signtStatus) : that.signtStatus != null) return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (merchantNo != null ? !merchantNo.equals(that.merchantNo) : that.merchantNo != null) return false;
        if (modelNo != null ? !modelNo.equals(that.modelNo) : that.modelNo != null) return false;
        if (modelName != null ? !modelName.equals(that.modelName) : that.modelName != null) return false;
        if (dealNo != null ? !dealNo.equals(that.dealNo) : that.dealNo != null) return false;
        if (dealChannel != null ? !dealChannel.equals(that.dealChannel) : that.dealChannel != null) return false;
        if (dealCity != null ? !dealCity.equals(that.dealCity) : that.dealCity != null) return false;
        if (broadbandNo != null ? !broadbandNo.equals(that.broadbandNo) : that.broadbandNo != null) return false;
        if (consumerType != null ? !consumerType.equals(that.consumerType) : that.consumerType != null) return false;
        if (remark1 != null ? !remark1.equals(that.remark1) : that.remark1 != null) return false;
        if (filed1 != null ? !filed1.equals(that.filed1) : that.filed1 != null) return false;
        if (filed2 != null ? !filed2.equals(that.filed2) : that.filed2 != null) return false;
        if (filed3 != null ? !filed3.equals(that.filed3) : that.filed3 != null) return false;
        if (filed4 != null ? !filed4.equals(that.filed4) : that.filed4 != null) return false;
        if (filed5 != null ? !filed5.equals(that.filed5) : that.filed5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tradeNo != null ? tradeNo.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (batchNo != null ? batchNo.hashCode() : 0);
        result = 31 * result + (merchant != null ? merchant.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (couponName != null ? couponName.hashCode() : 0);
        result = 31 * result + (bossGoodsNo != null ? bossGoodsNo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (dealTime != null ? dealTime.hashCode() : 0);
        result = 31 * result + (signType != null ? signType.hashCode() : 0);
        result = 31 * result + (signtStatus != null ? signtStatus.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (merchantNo != null ? merchantNo.hashCode() : 0);
        result = 31 * result + (modelNo != null ? modelNo.hashCode() : 0);
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        result = 31 * result + (dealNo != null ? dealNo.hashCode() : 0);
        result = 31 * result + (dealChannel != null ? dealChannel.hashCode() : 0);
        result = 31 * result + (dealCity != null ? dealCity.hashCode() : 0);
        result = 31 * result + (broadbandNo != null ? broadbandNo.hashCode() : 0);
        result = 31 * result + (consumerType != null ? consumerType.hashCode() : 0);
        result = 31 * result + (remark1 != null ? remark1.hashCode() : 0);
        result = 31 * result + (filed1 != null ? filed1.hashCode() : 0);
        result = 31 * result + (filed2 != null ? filed2.hashCode() : 0);
        result = 31 * result + (filed3 != null ? filed3.hashCode() : 0);
        result = 31 * result + (filed4 != null ? filed4.hashCode() : 0);
        result = 31 * result + (filed5 != null ? filed5.hashCode() : 0);
        return result;
    }
}
