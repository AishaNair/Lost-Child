import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;

class Delete
extends JFrame
implements ActionListener
{
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	JLabel l8;
	JLabel l9;
	JLabel l10;
	JLabel l11;
	JLabel l12;
	JLabel l13;
	JLabel cb1;
	JLabel head;
	JLabel photo;
	JComboBox c1;
	JComboBox c2;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextField t5;
	JTextField t6;
	JTextField t7;
	JTextField t8;
	JTextField t9;
	JTextField t10;
	JTextField t11;
	JTextField t12;
	JTextField t13;
	
	JButton b1;
	JButton b2;
	JButton b3;
	Connection cn;
	Statement stmt;

	public Delete()
	{
		super("Show Details Form");
		Color customColor = new Color(00,192,255);
		Color customColor1 = new Color(255,64,00);
		Color customColor2 = new Color(255,192,64);
		Container localContainer = getContentPane();
		localContainer.setLayout(null);
		setSize(700, 710);

		Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle localRectangle = getBounds();
		setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);

		setResizable(false);

		this.head = new JLabel("Delete Child Records Form");
		head.setForeground(customColor);
	    this.head.setFont(new Font("Eras Bold ITC", 0, 25));
	    this.head.setBounds(160, 10, 400, 30);
	    localContainer.add(this.head);
	    localContainer.setBackground(new Color(0,0,0));
		this.photo = new JLabel("");
		this.photo.setFont(new Font("Eras Bold ITC", 0, 20));			//photo=JLabel
	    this.photo.setBounds(420, 85, 200, 260);
	    this.photo.setForeground(customColor1);
	    this.photo.setBorder(BorderFactory.createTitledBorder(""));
	    localContainer.add(this.photo);

		this.l1 = new JLabel("Delete Records");
		this.l2 = new JLabel("First Name");
		this.l3 = new JLabel("Last Name");
		this.l4 = new JLabel("Alias Name");
		this.l5 = new JLabel("D.O.B");
		this.l6 = new JLabel("Age");
		this.l7 = new JLabel("Gender");
		this.l8 = new JLabel("Address");
		this.l9 = new JLabel("City");
		this.l10 = new JLabel("State");
		this.l11 = new JLabel("Missing Date");
		this.l12 = new JLabel("Additional Info");
		this.l13 = new JLabel("Case Status");
		this.cb1= new JLabel("View Found Cases");
		this.t2 = new JTextField(20);
		this.t3 = new JTextField(20);
		this.t4 = new JTextField(20);
		this.t5 = new JTextField(20);
		this.t6 = new JTextField(20);
		this.t7 = new JTextField(20);
		this.t8 = new JTextField(20);
		this.t9 = new JTextField(20);
		this.t10 = new JTextField(20);
		this.t11 = new JTextField(20);
		this.t12 = new JTextField(20);
		this.t13 = new JTextField(20);
		this.c1 = new JComboBox();
		this.c2 = new JComboBox();
		this.b1 = new JButton("Clear");
		this.b2 = new JButton("Close");
		this.b3= new JButton("Delete");
		
		try
		{ 
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        this.cn = DriverManager.getConnection("jdbc:odbc:abc","","");
	        this.stmt = this.cn.createStatement();
	        ResultSet localResultSet = this.stmt.executeQuery("select cid from face order by cid asc");
	        this.c1.removeAllItems();
	      this.c1.addItem("Select Id");
	      while (localResultSet.next()) {
	        this.c1.addItem(localResultSet.getString(1));
	      }
	      ResultSet localResultSet1 = this.stmt.executeQuery("select cid from found order by cid asc");
	        this.c2.removeAllItems();
	      this.c2.addItem("Select Id");
	      while (localResultSet1.next()) {
	        this.c2.addItem(localResultSet1.getString(1));
	      }
	      //localResultSet.close();
	    }
	    catch (Exception localException)
	    {
	      JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details", 0);
	    }
		
		this.l1.setBounds(20, 50, 180, 30);
		this.l1.setForeground(customColor1);
	    this.l1.setFont(new Font("Eras Bold ITC", 0, 17));
		this.c1.setBounds(190, 50, 150, 30);
		
		this.cb1.setBounds(350, 50, 180, 30);
		this.cb1.setForeground(customColor1);
	    this.cb1.setFont(new Font("Eras Bold ITC", 0, 17));
		this.c2.setBounds(520, 50, 150, 30);

		this.l2.setBounds(20, 90, 100, 30);
		this.l2.setForeground(customColor1);
	    this.l2.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t2.setBounds(190, 90, 150, 30);
		
		this.l3.setBounds(20, 130, 100, 30);
		this.l3.setForeground(customColor1);
	    this.l3.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t3.setBounds(190, 130, 150, 30);

		this.l4.setBounds(20, 170, 100, 30);
		this.l4.setForeground(customColor1);
	    this.l4.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t4.setBounds(190, 170, 150, 30);

		this.l5.setBounds(20, 210, 100, 30);
		this.l5.setForeground(customColor1);
	    this.l5.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t5.setBounds(190, 210, 150, 30);

		this.l6.setBounds(20, 250, 100, 30);
		this.l6.setForeground(customColor1);
	    this.l6.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t6.setBounds(190, 250, 150, 30);
		
		this.l7.setBounds(20, 290, 100, 30);
		this.l7.setForeground(customColor1);
	    this.l7.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t7.setBounds(190, 290, 150, 30);

		this.l8.setBounds(20, 330, 100, 30);
		this.l8.setForeground(customColor1);
	    this.l8.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t8.setBounds(190, 330, 150, 30);

		this.l9.setBounds(20, 370, 100, 30);
		this.l9.setForeground(customColor1);
	    this.l9.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t9.setBounds(190, 370, 150, 30);

		this.l10.setBounds(20, 410, 100, 30);
		this.l10.setForeground(customColor1);
	    this.l10.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t10.setBounds(190, 410, 150, 30);

		this.l11.setBounds(20, 450, 150, 30);
		this.l11.setForeground(customColor1);
	    this.l11.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t11.setBounds(190, 450, 150, 30);

		this.l12.setBounds(20, 490, 150, 30);
		this.l12.setForeground(customColor1);
	    this.l12.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t12.setBounds(190, 490, 150, 30);
		
		this.l13.setBounds(20, 530, 100, 30);
		this.l13.setForeground(customColor1);
	    this.l13.setFont(new Font("Eras Bold ITC", 0, 17));
		this.t13.setBounds(190, 530, 150, 30);

		this.l2.setVisible(false);
		this.t2.setVisible(false);

		this.l3.setVisible(false);
		this.t3.setVisible(false);

		this.l4.setVisible(false);
		this.t4.setVisible(false);

		this.l5.setVisible(false);
		this.t5.setVisible(false);

		this.l6.setVisible(false);
		this.t6.setVisible(false);

		this.l7.setVisible(false);
		this.t7.setVisible(false);

		this.l8.setVisible(false);
		this.t8.setVisible(false);

		this.l9.setVisible(false);
		this.t9.setVisible(false);

		this.l10.setVisible(false);
		this.t10.setVisible(false);

		this.l11.setVisible(false);
		this.t11.setVisible(false);

		this.l12.setVisible(false);
		this.t12.setVisible(false);
		
		this.l13.setVisible(false);
		this.t13.setVisible(false);

		this.photo.setVisible(false);

		this.b1.setBounds(180, 640, 100, 30);
		this.b2.setBounds(300, 640, 100, 30);
		this.b3.setBounds(420, 640, 100, 30);

		
		localContainer.add(this.l1);localContainer.add(this.c1);
		localContainer.add(this.cb1);localContainer.add(this.c2);
		localContainer.add(this.l2);localContainer.add(this.t2);
		localContainer.add(this.l3);localContainer.add(this.t3);
		localContainer.add(this.l4);localContainer.add(this.t4);
		localContainer.add(this.l5);localContainer.add(this.t5);
		localContainer.add(this.l6);localContainer.add(this.t6);
		
		localContainer.add(this.l7);localContainer.add(this.t7);
		localContainer.add(this.l8);localContainer.add(this.t8);
		localContainer.add(this.l9);localContainer.add(this.t9);
		localContainer.add(this.l10);localContainer.add(this.t10);
		localContainer.add(this.l11);localContainer.add(this.t11);
		localContainer.add(this.l12);localContainer.add(this.t12);
		localContainer.add(this.l13);localContainer.add(this.t13);
		localContainer.add(this.b1);localContainer.add(this.b2);
		localContainer.add(this.b3);
		
		this.b2.setForeground(Color.black);
		this.b1.setForeground(Color.black);
		this.b3.setForeground(Color.black);
		this.b3.setFont(new Font("Eras Bold ITC", 0, 17));
		this.b2.setFont(new Font("Eras Bold ITC", 0, 17));
		this.b1.setFont(new Font("Eras Bold ITC", 0, 17));
		this.b2.setBackground(customColor2);
		this.b1.setBackground(customColor2);
		this.b3.setBackground(customColor2);
		
		this.c1.addActionListener(this);
		this.c2.addActionListener(this);
		this.b1.addActionListener(this);
		this.b2.addActionListener(this);
		this.b3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent paramActionEvent)
	{
		if (paramActionEvent.getSource() == this.c1) {
			if (this.c1.getSelectedIndex() != 0) {
				try
				{
					String str1 = this.c1.getSelectedItem().toString();
					PreparedStatement st;
					ResultSet rs;
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob, age, gender, address, city, state, missdate, info,status from face where cid=" + str1);
					if (localResultSet.next())
					{
						
						this.t2.setEditable(false);

						
						this.t3.setEditable(false);

						
						this.t4.setEditable(false);

						
						this.t5.setEditable(false);

						
						this.t6.setEditable(false);

						
						this.t7.setEditable(false);

						
						this.t8.setEditable(false);

						
						this.t9.setEditable(false);

						
						this.t10.setEditable(false);
						this.t11.setEditable(false);
						this.t12.setEditable(false);
						this.t13.setEditable(false);

						

						this.l2.setVisible(true);
						this.t2.setVisible(true);

						this.l3.setVisible(true);
						this.t3.setVisible(true);

						this.l4.setVisible(true);
						this.t4.setVisible(true);

						this.l5.setVisible(true);
						this.t5.setVisible(true);

						this.l6.setVisible(true);
						this.t6.setVisible(true);

						this.l7.setVisible(true);
						this.t7.setVisible(true);

						this.l8.setVisible(true);
						this.t8.setVisible(true);

						this.l9.setVisible(true);
						this.t9.setVisible(true);

						this.l10.setVisible(true);
						this.t10.setVisible(true);

						this.l11.setVisible(true);
						this.t11.setVisible(true);
						this.l11.setText("Missing Date");
						
						this.l12.setVisible(true);
						this.t12.setVisible(true);
						
						this.l13.setVisible(true);
						this.t13.setVisible(true);
						this.photo.setVisible(true);

						this.t2.setText(localResultSet.getString(2).trim());
						this.t3.setText(localResultSet.getString(3).trim());
						this.t4.setText(localResultSet.getString(4).trim());
						this.t5.setText(localResultSet.getString(5).trim());
						this.t6.setText(localResultSet.getString(6).trim());
						this.t7.setText(localResultSet.getString(7).trim());
						this.t8.setText(localResultSet.getString(8).trim());
						this.t9.setText(localResultSet.getString(9).trim());
						this.t10.setText(localResultSet.getString(10).trim());
						this.t11.setText(localResultSet.getString(11).trim());
						this.t12.setText(localResultSet.getString(12).trim());
						this.t13.setText(localResultSet.getString(13).trim());
												
						cn.setAutoCommit(false);
						st=cn.prepareStatement("select photo from face where cid=?");
						st.setString(1, str1);
						rs=st.executeQuery();
						byte[] bytes=null;
						if(rs.next())	{
							bytes=rs.getBytes(1);
						}
						if(bytes!=null)
						{
							InputStream in = new ByteArrayInputStream(bytes);
							BufferedImage bi = ImageIO.read(in);
							BufferedImage bi2=new BufferedImage(200,260,BufferedImage.TYPE_INT_RGB);
				        	Graphics g=bi2.createGraphics();
				    		g.drawImage(bi, 0, 0,200,260, null);
				    		g.dispose();
				        	this.photo.setIcon(new ImageIcon(bi2));
						}					
					}
				}
				catch (Exception localException)
				{
					JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details2", 0);
					localException.printStackTrace();
				}
			}
		}
		if (paramActionEvent.getSource() == this.c2) {
			if (this.c2.getSelectedIndex() != 0) {
				try
				{
					String str1 = this.c2.getSelectedItem().toString();
					PreparedStatement st;
					ResultSet rs;
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob, age, gender, address, city, state, founddate, info,status from found where cid=" + str1);
					if (localResultSet.next())
					{
						this.l2.setVisible(true);
						this.t2.setVisible(true);

						this.l3.setVisible(true);
						this.t3.setVisible(true);

						this.l4.setVisible(true);
						this.t4.setVisible(true);

						this.l5.setVisible(true);
						this.t5.setVisible(true);

						this.l6.setVisible(true);
						this.t6.setVisible(true);

						this.l7.setVisible(true);
						this.t7.setVisible(true);

						this.l8.setVisible(true);
						this.t8.setVisible(true);

						this.l9.setVisible(true);
						this.t9.setVisible(true);

						this.l10.setVisible(true);
						this.t10.setVisible(true);

						this.l11.setVisible(true);
						this.t11.setVisible(true);
						this.l11.setText("Found Date");

						this.l12.setVisible(true);
						this.t12.setVisible(true);
						
						this.l13.setVisible(true);
						this.t13.setVisible(true);
						this.photo.setVisible(true);

						this.t2.setText(localResultSet.getString(2).trim());
						this.t3.setText(localResultSet.getString(3).trim());
						this.t4.setText(localResultSet.getString(4).trim());
						this.t5.setText(localResultSet.getString(5).trim());
						this.t6.setText(localResultSet.getString(6).trim());
						this.t7.setText(localResultSet.getString(7).trim());
						this.t8.setText(localResultSet.getString(8).trim());
						this.t9.setText(localResultSet.getString(9).trim());
						this.t10.setText(localResultSet.getString(10).trim());
						this.t11.setText(localResultSet.getString(11).trim());
						this.t12.setText(localResultSet.getString(12).trim());
						this.t13.setText(localResultSet.getString(13).trim());
												
						cn.setAutoCommit(false);
						st=cn.prepareStatement("select photo from found where cid=?");
						st.setString(1, str1);
						rs=st.executeQuery();
						byte[] bytes=null;
						if(rs.next())	{
							bytes=rs.getBytes(1);
						}
						if(bytes!=null)
						{
							InputStream in = new ByteArrayInputStream(bytes);
							BufferedImage bi = ImageIO.read(in);
							BufferedImage bi2=new BufferedImage(200,260,BufferedImage.TYPE_INT_RGB);
				        	Graphics g=bi2.createGraphics();
				    		g.drawImage(bi, 0, 0,200,260, null);
				    		g.dispose();
				        	this.photo.setIcon(new ImageIcon(bi2));
						}					
					}
				}
				catch (Exception localException)
				{
					JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details2", 0);
					localException.printStackTrace();
				}
			}
		}
		if (paramActionEvent.getSource() == this.b1)
		{
			this.c1.setSelectedItem("Select Id");
			this.t2.setText("");
			this.t3.setText("");
			this.t4.setText("");
			this.t5.setText("");
			this.t6.setText("");
			this.t7.setText("");
			this.t8.setText("");
			this.t9.setText("");
			this.t10.setText("");
			this.t11.setText("");
			this.t12.setText("");
			this.t13.setText("");
			
			
			this.photo.setVisible(false);
		}
		if (paramActionEvent.getSource() == this.b3)
		{
			if(l11.getText()=="Missing Date"){
				String str1 = this.c1.getSelectedItem().toString();
				try {
					int del = this.stmt.executeUpdate("delete from face where cid="+str1);
					if(del==1){
						JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
					}
					this.cn.commit();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				this.c1.setSelectedItem("Select Id");
				this.t2.setText("");
				this.t3.setText("");
				this.t4.setText("");
				this.t5.setText("");
				this.t6.setText("");
				this.t7.setText("");
				this.t8.setText("");
				this.t9.setText("");
				this.t10.setText("");
				this.t11.setText("");
				this.t12.setText("");
				this.t13.setText("");
				this.photo.setVisible(false);
				
				
			}
			else if(l11.getText()=="Found Date"){
			String str2= this.c2.getSelectedItem().toString();
			try {
			int delete= this.stmt.executeUpdate("delete from found where cid="+str2);
			if(delete==1){
				JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
			}
			this.cn.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.c2.setSelectedItem("Select Id");
		this.t2.setText("");
		this.t3.setText("");
		this.t4.setText("");
		this.t5.setText("");
		this.t6.setText("");
		this.t7.setText("");
		this.t8.setText("");
		this.t9.setText("");
		this.t10.setText("");
		this.t11.setText("");
		this.t12.setText("");
		this.t13.setText("");
		this.photo.setVisible(false);
		
		
	}
			
		}
		if (paramActionEvent.getSource() == this.b2)
		{
			setVisible(false);
			dispose();
		}
	
	}
}
