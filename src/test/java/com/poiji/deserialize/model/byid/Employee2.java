package com.poiji.deserialize.model.byid;

import com.poiji.annotation.ExcelCell;

import java.util.Date;

public class Employee2 {
    @ExcelCell(0)
    protected long employeeId;

    @ExcelCell(1)
    protected String name = "";

    @ExcelCell(2)
    protected String surname;

    @ExcelCell(3)
    protected Integer age;

    @ExcelCell(4)
    protected boolean single;

    @ExcelCell(5)
    protected Date birthday;

    @ExcelCell(6)
    private double rate;

    @ExcelCell(7)
    private Date date;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "employeeId=" + employeeId
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", single=" + single
                + ", birthday='" + birthday + '\''
                + ", rate=" + rate
                + ", date=" + date
                + '}';

    }
}
