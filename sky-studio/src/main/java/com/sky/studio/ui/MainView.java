package com.sky.studio.ui;

import java.io.File;

import com.sky.studio.entity.ProjectEntity;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.VerticalLayout;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

//@DesignRoot
@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements View {

	private JPAContainer<ProjectEntity> projects = JPAContainerFactory.make(ProjectEntity.class,"skystudio");
	
	// Menu navigation button listener
    class ButtonListener implements Button.ClickListener {
        String menuitem;
        public ButtonListener(String menuitem) {
            this.menuitem = menuitem;
        }

        @Override
        public void buttonClick(ClickEvent event) {
            // Navigate to a specific state
        	getUI().getNavigator().navigateTo("main" + "/" + menuitem);
        }
    }
	
	VerticalLayout menuContent;
	
	public MainView() {
        //Design.read(this);
        menuContent = new VerticalLayout();
        menuContent.addComponent(new Button("Pig",
                new ButtonListener("pig")));
        
		// Set a session attribute
		String sessionId = VaadinSession.getCurrent().getSession().getId();
		
		// Access the HTTP service parameters
		File baseDir = VaadinService.getCurrent().getBaseDirectory();
		
		Label welcomeLabel = new Label("Welcome to Sky-Sutdio");
		Label detailLabel = new Label("The Sky-Sutdio is a Project management tool");
		Label emptyLine = new Label("");
		
		Button button = new Button("Create Project");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				addComponent(new Label("Thank you for clicking"));
			}
		});
		
		ComboBox projectCombobox = new ComboBox("--Please select project--",projects);
		projectCombobox.setItemCaptionPropertyId("name"); 
		
		addComponent(new Label("Session id : " + sessionId));
		addComponent(new Label("baseDir : " + baseDir.getAbsolutePath()));
		
		addComponent(welcomeLabel);
		addComponent(detailLabel);
		addComponent(emptyLine);
		addComponent(projectCombobox);
		addComponent(button);
        
        addComponent(menuContent);
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
