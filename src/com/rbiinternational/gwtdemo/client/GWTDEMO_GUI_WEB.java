package com.rbiinternational.gwtdemo.client;

import org.apache.commons.lang3.StringUtils;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.rbiinternational.gwtdemo.client.ui.DemoPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTDEMO_GUI_WEB implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		DemoPanel demoPanel = new DemoPanel();

		RootPanel.get().add(demoPanel);

		Anchor anchor = new Anchor("TutorialsPoint", false, "http://www.tutorialspoint.com", "_blank");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.add(anchor);

		RootPanel.get().add(horizontalPanel);

		// create a push button
		PushButton pushButton = new PushButton("Click Me!");

		// create a push button
		PushButton pushButton1 = new PushButton("Click Me 2");

		// add a clickListener to the push button
		pushButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Hello World!");
			}
		});

		pushButton1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.confirm("Go away!!");

			}
		});

		// Add push buttons to the root panel.
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(20);
		panel.add(pushButton);
		panel.add(pushButton1);
		RootPanel.get().add(panel);

		// Make a new check box, and select it by default.
		CheckBox checkBox1 = new CheckBox("Check Me!");
		CheckBox checkBox2 = new CheckBox("Check Me!");

		// set check box as selected
		checkBox1.setValue(true);

		// disable a checkbox
		// checkBox2.setEnabled(false);

		checkBox1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				CheckBox checkBox = (CheckBox) event.getSource();
				Window.alert("CheckBox is " + (checkBox.getValue() ? "" : "not") + " checked" + checkBox.getName());
			}
		});

		// Add checkboxes to the root panel.
		panel.setSpacing(10);
		panel.add(checkBox1);
		panel.add(checkBox2);

		RootPanel.get().add(panel);

		// Make a new list box, adding a few items to it.
		ListBox listBox1 = new ListBox();
		listBox1.addItem("First");
		listBox1.addItem("Second");
		listBox1.addItem("Third");
		listBox1.addItem("Fourth");
		listBox1.addItem("Fifth");

		// Make a new list box, adding a few items to it.
		ListBox listBox2 = new ListBox();
		listBox2.addItem("First");
		listBox2.addItem("Second");
		listBox2.addItem("Third");
		listBox2.addItem("Fourth");
		listBox2.addItem("Fifth");

		// Make enough room for all five items
		listBox1.setVisibleItemCount(5);

		// setting itemcount value to 1 turns listbox into a drop-down list.
		// listBox2.setVisibleItemCount(1);

		panel.setSpacing(10);
		panel.add(listBox1);
		panel.add(listBox2);

		// create the suggestion data
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		oracle.add("A");
		oracle.add("AB");
		oracle.add("ABC");
		oracle.add("ABCD");
		oracle.add("B");
		oracle.add("BC");
		oracle.add("BCD");
		oracle.add("BCDE");
		oracle.add("C");
		oracle.add("CD");
		oracle.add("CDE");
		oracle.add("CDEF");
		oracle.add("D");
		oracle.add("DE");
		oracle.add("DEF");
		oracle.add("DEFG");

		// create the suggestion box and pass it the data created above
		SuggestBox suggestionBox = new SuggestBox(oracle);
		// set width to 200px.
		suggestionBox.setWidth("200");

		panel.add(suggestionBox);

		TextBox textBox = new TextBox();
		textBox.setText("Hi dev");
		textBox.setReadOnly(true);

		panel.add(textBox);

		PasswordTextBox passwordTextBox = new PasswordTextBox();
		panel.add(passwordTextBox);

		final FormPanel formPanel = new FormPanel();
		final FileUpload fileUpload = new FileUpload();

		Label selectLabel = new Label("Select a file:");
		Button uploadButton = new Button("Upload file");

		formPanel.setAction("http://www.tutorialspoint.com/gwt/myFormHandler");
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);

		panel.add(selectLabel);
		panel.add(fileUpload);
		panel.add(uploadButton);

		uploadButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String filename = fileUpload.getFilename();
				if (filename.length() == 0) {
					Window.alert("No file here");
				} else {
					formPanel.submit();
				}
			}
		});

		formPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {

			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				Window.alert(event.getResults());

			}
		});


		////////////////  Tree Widget  ////////
		new TreeItem("");

	}
}
