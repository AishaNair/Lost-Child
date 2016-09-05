import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.DefaultEditorKit.CutAction;

class Login
  extends JFrame
  implements ActionListener
{
  JLabel l;
  JLabel l1;
  JLabel l2;
  JLabel pic;
  JTextField t1;
  JTextField t2;
  JButton b1;
  JButton b2;
  
  Login()
  {
    super("Login Page");
    Color customColor = new Color(00,192,255);
    Color customColor1 = new Color(255,64,00);
    Color customColor2 = new Color(255,192,64);
    this.pic= new JLabel("");
    ImageIcon image = new ImageIcon("C://Users/Aisha/Lost Child Returns/icon.jpg");
    this.pic.setIcon(image);
    this.l = new JLabel("Lost Child Login Screen");
    this.l.setFont(new Font("Eras Bold ITC", 0, 20));
    this.l.setForeground(customColor);
    this.l1 = new JLabel(" User Name ");
    this.l2 = new JLabel(" Password ");
    this.l1.setForeground(customColor1);
    this.l2.setForeground(customColor1);
    this.l1.setFont(new Font("Eras Bold ITC", 0, 17));
    this.l2.setFont(new Font("Eras Bold ITC", 0, 17));
    this.t1 = new JTextField(10);
    this.t2 = new JPasswordField(10);
    
    this.b1 = new JButton(" Submit ");
    this.b2 = new JButton(" Cancel");
    
    JPanel localJPanel1 = new JPanel();
    JPanel localJPanel2 = new JPanel();
    localJPanel1.setBackground(new Color(0,0,0));
    localJPanel2.setBackground(new Color(0,0,0));
    Container localContainer = getContentPane();
    localContainer.setLayout(null);
    localContainer.add(localJPanel1);
    localContainer.add(localJPanel2);
    localContainer.setBackground(new Color(32,32,32));
    
    setSize(400, 500);
    setResizable(false);
    
    Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle localRectangle = getBounds();
    setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);
    
    localJPanel1.setBounds(40, 20, 300, 300);
    localJPanel2.setBounds(40, 350, 300, 100);
    
    this.l.setBounds(30, 10, 250, 30);
    this.pic.setBounds(30,40,250,120);
    this.l1.setBounds(40, 200, 120, 30);
    this.t1.setBounds(180, 200, 100, 30);
    
    this.l2.setBounds(40, 250, 120, 30);
    this.t2.setBounds(180, 250, 100, 30);
    
    localJPanel1.setLayout(null);
    
    localJPanel1.add(this.l);localJPanel1.add(this.pic);
    localJPanel1.add(this.l1);localJPanel1.add(this.t1);
    localJPanel1.add(this.l2);localJPanel1.add(this.t2);
    this.b1.setFont(new Font("Eras Bold ITC", 0, 15));
    this.b2.setFont(new Font("Eras Bold ITC", 0, 15));
    this.b1.setForeground(Color.black);
    this.b1.setBackground(customColor2);
    this.b2.setForeground(Color.black);
    this.b2.setBackground(customColor2);
    this.b1.setBounds(30, 40, 100, 30);
    this.b2.setBounds(160, 40, 100, 30);
    
    this.t1.setFont(new Font("Times New Roman", 0, 18));
    this.t2.setFont(new Font("Times New Roman", 0, 18));
    
    localJPanel2.setLayout(null);
    localJPanel2.add(this.b1);localJPanel2.add(this.b2);
    
    this.b1.addActionListener(this);
    this.b2.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    JButton localJButton = (JButton)paramActionEvent.getSource();
    if (localJButton == this.b1)
    {
      String str1 = this.t1.getText();
      String str2 = this.t2.getText();
      if (this.t1.getText().equals("abc"))
      {
        if (this.t2.getText().equals("password"))
        {
          setVisible(false);
          dispose();
          new FaceMenu().show();
        }
        else
        {
          JOptionPane.showMessageDialog(this, "Invalid password", "Sign In", 2);
          this.t2.setText("");
          this.t2.requestFocus();
        }
      }
      else
      {
        JOptionPane.showMessageDialog(this, "Invalid UserName", "Sign In", 2);
        this.t1.setText("");
        this.t1.requestFocus();
        this.t2.setText("");
      }
    }
    if (localJButton == this.b2) {
      System.exit(0);
    }
  }
 
  public static void main(String[] paramArrayOfString)
  {
	  Login localLogin = new Login();
	  localLogin.show();
	  
  }
}
