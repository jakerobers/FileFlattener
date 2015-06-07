package com.jakerobers.flatten;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

public class Window extends JFrame {

	private static final long serialVersionUID = 136944921041511059L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Directory Flattener");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 439, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(6, 80, 438, 192);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnChooseDirectory = new JButton("Choose Directory");
		btnChooseDirectory.setBounds(6, 6, 139, 29);
		panel_1.add(btnChooseDirectory);
		
		JLabel lblsomedirectory = new JLabel("<html>&#47;Some&#47;Directory</html>");
		lblsomedirectory.setVerticalAlignment(SwingConstants.TOP);
		lblsomedirectory.setBounds(16, 47, 416, 29);
		panel_1.add(lblsomedirectory);
		
		JRadioButton rdbtnModifyCurrentDirectory = new JRadioButton("Modify Directory");
		rdbtnModifyCurrentDirectory.setBounds(6, 88, 139, 23);
		panel_1.add(rdbtnModifyCurrentDirectory);
		
		JRadioButton rdbtnCreateDuplicate = new JRadioButton("Create Duplicate");
		rdbtnCreateDuplicate.setBounds(171, 88, 141, 23);
		panel_1.add(rdbtnCreateDuplicate);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnModifyCurrentDirectory);
		group.add(rdbtnCreateDuplicate);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(6, 157, 139, 29);
		panel_1.add(btnGo);
		
		JLabel lblIAmNot = new JLabel("<html>I am not responsible for lost files. Make backups first!</html>");
		lblIAmNot.setForeground(Color.RED);
		lblIAmNot.setBounds(239, 154, 193, 32);
		panel_1.add(lblIAmNot);
		
		
		goButtonAL(btnGo, group);
		fileChooserAL(btnChooseDirectory, lblsomedirectory);
	}
	
	private void goButtonAL(JButton go, ButtonGroup group) {
		go.addActionListener(e -> {
			System.out.println(e.getSource().toString());
		});
	}
	
	private void fileChooserAL(JButton fileChooser, JLabel fileDisplay) {
		fileChooser.addActionListener(e -> {
			System.out.println(e.getSource().toString());
		});
	}
	
}
