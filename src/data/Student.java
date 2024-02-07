package data;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckBox;

public class Student {
	private String  studentNum, studentName, studentClass , studentRnum; 
	private int LectScore=0;
	private String Id, Password="";
	private CheckBox check;

	private List<Lecture> mylList = new ArrayList<>();
	
	public Student(String studentNum, String studentName, String studentClass, 
                String studentRnum ,String Id, String Passwd, CheckBox check) {
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentRnum = studentRnum;
		this.Id = Id;
		this.Password=Passwd;
		this.check = check;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentRnum() {
		return studentRnum;
	}

	public void setStudentRnum(String studentRnum) {
		this.studentRnum = studentRnum;
	}

	public CheckBox getCheck() {
		return check;
	}

	public void setCheck(CheckBox check) {
		this.check = check;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getLectScore() {
		return LectScore;
	}

	public void setLectScore(int lectScore) {
		if(lectScore > 0) {
			LectScore += lectScore;
		}else {
			LectScore -= lectScore;
		}
	}

	public List<Lecture> getMylList() {
		return mylList;
	}

	public void setMylList(Lecture l) {
		mylList.add(l);
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	

}
