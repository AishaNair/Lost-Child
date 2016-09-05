import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ShowMaxPossible
  extends JDialog
{
  Vector cidvect = new Vector(2, 2);
  Vector cidrepeats = new Vector(2, 2);
  Vector finalVect = new Vector(2, 2);
  Connection cn;
  Statement stmt;
  int presentsimilar = 0;
  private JButton btnClose;
  private JButton btnPrevious;
  private JButton btnNext;
  private JLabel lblChildId;
  private JLabel lblHeading;
  private JLabel lblPhoto;
  private JLabel jLabel11;
  private JLabel jLabel10;
  private JLabel jLabel9;
  private JLabel jLabel8;
  private JLabel jLabel7;
  private JLabel jLabel6;
  private JLabel jLabel5;
  private JLabel lblPhotoSpace;
  private JLabel jLabel4;
  private JLabel jLabel3;
  private JLabel jLabel2;
  private JLabel jLabel1;
  private JLabel jStatus;
  private JLabel lcr;
  private JLabel lfname;
  private JLabel llast;
  private JLabel lalias;
  private JLabel ldob;
  private JLabel lage;
  private JLabel lgender;
  private JLabel laddress;
  private JLabel lcity;
  private JLabel lstate;
  private JLabel lfoundate;
  private JLabel linfo;
private JLabel lstatus;

  
  public ShowMaxPossible(Frame paramFrame, boolean paramBoolean1, int[] paramArrayOfInt, boolean paramBoolean2)
  {
	super(paramFrame, paramBoolean1);
    initComponents();
    setSize(575, 650);
   
    Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle localRectangle = getBounds();
    setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);
    
    setResizable(false);
    if (paramBoolean2) {
      this.lblHeading.setText("View All Similar Faces");
    } else {
      this.lblHeading.setText("Most Possible Similar Face(s)");
    }
    this.btnNext.setEnabled(false);
    this.btnPrevious.setEnabled(false);
    setTitle("Child Mostly suitable with the Designed Photo");
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      this.cn = DriverManager.getConnection("jdbc:odbc:abc", "", "");
      this.stmt = this.cn.createStatement();
    }
    catch (Exception localException) {}
    int i = 0;
    int j = 0;
   
    for (int k = 0; k < 6; k++)
    {
      j = 1;
      if (!this.cidvect.contains(new Integer(paramArrayOfInt[k])))
      {
        for (int m = k + 1; m < 6; m++) {
          if (paramArrayOfInt[k] == paramArrayOfInt[m]) {
            j++;
          }
        }
        this.cidvect.add(new Integer(paramArrayOfInt[k]));
        this.cidrepeats.add(new Integer(j));
        if (j > i) {
          i = j;
        }
      }
    }
    if (!paramBoolean2) {
      this.finalVect = finalList(i);
    } else {
      this.finalVect = this.cidvect;
    }
    Integer localInteger = (Integer)this.finalVect.elementAt(this.presentsimilar);
    displayDetails(localInteger.intValue());
    if (this.finalVect.size() == 1)
    {
      this.btnNext.setEnabled(false);
      this.btnPrevious.setEnabled(false);
    }
    else
    {
      this.btnNext.setEnabled(true);
    }
  }
  
  private void initComponents()
  {
    this.lblChildId = new JLabel("Child Id");
    
    this.jLabel1 = new JLabel("First Name");
    this.jLabel2 = new JLabel("Last Name");
    this.jLabel3 = new JLabel("Alias Name");
    this.jLabel4 = new JLabel("D.O.B");
    this.jLabel5 = new JLabel("Age");
    this.jLabel6 = new JLabel("Gender");
    this.jLabel7 = new JLabel("Address");
    this.jLabel8 = new JLabel("City");
    this.jLabel9 = new JLabel("State");
    this.jLabel10 = new JLabel("Found Date");
    this.jLabel11 = new JLabel("Info");
    this.jStatus = new JLabel("Status");
    this.lblPhoto = new JLabel();
    this.lblPhotoSpace = new JLabel();
    
    this.lcr = new JLabel("cr");
    this.lfname = new JLabel("fn");
    this.llast = new JLabel("la");
    this.lalias = new JLabel("al");
    this.ldob = new JLabel("dop");
    this.lage = new JLabel("afe");
    this.lgender = new JLabel("ge");
    this.laddress = new JLabel("add");
    this.lcity = new JLabel("ci");
    this.lstate = new JLabel("st");
    this.lfoundate = new JLabel("ar");
    this.linfo = new JLabel("cri");
    this.lstatus = new JLabel("st");
    this.btnClose = new JButton();
    this.btnPrevious = new JButton();
    this.btnNext = new JButton();
    
    this.lblHeading = new JLabel();
    
    getContentPane().setLayout(null);
    
    addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent)
      {
        ShowMaxPossible.this.formMouseClicked(paramAnonymousMouseEvent);
      }
    });
    addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent paramAnonymousWindowEvent)
      {
        ShowMaxPossible.this.closeDialog(paramAnonymousWindowEvent);
      }
    });
    getContentPane().add(this.lblChildId);
    this.lblChildId.setBounds(10, 40, 90, 30);
    
    getContentPane().add(this.lcr);
    this.lcr.setBounds(130, 40, 90, 30);
    
    getContentPane().add(this.jLabel1);
    this.jLabel1.setBounds(10, 80, 90, 30);
    
    getContentPane().add(this.lfname);
    this.lfname.setBounds(130, 80, 90, 30);
    
    getContentPane().add(this.jLabel2);
    this.jLabel2.setBounds(10, 120, 90, 30);
    
    getContentPane().add(this.llast);
    this.llast.setBounds(130, 120, 90, 30);
    
    getContentPane().add(this.jLabel3);
    this.jLabel3.setBounds(10, 160, 90, 30);
    
    getContentPane().add(this.lalias);
    this.lalias.setBounds(130, 160, 90, 30);
    
    getContentPane().add(this.jLabel4);
    this.jLabel4.setBounds(10, 200, 90, 30);
    
    getContentPane().add(this.ldob);
    this.ldob.setBounds(130, 200, 120, 30);
    
    getContentPane().add(this.jLabel5);
    this.jLabel5.setBounds(10, 240, 90, 30);
    
    getContentPane().add(this.lage);
    this.lage.setBounds(130, 240, 120, 30);
    
    getContentPane().add(this.jLabel6);
    this.jLabel6.setBounds(10, 280, 90, 30);
    
    getContentPane().add(this.lgender);
    this.lgender.setBounds(130, 280, 90, 30);
    
    getContentPane().add(this.jLabel7);
    this.jLabel7.setBounds(10, 320, 90, 30);
    
    getContentPane().add(this.laddress);
    this.laddress.setBounds(130, 320, 150, 30);
    
    getContentPane().add(this.jLabel8);
    this.jLabel8.setBounds(10, 360, 90, 30);
    
    getContentPane().add(this.lcity);
    this.lcity.setBounds(130, 360, 150, 30);
    
    getContentPane().add(this.jLabel9);
    this.jLabel9.setBounds(10, 400, 90, 30);
    
    getContentPane().add(this.lstate);
    this.lstate.setBounds(130, 400, 150, 30);
    
    getContentPane().add(this.jLabel10);
    this.jLabel10.setBounds(10, 440, 90, 30);
    
    getContentPane().add(this.lfoundate);
    this.lfoundate.setBounds(130, 440, 130, 30);
    
    getContentPane().add(this.jLabel11);
    this.jLabel11.setBounds(10, 480, 90, 30);
    
    getContentPane().add(this.linfo);
    this.linfo.setBounds(130, 480, 300, 30);
    
    getContentPane().add(this.jStatus);
    this.jStatus.setBounds(10, 520, 90, 30);
    
    getContentPane().add(this.lstatus);
    this.lstatus.setBounds(130, 520, 90, 30);
    
    this.lblPhoto.setText("Photo");
    getContentPane().add(this.lblPhoto);
    this.lblPhoto.setBounds(410, 40, 33, 16);
    
    getContentPane().add(this.lblPhotoSpace);
    this.lblPhotoSpace.setBounds(310, 60, 240, 260);
    
    this.btnClose.setText("Close");
    this.btnClose.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        ShowMaxPossible.this.btnCloseActionPerformed(paramAnonymousActionEvent);
      }
    });
    getContentPane().add(this.btnClose);
    this.btnClose.setBounds(30, 560, 140, 30);
    
    this.btnPrevious.setText("Previous Similar");
    this.btnPrevious.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        ShowMaxPossible.this.btnPreviousActionPerformed(paramAnonymousActionEvent);
      }
    });
    getContentPane().add(this.btnPrevious);
    this.btnPrevious.setBounds(220, 560, 140, 30);
    
    this.btnNext.setText("Next Similar");
    this.btnNext.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        ShowMaxPossible.this.btnNextActionPerformed(paramAnonymousActionEvent);
      }
    });
    getContentPane().add(this.btnNext);
    this.btnNext.setBounds(400, 560, 140, 30);
    
    this.lblHeading.setFont(new Font("Times New Roman", 0, 25));
    
    this.lblHeading.setText("View All Similar");
    getContentPane().add(this.lblHeading);
    this.lblHeading.setBounds(180, 10, 350, 30);
    
    pack();
  }
  
  private void btnCloseActionPerformed(ActionEvent paramActionEvent)
  {
    setVisible(false);
    dispose();
  }
  
  private void btnPreviousActionPerformed(ActionEvent paramActionEvent)
  {
    this.presentsimilar -= 1;
    Integer localInteger = (Integer)this.finalVect.get(this.presentsimilar);
    displayDetails(localInteger.intValue());
    if (this.presentsimilar == 0) {
      this.btnPrevious.setEnabled(false);
    }
    this.btnNext.setEnabled(true);
  }
  
  private void btnNextActionPerformed(ActionEvent paramActionEvent)
  {
    this.presentsimilar += 1;
    Integer localInteger = (Integer)this.finalVect.get(this.presentsimilar);
    displayDetails(localInteger.intValue());
    if (this.presentsimilar == this.finalVect.size() - 1) {
      this.btnNext.setEnabled(false);
    }
    this.btnPrevious.setEnabled(true);
  }
  
  private void formMouseClicked(MouseEvent paramMouseEvent) {}
  
  private void closeDialog(WindowEvent paramWindowEvent)
  {
    setVisible(false);
    dispose();
  }
  
  public void displayDetails(int paramInt)
  {
    try
    {
      ResultSet localResultSet = this.stmt.executeQuery("select cid, fname, lname, aname, dob, age, gender, address, city, state, founddate, info, status, photofile from found where cid=" + paramInt);
      if (localResultSet.next())
      {
        this.lcr.setText(localResultSet.getString(1).trim());
        this.lfname.setText(localResultSet.getString(2).trim());
        this.llast.setText(localResultSet.getString(3).trim());
        this.lalias.setText(localResultSet.getString(4).trim());
        this.ldob.setText(localResultSet.getString(5).trim());
        this.lage.setText(localResultSet.getString(6).trim());
        this.lgender.setText(localResultSet.getString(7).trim());
        this.laddress.setText(localResultSet.getString(8).trim());
        this.lcity.setText(localResultSet.getString(9).trim());
        this.lstate.setText(localResultSet.getString(10).trim());
        this.lfoundate.setText(localResultSet.getString(11).trim());
        this.linfo.setText(localResultSet.getString(12).trim());
        this.lstatus.setText(localResultSet.getString(13).trim());
        String str = localResultSet.getString(14).trim();
        ImageIcon localImageIcon = new ImageIcon(str);
        this.lblPhotoSpace.setIcon(localImageIcon);
      }
    }
    catch (Exception localException)
    {
      JOptionPane.showMessageDialog(this, localException.getMessage(), "Child Details", 0);
    }
  }
  
  public Vector finalList(int paramInt)
  {
    Vector localVector = new Vector(2, 2);
    int i = 0;
    i = this.cidrepeats.indexOf(new Integer(paramInt), i);
    while (i != -1)
    {
      localVector.add(this.cidvect.elementAt(i));
      i = this.cidrepeats.indexOf(new Integer(paramInt), i + 1);
    }
    return localVector;
  }
}
