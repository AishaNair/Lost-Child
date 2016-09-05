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

class CaseSolvedReport
extends JFrame
implements ActionListener
{
	Color customColor = new Color(00,192,255);
	Color customColor1 = new Color(255,64,00);
	Color customColor2 = new Color(255,192,64);
	Object[] columnNames={"cid","fname","lname","aname","dob","age","gender","address","city","state","missdate","info","status"};
	Object[] columnNames1={"cid","fname","lname","aname","dob","age","gender","address","city","state","founddate","info","status"};
	DefaultTableModel model;
	JTable table;
	DefaultTableModel model1;
	JTable table1;
	JLabel head;
	JButton b1;
	JButton b2;
	JButton scm;
	JButton scf;
	Connection cn;
	Statement stmt;

	 public CaseSolvedReport() {
		super("Solved Cases Report");

		model = new DefaultTableModel(); 
		table = new JTable(model);

		model1 = new DefaultTableModel(); 
		table1 = new JTable(model1);

		for(int i=0;i<columnNames.length;i++){
			model.addColumn(columnNames[i]);
			
		}
		for(int i=0;i<columnNames1.length;i++){
			model1.addColumn(columnNames1[i]);
			
		}
				
	    JScrollPane scrollpane = new JScrollPane(table);
	    JScrollPane scrollpane1 = new JScrollPane(table1);
		Container localContainer = getContentPane();
		localContainer.setLayout(null);
		localContainer.setBackground(new Color(0,0,0));
		setSize(800, 710);
		localContainer.add(scrollpane);
		localContainer.add(scrollpane1);
		scrollpane.setBounds(60, 100, 700, 200);
		scrollpane1.setBounds(60, 400, 700, 200);
		Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle localRectangle = getBounds();
		setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);

		setResizable(false);

		
		this.head = new JLabel("Solved Cases Report");
		this.head.setForeground(customColor);
		this.head.setFont(new Font("Eras Bold ITC", 0, 25));
		  		
		this.b1 = new JButton("Clear");
		this.b2 = new JButton("Close");
		this.scm= new JButton("View all Solved Missing Cases");
		this.scf= new JButton("View all Solved Found Cases");
		try
		{ 
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        this.cn = DriverManager.getConnection("jdbc:odbc:abc","","");
	        this.stmt = this.cn.createStatement();
	        
	     }
	    catch (Exception localException)
	    {
	      JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details", 0);
	    }
		
		
		this.head.setBounds(300, 10, 500, 30);

		this.scm.setBounds(80, 50, 300, 30);
		this.scf.setBounds(430, 50, 300, 30);
		this.b1.setBounds(180, 640, 100, 30);
		this.b2.setBounds(360, 640, 100, 30);

		
		localContainer.add(this.head);
		localContainer.add(this.scm);
		localContainer.add(this.scf);

		localContainer.add(this.b1);localContainer.add(this.b2);
		this.scm.addActionListener(this);
		this.scf.addActionListener(this);
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
	    		s1.c1.setSelectedIndex(Integer.parseInt(s));
	    		s1.show(true);
		        }
				
			}
		});
		table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
		        {
				ListSelectionModel mod1 = table1.getSelectionModel();
	            int lead1 = mod1.getLeadSelectionIndex();
	            String st = "";
	            Object o1 = table1.getValueAt(lead1, 0);
	            st = o1.toString();
	            Show1 s2= new Show1();
	    		s2.c2.setSelectedIndex(Integer.parseInt(st));
	    		s2.show(true);
		        }
			}
		});
		
	}

	public void actionPerformed(ActionEvent paramActionEvent)
	{
		if (paramActionEvent.getSource() == this.scm) {
			try
				{
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob,age, gender, address, city, state, missdate, info,status from face where status='Solved'");
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
		if (paramActionEvent.getSource() == this.scf) {
			try
				{
					ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob,age, gender, address, city, state, founddate, info,status from found where status='Solved'");
					while (localResultSet.next())
					{
						model1.addRow(new Object[]{localResultSet.getInt(1),localResultSet.getString(2).trim(),localResultSet.getString(3).trim(),localResultSet.getString(4).trim(),localResultSet.getString(5).trim(),localResultSet.getString(6).trim(),localResultSet.getString(7).trim(),localResultSet.getString(8).trim(),localResultSet.getString(9).trim(),localResultSet.getString(10).trim(),localResultSet.getString(11).trim(),localResultSet.getString(12).trim(),localResultSet.getString(13).trim()});
					}
				}
				catch (Exception localException)
				{
					JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details2", 0);
				}
			}
		
		if (paramActionEvent.getSource() == this.b1)
		{
			model.setRowCount(0);
			model1.setRowCount(0);
			
		}
		if (paramActionEvent.getSource() == this.b2)
		{
			setVisible(false);
			dispose();
		}
	}
		
}

