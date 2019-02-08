package com.coding.journal;

import java.util.ArrayList;

public class Journal {

    private String subject;
    private String teacher;
    private String courseType;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Journal(String subject, String teacher, String courseType) {
        this.subject = subject;
        this.teacher = teacher;
        this.courseType = courseType;
    }

    public Journal() {
    }



    public static ArrayList<Journal> getTestingDatas() {
        ArrayList<Journal> list = new ArrayList<>();
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));
        list.add(new Journal("History", "Kraman M.D.", "common"));

        return list;
    }
}
