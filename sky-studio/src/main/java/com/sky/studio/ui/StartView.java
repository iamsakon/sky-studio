package com.sky.studio.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

@SuppressWarnings("serial")
public class StartView extends VerticalLayout implements View {

	public StartView() {
        setSizeFull();

        Button button = new Button("Go to Main View",
                new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
            	getUI().getNavigator().navigateTo("main");
            	//UI.getCurrent().getNavigator().navigateTo("foobar");
            }
        });
        
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome to the SKY STUDIO 1.0");
	}

}
