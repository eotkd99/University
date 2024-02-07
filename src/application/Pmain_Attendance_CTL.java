package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.Lecture;
import data.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class Pmain_Attendance_CTL implements Initializable {

	@FXML
	private StackPane Pmain_3;
	@FXML
	private Button Pmain_3_1;
	@FXML
	private TableView<Student> tableView1;
	@FXML
	private TableColumn<Student, String> studentName,studentNum;
	@FXML
	private TableView<Lecture> tableView2;
	@FXML
	private TableColumn<Lecture, String> LectureName,LectureScore;
	
	
	public void renew() {
		list1.removeAll(list1);
		list2.removeAll(list2);
		for (int i = 0; i < DataList.sList.size(); i++) {
			for (int j = 0; j < DataList.sList.get(i).getMylList().size(); j++) {
				for (int k = 0; k < DataList.pList.get(LoginCTL.userIndex).getMylList().size(); k++) {
					if (DataList.sList.get(i).getMylList().get(j).getLectureName()
                                                .equals(DataList.pList.get(LoginCTL.userIndex).getMylList().get(k).getLectureName())) {
						list1.add(DataList.sList.get(i));
						list2.add(DataList.sList.get(i).getMylList().get(j));
					}
				}
			}
		}
	}

	ObservableList<Student> list1 = FXCollections.observableArrayList();
	ObservableList<Lecture> list2 = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		renew();
		studentName.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));
		studentNum.setCellValueFactory(new PropertyValueFactory<Student, String>("studentNum"));
		tableView1.setItems(list1);
		
		LectureName.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureName"));
		LectureScore.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureScore"));
		tableView2.setItems(list2);
	}

	public void Pmain_3_Fun1(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Pmain_3_1.getScene().getRoot();
		root.getChildren().remove(Pmain_3);
	}
}
