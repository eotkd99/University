package data;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckBox;

public class Professor {
	
	private String  ProfessorNum, ProfessorName, ProfessorClass , ProfessorRnum;
	private String Id,Password="";
	private CheckBox check;
	private List<Lecture> mylList = new ArrayList<>();

	public Professor(String professorNum, String professorName, String ProfessorClass,
                String professorRnum,String Id,String Passwd, CheckBox check) {
		this.ProfessorNum = professorNum;
		this.ProfessorName = professorName;
		this.ProfessorClass = ProfessorClass;
		this.ProfessorRnum = professorRnum;
		this.Id = Id;
		this.check =check;
		this.Password=Passwd;
	}
	public String getProfessorNum() {
		return ProfessorNum;
	}
	public void setProfessorNum(String professorNum) {
		this.ProfessorNum = professorNum;
	}
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		this.ProfessorName = professorName;
	}
	public String getProfessorClass() {
		return ProfessorClass;
	}
	public void setProfessorClass(String ProfessorClass) {
		this.ProfessorClass = ProfessorClass;
	}
	public String getProfessorRnum() {
		return ProfessorRnum;
	}
	public void setProfessorRnum(String professorRnum) {
		this.ProfessorRnum = professorRnum;
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

