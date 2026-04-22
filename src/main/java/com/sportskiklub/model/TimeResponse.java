package com.sportskiklub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class TimeResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String timeZone;
    public String dateTime;
    public String date;
    public String time;
    public String dayOfWeek;
    public boolean dstActive;
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public int seconds;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igrac_id")
    private Igrac igrac;

    public TimeResponse() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTimeZone() { return timeZone; }
    public void setTimeZone(String timeZone) { this.timeZone = timeZone; }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public boolean isDstActive() { return dstActive; }
    public void setDstActive(boolean dstActive) { this.dstActive = dstActive; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }

    public int getMinute() { return minute; }
    public void setMinute(int minute) { this.minute = minute; }

    public int getSeconds() { return seconds; }
    public void setSeconds(int seconds) { this.seconds = seconds; }

    public Igrac getIgrac() { return igrac; }
    public void setIgrac(Igrac igrac) { this.igrac = igrac; }

    @Override
    public String toString() {
        return "TimeResponse{" +
                "timeZone='" + timeZone + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }
}