package budgetingApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class BudgetJFrame extends JFrame implements ActionListener {

	File f;
	
	JPanel panelCont = new JPanel();
	JPanel panelMain = new JPanel();
	JPanel panelUpload = new JPanel();
	JPanel panelPlan1 = new JPanel();
	JPanel panelPlan2 = new JPanel();
	JPanel panelOutPut = new JPanel();
	JPanel panelUpFile = new JPanel();

	//File path for input file
	String filePath;

	//budget options
	int necessary, savings, entertainment, debt; 
	
	//When user uploads file then adds new expenses
	List<String> newExpenses = new ArrayList<String>();
	
	//budget options as percentages
	double perNec;
	double perSav;
	double perEnt;
	double perDebt;

	//	Main Menu	
	JLabel mainTitle = new JLabel("Budgeting App");
	JButton buttonMakeProfile = new JButton("Make New Profile");
	JButton buttonUploadMenu = new JButton("Upload File");

	//	Upload Menu	
	JLabel uploadTitle = new JLabel("Upload A Text File");
	JButton buttonUploadB2Main = new JButton("Back to Main Menu");
	JButton buttonUploadAddFile = new JButton("Add File");
	
	//Uploaded File Menu
	JLabel uploadedFile = new JLabel(filePath);
	JTextField addExpenses = new JTextField("Enter new Expenses /n ex. 40.45");
	JButton addUserExp = new JButton("Add");
	JButton exportAll = new JButton("Export");

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
		
		//Display Uploaded file
		panelUpFile.setLayout(new GridLayout(3, 1, 0, 0));
		uploadedFile.setHorizontalAlignment(SwingConstants.CENTER);
		panelUpFile.add(addExpenses);
		panelUpFile.add(addUserExp);
		panelUpFile.add(exportAll);
		
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
		panelCont.add(panelUpFile, "6");
		

		//	Startup panel
		cl.show(panelCont, "1");

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
			}
		});



		buttonUploadAddFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
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

		addUserExp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				newExpenses.add(addUserExp.getText());
				addExpenses.setText("");
			}
		});
		
		exportAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//File export with new Budget
				ToFile tf = new ToFile();
				tf.toFile(f, newExpenses);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("Upload File")) {

			cl.show(panelCont, "2");
		}
	}

	/**
	 * Opens file chooser and creates a stream for that file in the system
	 */
	public void selectFile() {
		try  
		{  
			JFileChooser chooser = new JFileChooser();
			if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
				f = chooser.getSelectedFile();		//constructor of file class having file as argument 
				filePath = f.getAbsolutePath();
				cl.show(panelCont, "6");
			}
		}
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
	}
}
