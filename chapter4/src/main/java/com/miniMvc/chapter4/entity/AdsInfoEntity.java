package com.miniMvc.chapter4.entity;

import javax.persistence.*;

/**
 * Created by yjq14 on 2018/4/23.
 */
@Entity
@Table(name = "ADS_INFO", schema = "ERKUAI", catalog = "")
public class AdsInfoEntity {
    private long id;
    private String identity;
    private String uri;
    private long createtime;
    private String name;
    private String description;
    private String link;
    private String city;
    private long regionflag;
    private long status;
    private long ordervalue;
    private long appVersion;
    private long osVersion;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IDENTITY")
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Basic
    @Column(name = "URI")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Basic
    @Column(name = "CREATETIME")
    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "LINK")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "REGIONFLAG")
    public long getRegionflag() {
        return regionflag;
    }

    public void setRegionflag(long regionflag) {
        this.regionflag = regionflag;
    }

    @Basic
    @Column(name = "STATUS")
    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ORDERVALUE")
    public long getOrdervalue() {
        return ordervalue;
    }

    public void setOrdervalue(long ordervalue) {
        this.ordervalue = ordervalue;
    }

    @Basic
    @Column(name = "APP_VERSION")
    public long getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(long appVersion) {
        this.appVersion = appVersion;
    }

    @Basic
    @Column(name = "OS_VERSION")
    public long getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(long osVersion) {
        this.osVersion = osVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdsInfoEntity that = (AdsInfoEntity) o;

        if (id != that.id) return false;
        if (createtime != that.createtime) return false;
        if (regionflag != that.regionflag) return false;
        if (status != that.status) return false;
        if (ordervalue != that.ordervalue) return false;
        if (appVersion != that.appVersion) return false;
        if (osVersion != that.osVersion) return false;
        if (identity != null ? !identity.equals(that.identity) : that.identity != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (int) (createtime ^ (createtime >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (int) (regionflag ^ (regionflag >>> 32));
        result = 31 * result + (int) (status ^ (status >>> 32));
        result = 31 * result + (int) (ordervalue ^ (ordervalue >>> 32));
        result = 31 * result + (int) (appVersion ^ (appVersion >>> 32));
        result = 31 * result + (int) (osVersion ^ (osVersion >>> 32));
        return result;
    }
}
