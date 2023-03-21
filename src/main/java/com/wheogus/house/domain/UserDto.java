package com.wheogus.house.domain;

import java.util.Date;
import java.util.Objects;

public class UserDto {

    private String id;
    private String pwd;
    private Integer total;



    public UserDto() {}

    public UserDto(String id, String pwd, Integer total) {
        this.id = id;
        this.pwd = pwd;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(pwd, userDto.pwd) && Objects.equals(total, userDto.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pwd, total);
    }
}
