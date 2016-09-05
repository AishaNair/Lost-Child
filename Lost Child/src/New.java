import java.awt.Canvas;
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
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class New
  extends JFrame
  implements ActionListener
{
 
  String[] msg = { "Male", "Female" };
  String[] msg1 = { "Pending", "Solved" };
  int i;
  File f1;
  JLabel head = new JLabel("New Missing Case Report Form");
  JLabel photo = new JLabel("\t\tPhoto\t");
  JLabel l1 = new JLabel("Enter Id");
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
  JLabel l15= new JLabel("Status of Case");
  JTextField t1 = new JTextField(20);		
  JTextField t2 = new JTextField(20);
  JTextField t3 = new JTextField(20);
  JTextField t4 = new JTextField(20);
  JTextField t5 = new JTextField(20);
  JTextField t6 = new JTextField(20);
  JTextField t7 = new JTextField(20);
  JTextField t8 = new JTextField(20);
  JTextField t9 = new JTextField(20);
  JTextField t11 = new JTextField(20);
  JComboBox c = new JComboBox();
  JComboBox status = new JComboBox();
  JComboBox da = new JComboBox();
  JComboBox mo = new JComboBox();
  JComboBox yr = new JComboBox();
  JComboBox dd = new JComboBox();
  JComboBox mm = new JComboBox();
  JComboBox yy = new JComboBox();
  JButton b2 = new JButton("Ok");
  JButton b3 = new JButton("Exit");
  JButton b4 = new JButton(".......");
  JButton b5 = new JButton("Clear");
  int id = 0;
  Connection con;
  Statement stmt;
  PreparedStatement ps;
private int j;
private int k;
  
  New()
  {
    super("New Child Record");
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      this.con = DriverManager.getConnection("jdbc:odbc:abc", "", "");
     this.stmt = this.con.createStatement();
     
      ResultSet localObject1 = this.stmt.executeQuery("select max(cid) from face");
      if (((ResultSet)localObject1).next())
      {
        String localObject2 = ((ResultSet)localObject1).getString(1);
        if (localObject2 != null) {
          this.id = Integer.parseInt((String)localObject2);
        }
      }
      this.id += 1;
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
    setSize(650, 700);
    setResizable(false);
    
    Object localObject1 = Toolkit.getDefaultToolkit().getScreenSize();
    Object localObject2 = getBounds();
    setLocation((((Dimension)localObject1).width - ((Rectangle)localObject2).width) / 2, (((Dimension)localObject1).height - ((Rectangle)localObject2).height) / 2);
    
    localContainer.setBackground(new Color(0,0,0));
   
    head.setForeground(customColor);
    
    this.head.setFont(new Font("Eras Bold ITC", 0, 25));
    this.head.setBounds(140, 10, 400, 30);
    localContainer.add(this.head);
    
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
  
    this.da.addItem("NA");
    for (j = 1; j <= 31; j++) {
      this.da.addItem(j + "");
    }
   
    String[] arrayOfString = {"NA", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
    for (int k = 0; k <= 12; k++) {
      this.mo.addItem(arrayOfString[k]);
    }

    this.yr.addItem("NA");
    for (k = 1995; k <= 2015; k++) {
      this.yr.addItem(k + "");
    }
    
     
      for (j = 1; j <= 31; j++) {
        this.dd.addItem(j + "");
      }
    
      String[] arrayString1 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
      for (int k = 0; k < 12; k++) {
        this.mm.addItem(arrayString1[k]);
      }
     
      for (k = 1995; k <= 2015; k++) {
        this.yy.addItem(k + "");
      }
      
    this.t1.setText(this.id + "");					//t1=eno
    this.t1.setEditable(false);
    
    this.t2.requestFocus();							
    this.l1.setBounds(20, 50, 100, 30);
    this.l1.setForeground(customColor1);
    this.l1.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t1.setBounds(180, 50, 215, 30);
    
    this.l2.setBounds(20, 90, 100, 30);
    this.t2.setBounds(180, 90, 215, 30);
    this.l2.setForeground(customColor1);
    this.l2.setFont(new Font("Eras Bold ITC", 0, 17));//t2=fname
    
    this.l3.setBounds(20, 130, 100, 30);
    this.l3.setForeground(customColor1);
    this.l3.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t3.setBounds(180, 130, 215, 30);			//t3=lname
    
    this.l4.setBounds(20, 170, 100, 30);
    this.l4.setForeground(customColor1);
    this.l4.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t4.setBounds(180, 170, 215, 30);			//t4=alias
    
    this.l14.setBounds(20, 210, 100, 30);
    this.l14.setForeground(customColor1);
    this.l14.setFont(new Font("Eras Bold ITC", 0, 17));
    this.da.setBounds(180, 210, 55, 30);
    this.mo.setBounds(245, 210, 80, 30);
    this.yr.setBounds(335, 210, 60, 30);
    
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
    this.t9.setBounds(180, 410, 215, 30);			//t9=state
    
    this.l10.setBounds(20, 450, 150, 30);
    this.l10.setForeground(customColor1);
    this.l10.setFont(new Font("Eras Bold ITC", 0, 17));   //missing date
    this.dd.setBounds(180, 450, 55, 30);
    this.mm.setBounds(245, 450, 80, 30);
    this.yy.setBounds(335, 450, 60, 30);
    
    
    this.l11.setBounds(20, 490, 200, 30);
    this.l11.setForeground(customColor1);
    this.l11.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t11.setBounds(180, 490, 215, 30);			//t11=Additional info
    
    this.l13.setBounds(20, 530, 100, 30);
    this.l13.setForeground(customColor1);
    this.l13.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t6.setBounds(180, 530, 215, 30);//t6=image text
    
    this.b4.setBackground(customColor2);
    this.b4.setBounds(405, 530, 80, 30);
    this.b4.setForeground(Color.black);
    this.b4.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t6.setEditable(false);
    
    this.l15.setBounds(20, 570, 150, 30);			//l15=status
    this.l15.setForeground(customColor1);
    this.l15.setFont(new Font("Eras Bold ITC", 0, 17));
    this.status.setBounds(180, 570, 215, 30);
    
    localContainer.add(this.l1);localContainer.add(this.t1);
    localContainer.add(this.l2);localContainer.add(this.t2);
    localContainer.add(this.l3);localContainer.add(this.t3);
    localContainer.add(this.l4);localContainer.add(this.t4);
    localContainer.add(this.l14);localContainer.add(this.da);
    localContainer.add(this.mo);
    localContainer.add(this.yr);
    localContainer.add(this.dd);
    localContainer.add(this.mm);localContainer.add(this.yy);
    localContainer.add(this.l5);localContainer.add(this.t5);
    localContainer.add(this.l6);localContainer.add(this.c);
    localContainer.add(this.l7);localContainer.add(this.t7);
    localContainer.add(this.l8);localContainer.add(this.t8);
    localContainer.add(this.l9);localContainer.add(this.t9);
    localContainer.add(this.l10);
    localContainer.add(this.l11);localContainer.add(this.t11);
    localContainer.add(this.l13);localContainer.add(this.t6);
    localContainer.add(this.b4);
    localContainer.add(this.l15);localContainer.add(this.status);
    
    
    this.b2.setBounds(40, 610, 85, 30);
    this.b3.setBounds(200, 610, 85, 30);
    this.b5.setBounds(360, 610, 85, 30);
   
    this.b2.setForeground(Color.black);
    this.b3.setForeground(Color.black);
    this.b5.setForeground(Color.black);
    this.b2.setFont(new Font("Eras Bold ITC", 0, 17));
    this.b3.setFont(new Font("Eras Bold ITC", 0, 17));
    this.b5.setFont(new Font("Eras Bold ITC", 0, 17));
    
    this.b2.setBackground(customColor2);
    this.b3.setBackground(customColor2);
    this.b5.setBackground(customColor2);
    
    localContainer.add(this.b2);localContainer.add(this.b3);localContainer.add(this.b5);
       
    this.b2.addActionListener(this);
    this.b3.addActionListener(this);
    this.b4.addActionListener(this);
    this.b5.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    JButton localJButton = (JButton)paramActionEvent.getSource();
    if (localJButton == this.b2)		//b2=Ok
    {
      try
      {
        int j = Integer.parseInt(this.t1.getText());
        String str1 = this.t2.getText();						//str1=fname
        String str2 = this.t3.getText();						//str2=lname
        String str3 = this.t4.getText();						//str3=alias name
        String str4 = this.da.getSelectedItem().toString();		//str4=date
        String str5 = this.mo.getSelectedItem().toString();		//str5=month
        String str6 = this.yr.getSelectedItem().toString();		//str6=year
        String str7 = this.t5.getText();						//str7=age
        String str8 = this.c.getSelectedItem().toString();		//str8=gender
        String str9 = this.t7.getText();						//str9=address
        String str10 = this.t8.getText();						//str10=city
        String str11 = this.t9.getText();						  //str11=state
        String str12 = this.dd.getSelectedItem().toString();		//str12=found date
        String str13 = this.mm.getSelectedItem().toString();	//str13=found month
        String str14 = this.yy.getSelectedItem().toString();	//str14=found year
        String str16 = this.t6.getText();						//str16=photo file
        String str15 = this.t11.getText();						//str15=Additional info
        String str17 = this.status.getSelectedItem().toString();		//str17=status
       	int flag=0;					       
       this.stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from face where fname='"+str1+"' or lname='"+str2+"' or aname='"+str3+"'" );
        while(rs.next()){
        	int response = JOptionPane.showConfirmDialog(this,"Similar record found. Wish to view it?", "Record Found",
        			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	if (response == JOptionPane.NO_OPTION) {
        	 	dispose();
        	    } 
        	else if (response == JOptionPane.YES_OPTION) {
        	      newmissfound f= new newmissfound(str1,str2,str3);
        	      flag++;    
        	} 
        	
        }
        if(flag==0){
        con.setAutoCommit(false);
        FileInputStream fis=new FileInputStream(f1);
		this.ps=con.prepareStatement("insert into face values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,j);
			ps.setString(2, str1);
			ps.setString(3, str2);
			ps.setString(4,str3);
			ps.setString(5, str4+"-"+str5+"-"+str6);
			ps.setString(6, str7);
			ps.setString(7,str8);
			ps.setString(8, str9);
			ps.setString(9, str10);
			ps.setString(10,str11);
			ps.setString(11,str12+"-"+str13+"-"+str14);
			ps.setString(12,str15);
			ps.setBinaryStream(13, fis,(int)f1.length());
			ps.setString(14,str16);
			ps.setString(15,str17);
			int m=ps.executeUpdate();
			con.commit();
			ps.close();
			fis.close();
			
        if (m == 1) {
          JOptionPane.showMessageDialog(this, "Record Inserted");
        }        
       }
      }
      catch (Exception localException)
      {
    	  localException.printStackTrace();
        JOptionPane.showMessageDialog(this, localException.getMessage(), "New Child Record", 0);
      }
    }
    else if (localJButton == this.b5)
    {
      this.t2.setText("");
      this.t3.setText("");
      this.t4.setText("");
      this.t5.setText("");
      this.t6.setText("");
      this.t7.setText("");
      this.t8.setText("");
      this.t9.setText("");
     
      this.t11.setText("");
      this.c.setSelectedIndex(0);
      this.da.setSelectedIndex(0);
      this.mo.setSelectedIndex(0);
      this.yr.setSelectedIndex(0);
      this.dd.setSelectedIndex(0);
      this.mm.setSelectedIndex(0);
      this.yy.setSelectedIndex(0);
      this.status.setSelectedIndex(0);
    }
    else if (localJButton == this.b4)
    {
    	JFileChooser chooser = new JFileChooser();
	    chooser.showOpenDialog(null);
	    File f = chooser.getSelectedFile();
	    f1=f;
	    String filename = f.getAbsolutePath();
	    t6.setText(filename);
	    try {
	        ImageIcon ii=new ImageIcon(scaleImage(200, 260, ImageIO.read(new File(filename))));//get the image from file chooser and scale it to match JLabel size
	        photo.setIcon(ii);
	    } 
	    catch (Exception ex) {
	        ex.printStackTrace();
	    }
    }
    else if (localJButton == this.b3)
    {
      setVisible(false);
      dispose();
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
