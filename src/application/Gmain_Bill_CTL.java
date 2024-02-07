package application;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ResourceBundle;

import data.Lecture;
import data.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Gmain_Bill_CTL implements Initializable {

	@FXML
	private StackPane Gmain_3;
	@FXML
	private Button Gmain_3_1, Gmain_3_2;
	@FXML
	private TableColumn<Lecture, CheckBox> check;
	@FXML
	private TableView<Student> tableView1;
	@FXML
	private TableColumn<Student, String> studentName, studentNum, studentClass, studentRnum, LectScore;
	@FXML
	private TableView<Lecture> tableView2;
	@FXML
	private TableColumn<Lecture, String> LectureNum, LectureName, LectureDepartment, LectureSnum, LectureProfessor,
			LectureScore;

	public static void textInput(String str) throws IOException {
		FileOutputStream output = new FileOutputStream("Student_Bill.txt", false);
		OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
		BufferedWriter out = new BufferedWriter(writer);
		out.write(str);
		out.close();
	}

	public void renew() {
		list1.removeAll(list1);
		list2.removeAll(list2);
		for (int i = 0; i < DataList.sList.size(); i++) {
			for (int j = 0; j < DataList.sList.get(i).getMylList().size(); j++) {
				for (int k = 0; k < DataList.lList.size(); k++) {
					if (DataList.sList.get(i).getMylList().get(j).getLectureName().equals(DataList.lList.get(k).getLectureName())) {
						list1.add(DataList.sList.get(i));
						list2.add(DataList.sList.get(i).getMylList().get(j));
					}
				}
			}
		}
	}
	public void popup(String txt) throws IOException {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		Parent p = FXMLLoader.load(getClass().getResource("popup.fxml"));
		Label txtTitle = (Label) p.lookup("#txt");
		txtTitle.setText(txt);
		Button buttok = (Button) p.lookup("#OK");
		buttok.setOnAction(ee -> dialog.close());
		Scene s = new Scene(p);
		dialog.setScene(s);
		dialog.setResizable(false);
		dialog.show();
	}
	ObservableList<Student> list1 = FXCollections.observableArrayList();
	ObservableList<Lecture> list2 = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		renew();
		studentName.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));
		studentNum.setCellValueFactory(new PropertyValueFactory<Student, String>("studentNum"));
		studentClass.setCellValueFactory(new PropertyValueFactory<Student, String>("studentClass"));
		studentRnum.setCellValueFactory(new PropertyValueFactory<Student, String>("studentRnum"));
		LectScore.setCellValueFactory(new PropertyValueFactory<Student, String>("LectScore"));
		check.setCellValueFactory(new PropertyValueFactory<Lecture, CheckBox>("check"));
		tableView1.setItems(list1);

		LectureName.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureName"));
		LectureNum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureNum"));
		LectureDepartment.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureDepartment"));
		LectureSnum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureSnum"));
		LectureProfessor.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureProfessor"));
		LectureScore.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureScore"));
		tableView2.setItems(list2);
	}

	public void Gmain_3_Fun1(ActionEvent event) throws IOException {
		
		for (int i = 0; i < tableView1.getItems().size(); i++) {
			String str=null;
			if (tableView1.getItems().get(i).getCheck().isSelected()) {
				str="학번:" + DataList.sList.get(i).getStudentNum() + "\n"
				+"이름 : " + DataList.sList.get(i).getStudentName() + "\n"
				+"학과 : " + DataList.sList.get(i).getStudentClass() + "\n"
				+"주민등록번호 : " + DataList.sList.get(i).getStudentRnum() + "\n";
				for (int j = 0; j < DataList.sList.get(i).getMylList().size(); j++) {
					str += "강좌번호 : " + DataList.sList.get(i).getMylList().get(j).getLectureNum() + "\n"
					+"강좌이름 : " + DataList.sList.get(i).getMylList().get(j).getLectureName() + "\n"
					+"담당학과 : " + DataList.sList.get(i).getMylList().get(j).getLectureDepartment() + "\n"
					+"담당교수 : " + DataList.sList.get(i).getMylList().get(j).getLectureProfessor() + "\n"
					+"학점 : " + DataList.sList.get(i).getMylList().get(j).getLectureSnum() + "\n"
					+"성적 : " + DataList.sList.get(i).getMylList().get(j).getLectureScore() + "\n";
				}
				str+="신청학점 : " + DataList.sList.get(i).getLectScore() + "\n";
				textInput(str);
				popup("청구서 발급 완료");
			}

		}
	}

	public void Gmain_3_Fun2(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Gmain_3_1.getScene().getRoot();
		root.getChildren().remove(Gmain_3);
	}
}
