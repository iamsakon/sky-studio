package com.sky.studio.ui;

import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("skystudio")
public class WelcomeVaadinUI extends UI {
	
	Navigator navigator;
    protected static final String MAINVIEW = "main";
	


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
		
		// Create a navigator to control the views
        navigator = new Navigator(this, this);
		// Create and register the views
        navigator.addView("", new StartView());
        navigator.addView("main", new MainView());
	}

}
