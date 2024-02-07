package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.util.Duration;

public class StaticFunc {
	
	public static void animation(Parent p) {	//전역 함수
		p.setTranslateX(400);
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(p.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(200), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

}
