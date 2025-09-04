package iuh.fit.se.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
public class LocalDateCustom {
    private int year;
    private int month;
    private int day;

    @JsonIgnore
    public LocalDate getLocalDate() {
        return LocalDate.of(year, month, day);
    }

    public void setLocalDate(LocalDate localDate) {
        this.year = localDate.getYear();
        this.month = localDate.getMonthValue();
        this.day = localDate.getDayOfMonth();
    }

    public LocalDateCustom(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static LocalDateCustom of(int year, int month, int day) {
        return new LocalDateCustom(year, month, day);
    }

    public static LocalDateCustom of(LocalDate localDate) {
        return LocalDateCustom.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }

    public static LocalDateCustom now() {
        LocalDate now = LocalDate.now();
        return LocalDateCustom.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
    }

    public static int compareYear(LocalDateCustom date1, LocalDateCustom date2) {
        return (int) ChronoUnit.YEARS.between(date1.getLocalDate(), date2.getLocalDate());
    }

    public static int compareMonth(LocalDateCustom date1, LocalDateCustom date2) {
        return (int) ChronoUnit.MONTHS.between(date1.getLocalDate(), date2.getLocalDate());
    }

    public static int compareDay(LocalDateCustom date1, LocalDateCustom date2) {
        return (int) ChronoUnit.DAYS.between(date1.getLocalDate(), date2.getLocalDate());
    }
}
