import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MortgageFrame extends JFrame implements ActionListener
{
	//Data Fields
	private JTextField price = new JTextField(10);
	private JTextField downpay = new JTextField(10);
	private JTextField rate = new JTextField(10);
	private JTextField term = new JTextField(10);
	private JTextField tax = new JTextField(10);
	private JTextField insurance = new JTextField(10);
	private JButton calc = new JButton ("Calculate");
	private JButton clear = new JButton ("Clear");
	private JTextField payment = new JTextField(10);

	
//Constructor
public MortgageFrame()
{
	JLabel priceLab = new JLabel ("Enter the price of house:               ");
	JLabel downpayLab = new JLabel ("Enter the downpayment:                ");
	JLabel rateLab = new JLabel ("Enter the annual interest rate:      ");
	JLabel termLab = new JLabel ("Enter how many years:                   ");
	JLabel taxLab = new JLabel ("Enter the annual tax:                       ");
	JLabel insuranceLab = new JLabel ("Enter the annual insurance:          ");
	JLabel paymentLab = new JLabel ("The payment is:                                 ");
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////

	JPanel pricePanel = new JPanel();
	JPanel downpayPanel = new JPanel();
	JPanel ratePanel = new JPanel();
	JPanel termPanel = new JPanel();
	JPanel taxPanel = new JPanel();
	JPanel insurancePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel paymentPanel = new JPanel();

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	getContentPane().setLayout(new FlowLayout());

	pricePanel.add(priceLab);
	pricePanel.add(price);
	getContentPane().add(pricePanel);

	price.requestFocus();

	downpayPanel.add(downpayLab);
	downpayPanel.add(downpay);
	getContentPane().add(downpayPanel);

	ratePanel.add(rateLab);
	ratePanel.add(rate);
	getContentPane().add(ratePanel);
	
	termPanel.add(termLab);
	termPanel.add(term);
	getContentPane().add(termPanel);

	taxPanel.add(taxLab);
	taxPanel.add(tax);
	getContentPane().add(taxPanel);

	insurancePanel.add(insuranceLab);
	insurancePanel.add(insurance);
	getContentPane().add(insurancePanel);


	buttonPanel.add(calc);
	calc.addActionListener(this);
	buttonPanel.add(clear);
	clear.addActionListener(this);
	getContentPane().add(buttonPanel);	
	
	paymentPanel.add(paymentLab);
	paymentPanel.add(payment);
	getContentPane().add(paymentPanel);
} // end constructor

public void actionPerformed(ActionEvent aE)
	{
		String button = aE.getActionCommand();

		if(button.equals("Calculate"))
		{
			String str1 = price.getText();
			String str2 = downpay.getText();
			String str3 = rate.getText();
			String str4 = term.getText();
			String str5 = tax.getText();
			String str6 = insurance.getText();
			int a = Integer.parseInt(str1);
			int b = Integer.parseInt(str2);
			int amount = (a - b);
			int c = Integer.parseInt(str5);
			int d = Integer.parseInt(str6);
			
			LoanCalc myloancalc = new LoanCalc(amount, rate, term);
			int total = myloancalc.getPayment();

			total += (c/12);
			total += (d/12);

			payment.setText ("" + total);
			
		}
		else if(button.equals("Clear"))
		{
			price.setText("");
			downpay.setText("");
			rate.setText("");
			term.setText("");
			tax.setText("");
			insurance.setText("");
			payment.setText("");
		}

		price.requestFocus();
	}
	public static void main (String[] args)
	{
	MortgageFrame theFrame = new MortgageFrame();
	theFrame.setSize(350,350);
	theFrame.setVisible(true);
	theFrame.setTitle("Addition");
	theFrame.addWindowListener (
	new WindowAdapter() {
	public void windowClosing(WindowEvent e)
		{
		System.exit(0);
		}
			    }
				    );
	}
}

	
