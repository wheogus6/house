package com.wheogus.house.domain;

public class PlusDto {

    private Integer money;

    private String id;

    private String content;

    private String d;

    private Integer pno;

    public PlusDto(Integer money, String id, String content, String d, Integer pno) {
        this.money = money;
        this.id = id;
        this.content = content;
        this.d = d;
        this.pno = pno;
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

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }

    @Override
    public String toString() {
        return "PlusDto{" +
                "money=" + money +
                ", id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", d='" + d + '\'' +
                ", pno=" + pno +
                '}';
    }
}
