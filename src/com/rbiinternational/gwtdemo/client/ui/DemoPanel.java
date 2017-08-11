package com.rbiinternational.gwtdemo.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rbiinternational.gwtdemo.client.GreetingService;
import com.rbiinternational.gwtdemo.client.GreetingServiceAsync;
import com.rbiinternational.gwtdemo.client.ui.MessagePanel.MessageType;
import com.rbiinternational.gwtdemo.client.ui.i18n.TextBundle;

public class DemoPanel extends Composite {

	private static DemoPanelUiBinder uiBinder = GWT.create(DemoPanelUiBinder.class);

	interface DemoPanelUiBinder extends UiBinder<Widget, DemoPanel> {
	}

	@UiField
	Button button;

	@UiField
	TextBox textBox;

	/*@UiField
	Label label;*/

	@UiField
	Image busyImage;

	@UiField
	MessagePanel messagePanel;

	public DemoPanel() {
		initWidget(uiBinder.createAndBindUi(this));

		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				busyImage.setVisible(true);

				messagePanel.clearMessage();

				GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
				greetingService.sendData(textBox.getText(), new AsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {

						messagePanel.setMessage(result, MessageType.INFO);
//						label.setText(result);
//						label.setVisible(true);

						busyImage.setVisible(true);

					}

					@Override
					public void onFailure(Throwable caught) {

						messagePanel.setMessage(TextBundle.INSTANCE.msgErrorMessage(textBox.getText()), MessageType.ERROR);

						/*label.setText(TextBundle.INSTANCE.msgErrorMessage(textBox.getText()));
						label.setVisible(true);*/

						busyImage.setVisible(true);

					}
				});
			}
		});
	}
}
