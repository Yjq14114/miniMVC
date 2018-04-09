package com.miniMvc.chapter4.entity;


import java.sql.Date;
import java.sql.Timestamp;

public class Boss_coupon_status {
    @Override
    public String toString() {
        return "Boss_coupon_status{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", trade_no='" + trade_no + '\'' +
                ", batch_no='" + batch_no + '\'' +
                ", boss_goodsNo='" + boss_goodsNo + '\'' +
                ", status=" + status +
                ", work_status=" + work_status +
                ", work_id='" + work_id + '\'' +
                ", coupon_no='" + coupon_no + '\'' +
                ", remark='" + remark + '\'' +
                ", create_time=" + create_time +
                ", hander_time=" + hander_time +
                '}';
    }

    private Long id;
  private String telephone;
  private String trade_no;
  private String batch_no;
  private String boss_goodsNo;
  private Integer status;
  private Integer work_status;
  private String work_id;
  private String coupon_no;
  private String remark;
  private java.sql.Timestamp create_time;
  private java.sql.Timestamp hander_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getBoss_goodsNo() {
        return boss_goodsNo;
    }

    public void setBoss_goodsNo(String boss_goodsNo) {
        this.boss_goodsNo = boss_goodsNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWork_status() {
        return work_status;
    }

    public void setWork_status(Integer work_status) {
        this.work_status = work_status;
    }

    public String getWork_id() {
        return work_id;
    }

    public void setWork_id(String work_id) {
        this.work_id = work_id;
    }

    public String getCoupon_no() {
        return coupon_no;
    }

    public void setCoupon_no(String coupon_no) {
        this.coupon_no = coupon_no;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getHander_time() {
        return hander_time;
    }

    public void setHander_time(Timestamp hander_time) {
        this.hander_time = hander_time;
    }
}
