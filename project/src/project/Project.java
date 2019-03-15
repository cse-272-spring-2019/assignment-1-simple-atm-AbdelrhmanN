package project;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField; 
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class Project{
    Homescreen homescreen;
	Scene scene;
	Login login = new Login();
	Stage stage;
	public Project(Stage stage) {
		this.stage = stage;
		
	}

    public void prepareScene() {
    	Label username = new Label("Enter Username : ");
        Label password = new Label("Enter Password : ");
        username.setFont(new Font(20));
        password.setFont(new Font(20));
        TextField usernameField = new TextField(); 
        PasswordField passwordField = new PasswordField();
        Button Login = new Button("Login");
        Label validation = new Label();
        GridPane grid = new GridPane();
        grid.add(username, 0,0);
        grid.setVgap(10);
        grid.add(password, 0, 1);
        grid.setHgap(20);
        grid.add(usernameField,1, 0);
        grid.add(passwordField, 1, 1);
        grid.add(Login, 1, 2);
        grid.add(validation, 1, 3);
        Login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username=usernameField.getText();
                String password=passwordField.getText();
                boolean valid = login.validte(username, password);
                if (valid) {
                	validation.setText("Welcome Mr "+ username);
                    
                	stage.setScene(homescreen.getScene());
                	
                }else {
                	validation.setText("Wrong User name Or Password");
                }
            }
               
        });
      
        scene = new Scene(grid,400,300);  
    }
    

       public Scene getScene() {
    	   return this.scene;
    	   
       }


	public void setHomescreen(Homescreen homescreen) {
		this.homescreen = homescreen;
	}



       
       
  }