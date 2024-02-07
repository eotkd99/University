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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Pmain_StudentList_CTL implements Initializable {
	@FXML
	private StackPane Pmain_2;
	@FXML
	private Button Pmain_2_1, Pmain_2_2, Pmain_2_3, Pmain_2_4, Pmain_2_5;
	@FXML
	private TableView<Student> tableView1;
	@FXML
	private TableView<Lecture> tableView2;
	@FXML
	private TableColumn<Student, String> studentNum, studentName, studentClass;
	@FXML
	private TableColumn<Lecture, String> LectureScore, LectureName;
	@FXML
	private TableColumn<Student, CheckBox> check;
	@FXML
	private TextField inSearch, inStudentName, inStudentNum, inStudentClass, inLectureScore;

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
		studentNum.setCellValueFactory(new PropertyValueFactory<Student, String>("studentNum"));
		studentName.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));
		studentClass.setCellValueFactory(new PropertyValueFactory<Student, String>("studentClass"));
		check.setCellValueFactory(new PropertyValueFactory<Student, CheckBox>("check"));
		tableView1.setItems(list1);

		LectureName.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureName"));
		LectureScore.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureScore"));
		tableView2.setItems(list2);
	}

	public void Pmain_2_Fun1(ActionEvent event) throws IOException {

		if ((inLectureScore.getText().equals("A") == true) 
				|| (inLectureScore.getText().equals("B") == true)
				|| (inLectureScore.getText().equals("C") == true) 
				|| (inLectureScore.getText().equals("D") == true)
				|| (inLectureScore.getText().equals("F") == true)) {
			String str = null;
			for (int i = 0; i < tableView1.getItems().size(); i++) {
				if (tableView1.getItems().get(i).getCheck().isSelected()) {
					str = list1.get(i).getStudentName();
				}
			}
			for (int i = 0; i < DataList.sList.size(); i++) {
				for (int j = 0; j < DataList.sList.get(i).getMylList().size(); j++) {
					if (str.equals(DataList.sList.get(i).getStudentName())) {
						DataList.sList.get(i).getMylList().get(j).setLectureScore(inLectureScore.getText());
					}
				}
			}
			renew();
			popup("성적 입력 완료");
		
		} else {
			popup("A,B,C,D,F(4.0~0.0)중 하나를 입력해주세요.");
		}
	}

	public void Pmain_2_Fun2(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Pmain_2_2.getScene().getRoot();
		root.getChildren().remove(Pmain_2);
	}
}
