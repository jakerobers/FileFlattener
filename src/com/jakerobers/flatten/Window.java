package com.jakerobers.flatten;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

public class Window extends JFrame {

	private static final long serialVersionUID = 136944921041511059L;
	private JPanel contentPane;
	private JFileChooser fc;
	private File selectedDir;
	private Setting currentSetting;
	private enum Setting {MOVE, COPY};

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.fc = new JFileChooser();
		this.fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		JLabel lblNewLabel = new JLabel("Directory Flattener");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 439, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(6, 80, 438, 192);
		
		JLabel lblsomedirectory = new JLabel("Select a directory");
		lblsomedirectory.setFont(new Font("Arial", Font.PLAIN, 13));
		lblsomedirectory.setVerticalAlignment(SwingConstants.TOP);
		lblsomedirectory.setBounds(16, 47, 416, 29);
		panel_1.add(lblsomedirectory);
		
		JRadioButton rdbtnModifyCurrentDirectory = new JRadioButton("Modify Directory");
		rdbtnModifyCurrentDirectory.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnModifyCurrentDirectory.setBounds(6, 88, 153, 23);
		rdbtnModifyCurrentDirectory.addActionListener(e -> {
			this.currentSetting = Setting.MOVE;
		});
		panel_1.add(rdbtnModifyCurrentDirectory);
		
		JRadioButton rdbtnCreateDuplicate = new JRadioButton("Create Duplicate");
		rdbtnCreateDuplicate.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnCreateDuplicate.setBounds(199, 88, 170, 23);
		rdbtnCreateDuplicate.addActionListener(e -> {
			this.currentSetting = Setting.COPY;
		});
		panel_1.add(rdbtnCreateDuplicate);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnModifyCurrentDirectory);
		group.add(rdbtnCreateDuplicate);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnChooseDirectory = new JButton("Choose Directory");
		btnChooseDirectory.setFont(new Font("Arial", Font.PLAIN, 13));
		btnChooseDirectory.setBounds(6, 6, 160, 29);
		btnChooseDirectory.addActionListener(e -> {
			int retVal = this.fc.showDialog(this, "Select");
			if (retVal == JFileChooser.APPROVE_OPTION) {
                this.selectedDir = fc.getSelectedFile();
                lblsomedirectory.setText(this.selectedDir.toString());
            }
		});
		panel_1.add(btnChooseDirectory);
		
		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Arial", Font.PLAIN, 13));
		btnGo.setBounds(6, 157, 139, 29);
		btnGo.addActionListener(e -> {
			try {
				this.go();
			} catch (Exception e1) {
				showErrorMessage(this, e1.getMessage());
				e1.printStackTrace();
			}
		});
		panel_1.add(btnGo);
		
		JLabel lblIAmNot = new JLabel("<html>I am not responsible for lost files. Make backups first!</html>");
		lblIAmNot.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblIAmNot.setForeground(Color.RED);
		lblIAmNot.setBounds(162, 154, 270, 32);
		panel_1.add(lblIAmNot);
	}
	
	public void go() throws Exception {
		if ( this.currentSetting != null && this.selectedDir != null) {
			Flattener f;
			switch(this.currentSetting) {
				case MOVE:
					f = new MoveFlattener();
					f.move(this.selectedDir.getAbsolutePath());
					break;
				case COPY:
					f = new CopyFlattener();
					f.copy(this.selectedDir.getAbsolutePath());
					break;
				default: throw new Exception("A selection was not made.");
			}
		}
	}
	
	public void showErrorMessage(JFrame root, String message) {
		JOptionPane.showMessageDialog(root, message);
	}
}
