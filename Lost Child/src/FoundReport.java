import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

class FoundReport
extends JFrame
implements ActionListener
{
	Color customColor = new Color(00,192,255);
	Color customColor1 = new Color(255,64,00);
	Color customColor2 = new Color(255,192,64);
	Object[] columnNames={"cid","fname","lname","aname","dob","age","gender","address","city","state","founddate","info","status"};
	DefaultTableModel model;
	JTable table;
	JLabel Age;
	JLabel Gender;
	JLabel MissDate;
	JLabel city;
	JLabel state;
	JLabel head;
	JComboBox a;
	JComboBox g;
	JComboBox md;
	JComboBox c;
	JComboBox st;
	JButton b1;
	JButton b2;
	Connection cn;
	Statement stmt;

	 public FoundReport() {
		super("Found Cases Report");

		model = new DefaultTableModel(); 
		table = new JTable(model);

		for(int i=0;i<columnNames.length;i++){
			model.addColumn(columnNames[i]);
			
		}
				
	    JScrollPane scrollpane = new JScrollPane(table);
	
		Container localContainer = getContentPane();
		localContainer.setBackground(new Color(0,0,0));
		localContainer.setLayout(null);
		setSize(800, 710);
		localContainer.add(scrollpane);
		scrollpane.setBounds(60, 100, 700, 500);
		Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle localRectangle = getBounds();
		setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);

		setResizable(false);

		
		this.head = new JLabel("Found Cases Report");
		this.head.setForeground(customColor);
		this.head.setFont(new Font("Eras Bold ITC", 0, 25));

		this.Age = new JLabel("Age");
		this.Gender = new JLabel("Gender");
		this.MissDate = new JLabel("Found Date");
		this.city = new JLabel("City");
		this.state = new JLabel("State");
		
		this.Age.setForeground(customColor1);
		this.Age.setFont(new Font("Eras Bold ITC", 0, 15));
		this.Gender.setForeground(customColor1);
		this.Gender.setFont(new Font("Eras Bold ITC", 0, 15));
		this.MissDate.setForeground(customColor1);
		this.MissDate.setFont(new Font("Eras Bold ITC", 0, 15));
		this.city.setForeground(customColor1);
		this.city.setFont(new Font("Eras Bold ITC", 0, 15));
		this.state.setForeground(customColor1);
		this.state.setFont(new Font("Eras Bold ITC", 0, 15));
		
		this.a = new JComboBox();
		this.g = new JComboBox();
		this.md = new JComboBox();
		this.c = new JComboBox();
		this.st = new JComboBox();
		  		
		this.b1 = new JButton("Clear");
		this.b2 = new JButton("Close");
		
		try
		{ 
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        this.cn = DriverManager.getConnection("jdbc:odbc:abc","","");
	        this.stmt = this.cn.createStatement();
	        ResultSet localResultSet = this.stmt.executeQuery("select distinct(age) from found");
	        this.a.removeAllItems();
	      this.a.addItem("Select");
	      while (localResultSet.next()) {
	        this.a.addItem(localResultSet.getString(1).trim());
	      }
	      ResultSet localResultSet1 = this.stmt.executeQuery("select distinct(gender) from found");
	        this.g.removeAllItems();
	      this.g.addItem("Select");
	      while (localResultSet1.next()) {
	        this.g.addItem(localResultSet1.getString(1).trim());
	      }
	      ResultSet localResultSet2 = this.stmt.executeQuery("select distinct(founddate) from found");
	        this.md.removeAllItems();
	      this.md.addItem("Select");
	      while (localResultSet2.next()) {
	        this.md.addItem(localResultSet2.getString(1).trim());
	      }
	      ResultSet localResultSet3 = this.stmt.executeQuery("select distinct(city) from found");
	        this.c.removeAllItems();
	      this.c.addItem("Select");
	      while (localResultSet3.next()) {
	        this.c.addItem(localResultSet3.getString(1).trim());
	      }
	      ResultSet localResultSet4 = this.stmt.executeQuery("select distinct(state) from found");
	        this.st.removeAllItems();
	      this.st.addItem("Select");
	      while (localResultSet4.next()) {
	        this.st.addItem(localResultSet4.getString(1).trim());
	      }
	     }
	    catch (Exception localException)
	    {
	      JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details", 0);
	    }
		
		
		this.head.setBounds(300, 10, 350, 30);

		this.Age.setBounds(20, 50, 50, 30);
		this.a.setBounds(60, 50, 90, 30);

		this.Gender.setBounds(150, 50, 100, 30);
		this.g.setBounds(210, 50, 90, 30);

		this.MissDate.setBounds(310, 50, 150, 30);
		this.md.setBounds(410, 50, 90, 30);

		this.city.setBounds(510, 50, 40, 30);
		this.c.setBounds(540, 50, 90, 30);

		this.state.setBounds(630, 50, 50, 30);
		this.st.setBounds(670, 50, 90, 30);

		this.b1.setBounds(180, 640, 100, 30);
		this.b2.setBounds(360, 640, 100, 30);

		
		localContainer.add(this.head);
		localContainer.add(this.Age);localContainer.add(this.a);
		localContainer.add(this.Gender);localContainer.add(this.g);
		localContainer.add(this.MissDate);localContainer.add(this.md);
		localContainer.add(this.city);localContainer.add(this.c);
		localContainer.add(this.state);localContainer.add(this.st);
		

		localContainer.add(this.b1);localContainer.add(this.b2);
		this.a.addActionListener(this);
		this.g.addActionListener(this);
		this.md.addActionListener(this);
		this.c.addActionListener(this);
		this.st.addActionListener(this);
		this.b1.addActionListener(this);
		this.b2.addActionListener(this);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
		        {
				ListSelectionModel mod = table.getSelectionModel();
	            int lead = mod.getLeadSelectionIndex();
	            String s = "";
	            Object o = table.getValueAt(lead, 0);
	            s = o.toString();
	            Show1 s1= new Show1();
	    		s1.c2.setSelectedIndex(Integer.parseInt(s));
	    		s1.show(true);
		        }
			}
		});
	}

	public void actionPerformed(ActionEvent paramActionEvent)
	{
		model.setRowCount(0);
		if (paramActionEvent.getSource() == this.a) {
			 	
			
		if (this.a.getSelectedIndex() != 0) {
				try
				{
					String str1 = this.a.getSelectedItem().toString();
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob,age, gender, address, city, state, founddate, info,status from found where age=" + str1);
					while (localResultSet.next())
					{
						
						model.addRow(new Object[]{localResultSet.getInt(1),localResultSet.getString(2).trim(),localResultSet.getString(3).trim(),localResultSet.getString(4).trim(),localResultSet.getString(5).trim(),localResultSet.getString(6).trim(),localResultSet.getString(7).trim(),localResultSet.getString(8).trim(),localResultSet.getString(9).trim(),localResultSet.getString(10).trim(),localResultSet.getString(11).trim(),localResultSet.getString(12).trim(),localResultSet.getString(13).trim()});
					}
				}
				catch (Exception localException)
				{
					JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details2", 0);
				}
			}
		}
		if (paramActionEvent.getSource() == this.g) {
			//model.setRowCount(0);
		if (this.g.getSelectedIndex() != 0) {
				try
				{
					String str1 = this.g.getSelectedItem().toString();
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob,age, gender, address, city, state, founddate, info,status from found where gender='" + str1+"'");
					while (localResultSet.next())
					{
						model.addRow(new Object[]{localResultSet.getInt(1),localResultSet.getString(2).trim(),localResultSet.getString(3).trim(),localResultSet.getString(4).trim(),localResultSet.getString(5).trim(),localResultSet.getString(6).trim(),localResultSet.getString(7).trim(),localResultSet.getString(8).trim(),localResultSet.getString(9).trim(),localResultSet.getString(10).trim(),localResultSet.getString(11).trim(),localResultSet.getString(12).trim(),localResultSet.getString(13).trim()});
					}
				}
				catch (Exception localException)
				{
					JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details2", 0);
					localException.printStackTrace();
				}
			}
		}
		if (paramActionEvent.getSource() == this.md) {
			//model.setRowCount(0);
		if (this.md.getSelectedIndex() != 0) {
				try
				{
					String str1 = this.md.getSelectedItem().toString();
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob,age, gender, address, city, state, founddate, info,status from found where founddate='" + str1+"'");
					while (localResultSet.next())
					{
						model.addRow(new Object[]{localResultSet.getInt(1),localResultSet.getString(2).trim(),localResultSet.getString(3).trim(),localResultSet.getString(4).trim(),localResultSet.getString(5).trim(),localResultSet.getString(6).trim(),localResultSet.getString(7).trim(),localResultSet.getString(8).trim(),localResultSet.getString(9).trim(),localResultSet.getString(10).trim(),localResultSet.getString(11).trim(),localResultSet.getString(12).trim(),localResultSet.getString(13).trim()});
					}
				}
				catch (Exception localException)
				{
					JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details2", 0);
					localException.printStackTrace();
				}
			}
		}
		if (paramActionEvent.getSource() == this.c) {
			//model.setRowCount(0);
		if (this.c.getSelectedIndex() != 0) {
				try
				{
					String str1 = this.c.getSelectedItem().toString();
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob,age, gender, address, city, state, founddate, info,status from found where city='" + str1+"'");
					while (localResultSet.next())
					{
						model.addRow(new Object[]{localResultSet.getInt(1),localResultSet.getString(2).trim(),localResultSet.getString(3).trim(),localResultSet.getString(4).trim(),localResultSet.getString(5).trim(),localResultSet.getString(6).trim(),localResultSet.getString(7).trim(),localResultSet.getString(8).trim(),localResultSet.getString(9).trim(),localResultSet.getString(10).trim(),localResultSet.getString(11).trim(),localResultSet.getString(12).trim(),localResultSet.getString(13).trim()});
					}
				}
				catch (Exception localException)
				{
					JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details2", 0);
					localException.printStackTrace();
				}
			}
		}
		if (paramActionEvent.getSource() == this.st) {
			//model.setRowCount(0);
		if (this.st.getSelectedIndex() != 0) {
				try
				{
					String str1 = this.st.getSelectedItem().toString();
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob,age, gender, address, city, state, founddate, info,status from found where state='" + str1+"'");
					while (localResultSet.next())
					{
						model.addRow(new Object[]{localResultSet.getInt(1),localResultSet.getString(2).trim(),localResultSet.getString(3).trim(),localResultSet.getString(4).trim(),localResultSet.getString(5).trim(),localResultSet.getString(6).trim(),localResultSet.getString(7).trim(),localResultSet.getString(8).trim(),localResultSet.getString(9).trim(),localResultSet.getString(10).trim(),localResultSet.getString(11).trim(),localResultSet.getString(12).trim(),localResultSet.getString(13).trim()});
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
			this.a.setSelectedItem("Select Id");
			this.g.setSelectedItem("Select Id");
			this.md.setSelectedItem("Select Id");
			this.c.setSelectedItem("Select Id");
			this.st.setSelectedItem("Select Id");
			model.setRowCount(0);
			
		}
		if (paramActionEvent.getSource() == this.b2)
		{
			setVisible(false);
			dispose();
		}
	}
			
}

