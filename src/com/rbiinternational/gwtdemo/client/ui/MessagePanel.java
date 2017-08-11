package com.rbiinternational.gwtdemo.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MessagePanel extends Composite {

	private static MessagePanelUiBinder uiBinder = GWT.create(MessagePanelUiBinder.class);

	interface MessagePanelUiBinder extends UiBinder<Widget, MessagePanel> {
	}

	enum MessageType {
		INFO, ERROR;
	}

	@UiField
	Label messageLabel;

	public MessagePanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setMessage(String message, MessageType type) {
		switch (type) {
		case INFO:
			messageLabel.getElement().getStyle().setColor("green");
			break;

		case ERROR:
			messageLabel.getElement().getStyle().setColor("red");
			break;
		}

		messageLabel.setText(message);
		this.setVisible(true);
	}

	public void clearMessage() {
		this.setVisible(false);
		messageLabel.setText("NULL");
	}


}
