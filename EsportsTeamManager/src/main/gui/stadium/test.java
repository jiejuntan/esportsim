package main.gui.stadium;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea txtrDwqdqwdDwqdqwd = new JTextArea();
		txtrDwqdqwdDwqdqwd.setWrapStyleWord(true);
		txtrDwqdqwdDwqdqwd.setLineWrap(true);
		txtrDwqdqwdDwqdqwd.setText("dwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd\r\ndwqdqwd");
		frame.getContentPane().add(txtrDwqdqwdDwqdqwd, BorderLayout.CENTER);
	}

}
