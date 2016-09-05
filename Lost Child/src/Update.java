import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Update
  extends JFrame
  implements ActionListener
{
 
  String[] msg = { "Male", "Female" };
  String[] msg1= {"Pending", "Solved"};
  int i;
  File f1;
  JLabel head = new JLabel("Update Child Form");
  JLabel photo = new JLabel("\t\tPhoto\t");
  JLabel l1 = new JLabel("Missing Cases");
  JLabel ll1 = new JLabel("Found Cases");
  JLabel l2 = new JLabel("First Name");
  JLabel l3 = new JLabel("Last Name");
  JLabel l4 = new JLabel("Alias Name");
  JLabel l14 = new JLabel("D.O.B");
  JLabel l5 = new JLabel("Age");
  JLabel l6 = new JLabel("Gender");
  JLabel l7 = new JLabel("Address");
  JLabel l8 = new JLabel("City");
  JLabel l9 = new JLabel("State");
  JLabel l10 = new JLabel("Missing Date");
  JLabel l11 = new JLabel("Additional Info");
  JLabel l13 = new JLabel("Image Path");
  JLabel lst= new JLabel("Status of Case");
  JTextField t2 = new JTextField(20);
  JTextField t3 = new JTextField(20);
  JTextField t4 = new JTextField(20);
  JTextField t5 = new JTextField(20);
  JTextField t6 = new JTextField(20);
  JTextField t7 = new JTextField(20);
  JTextField t8 = new JTextField(20);
  JTextField t9 = new JTextField(20);
  JTextField t10 = new JTextField(20);
  JTextField t11 = new JTextField(20);
  JTextField t12 = new JTextField(20);
  JComboBox status= new JComboBox();
  JComboBox idc = new JComboBox();
  JComboBox c = new JComboBox();
  JComboBox idc1= new JComboBox();
  String filename;
  JButton b2 = new JButton("Update");
  JButton b3 = new JButton("Exit");
  JButton b4 = new JButton("Replace photo");
  JButton b5 = new JButton("Clear");
  int criminalid = 1;
  Connection con;
  Statement stmt;
  PreparedStatement ps;
  ResultSet rs;
private int j;
private int k;
private ResultSet localObject;
private ResultSet localObject1;
  
  Update()
  {
    super("Update Child Form");
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      this.con = DriverManager.getConnection("jdbc:odbc:abc", "", "");
      this.stmt = this.con.createStatement();
      localObject = this.stmt.executeQuery("select cid from face order by cid asc");
      
      this.idc.removeAllItems();
      this.idc.addItem("Select Id");
      while (((ResultSet)localObject).next()) {
        this.idc.addItem(((ResultSet)localObject).getString(1));
      }
      localObject1 = this.stmt.executeQuery("select cid from found order by cid asc");
      
      this.idc1.removeAllItems();
      this.idc1.addItem("Select Id");
      while (((ResultSet)localObject1).next()) {
        this.idc1.addItem(((ResultSet)localObject1).getString(1));
      }
      
    }
    catch (Exception localException)
    {
      JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details", 0);
    }
    Color customColor = new Color(00,192,255);
	Color customColor1 = new Color(255,64,00);
	Color customColor2 = new Color(255,192,64);
    Container localContainer = getContentPane();
    localContainer.setLayout(null);
    setSize(700, 710);
    setResizable(false);
    localContainer.setBackground(new Color(0,0,0));
    Object localObject = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle localRectangle = getBounds();
    setLocation((((Dimension)localObject).width - localRectangle.width) / 2, (((Dimension)localObject).height - localRectangle.height) / 2);
    
    this.head = new JLabel("Show Child Details Form");
	head.setForeground(customColor);
    this.head.setFont(new Font("Eras Bold ITC", 0, 25));
    this.head.setBounds(160, 10, 400, 30);
    localContainer.add(this.head);

	this.photo = new JLabel("");
	this.photo.setFont(new Font("Eras Bold ITC", 0, 20));			//photo=JLabel
    this.photo.setBounds(420, 85, 200, 260);
    this.photo.setForeground(customColor1);
    this.photo.setBorder(BorderFactory.createTitledBorder(""));
    localContainer.add(this.photo);
    
    
    for (int j = 0; j < 2; j++) {
      this.c.addItem(this.msg[j]);
    }
   
    for (int j = 0; j < 2; j++) {
      this.status.addItem(this.msg1[j]);
    }
    this.l1.setBounds(20, 50, 150, 30);
    this.l1.setForeground(customColor1);
    this.l1.setFont(new Font("Eras Bold ITC", 0, 17));
    this.idc.setBounds(180, 50, 100, 30);
    
    this.ll1.setBounds(420, 50, 150, 30);
    this.ll1.setForeground(customColor1);
    this.ll1.setFont(new Font("Eras Bold ITC", 0, 17));
    this.idc1.setBounds(540, 50, 100, 30);
    
    this.l2.setBounds(20, 90, 100, 30);
    this.t2.setBounds(180, 90, 215, 30);
    this.l2.setForeground(customColor1);
    this.l2.setFont(new Font("Eras Bold ITC", 0, 17));			//t2=fname
    
    this.l3.setBounds(20, 130, 100, 30);
    this.l3.setForeground(customColor1);
    this.l3.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t3.setBounds(180, 130, 215, 30);			//t3=lname
    
    this.l4.setBounds(20, 170, 100, 30);
    this.l4.setForeground(customColor1);
    this.l4.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t4.setBounds(180, 170, 215, 30);			//t4=alias
    
    this.l14.setBounds(20, 210, 100, 30);			//dob
    this.l14.setForeground(customColor1);
    this.l14.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t12.setBounds(180, 210, 215, 30);
    
    this.l5.setBounds(20, 250, 100, 30);
    this.l5.setForeground(customColor1);//t5=age
    this.l5.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t5.setBounds(180, 250, 215, 30);
    
    this.l6.setBounds(20, 290, 100, 30);
    this.l6.setForeground(customColor1);//c=gender
    this.l6.setFont(new Font("Eras Bold ITC", 0, 17));
    this.c.setBounds(180, 290, 215, 30);
    
    this.l7.setBounds(20, 330, 100, 30);
    this.l7.setForeground(customColor1);		//t7=Address
    this.l7.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t7.setBounds(180, 330, 215, 30);
    
    this.l8.setBounds(20, 370, 100, 30);
    this.l8.setForeground(customColor1);
    this.l8.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t8.setBounds(180, 370, 215, 30);			//t8=city
    
    this.l9.setBounds(20, 410, 100, 30);
    this.l9.setForeground(customColor1);
    this.l9.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t9.setBounds(180, 410, 215, 30);				//t9=state
    
    this.l10.setBounds(20, 450, 150, 30);
    this.l10.setForeground(customColor1);
    this.l10.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t10.setBounds(180, 450, 215, 30);			//t10=Found date
    
    this.l11.setBounds(20, 490, 200, 30);
    this.l11.setForeground(customColor1);
    this.l11.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t11.setBounds(180, 490, 215, 30);			//t11=Additional info
    
    this.l13.setBounds(20, 530, 100, 30);
    this.l13.setForeground(customColor1);
    this.l13.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t6.setBounds(180, 530, 215, 30);			//t6=image text
    this.b4.setBackground(customColor2);
    this.b4.setBounds(405, 530, 250, 30);
    this.b4.setForeground(Color.black);
    this.b4.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t6.setEditable(false);
    
    this.lst.setBounds(20, 570, 150, 30);
    this.lst.setForeground(customColor1);
    this.lst.setFont(new Font("Eras Bold ITC", 0, 17));
    this.status.setBounds(180,570,215,30);
    
    localContainer.add(this.l1);localContainer.add(this.idc);
    localContainer.add(this.ll1);localContainer.add(this.idc1);
    localContainer.add(this.l2);localContainer.add(this.t2);
    localContainer.add(this.l3);localContainer.add(this.t3);
    localContainer.add(this.l4);localContainer.add(this.t4);
    localContainer.add(this.l14);localContainer.add(this.t12);
    
    localContainer.add(this.l5);localContainer.add(this.t5);
    localContainer.add(this.l6);localContainer.add(this.c);
    localContainer.add(this.l7);localContainer.add(this.t7);
    localContainer.add(this.l8);localContainer.add(this.t8);
    localContainer.add(this.l9);localContainer.add(this.t9);
    localContainer.add(this.l10);localContainer.add(this.t10);
    localContainer.add(this.l11);localContainer.add(this.t11);
    localContainer.add(this.l13);localContainer.add(this.t6);localContainer.add(this.b4);
   localContainer.add(this.lst);localContainer.add(this.status);
   
    this.b2.setBounds(40, 610, 120, 30);
    this.b3.setBounds(200, 610, 85, 30);
    this.b5.setBounds(360, 610, 85, 30);
    localContainer.add(this.b2);localContainer.add(this.b3);localContainer.add(this.b5);
    
    this.b2.setForeground(Color.black);
    this.b3.setForeground(Color.black);
    this.b5.setForeground(Color.black);
    this.b2.setFont(new Font("Eras Bold ITC", 0, 17));
    this.b3.setFont(new Font("Eras Bold ITC", 0, 17));
    this.b5.setFont(new Font("Eras Bold ITC", 0, 17));
    this.b2.setBackground(customColor2);
    this.b3.setBackground(customColor2);
    this.b5.setBackground(customColor2);
    
    this.b2.addActionListener(this);
    this.b3.addActionListener(this);
    this.b4.addActionListener(this);
    this.b5.addActionListener(this);
    this.idc.addActionListener(this);
    this.idc1.addActionListener(this);
    this.b4.setEnabled(false);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    Object localObject2;
    int n;
    Object localObject1;
    if (paramActionEvent.getSource() == this.b2)
    {
    	if(l10.getText()=="Missing Date"){
    		try
    	      {
    	    	  int j = Integer.parseInt(this.idc.getSelectedItem().toString());
    	          String str1 = this.t2.getText();						//str1=fname
    	          String str2 = this.t3.getText();						//str2=lname
    	          String str3 = this.t4.getText();						//str3=alias name
    	          String str4= this.t12.getText();						//str4=year
    	          String str7 = this.t5.getText();						//str7=age
    	          String str8 = this.c.getSelectedItem().toString();		//str8=gender
    	          String str9 = this.t7.getText();						//str9=address
    	          String str10 = this.t8.getText();						//str10=city
    	          String str11 = this.t9.getText();						//str11=state
    	          String str12 = this.t10.getText();						//str12=found date
    	          String str13 = this.t11.getText();						//str13=Additional info
    	          String str14 = this.t6.getText();							//str14= photo file
    	          String str15 = this.status.getSelectedItem().toString();		//str14=status
    	          con.setAutoCommit(false);
    	          File fin= new File(str14);
    	          f1=fin;
    	          FileInputStream fis=new FileInputStream(f1);
    	          this.ps=con.prepareStatement("Update face set fname=?,lname=?,aname=?,dob=?,age=?,gender=?,address=?,city=?,state=?,missdate=?,info=?,photo=?,photofile=?,status=? where cid=" + j);
    	  			
    	  			ps.setString(1, str1);
    	  			ps.setString(2, str2);
    	  			ps.setString(3,str3);
    	  			ps.setString(4, str4);
    	  			ps.setString(5, str7);
    	  			ps.setString(6,str8);
    	  			ps.setString(7, str9);
    	  			ps.setString(8, str10);
    	  			ps.setString(9,str11);
    	  			ps.setString(10, str12);
    	  			ps.setString(11,str13);
    	  			ps.setBinaryStream(12, fis,(int)f1.length());
    	  			ps.setString(13,str14);
    	  			ps.setString(14, str15);
    	  			int m=ps.executeUpdate();
    	  			con.commit();
    	  			ps.close();
    	  			fis.close();
    	  			
    	          if (m == 1) {
    	            JOptionPane.showMessageDialog(this, "Record Updated Successfully");
    	          }
    	    }
    	      catch (Exception localException1)
    	      {
    	        JOptionPane.showMessageDialog(this, localException1.getMessage(), "Updating the Child Details", 0);
    	        localException1.printStackTrace();
    	      }
			}
    	else if(l10.getText()=="Found Date"){
    		try
  	      {
  	    	  int j = Integer.parseInt(this.idc1.getSelectedItem().toString());
  	          String str1 = this.t2.getText();						//str1=fname
  	          String str2 = this.t3.getText();						//str2=lname
  	          String str3 = this.t4.getText();						//str3=alias name
  	          String str4= this.t12.getText();						//str4=year
  	          String str7 = this.t5.getText();						//str7=age
  	          String str8 = this.c.getSelectedItem().toString();		//str8=gender
  	          String str9 = this.t7.getText();						//str9=address
  	          String str10 = this.t8.getText();						//str10=city
  	          String str11 = this.t9.getText();						//str11=state
  	          String str12 = this.t10.getText();						//str12=found date
  	          String str13 = this.t11.getText();						//str13=Additional info
  	          String str14 = this.t6.getText();							//str14= photo file
  	          String str15 = this.status.getSelectedItem().toString();		//str14=status
  	          con.setAutoCommit(false);
  	          File fin= new File(str14);
  	          f1=fin;
  	          FileInputStream fis=new FileInputStream(f1);
  	          this.ps=con.prepareStatement("Update found set fname=?,lname=?,aname=?,dob=?,age=?,gender=?,address=?,city=?,state=?,founddate=?,info=?,photo=?,photofile=?,status=? where cid=" + j);
  	  			
  	  			ps.setString(1, str1);
  	  			ps.setString(2, str2);
  	  			ps.setString(3,str3);
  	  			ps.setString(4, str4);
  	  			ps.setString(5, str7);
  	  			ps.setString(6,str8);
  	  			ps.setString(7, str9);
  	  			ps.setString(8, str10);
  	  			ps.setString(9,str11);
  	  			ps.setString(10, str12);
  	  			ps.setString(11,str13);
  	  			ps.setBinaryStream(12, fis,(int)f1.length());
  	  			ps.setString(13,str14);
  	  			ps.setString(14, str15);
  	  			int m=ps.executeUpdate();
  	  			con.commit();
  	  			ps.close();
  	  			fis.close();
  	  			
  	          if (m == 1) {
  	            JOptionPane.showMessageDialog(this, "Record Updated Successfully");
  	          }
  	    }
  	      catch (Exception localException1)
  	      {
  	        JOptionPane.showMessageDialog(this, localException1.getMessage(), "Updating the Child Details", 0);
  	        localException1.printStackTrace();
  	      }
			
    	}
    	
    }
    else if (paramActionEvent.getSource() == this.b5)
    {
    	
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
        this.status.setSelectedIndex(0);
        this.c.setSelectedIndex(0);
      this.photo.setVisible(false);       
    }
    else if (paramActionEvent.getSource() == this.b4)
    {
    	JFileChooser chooser = new JFileChooser();
	    chooser.showOpenDialog(null);
	    File f = chooser.getSelectedFile();
	    f1=f;
	    filename = f.getAbsolutePath();
	    t6.setText(filename);
	    try {
	        ImageIcon ii=new ImageIcon(scaleImage(200, 260, ImageIO.read(new File(filename))));//get the image from file chooser and scale it to match JLabel size
	        photo.setIcon(ii);
	    } 
	    catch (Exception ex) {
	        ex.printStackTrace();
	    }
    }
    else if (paramActionEvent.getSource() == this.b3)
    {
      setVisible(false);
      dispose();
    }
    if (paramActionEvent.getSource() == this.idc) {
      if (this.idc.getSelectedIndex() != 0) {
        try
        {
          localObject1 = this.idc.getSelectedItem().toString();
          localObject2 = this.stmt.executeQuery("select cid, fname, lname, aname, dob, age, gender, address, city, state, missdate, info, photo, photofile,status from face where cid=" + (String)localObject1);
          if (((ResultSet)localObject2).next())
          {
            this.b4.setEnabled(true);
            this.l10.setText("Missing Date");
            this.t2.setText(((ResultSet)localObject2).getString(2).trim());
            this.t3.setText(((ResultSet)localObject2).getString(3).trim());
            this.t4.setText(((ResultSet)localObject2).getString(4).trim());
            
            this.t12.setText(((ResultSet)localObject2).getString(5).trim()) ;       
                      
            this.t5.setText(((ResultSet)localObject2).getString(6).trim());
            this.c.setSelectedItem(((ResultSet)localObject2).getString(7).trim());
            this.t7.setText(((ResultSet)localObject2).getString(8).trim());
            this.t8.setText(((ResultSet)localObject2).getString(9).trim());
            this.t9.setText(((ResultSet)localObject2).getString(10).trim());
            this.t10.setText(((ResultSet)localObject2).getString(11).trim());
            this.t11.setText(((ResultSet)localObject2).getString(12).trim());
            String str4 = ((ResultSet)localObject2).getString("photofile").trim();
            this.t6.setText(str4);
            this.status.setSelectedItem(((ResultSet)localObject2).getString("status").trim());
           
            PreparedStatement st;
			ResultSet rs;
            con.setAutoCommit(false);
			st=con.prepareStatement("select photo from face where cid=?");
			st.setString(1, (String)localObject1);
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
        catch (Exception localException2)
        {
          JOptionPane.showMessageDialog(this, localException2.getMessage(), "Child Details", 0);
        }
      }
    }
    if (paramActionEvent.getSource() == this.idc1) {
        if (this.idc1.getSelectedIndex() != 0) {
          try
          {
            localObject1 = this.idc1.getSelectedItem().toString();
            localObject2 = this.stmt.executeQuery("select cid, fname, lname, aname, dob, age, gender, address, city, state, founddate, info, photo, photofile,status from found where cid=" + (String)localObject1);
            if (((ResultSet)localObject2).next())
            {
              this.b4.setEnabled(true);
              this.l10.setText("Found Date");
              this.t2.setText(((ResultSet)localObject2).getString(2).trim());
              this.t3.setText(((ResultSet)localObject2).getString(3).trim());
              this.t4.setText(((ResultSet)localObject2).getString(4).trim());
              
              this.t12.setText(((ResultSet)localObject2).getString(5).trim()) ;       
                        
              this.t5.setText(((ResultSet)localObject2).getString(6).trim());
              this.c.setSelectedItem(((ResultSet)localObject2).getString(7).trim());
              this.t7.setText(((ResultSet)localObject2).getString(8).trim());
              this.t8.setText(((ResultSet)localObject2).getString(9).trim());
              this.t9.setText(((ResultSet)localObject2).getString(10).trim());
              this.t10.setText(((ResultSet)localObject2).getString(11).trim());
              this.t11.setText(((ResultSet)localObject2).getString(12).trim());
              String str4 = ((ResultSet)localObject2).getString("photofile").trim();
              this.t6.setText(str4);
              this.status.setSelectedItem(((ResultSet)localObject2).getString("status").trim());
             
              PreparedStatement st;
  			ResultSet rs;
              con.setAutoCommit(false);
  			st=con.prepareStatement("select photo from found where cid=?");
  			st.setString(1, (String)localObject1);
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
          catch (Exception localException2)
          {
            JOptionPane.showMessageDialog(this, localException2.getMessage(), "Child Details", 0);
          }
        }
      }
  }

 public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
	    BufferedImage bi;
	    bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(img, 0, 0, w, h, null);
	    g2d.dispose();
	    return bi;
	}
}
