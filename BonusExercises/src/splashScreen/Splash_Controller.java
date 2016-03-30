package splashScreen;

public class Splash_Controller extends Controller<Splash_Model, Splash_View> {
	
	public Splash_Controller(final StartChating main, Splash_Model model, Splash_View view) {
		super (model, view);
		
		view.progress.progressProperty().bind(model.initializer.progressProperty());
		
	}

}
