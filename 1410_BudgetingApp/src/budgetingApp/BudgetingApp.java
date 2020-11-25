package budgetingApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BudgetingApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BudgetingApp frame = new BudgetingApp();
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
	public BudgetingApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = createBudgetButton();
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = uploadBudgetButton();
		contentPane.add(btnNewButton);
	}

	/**
	 * This method creates the upload button. The actionListener will create a new Jframe that will 
	 * run the upload class.
	 * @return
	 */
	private JButton uploadBudgetButton() {
		JButton btnNewButton = new JButton("Upload New Budget");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UploadBudget upload = new UploadBudget();
				upload.setVisible(true);
				
			}
		});
		return btnNewButton;
	}

	
	/**
	 * This method creates the create button. The actionListener will create a new Jframe that will 
	 * run the CreateBudget class.
	 * @return
	 */
	private JButton createBudgetButton() {
		JButton btnNewButton_1 = new JButton("Create New Budget");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreateBudget create = new CreateBudget();
				create.setVisible(true);
				
			}
		});
		return btnNewButton_1;
	}
}
