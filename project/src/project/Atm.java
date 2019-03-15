package project;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Atm extends Application {
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		Project project = new Project(primaryStage);
		Homescreen homescreen=new Homescreen(primaryStage);
		project.prepareScene();
		homescreen.homeScreen();
		project.setHomescreen(homescreen);
		primaryStage.setTitle("Atm");
		
	        primaryStage.setScene(project.getScene());
	        
	       primaryStage.show();
	        
		
	}
	

}
