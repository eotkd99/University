package application;

import java.util.ArrayList;
import java.util.List;

import data.Lecture;
import data.Professor;
import data.Student;
import data.gManager;
import data.hManager;
import javafx.scene.control.CheckBox;

public class DataList { 
	public static List<Student> sList = new ArrayList<>();
	public static List<Professor> pList = new ArrayList<>();
	public static List<gManager> gList = new ArrayList<>();
	public static List<hManager> hList = new ArrayList<>(); 
	public static List<Lecture> lList = new ArrayList<>();	
	public static void dataIn() {

		sList.add(new Student("S001", "김대상", "컴퓨터소프트웨어", "123456-1234567","","", new CheckBox()));
		sList.add(new Student("S002", "김민승", "컴퓨터소프트웨어", "123456-1234567","","", new CheckBox()));
		sList.add(new Student("S003", "이수진", "컴퓨터소프트웨어", "123456-1234567","","", new CheckBox()));
		sList.add(new Student("S004", "안승해", "컴퓨터소프트웨어", "123456-1234567","","", new CheckBox()));
		sList.add(new Student("S005", "정재현", "컴퓨터소프트웨어", "123456-1234567","","", new CheckBox()));

		pList.add(new Professor("P001", "이다미", "전산학과", "123456-1234567","","", new CheckBox()));
		pList.add(new Professor("P002", "배서정", "전자공학과", "123456-1234567","","", new CheckBox()));
		pList.add(new Professor("P003", "노원석", "화학공학과", "123456-1234567","","", new CheckBox()));
		pList.add(new Professor("P004", "윤지원", "기계공학과", "123456-1234567","","", new CheckBox()));
		pList.add(new Professor("P005", "하지영", "항공우주공학과", "123456-1234567","","", new CheckBox()));
		pList.add(new Professor("P006", "허민석", "컴퓨터소프트웨어공학과", "123456-1234567","","", new CheckBox()));
		pList.add(new Professor("P007", "장민경", "신소재공학과", "123456-1234567","","", new CheckBox()));
		pList.add(new Professor("P008", "권병수", "경제학과", "123456-1234567","","", new CheckBox()));
		
		hList.add(new hManager("H001","1234"));
		gList.add(new gManager("G001","1234"));
		
		lList.add(new Lecture("L001","창의경영","전산학과","3","","","","","","","0",new CheckBox()));
		lList.add(new Lecture("L002","회로이론","전자공학과","3","","","","","","","0",new CheckBox()));
		lList.add(new Lecture("L003","유기화학","화학공학과","3","","","","","","","0",new CheckBox()));
		lList.add(new Lecture("L004","공업수학","기계공학과","3","","","","","","","0",new CheckBox()));
		lList.add(new Lecture("L005","항공기 구조역학","항공우주공학과","3","","","","","","","0",new CheckBox()));
		lList.add(new Lecture("L006","객체지향프로그래밍","컴퓨터소프트웨어공학과","3","","","","","","","0",new CheckBox()));
		lList.add(new Lecture("L007","물리화학Ⅱ","신소재공학과","3","","","","","","","0",new CheckBox()));
		lList.add(new Lecture("L008","미시경제원론","경제학과","3","","","","","","","0",new CheckBox()));	

	} 
}

