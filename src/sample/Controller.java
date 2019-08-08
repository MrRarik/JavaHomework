package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

import java.io.File;

public class Controller {
    @FXML
    public TextArea textArea;
    @FXML
    public TextField textFiled;

    //Добавил музыку.
    Media sound = new Media(new File("C:\\Users\\User\\IdeaProjects\\Homework_4\\src\\Blacklite_District_-_Believing_the_Hype_(musicport.org).mp3").toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public void enterMSG(ActionEvent actionEvent) {
        textArea.appendText(textFiled.getText() + "\n");

        if ("/play music".equals(textFiled.getText())) mediaPlayer.play(); //включение музыки
        if ("/stop music".equals(textFiled.getText())) mediaPlayer.stop(); //остановить музыку

        textFiled.setText("");
    }
}
