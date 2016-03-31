package abstractClasses;

public abstract class Controller<M, V> {

	protected M model;
	protected V view;
	
	protected Controller(M model, V view) {
		this.model = model;
		this.view = view;
	}
}
