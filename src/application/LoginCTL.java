package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginCTL implements Initializable {
	@FXML
	private Button submit, passwordChangeSubmit, prevButt;
	@FXML
	private StackPane pwdWindow;
	@FXML
	private TextField ID, PASSWORD;
	@FXML
	private TextField oldPasswd, newPasswd1, newPasswd2;
	
	private String userHeadId;//아이디 첫문자
	private static String userId;//사용자 아이디
	private static String userPasswd;// 사용자 패스워드
	public static int userIndex = 0;// 사용자 인덱스(리스트 탐색 시 사용)
	
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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void loginSubmit(ActionEvent event) throws IOException {
		if (ID.getText().equals("")) {
			popup("입력값을 확인해주세요.");
		} else {
		userHeadId = (ID.getText()).substring(0, 1);
		userId = (ID.getText());
		userPasswd = (PASSWORD.getText());

		if (userHeadId.equals("H")) {
			for (int i = 0; i < DataList.hList.size(); i++) {
				if (userId.equals(DataList.hList.get(i).getId())
						&& userPasswd.equals(DataList.hList.get(i).getPassword())) {
					Parent login = FXMLLoader.load(getClass().getResource("Hmain.fxml"));
					StackPane root = (StackPane) submit.getScene().getRoot();
					root.getChildren().add(login);
					StaticFunc.animation(login);
					userIndex = i;
					break;
				}else {
					popup("아이디가 없거나 비밀번호가 올바르지 않습니다.");
				}
			}
		} else if (userHeadId.equals("G")) {
			for (int i = 0; i < DataList.gList.size(); i++) {
				if (userId.equals(DataList.gList.get(i).getId())
						&& userPasswd.equals(DataList.gList.get(i).getPassword())) {
					Parent login = FXMLLoader.load(getClass().getResource("Gmain.fxml"));
					StackPane root = (StackPane) submit.getScene().getRoot();
					root.getChildren().add(login);
					StaticFunc.animation(login);
					userIndex = i;
					break;
				}else {
					popup("아이디가 없거나 비밀번호가 올바르지 않습니다.");
				}
			}
		} else if (userHeadId.equals("P")) {
			for (int i = 0; i < DataList.pList.size(); i++) {
				if (userId.equals(DataList.pList.get(i).getProfessorNum())
						&& userPasswd.equals(DataList.pList.get(i).getPassword())) {
					Parent login = FXMLLoader.load(getClass().getResource("Pmain.fxml"));
					StackPane root = (StackPane) submit.getScene().getRoot();
					root.getChildren().add(login);
					StaticFunc.animation(login);
					userIndex = i;
					break;
				}else {
					popup("아이디가 없거나 비밀번호가 올바르지 않습니다.");
				}
			}
		} else if (userHeadId.equals("S")) {
			for (int i = 0; i < DataList.sList.size(); i++) {
				if (userId.equals(DataList.sList.get(i).getStudentNum())
						&& userPasswd.equals(DataList.sList.get(i).getPassword())) {
					Parent login = FXMLLoader.load(getClass().getResource("Smain.fxml"));
					StackPane root = (StackPane) submit.getScene().getRoot();
					root.getChildren().add(login);
					StaticFunc.animation(login);
					userIndex = i;
					break;
				}else {
					popup("아이디가 없거나 비밀번호가 올바르지 않습니다.");
				}
			}
		}else {
			popup("아이디가 없거나 비밀번호가 올바르지 않습니다.");
		}
		}
	}

	public void passwordChangeSubmitFun(ActionEvent event) {
		try {
			if ((oldPasswd.getText()).equals(userPasswd)) {
				if((newPasswd1.getText()).equals(newPasswd2.getText())) {
				String A = userId.substring(0, 1);

				if (A.equals("H")) {
					DataList.hList.get(userIndex).setPassword(newPasswd1.getText());
					StackPane root = (StackPane) prevButt.getScene().getRoot();
					root.getChildren().remove(pwdWindow);popup("비밀번호 변경 완료");
				} else if (A.equals("G")) {
					DataList.gList.get(userIndex).setPassword(newPasswd1.getText());
					StackPane root = (StackPane) prevButt.getScene().getRoot();
					root.getChildren().remove(pwdWindow);popup("비밀번호 변경 완료");
				} else if (A.equals("P")) {
					DataList.pList.get(userIndex).setPassword(newPasswd1.getText());
					StackPane root = (StackPane) prevButt.getScene().getRoot();
					root.getChildren().remove(pwdWindow);popup("비밀번호 변경 완료");
				} else if (A.equals("S")) {
					DataList.sList.get(userIndex).setPassword(newPasswd1.getText());
					StackPane root = (StackPane) prevButt.getScene().getRoot();
					root.getChildren().remove(pwdWindow);popup("비밀번호 변경 완료");
				}
				}else {
					popup("새 비밀번호가 동일하지 않습니다.");
				}
			}else {
				popup("비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prevButtFun(ActionEvent event) {
		try {
			StackPane root = (StackPane) prevButt.getScene().getRoot();
			root.getChildren().remove(pwdWindow);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}