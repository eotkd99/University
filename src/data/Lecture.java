package data;

import javafx.scene.control.CheckBox;

public class Lecture {
    private String LectureNum, LectureName, LectureDepartment, LectureSnum, LectureDes, LectureProfessor, LectureScore, LectureMIN, LectureMAX, LectureOPEN, LecturePersonNum;
    private CheckBox check;
    public Lecture(String lectureNum, String lectureName, String lectureDepartment, String lectureSnum, String lectureDes, String lectureProfessor,
            String lectureScore, String LectureMIN, String LectureMAX, String LectureOPEN, String LecturePersonNum, CheckBox check) {
        LectureNum = lectureNum;
        LectureName = lectureName;
        LectureDepartment = lectureDepartment;
        LectureSnum = lectureSnum;
        LectureDes = lectureDes;
        LectureProfessor = lectureProfessor;
        LectureScore = lectureScore;
        this.LectureMIN = LectureMIN;
        this.LectureMAX = LectureMAX;
        this.LectureOPEN = LectureOPEN;
        this.LecturePersonNum = LecturePersonNum;
        this.check = check;
    }
    public String getLectureNum() { 
        return LectureNum;
    }
    public void setLectureNum(String lectureNum) {
        LectureNum = lectureNum;
    }
    public String getLectureName() {
        return LectureName;
    }
    public void setLectureName(String lectureName) {
        LectureName = lectureName;
    }
    public String getLectureDepartment() {
        return LectureDepartment;
    }
    public void setLectureDepartment(String lectureDepartment) {
        LectureDepartment = lectureDepartment;
    }
    public String getLectureSnum() {
        return LectureSnum;
    }
    public void setLectureSnum(String lectureSnum) {
        LectureSnum = lectureSnum;
    }
    public String getLectureDes() {
        return LectureDes;
    }
    public void setLectureDes(String lectureDes) {
        LectureDes = lectureDes;
    }
    public String getLectureProfessor() {
        return LectureProfessor;
    }
    public void setLectureProfessor(String lectureProfessor) {
        LectureProfessor = lectureProfessor;
    }
    public String getLectureScore() {
        return LectureScore;
    }
    public void setLectureScore(String lectureScore) {
        LectureScore = lectureScore;
    }
    public CheckBox getCheck() {
        return check;
    }
    public void setCheck(CheckBox check) {
        this.check = check;
    }
    public String getLectureMIN() {
        return LectureMIN;
    }
    public void setLectureMIN(String lectureMIN) {
        LectureMIN = lectureMIN;
    }
    public String getLectureMAX() {
        return LectureMAX;
    }
    public void setLectureMAX(String lectureMAX) {
        LectureMAX = lectureMAX;
    }
    public String getLectureOPEN() {
        return LectureOPEN;
    }
    public void setLectureOPEN(String lectureOPEN) {
        LectureOPEN = lectureOPEN;
    }
    public String getLecturePersonNum() {
        return LecturePersonNum;
    }
    public void setLecturePersonNum(int num) {
        int n = Integer.parseInt(LecturePersonNum) + num;
        String to_st;
        to_st = Integer.toString(n);
        LecturePersonNum = to_st;
    }
}
