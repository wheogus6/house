package com.wheogus.house.domain;

import java.util.Date;
import java.util.Objects;

public class CalendarDto {

    private String week;

    public CalendarDto() {

    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "CalendarDto{" +
                "week='" + week + '\'' +
                '}';
    }

    public CalendarDto(String week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarDto that = (CalendarDto) o;
        return Objects.equals(week, that.week);
    }

    @Override
    public int hashCode() {
        return Objects.hash(week);
    }
}
