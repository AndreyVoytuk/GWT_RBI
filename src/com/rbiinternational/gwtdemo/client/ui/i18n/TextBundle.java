package com.rbiinternational.gwtdemo.client.ui.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

public interface TextBundle extends Messages {
	public static final TextBundle INSTANCE = GWT.create(TextBundle.class);

	String labelName();
    String labelNameTextboxValue();
    String actionSendButton();
    String msgErrorMessage(String value);

}
