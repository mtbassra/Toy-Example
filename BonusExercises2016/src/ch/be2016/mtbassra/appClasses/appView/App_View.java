package ch.be2016.mtbassra.appClasses.appView;

import java.util.Locale;
import java.util.logging.Logger;

import ch.be2016.mtbassra.abstractClasses.View;
import ch.be2016.mtbassra.appClasses.appModel.App_Model;
import ch.be2016.mtbassra.commonClasses.ServiceLocator;
import ch.be2016.mtbassra.commonClasses.Translator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */
public class App_View extends View<App_Model> {
    Menu menuFile;
    Menu menuFileLanguage;
    Menu menuHelp;
    
    private Label lblNumber;
    private Button btnClick;

	public App_View(Stage stage, App_Model model) {
        super(stage, model);
        stage.setTitle("JavaFX Application Template");
        
        ServiceLocator.getServiceLocator().getLogger().info("Application view initialized");
    }

	@Override
	protected Scene create_GUI() {
	    ServiceLocator sl = ServiceLocator.getServiceLocator();  
	    Logger logger = sl.getLogger();
	    Translator t = sl.getTranslator();
	    
	    MenuBar menuBar = new MenuBar();
	    menuFile = new Menu(t.getString("program.menu.file"));
	    menuFileLanguage = new Menu(t.getString("program.menu.file.language"));
	    menuFile.getItems().add(menuFileLanguage);
	    
       for (Locale locale : sl.getLocales()) {
           MenuItem language = new MenuItem(locale.getLanguage());
           menuFileLanguage.getItems().add(language);
           language.setOnAction( event -> {
                   sl.setTranslator(new Translator(locale.getLanguage()));
                   updateTexts();
            });
        }
	    
        menuHelp = new Menu(t.getString("program.menu.help"));
	    menuBar.getMenus().addAll(menuFile, menuHelp);
		
		GridPane root = new GridPane();
		root.add(menuBar, 0, 0);
		
		setLblNumber(new Label());
        getLblNumber().setText(Integer.toString(model.getValue()));
        getLblNumber().setMinWidth(200);
        getLblNumber().setAlignment(Pos.BASELINE_CENTER);
        root.add(getLblNumber(), 0, 1);
        
        setBtnClick(new Button());
        getBtnClick().setText(t.getString("button.clickme"));
        getBtnClick().setMinWidth(200);
        root.add(getBtnClick(), 0, 2);
		
        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("app.css").toExternalForm());
        return scene;
	}
	
	   protected void updateTexts() {
	       Translator t = ServiceLocator.getServiceLocator().getTranslator();
	        
	        // The menu entries
	       menuFile.setText(t.getString("program.menu.file"));
	       menuFileLanguage.setText(t.getString("program.menu.file.language"));
           menuHelp.setText(t.getString("program.menu.help"));
	        
	        // Other controls
           getBtnClick().setText(t.getString("button.clickme"));
	    }

	public Button getBtnClick() {
		return btnClick;
	}

	public void setBtnClick(Button btnClick) {
		this.btnClick = btnClick;
	}

	public Label getLblNumber() {
		return lblNumber;
	}

	public void setLblNumber(Label lblNumber) {
		this.lblNumber = lblNumber;
	}
}