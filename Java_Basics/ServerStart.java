package server_application;



public class ServerStart {
		private static View view;
	    private static Model model;
	    private static Controller controller;
	    
		public static void main(String[] args) {
			 // Create the MVC objects
	        model = new Model();
	        view = new View(model);
	        controller = new Controller(model, view);
	}
}