package com.sky.studio.ui;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;

@SuppressWarnings("serial")
@Theme("skystudio")
public class WelcomeVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = WelcomeVaadinUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Page.getCurrent().setTitle("SKY-STUDIO");
		
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
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		
		ComboBox projectCombobox = new ComboBox("--Please select project--");
		
		layout.addComponent(new Label("Session id : " + sessionId));
		layout.addComponent(new Label("baseDir : " + baseDir.getAbsolutePath()));
		
		layout.addComponent(welcomeLabel);
		layout.addComponent(detailLabel);
		layout.addComponent(emptyLine);
		layout.addComponent(projectCombobox);
		layout.addComponent(button);
	}

}
