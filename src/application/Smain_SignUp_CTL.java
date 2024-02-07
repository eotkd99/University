package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.Lecture;
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

public class Smain_SignUp_CTL implements Initializable {

	@FXML
	private StackPane Smain_2;
	@FXML
	private Button Smain_2_1, Smain_2_2, Smain_2_3;
	@FXML
	private TableView<Lecture> tableView;
	@FXML
	private TableColumn<Lecture, String> LectureNum, LectureName, LectureDepartment, LectureSNum, LectureDes,
			LectureProfessor, LecturePersonNum, LectureMAX;
	@FXML
	private TableColumn<Lecture, CheckBox> check;
	@FXML
	private TextField inSearch, myScore;

	public void renew() {
		list.removeAll(list);
		for (int i = 0; i < DataList.lList.size(); i++) {
			if ((DataList.lList.get(i).getLectureOPEN().equals("O"))) {
				list.add(DataList.lList.get(i));
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

	ObservableList<Lecture> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		renew();
		String str = Integer.toString(DataList.sList.get(LoginCTL.userIndex).getLectScore());
		myScore.setText(str + "/18");
		LectureNum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureNum"));
		LectureName.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureName"));
		LectureDepartment.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureDepartment"));
		LectureSNum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureSnum"));
		LectureDes.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureDes"));
		LectureProfessor.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureProfessor"));
		LecturePersonNum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LecturePersonNum"));
		LectureMAX.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureMAX"));
		check.setCellValueFactory(new PropertyValueFactory<Lecture, CheckBox>("check"));

		tableView.setItems(list);
	}

	public boolean SameCheck(String str) {
		boolean s = false;
		for (int i = 0; i < DataList.sList.get(LoginCTL.userIndex).getMylList().size(); i++) {
			if ((DataList.sList.get(LoginCTL.userIndex).getMylList().get(i).getLectureNum()).equals(str)) {
				s = true;
			}
		}
		return s;
	}

	public void Smain_2_Fun1(ActionEvent event) throws IOException {

		for (int i = 0; i < tableView.getItems().size(); i++) {
			CheckBox cb = new CheckBox();
			if (tableView.getItems().get(i).getCheck().isSelected()) {
				if ((DataList.sList.get(LoginCTL.userIndex).getLectScore()
						+ Integer.parseInt(tableView.getItems().get(i).getLectureSnum())) <= 18) {
					boolean check;
					check = SameCheck(tableView.getItems().get(i).getLectureNum());
					if (check == false) {
						if (Integer.parseInt(tableView.getItems().get(i).getLecturePersonNum()) < Integer
								.parseInt(tableView.getItems().get(i).getLectureMAX())) {
							DataList.sList.get(LoginCTL.userIndex)
									.setMylList(new Lecture(tableView.getItems().get(i).getLectureNum(),
											tableView.getItems().get(i).getLectureName(),
											tableView.getItems().get(i).getLectureDepartment(),
											tableView.getItems().get(i).getLectureSnum(),
											tableView.getItems().get(i).getLectureDes(),
											tableView.getItems().get(i).getLectureProfessor(), "", "", "", "", "", cb));
							for (int k = 0; k < DataList.lList.size(); k++) {
								if (DataList.lList.get(k).getLectureNum()
										.equals(tableView.getItems().get(i).getLectureNum())) {
									DataList.lList.get(k).setLecturePersonNum(1);
								}
							}
							DataList.sList.get(LoginCTL.userIndex).setLectScore(3);
							myScore.setText(DataList.sList.get(LoginCTL.userIndex).getLectScore() + "/18");
							popup("수강 신청 완료.");
						} else {
							popup("해당 강좌의 최대 인원수를 초과하여 신청할 수 없습니다.");
							break;
						}

					} else {
						popup("동일한 강좌을 중복으로 신청할 수 없습니다.");
						break;
					}
				} else {
					popup("18학점을 초과할 수 없습니다.");
					break;
				}
			}
		}
		renew();
	}

	public void Smain_2_Fun2(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Smain_2_2.getScene().getRoot();
		root.getChildren().remove(Smain_2);
	}

	public void Smain_2_Fun3(ActionEvent event) throws IOException {
		if (inSearch.getText().equals("")) {
			renew();
		} else {
			list.removeAll(list);
			for (int i = 0; i < DataList.lList.size(); i++) {
				if (DataList.lList.get(i).getLectureNum().equals(inSearch.getText())) {
					list.add(DataList.lList.get(i));
				}
			}
		}
	}
}
