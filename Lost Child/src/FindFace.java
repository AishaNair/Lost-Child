import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.MemoryImageSource;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FindFace
  extends JFrame
{
  Connection cn;
  Statement stmt;
  boolean selectstatus = false;
  int[] cids = new int[6];
  private JButton btnClose;
  private JButton btnMostSimilar;
  private JButton btnAllSimilar;
  private JLabel lblPhoto;
  private JLabel lblChildId;
  private JComboBox cmbChildId;
  private JLabel jLabel1;
  Color customColor = new Color(00,192,255);
  Color customColor1 = new Color(255,64,00);
  Color customColor2 = new Color(255,192,64);
  public FindFace()
  {
    initComponents();
    setSize(650, 650);
   
    Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle localRectangle = getBounds();
    setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);
    
    setTitle("Find Face & Child Details Screen");
    setResizable(false);
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      this.cn = DriverManager.getConnection("jdbc:odbc:abc", "", "");
      this.stmt = this.cn.createStatement();
      ResultSet localResultSet = this.stmt.executeQuery("select * from face_suspectphoto");
      this.cmbChildId.removeAllItems();
      this.cmbChildId.addItem("Select");
      while (localResultSet.next()) {
        this.cmbChildId.addItem(localResultSet.getString(1));
      }
    }
    catch (Exception localException)
    {
      JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details", 0);
    }
    this.selectstatus = true;
  }
  
  private void initComponents()
  {
    this.lblPhoto = new JLabel();
    this.cmbChildId = new JComboBox();
    this.lblChildId = new JLabel();
    this.lblChildId.setForeground(customColor1);
    this.lblChildId.setFont(new Font("Eras Bold ITC", 0, 15));
    this.btnMostSimilar = new JButton();
    this.btnAllSimilar = new JButton();
    this.btnClose = new JButton();
    
    this.jLabel1 = new JLabel();
    this.jLabel1.setForeground(customColor);
    this.jLabel1.setFont(new Font("Eras Bold ITC", 0, 25));
    getContentPane().setLayout(null);
    getContentPane().setBackground(Color.black);
    
    addMouseListener(new MouseAdapter()
    {
      public void mousePressed(MouseEvent paramAnonymousMouseEvent)
      {
        FindFace.this.formMousePressed(paramAnonymousMouseEvent);
      }
    });
    
    getContentPane().add(this.lblPhoto);
    this.lblPhoto.setBounds(200, 100, 250, 500);
    
    this.cmbChildId.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        FindFace.this.cmbCrimeIdActionPerformed(paramAnonymousActionEvent);
      }
    });
    getContentPane().add(this.cmbChildId);
    this.cmbChildId.setBounds(90, 100, 160, 25);
    
    this.lblChildId.setText("Child ID");
    getContentPane().add(this.lblChildId);
    this.lblChildId.setBounds(20, 100, 150, 16);
    
    this.btnAllSimilar.setText("Show All Similar Faces");
    this.btnAllSimilar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        FindFace.this.btnAllSuspectsActionPerformed(paramAnonymousActionEvent);
      }
    });
    getContentPane().add(this.btnAllSimilar);
    this.btnAllSimilar.setBounds(20, 550, 200, 30);
    
    this.btnMostSimilar.setText("Show Most Suitable Child");
    this.btnMostSimilar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        FindFace.this.btnMostSupspectActionPerformed(paramAnonymousActionEvent);
      }
    });
    getContentPane().add(this.btnMostSimilar);
    this.btnMostSimilar.setBounds(230, 550, 200, 30);
    
    this.btnClose.setText("Close");
    this.btnClose.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        FindFace.this.btnCloseActionPerformed(paramAnonymousActionEvent);
      }
    });
    getContentPane().add(this.btnClose);
    this.btnClose.setBounds(450, 550, 100, 30);
    
    
    this.jLabel1.setText("Find Similar Child Faces");
    getContentPane().add(this.jLabel1);
    this.jLabel1.setBounds(150, 10, 300, 30);
    
    pack();
  }
  
  private void btnCloseActionPerformed(ActionEvent paramActionEvent)
  {
    setVisible(false);
    dispose();
  }
  
  private void btnMostSupspectActionPerformed(ActionEvent paramActionEvent)
  {
    new ShowMaxPossible(this, true, this.cids, false).show();
  }
  
  private void btnAllSuspectsActionPerformed(ActionEvent paramActionEvent)
  {
    new ShowMaxPossible(this, true, this.cids, true).show();
  }
  
  private void cmbCrimeIdActionPerformed(ActionEvent paramActionEvent)
  {
    if (this.cmbChildId.getSelectedIndex() != 0)
    {
      String str1 = this.cmbChildId.getSelectedItem().toString();
      try
      {
        ResultSet localResultSet = this.stmt.executeQuery("select * from face_suspectphoto where childid=" + str1);
        String str2 = "";
        int i = 0;
        while (localResultSet.next())
        {
          str2 = localResultSet.getString(2);
          i = Integer.parseInt(localResultSet.getString(3));
        }
        FileInputStream localFileInputStream = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Suspects/" + str2);
        DataInputStream localDataInputStream = new DataInputStream(localFileInputStream);
        int j = localFileInputStream.available();
        int[] arrayOfInt = new int[j];
        int k = 0;
        while (localFileInputStream.available() > 0)
        {
          arrayOfInt[k] = localDataInputStream.readInt();
          k++;
        }
        localFileInputStream.close();
        localDataInputStream.close();
        Image localImage = createImage(new MemoryImageSource(200, i, arrayOfInt, 0, 200));
        ImageIcon localImageIcon = new ImageIcon(localImage);
        this.lblPhoto.setIcon(localImageIcon);
        localResultSet.close();
        
        localResultSet = this.stmt.executeQuery("select * from face_suspects where childid=" + str1);
        k = 0;
        while (localResultSet.next())
        {
          this.cids[k] = Integer.parseInt(localResultSet.getString(2));
          k++;
        }
      }
      catch (Exception localException)
      {
        JOptionPane.showMessageDialog(this, localException.getMessage(), "Photo Status", 0);
      }
    }
  }
  
  private void formMousePressed(MouseEvent paramMouseEvent) {}
  
  
  
 
}
