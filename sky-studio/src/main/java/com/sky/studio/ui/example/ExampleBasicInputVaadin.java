/**
 * 
 */
package com.sky.studio.ui.example;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

/**
 * @author MrMai
 *
 */
@SuppressWarnings("serial")
@Theme("skystudio")
public class ExampleBasicInputVaadin extends UI {

	/* (non-Javadoc)
	 * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	 */
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		Page.getCurrent().setTitle("SKY-STUDIO -- Example");
	}

	private Label getLabelExample(){
		Label label = new Label();
		label.setCaption("This is an Label Example");
		return label;
	}
	
}
