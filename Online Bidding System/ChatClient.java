package com.rgt.training.session2basics.networking;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.net.SocketFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatClient extends JFrame {

	private static final String SERVER_ADDRESS = "localhost";

	private static final int SERVER_PORT = 8888;

	private final JTextArea chatTextArea = new JTextArea(20, 40);

	private final JTextField messageTextField = new JTextField(40);
	private final JTextField messagerName = new JTextField(40);

	private ObjectOutputStream output;

	private ObjectInputStream input;
	
	private JButton b ;

	public ChatClient() {

		JPanel mainPanel = new JPanel();

		chatTextArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(chatTextArea);

		mainPanel.add(scrollPane);

		mainPanel.add(messageTextField);

		messageTextField.addActionListener(e -> {
			try {
				sendMessage();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		b = new JButton("refresh");
		b.setBounds(50,100,60,30); 
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					reFresh();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); 
		mainPanel.add(b);

		this.setContentPane(mainPanel);

		this.pack();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("RGT Chat App");

		this.setVisible(true);

	}

	public void start() throws IOException {

		SocketFactory socketFactory = SocketFactory.getDefault();

		Socket socket = socketFactory.createSocket(SERVER_ADDRESS, SERVER_PORT);

		System.out.println("Connected to chat server");

		List<String> readString = Files.readAllLines(Paths.get("test.txt"));

		for (String string : readString) {
			String[] split = string.split(",");
			for (int i = 0; i < split.length; i++) {
				String text = chatTextArea.getText();
				String string3 = split[i];
				chatTextArea.setText(text.concat("\n" + split[i]));
			}
		}

		output = new ObjectOutputStream(socket.getOutputStream());

		input = new ObjectInputStream(socket.getInputStream());

		new Thread(new MessageReceiver()).start();

	}

	private void reFresh() throws IOException {
		List<String> readString = Files.readAllLines(Paths.get("test.txt"));
		chatTextArea.setText("");
		for (String string : readString) {
			String[] split = string.split(",");
			for (int i = 0; i < split.length; i++) {
				String text = chatTextArea.getText();
				chatTextArea.setText(text.concat("\n" + split[i]));
			}
		}
	}

	private void sendMessage() throws IOException {
		List<String> readString = Files.readAllLines(Paths.get("test.txt"));
		PrintWriter writer = new PrintWriter(new File("test.txt"));
		StringBuilder builder = new StringBuilder();
		String message = messageTextField.getText();
		String text = chatTextArea.getText();
		if (text.isEmpty()) {
			chatTextArea.setText(message);
		} else {
			chatTextArea.setText(text.concat("\n" + message));
		}
		messageTextField.setText("");
		messagerName.setText("");
		try {
			output.writeObject(message);

			for (String string : readString) {
				String value = string.substring(string.indexOf(":") + 1);
				builder.append(value);
			}

			builder.append("," + message);
			writer.println(builder.toString());
			writer.close();
			reFresh();
			output.flush();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	private class MessageReceiver implements Runnable {

		@Override
		public void run() {

			try {

				while (true) {

					String message = (String) input.readObject();

					System.out.println("Received message: " + message);

					SwingUtilities.invokeLater(() -> chatTextArea.append(message + "\n"));

				}

			} catch (IOException | ClassNotFoundException e) {
				System.out.println("Connection closed by server");
			}

		}

	}

	public static void main(String[] args) {

		try {

			ChatClient client = new ChatClient();

			client.start();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}