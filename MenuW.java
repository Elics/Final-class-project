/*
 * This program provides users with Covid-19 Testing Center
 * in their respective Zip code area. In this program we are using
 * three zip codes 
 * Middletown -17057
 * Hershey = 17033
 * Hummelstown - 17036
 * Users in these areas will choose from a drop down of these
 * zip code and depending on their selection, the program will display
 * Covid-19 Testing centers in that particular zip code
 */


/* for the testing centers*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;


public class MenuW extends JFrame implements ActionListener
{
	//Text Area
	JTextArea	txtAreaZip;

	//Array for zip code drop down	
	String [] ZipOptions = {"17057", "17033","17036"};

	//create combo box ie drop down menu
	JComboBox cboZipOptions; 
	
	//buttons
	JButton cmdNext;
	JButton cmdOk;
	JButton cmdExit;
	JButton cmdBack;
	
	//radio button
	JRadioButton optZip;

	//creates Jlabel 
	JLabel lblOptions;		//label for radio button
	JLabel lblZipOpt;		//label for zip code dropdown
	JLabel  lblTxtArea;		//label for text area
		
	
//Main Window
MenuW(){
this.setTitle("Testing Center");
		
	//radio button
	this.optZip =new JRadioButton("Zip code", true);
	this.optZip.setBounds(200,70,100,20);
	
	// button group label
	lblOptions = new JLabel("Select one of the following:");
	this.lblOptions.setBounds(160,50,200,20);
	add(lblOptions);
	
	//button group
	ButtonGroup Cone = new ButtonGroup();
	Cone.add(optZip);
	add(optZip);

	//adding and setting buttons
	
	//add Next buttons
	cmdNext = new JButton("Next");
	cmdNext.setBounds(300, 400, 100, 50);
	add(this.cmdNext);
	
	//ok button
	cmdOk = new JButton("OK");
	cmdOk.setBounds(300, 400, 100, 50);
	add(cmdOk);
	
	//exit button
	cmdExit = new JButton("Exit");
	cmdExit.setBounds(150,400,100,50);
	add(cmdExit);
	
	//back button
	cmdBack = new JButton("Back");
	cmdBack.setBounds(300, 400, 100, 50);
	add(cmdBack);
	
	
	//add events
	cmdNext.addActionListener(this);
	
	//ok button events
	cmdOk.addActionListener(this);
	cmdOk.setVisible(false);
	
	//exit button events
	cmdExit.addActionListener(this);
	
	//back button events
	cmdBack.addActionListener(this);
	cmdBack.setVisible(false);

	
	//window control
	this.setLayout(null);
	this.setSize(500,500);
	this.setVisible(true);
}


//action performed events
	@Override
	public void actionPerformed(ActionEvent e)  {
		// TODO Auto-generated method stub
		
		//switch for action performed
		switch(e.getActionCommand())
		{
			//when comboBox item is selected
			case "comboBoxChanged":
				cmdOk.setVisible(true);
				break;
			
			//when zip code radio button is selected
			case "Zip code":
				cmdOk.setVisible(true);
				break;
			
			//when next button is selected
			case "Next":
				nextFrame();
				cmdNext.setVisible(false);
				break;
				
			//when ok button is selected
			case "OK":
				DisplayZip();
				break;
			
			//when back button is selected
			case "Back":
				nextFrame();
				cmdOk.setVisible(true);
				txtAreaZip.setVisible(false);
				break;
						
			//when exit button is selected
			case "Exit":
				System.exit(0);
		
		}
		
	}//end of action performed method
	
	/*
	 * Display method is displays the Testing centers of
	 * the selected Zip code in the GUI
	 */
	public void DisplayZip()
	{
		//set the title to 
		this.setTitle("Testing Center 3");	
	
		//type cast  the item selected to string
		String strZipcode = (String) this.cboZipOptions.getSelectedItem();

		
		//JLabel  lblTxtArea;	
		//JTextArea	txtAreaZip;
		
		//creating text area  that display the results
		txtAreaZip = new JTextArea();
		
		//this create scroll pane when there are a lot of result 
		JScrollPane scrollZip = new JScrollPane(txtAreaZip);
		
		//set the size to the size of the window.
		this.txtAreaZip.setSize(500, 500);
		add(txtAreaZip);
		
		//this disable the edit option of the text area 
		txtAreaZip.setEditable(false);
	
		/*
		 * below is if statements that compare the item selected from
		 * the drop down to a zip codes and display the appropriate result
		 */
		//compare to hershey 17033
		if (this.cboZipOptions.getSelectedItem()=="17033")
			{
			//add info to the text area
			txtAreaZip.append("Here are the result for Zip code 17033- Hershey\n");
			}
		
		//compare to middletown 17957
		if (this.cboZipOptions.getSelectedItem()=="17057")
		 	{
			 txtAreaZip.append("Here are the result for " +"Zip code 17057- Middletown\n");
			 }

		//compare to hummelstown 17036
		if (this.cboZipOptions.getSelectedItem()=="17036")
			{
			//JOptionPane.showMessageDialog(null, "Zipcode 17036 is Hummelstown");
			txtAreaZip.append("Here are the result for " +"Zip code 17036- Hummelstown\n");
			}
		
	/*
	 * this block here set visibility of dropdown button and label to false
	 * it also make okay button disappear and make back button appear
	 */
	this.lblZipOpt.setVisible(false);
	this.cboZipOptions.setVisible(false);
	this.cmdOk.setVisible(false);
	this.cmdBack.setVisible(true);
	
}//end of DisplayZip method
	

	/*
	 * the nextFrame() method shows the dropdown button after
	 * the first page.
	 * In this method the radio button and label are set to false(disappear) 
	 */
public void nextFrame()
	{
		this.setTitle("Testing Center 2");
		this.lblOptions.setVisible(false);
		this.optZip.setVisible(false);

		//create combo box ie drop down menu
		cboZipOptions = new JComboBox(ZipOptions);
	
		//setting bounds for zip code dropdown and label
		lblZipOpt = new JLabel("Select your zip code:");
		lblZipOpt.setBounds(160,50,200,20);
		add(lblZipOpt);
		cboZipOptions.setBounds(160,80,200,40);
		add(cboZipOptions);
		
		//add events
		cboZipOptions.addActionListener(this);
 
	}//end of nextFrame method


	
}// end of class