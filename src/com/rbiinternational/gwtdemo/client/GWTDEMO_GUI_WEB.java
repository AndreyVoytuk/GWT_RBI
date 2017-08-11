package com.rbiinternational.gwtdemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
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
	}
}
