import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Screen {
	
	public JFrame Mainframe;
	public static JTextField Inputfield1;
	public static JTextField Inputfield2;
	public static JTextField Inputfield3;
	public static JTextField Inputfield4;
	
	public JLabel messageJlabel1;
	public JLabel messageJlabel2;
	public JLabel messageJlabel3;
	public JLabel messageJlabel4;
	public JLabel messageJlabel5;
	public JLabel messageJlabel6;
	public JLabel messageJlabel7;
	public JLabel messageJlabel8;
	public JLabel messageJlabel9;
	public JLabel messageJlabel10;
	
	public JButton loginbutton;
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JButton button4;
	public JButton button5;
	public JButton Exit;
	
	public int accnum=0;
	public int pin=0;
	
	public void displayMessage(String message) {
		System.out.print(message);
	}

	public void displayMessageLine(String message) {
		System.out.println(message);
	}
	
	public void displayDollarAmount(double amount) {
		System.out.printf("$%,.2f", amount);
	}
	
	public void createLogin() {
		Mainframe = new JFrame("ATM");
		messageJlabel4 = new JLabel("Insert your credit/debit card then     ");
		messageJlabel1 = new JLabel("Enter your PIN number:    ");
		
		Inputfield1 = new JTextField(10);
		
		messageJlabel2 = new JLabel("");
		Inputfield2 = new JTextField(10);
		
		loginbutton = new JButton("Login");
		messageJlabel3 = new JLabel("");
		
		Mainframe.setLayout(new FlowLayout());
		Mainframe.add(messageJlabel4);
		Mainframe.add(messageJlabel1);
		
		Mainframe.add(Inputfield2);
		Mainframe.add(messageJlabel2);
		
		Mainframe.add(Inputfield3);
		Inputfield2.setEditable(false);
		Mainframe.repaint();
	}
	
	public void createMenu() {
		Mainframe.getContentPane().removeAll();
		messageJlabel1= new JLabel("welcome");
		messageJlabel2=new JLabel("1- Balance");
		messageJlabel3= new JLabel("2-Deposit");
		messageJlabel4= new JLabel("3- Deposit");
		messageJlabel5 = new JLabel("4- Exit");
		
		Mainframe.setLayout(new FlowLayout());
		
		Mainframe.add(messageJlabel1);
		Mainframe.add(messageJlabel2);
		Mainframe.add(messageJlabel3);
		Mainframe.add(messageJlabel4);
		Mainframe.add(messageJlabel5);
		Mainframe.repaint();
	}
	
	public void createBalanceGUI() {
		Mainframe.getContentPane().removeAll();
		messageJlabel1= new JLabel("Balance Information:    ");
		messageJlabel2= new JLabel("Available Balance");
		messageJlabel3= new JLabel("Total Balance");
		Exit = new JButton("Back");
		Mainframe.setLayout(new FlowLayout());
		Mainframe.add(messageJlabel1);
		Mainframe.add(messageJlabel2);
		Mainframe.add(messageJlabel3);
		Mainframe.add(Exit);
		Mainframe.repaint();
	}
	
	public void createWithdrawGUI() {
		Mainframe.getContentPane().removeAll();
		messageJlabel1 = new JLabel("Withdraw Menu:   ");
		messageJlabel2 = new JLabel("1 - $20");
		messageJlabel3 = new JLabel("1 - $40");
		messageJlabel4 = new JLabel("1 - $60");
		messageJlabel5 = new JLabel("1 - $100");
		messageJlabel6 = new JLabel("1 - $200");
		messageJlabel7 = new JLabel("Choose an amount to Withdrawn");
		Exit = new JButton("Cancel");
		Mainframe.setLayout(new FlowLayout());
		Mainframe.add(messageJlabel1);
		Mainframe.add(messageJlabel2);
		Mainframe.add(messageJlabel3);
		Mainframe.add(messageJlabel4);
		Mainframe.add(messageJlabel5);
		Mainframe.add(messageJlabel6);
		Mainframe.add(Exit);
		Mainframe.add(messageJlabel7);
		Mainframe.repaint();
	}
	
	public void cashDepositGUI() {
		Mainframe.getContentPane().removeAll();
		messageJlabel2 = new JLabel("Please enter deposit amount in CENTS");
		messageJlabel3 = new JLabel("");
		Inputfield2 = new JTextField(10);
		button1 = new JButton("Deposit");
		Exit = new JButton("Cancel");
		Mainframe.setLayout(new FlowLayout());
		Mainframe.add(messageJlabel2);
		Mainframe.add(messageJlabel3);
		Mainframe.add(Inputfield2);
		Mainframe.add(Exit);
		Mainframe.repaint();
	}
	
	public void setGUI() {
		Mainframe.repaint();
	}
	
	public void createAdminpage() {
		messageJlabel1 = new JLabel("View Users:");
		messageJlabel2 = new JLabel("Account number:");
		messageJlabel3 = new JLabel("Available Balance:");
		messageJlabel4 = new JLabel("Total BAlance");
		messageJlabel5 = new JLabel("-----------------------");
		button1 = new JButton("Next");
		button4 = new JButton("Prevoius");
		Exit = new JButton("Back");
		Inputfield1 = new JTextField(10);
		Inputfield2 = new JTextField(10);
		Inputfield3 = new JTextField(10);
		Inputfield4 = new JTextField(10);
		Mainframe.setLayout(new FlowLayout());
		messageJlabel6 = new JLabel("Add Account: ");
		messageJlabel7 = new JLabel("User name: ");
		Mainframe.add(messageJlabel1);
		messageJlabel8 = new JLabel("          Account number: ");
		Mainframe.add(messageJlabel2);
		messageJlabel10 = new JLabel("                                       PIN: ");
		
		messageJlabel9 = new JLabel("              Balance number: ");
		button2 = new JButton("Add");
		button3 = new JButton("Delete");
		
		
		Mainframe.add(messageJlabel3);
		Mainframe.add(messageJlabel4);
		Mainframe.add(button4);
		Mainframe.add(button1);
		Mainframe.add(button3);
		Mainframe.add(messageJlabel5);
		Mainframe.add(messageJlabel6);
		Mainframe.add(messageJlabel7);
		Mainframe.add(Inputfield1);
		Mainframe.add(messageJlabel8);
		Mainframe.add(Inputfield2);
		Mainframe.add(messageJlabel10);
		Mainframe.add(Inputfield4);
		Mainframe.add(messageJlabel9);
		Mainframe.add(Inputfield3);
		
		Mainframe.add(button2);
		
		Mainframe.add(Exit);
		Mainframe.repaint();		
	}
}
