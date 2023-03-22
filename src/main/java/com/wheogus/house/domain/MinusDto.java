package com.wheogus.house.domain;

import java.util.Date;
import java.util.Objects;


public class MinusDto {

    private Integer money;
    private String id;
    private String content;
    private String d;
    private  Integer mno;

    public MinusDto(Integer money, String id, String content, String d, Integer mno) {
        this.money = money;
        this.id = id;
        this.content = content;
        this.d = d;
        this.mno = mno;
    }

    @Override
    public String toString() {
        return "MinusDto{" +
                "money=" + money +
                ", id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", d='" + d + '\'' +
                ", mno=" + mno +
                '}';
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Integer getMno() {
        return mno;
    }

    public void setMno(Integer mno) {
        this.mno = mno;
    }
}
