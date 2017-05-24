package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI{
	public static void init(){
		JFrame ui = new JFrame(vars.Constants.botName);
		JButton shutdownButton = new JButton("Shutdown");
		JLabel statusLabel = new JLabel("Online");
		JPanel pane = new JPanel();
		
		vars.Handlers.ui = ui;
		vars.Handlers.uiOnlineStatus = statusLabel;
		
		ui.add(pane);
		pane.add(shutdownButton);
		pane.add(statusLabel);
		
		shutdownButton.addActionListener(uiComponents.ShutdownButton.action);
		
		ui.pack();
		ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ui.setVisible(true);
	}
}
