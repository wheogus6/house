package com.wheogus.house.domain;

public class PlusDto {

    private Integer plusM;

    private String pid;

    private String content;

    private String pd;

    public PlusDto(Integer plusM, String pid, String content, String pd) {
        this.plusM = plusM;
        this.pid = pid;
        this.content = content;
        this.pd = pd;
    }

    public Integer getPlusM() {
        return plusM;
    }

    public void setPlusM(Integer plusM) {
        this.plusM = plusM;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    @Override
    public String toString() {
        return "PlusDto{" +
                "plusM=" + plusM +
                ", pid='" + pid + '\'' +
                ", content='" + content + '\'' +
                ", pd='" + pd + '\'' +
                '}';
    }
}
