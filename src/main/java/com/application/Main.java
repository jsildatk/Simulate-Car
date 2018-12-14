package com.application;
	
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.application.controller.MotionController;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
	
	private void runTask() {
		exec.scheduleAtFixedRate(new Runnable() {
			  @Override
			  public void run() {
			    MotionController.engineBrake();
			  }
			}, 0, 100, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			Scene scene = new Scene(root,1280,720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.getRoot().requestFocus();
			primaryStage.getIcons().add(new Image(Main.class.getResource("images/icon.png").toExternalForm()));
			primaryStage.setScene(scene);
			primaryStage.setTitle("Need For Speed");
			primaryStage.setFullScreen(true);
			primaryStage.show();
			runTask();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() {
		exec.shutdown();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
