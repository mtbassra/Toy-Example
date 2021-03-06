package ch.be.mtbassra.splashScreen;

import ch.be.mtbassra.Chat;
import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.Client;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;

public class Splash_Controller extends Controller<Splash_Model, Splash_View> {
	
	public Splash_Controller(final Chat main, Splash_Model model, Splash_View view) {
		super (model, view);
		
	
		
		//To monitor the progress property and pass it on to the progress bar
		//However, JavaFX can also do this for us: we just bind the progressProperty of the
		//progress bar to the progressProperty of the task.
		view.progress.progressProperty().bind(model.initializer.progressProperty());
		
		/*
		 * The statProperty tells us the status of the task. When the state is SUCCEEDED,
		 * the task is finished, so we tell the main program to continue.
		 */		
		//With lambda expression
		model.initializer.stateProperty().addListener(
				(observable, oldValue, newValue) -> {
					if(newValue == Worker.State.SUCCEEDED)
						main.startLoginView();
				});
		
	}

}
