package project;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField; 
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class Homescreen {
	Logic logic=new Logic(500);
	Project project;
	Scene scene,Depositscene,Withdrawsceen,Confirmscene,Confirmscene1,Balancescene;
	Stage stage;
	int b=0,maxIndex=0;
	
	public Homescreen(Stage stage) {
		this.stage=stage;
	}
	public void homeScreen (){
		Label L1 = new Label("Enter your Choice :");
		L1.setFont(new Font(20));
		Label trans = new Label();
		Button Deposite = new Button("Deposite");
		Button Withdraw = new Button("Withdraw");
		Button Balance = new Button("Balance");
		Button Previous = new Button("Previous");
		Button Next = new Button("next");
		GridPane Grid1 = new GridPane();
		Grid1.add(L1, 0, 1);
		Grid1.add(Deposite, 0, 2);
		Grid1.add(Withdraw, 0, 3);
		Grid1.add(Balance, 0, 4);
		Grid1.add(Next, 0, 5);
		Grid1.add(Previous, 1, 5);
		Grid1.add(trans,0,6);
		
	
		
	/////////////////////////////////////Deposit///////////////////////////////////////////////
		Label L2 = new Label("Deposite");
		Label validation2 = new Label();
		L2.setFont(new Font(20));
		TextField submitFiled = new TextField();
		Button p1 = new Button("Previous");
		Button p2 = new Button("Comfirm");
		GridPane Grid2= new GridPane();
		Grid2.add(L2, 1, 1);
		Grid2.add(validation2,0 ,3 );
		Grid2.setHgap(10);
		Grid2.add(submitFiled, 2, 1);
		Grid2.setVgap(20);
		Grid2.add(p1,1 , 2);
		Grid2.setHgap(20);
		Grid2.add(p2, 2, 2);
		Depositscene = new Scene(Grid2,400,200);
		
		
		
		
		 Deposite.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				stage.setScene(Depositscene);
	
				
				
				}
			
		});
		
		 ////////////// Action of deposit confirm //////////
		 
		Label L3 = new Label("Your New Balance is: ");
		L3.setFont( new Font(20));
		L3.setTextFill(Color.web("#0076a0"));
		Button P5= new Button("Other Services");
		GridPane grid2 =new GridPane();
		grid2.setVgap(20);
		grid2.add(L3, 1, 1);
		grid2.setVgap(20);
		grid2.add(P5, 1, 2);
		Confirmscene = new Scene(grid2,300,200);
		Label L4 = new Label();
		grid2.add(L4, 2, 1);
		p2.setOnAction(new EventHandler<ActionEvent>() {    //Confirm Action
			
			@Override
			public void handle(ActionEvent event) {
				String amount = submitFiled.getText();
				double x;
				if (logic.stringChecker(amount)){
					x = Double.parseDouble(amount);
					logic.Deposit(x);
					logic.saveTransactions("Deposited : "+amount+"$ ");
					validation2.setVisible(false);
					System.out.println("Your Balance is "+logic.getBalance());
					L4.setText(""+logic.getBalance());
					L4.setVisible(true);
					L4.setFont(new Font(20));
					stage.setScene(Confirmscene);
				}else {
//					Alert alert = new Alert(Alert.AlertType.ERROR);
//					alert.setContentText("Amount greater than balance !!");
//					alert.show();
					validation2.setVisible(true);
					validation2.setText("Error!!");
                    validation2.setFont(new Font(20));
				}
				
				
				
			
				} 
		});
		
		//////////////////////////////// End of Deposit////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////previous///////////
		
		p1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				stage.setScene(scene);
				
			}
		});
		
		/////////////////////////////////Otherservice Action///////////////////////////////////////

		
		//Button P5= new Button("other Services");
		
		P5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				L4.setVisible(false);
				stage.setScene(scene);
				
			}
		});
		
		
		
		
		//////////////////////////////////Withdraw///////////////////////////////////////////////////
		 Label L5 = new Label("WithDraw");
		 Label validation = new Label();
		 L5.setFont(new Font(20));
		 L5.setTextFill(Color.web("#0076a0"));
			TextField Value = new TextField();
			Button p3 = new Button("Previous");
			Button p4 = new Button("Confirm");
			GridPane Grid3= new GridPane();
			Grid3.add(validation,0 ,3 );
			Grid3.add(L5, 0, 1);
			Grid3.setHgap(10);
			Grid3.add(Value, 1, 1);
			Grid3.setVgap(20);
			Grid3.add(p3,0 , 2);
			Grid3.setHgap(20);
			Grid3.add(p4, 1, 2);
			Withdrawsceen = new Scene(Grid3,400,200); 
			
		Withdraw.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
		
				stage.setScene(Withdrawsceen);
			
			}
		});
		
	////////////////////////////////////////Action of Withdraw confirm//////////////////////////////////////////////////////////////	
		
		Label L6 = new Label("Your New Balance is : ");
		L6.setFont( new Font(20));
		L6.setTextFill(Color.web("#0076a0"));
		GridPane grid3 =new GridPane();
		grid3.setVgap(20);
		grid3.add(L6, 1, 1);
		P5.setVisible(true);
		L4.setText(""+logic.getBalance());
		
		Confirmscene1 = new Scene(grid3,300,200);
		
		p4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				//stage.setScene(Confirmscene1);
				String amount =Value.getText();
				double y=Double.parseDouble(amount);
				if (logic.stringChecker(amount)&&logic.validate(y))
				{
					
					logic.validate(y);
					logic.saveTransactions("Withdrawed : "+amount+"$ ");
					validation.setVisible(false);
					System.out.println("Your Balance is "+logic.getBalance());
					L4.setText(""+logic.getBalance());
					L4.setFont(new Font(20));
					L4.setVisible(true);
				stage.setScene(Confirmscene);
				}else {
//					Alert alert = new Alert(Alert.AlertType.ERROR);
//					alert.setContentText("Amount greater than balance !!");
//					alert.show();
					validation.setVisible(true);
					validation.setText("Error!!");
                    validation.setFont(new Font(20));

				}
				
				
				
				
				
				
			}
		});
		///////////////////////////////////////////End Of Withdraw///////////////////////////////////////////////////////////////////
		
		
		//////////////////////////////////////////////////////previous 2 ////////////////////////////////////////////////////////////
		
		p3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				stage.setScene(scene);
				
			}
		});
		
		
	///////////////////////////////////////Balance Button//////////////////////////////////////////////////////////////
		
		
		
		
		Balance.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Label L8 = new Label("Your Current Balance is : ");
				L8.setFont(new Font(20));
				L8.setTextFill(Color.web("#0076a0"));
				Button P6 = new Button("Other Services");
				Label L9 = new  Label(""+logic.getBalance());
				L9.setFont(new Font(20) );
				GridPane Grid4 = new GridPane();
				Grid4.add(L8, 1,1);
				Grid4.add(L9, 2, 1);
				Grid4.add(P6, 1, 2);
				//P5.setVisible(true);
				Balancescene = new Scene(Grid4,300,200);
				stage.setScene(Balancescene);
				P6.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent arg0) {
						stage.setScene(scene);
						
					}
				});
				
				
				
				
			}
		});
		
		
////////////////////////////////////////End of Balance////////////////////////////////////////////	
		
		
		
		
///////////////////////////////////////Next Button/////////////////////////////////////////////////
       Next.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent event) {
            	 b=logic.getB();
     			maxIndex=logic.getMaxIndex();
     			if (b==maxIndex){
     				trans.setText(logic.next());
     				Alert alert = new Alert(Alert.AlertType.WARNING);
     				alert.setContentText("Last history entry");
     				alert.show();
     			}else {
     				trans.setText(logic.next());
     			}

}
});////////////////////////////////////////End of Next////////////////////////////////////////	


///////////////////////////////////////Previous/////////////////////////////////////////////////
      Previous.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	          public void handle(ActionEvent event) {
	        	 b=logic.getB();
	 			maxIndex=logic.getMaxIndex();
	 			if (b==0){
	 				trans.setText(logic.previous());
	 				Alert alert = new Alert(Alert.AlertType.WARNING);
	 				alert.setContentText("First history entry");
	 				alert.show();
	 			}else {
	 				trans.setText(logic.previous());
	 			}
		
	}
});
      /////////////////////// end of Previous/////////////////////////////////////////////////////////////////////////
      
      scene = new Scene(Grid1,400,200);

	}
	
 public Scene getScene() {
	return scene;

}

public void setProject(Project project) {
	this.project = project;
}
 
 }

