package com.wheogus.house.domain;

import java.util.Date;
import java.util.Objects;


public class MinusDto {

    private Integer minusM;
    private String mid;
    private String content;
    private String md;

    public MinusDto(Integer minusM, String mid, String content, String md) {
        this.minusM = minusM;
        this.mid = mid;
        this.content = content;
        this.md = md;
    }

    public Integer getMinusM() {
        return minusM;
    }

    public void setMinusM(Integer minusM) {
        this.minusM = minusM;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinusDto minusDto = (MinusDto) o;
        return Objects.equals(minusM, minusDto.minusM) && Objects.equals(mid, minusDto.mid) && Objects.equals(content, minusDto.content) && Objects.equals(md, minusDto.md);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minusM, mid, content, md);
    }

    @Override
    public String toString() {
        return "MinusDto{" +
                "minusM=" + minusM +
                ", mid='" + mid + '\'' +
                ", content='" + content + '\'' +
                ", md=" + md +
                '}';
    }
}
