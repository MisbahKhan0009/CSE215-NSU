package application;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;

public class Main extends Application {
	 Button btn;
	 Label lbl;
	 int iClickCount =0;
	@Override public void start(Stage primaryStage) 
	{
		btn = new Button();
		btn.setText("Click Here Please!");
		btn.setFont(new Font("Arial",50));
		btn.setOnAction(e->buttonClick());
		
		lbl = new Label();
		lbl.setText("You have not clicked yet");
		lbl.setFont(new Font("Arial",60));
		
		BorderPane pane = new BorderPane();
		pane.setTop(lbl);
		pane.setCenter(btn);
		
		Scene scene = new Scene(pane, 900, 900);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My counter App");
		primaryStage.show();
		
	}
	public void buttonClick() 
	{
		
		if(iClickCount%2==0)
		{
			//lbl.setText("You have clicked once ");
			iClickCount++;
			lbl.setText("incremented");
		}
		else
		{
			//lbl.setText("You have clicked "+ iClickCount+" times");
			iClickCount--;
			lbl.setText("decremented");
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
