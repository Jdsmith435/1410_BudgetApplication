package budgetingApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

public class BudgetJFrame extends JFrame implements ActionListener {

	JPanel panelCont = new JPanel();
	JPanel panelMain = new JPanel();
	JPanel panelUpload = new JPanel();
	JPanel panelPlan1 = new JPanel();
	JPanel panelPlan2 = new JPanel();
	JPanel panelOutPut = new JPanel();
	
	String filePath;

	//	Main Menu	
	JLabel mainTitle = new JLabel("Budgeting App");
	JButton buttonMakeProfile = new JButton("Make New Profile");
	JButton buttonUploadMenu = new JButton("Upload File");

	//	Upload Menu	
	JLabel uploadTitle = new JLabel("Upload A Text File");
	JButton buttonUploadB2Main = new JButton("Back to Main Menu");
	JButton buttonUploadAddFile = new JButton("Add File");

	//	Create Budget Menu (panelPlan1)
	JLabel budget1Title = new JLabel("Create a Budget (p1)");
	JButton button1Back2Main = new JButton("Back to Main Menu");
	JButton button1Next = new JButton("Next");

	// Budget Categorizing (panelPlan2)
	JLabel budget2Title = new JLabel("Budget Categorization (p2)");
	JButton button2Back = new JButton("Back");
	JButton button2Next = new JButton("Next");

	// Budget Output (panelOutPut)	
	JLabel outPutTitle = new JLabel("Budget OutPut");
	JButton buttonOutPutRtnMain = new JButton("Return to Main Menu");
	JButton buttonOutPutBack = new JButton("Back");
	JButton buttonExportOutPut = new JButton("Export");

	CardLayout cl = new CardLayout();

	JFileChooser fileChooser = new JFileChooser();



	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BudgetJFrame frame = new BudgetJFrame();
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
	public BudgetJFrame() {

		buttonUploadAddFile.addActionListener(e -> {selectFile();});

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		//		contentPane = new JPanel();
		panelCont.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelCont);
		panelCont.setLayout(new CardLayout(0, 0));

		// 		JPanel panel = new JPanel();
		//		panelCont.add(panel, "name_21198427104456");
		//		panel.setLayout(new GridLayout(3, 1, 0, 0));


		panelCont.setLayout(cl);

		//	Main Menu		
		panelMain.setLayout(new GridLayout(3, 1, 0, 0));
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelMain.add(mainTitle);
		panelMain.add(buttonMakeProfile);
		panelMain.add(buttonUploadMenu);


		//	Upload Menu		
		panelUpload.setLayout(new GridLayout(3, 1, 0, 0));
		uploadTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelUpload.add(uploadTitle);
		panelUpload.add(buttonUploadB2Main);
		panelUpload.add(buttonUploadAddFile);

		//		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		//		int result = fileChooser.showOpenDialog(this);


		//	Create Budget Menu (panelPlan1)
		panelPlan1.setLayout(new GridLayout(3, 1, 0, 0));
		panelPlan1.add(budget1Title);
		panelPlan1.add(button1Back2Main);
		panelPlan1.add(button1Next);

		JRadioButton option1 = new JRadioButton ("Profile 1");
		JRadioButton option2 = new JRadioButton ("Profile 2");
		JRadioButton option3 = new JRadioButton ("Profile 3");

		ButtonGroup group = new ButtonGroup();
		group.add(option1);
		group.add(option2);
		group.add(option3);

		panelPlan1.add(option1);
		panelPlan1.add(option2);
		panelPlan1.add(option3);

		// Budget Categorizing (panelPlan2)
		panelPlan2.setLayout(new GridLayout(3, 1, 0, 0));
		panelPlan2.add(budget2Title);
		panelPlan2.add(button2Back);
		panelPlan2.add(button2Next);



		// Budget Output (panelOutPut)	
		panelOutPut.setLayout(new GridLayout(4, 1, 0, 0));
		panelOutPut.add(outPutTitle);
		panelOutPut.add(buttonOutPutBack);
		panelOutPut.add(buttonOutPutRtnMain);
		panelOutPut.add(buttonExportOutPut);

		//	Add panels to Container Card		
		panelCont.add(panelMain, "1");
		panelCont.add(panelUpload, "2");
		panelCont.add(panelPlan1, "3");
		panelCont.add(panelPlan2, "4");
		panelCont.add(panelOutPut, "5");



		//	Startup panel
		cl.show(panelCont, "1");


		//		int result = fileChooser.showOpenDialog(this);


		//	Button Action Listeners		
		buttonMakeProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "3");
			}
		});

		buttonUploadMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "2");
				//				
				//				if(e.getActionCommand().equals("Add File")) {
				//				 JFileChooser chooser = new JFileChooser();
				//		         File f = chooser.getSelectedFile();
				//				}
			}
		});

		buttonUploadB2Main.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");

			}
		});

		buttonUploadMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "2");
				//				
				//				if(e.getActionCommand().equals("Add File")) {
				//				 JFileChooser chooser = new JFileChooser();
				//		         File f = chooser.getSelectedFile();
				//				}
			}
		});



		buttonUploadAddFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {


				//				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				//				int result = fileChooser.showOpenDialog(this);
				//				if (result == JFileChooser.APPROVE_OPTION) {
				//				    File selectedFile = fileChooser.getSelectedFile();
				//				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				//				}
			}
		});

		button1Back2Main.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});

		button1Next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "4");
			}
		});

		button2Back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "3");
			}
		});

		button2Next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "5");
			}
		});

		buttonOutPutBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "4");
			}
		});

		buttonOutPutRtnMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});

	}


	//		
	//		
	//		
	//		JButton btnNewButton_1 = new JButton("Create New Plan");
	//		btnNewButton_1.addActionListener(new ActionListener() {
	//			public void actionPerformed(ActionEvent e) {
	//			}
	//		});
	//		
	//		JLabel lblNewLabel = new JLabel("Budgeting App");
	//		panel.add(lblNewLabel);
	//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	//		panel.add(btnNewButton_1);
	//		
	//		
	//		
	//		JButton btnNewButton = new JButton("Upload File");
	//		btnNewButton.addActionListener(new ActionListener() {
	//			public void actionPerformed(ActionEvent e) {
	//			}
	//		});
	//		panel.add(btnNewButton);
	//		
	//		
	//		
	//		btnNewButton.addActionListener(this);



	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("Upload File")) {

			cl.show(panelCont, "2");


			//			CardLayout cl = new CardLayout(0,0);
			//			JPanel panel = new JPanel();
			//			contentPane.add(panel, "name_21198427104456");
			//			panel.setLayout(new GridLayout(3, 1, 0, 0));
			//			cl.show(getParent(), "cl");;


		}
	}

	public void selectFile() {
		JFileChooser chooser = new JFileChooser();
		try{

			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
				this.filePath = f.getAbsolutePath();
				
				if(filePath.contains(".csv")) {
				//Just working on a file check system
				}
			}
			else {

			}
		}catch ( IllegalArgumentException ex) {
			System.err.println("File type must be a .csv file");
		}

	}
}
