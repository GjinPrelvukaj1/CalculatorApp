package Innovation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame jframe;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addbutton,subbutton,multbutton,divisbutton;
	JButton decButton, equalbutton, deletebutton, clearbutton, negativebutton;
	JPanel buttonpanel;
	
	Font myFont = new Font("Times New Roman",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		jframe = new JFrame("Calculator");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(700, 750);
		jframe.setLayout(null);
		jframe.setResizable(false);
		ImageIcon image = new ImageIcon("calculator.jpg");
		jframe.setIconImage(image.getImage());
		
		textfield = new JTextField();
		textfield.setBounds(150, 25, 400, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addbutton = new JButton("+");
		subbutton = new JButton("-");
		multbutton = new JButton("*");
		divisbutton = new JButton("/");
		decButton = new JButton(".");
		equalbutton = new JButton("=");
		deletebutton = new JButton("DEL");
		clearbutton = new JButton("CLR");
		negativebutton = new JButton("NEG");
		
		functionButtons[0] = addbutton;
		functionButtons[1] = subbutton;
		functionButtons[2] = multbutton;
		functionButtons[3] = divisbutton;
		functionButtons[4] = decButton;
		functionButtons[5] = equalbutton;
		functionButtons[6] = deletebutton;
		functionButtons[7] = clearbutton;
		functionButtons[8] = negativebutton;
		
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negativebutton.setBounds(150,600,100,50);
		deletebutton.setBounds(300,600,100,50);
		clearbutton.setBounds(450,600,100,50);
		
		buttonpanel = new JPanel();
		buttonpanel.setBounds(150, 100, 400, 400);
		buttonpanel.setLayout(new GridLayout(4,4,10,10));

		buttonpanel.add(numberButtons[1]);
		buttonpanel.add(numberButtons[2]);
		buttonpanel.add(numberButtons[3]);
		buttonpanel.add(addbutton);
		buttonpanel.add(numberButtons[4]);
		buttonpanel.add(numberButtons[5]);
		buttonpanel.add(numberButtons[6]);
		buttonpanel.add(subbutton);
		buttonpanel.add(numberButtons[7]);
		buttonpanel.add(numberButtons[8]);
		buttonpanel.add(numberButtons[9]);
		buttonpanel.add(multbutton);
		buttonpanel.add(decButton);
		buttonpanel.add(numberButtons[0]);
		buttonpanel.add(equalbutton);
		buttonpanel.add(divisbutton);
		
		jframe.add(buttonpanel);
		jframe.add(negativebutton);
		jframe.add(deletebutton);
		jframe.add(clearbutton);
		jframe.add(textfield);
		jframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calculatorprogram = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==multbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divisbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equalbutton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clearbutton) {
			textfield.setText("");
		}
		if(e.getSource()==deletebutton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negativebutton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
}


