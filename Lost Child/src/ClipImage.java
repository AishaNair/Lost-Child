import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

class ClipImage
  extends JFrame
  implements ActionListener
{
  Connection cn;
  Statement stmt;
  int x1;
  int x2;
  int y1;
  int y2;
  int w;
  int h;
  int[] pixels;
  Image orgimg = null;
  Image clipimg = null;
  ClipImage.SourceImageCanvas sourceimgcan = new ClipImage.SourceImageCanvas();
  ClipImage.ClipImagePanel clipimgcan = new ClipImage.ClipImagePanel();
  JButton btnForeHead;
  JButton btnEyes;
  JButton btnNose;
  JButton btnLips;
  JButton btnChin;
  JButton btnHair;
  JButton btnSave;
  JButton btnCancel;
  JButton btnPhoto;
  JButton btnClip;
  JButton clearHair;
  JButton clearForeHead;
  JButton clearEyes;
  JButton clearNose;
  JButton clearLips;
  JButton clearChin;
  JButton btnClear;
  JComboBox jcbCrimId;
  String imgfile = "";
  boolean imgstatus = false;
  boolean clipstatus = false;
  JLabel lblHair;
  JLabel lblForeHead;
  JLabel lblEyes;
  JLabel lblNose;
  JLabel lblLips;
  JLabel lblChin;
  JLabel note;
  int htHair = 0;
  int htForeHead = 0;
  int htEyes = 0;
  int htNose = 0;
  int htLips = 0;
  int htChin = 0;
  File f1;
  String selcrimid = "";
  
  ClipImage()
  {
    super("Clipping Face Screen");
    Container localContainer = getContentPane();
    localContainer.setLayout(null);
    setSize(800, 700);
    localContainer.setBackground(new Color(0,0,0));
    Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle localRectangle = getBounds();
    setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);
    
    this.clearHair = new JButton("Clear Hair");
    this.clearHair.setToolTipText("Clear Hair Clip");
    this.clearForeHead = new JButton("Clear Forehead");
    this.clearForeHead.setToolTipText("Clear Forehead Clip");
    this.clearEyes = new JButton("Clear Eyes");
    this.clearEyes.setToolTipText("Clear Eyes Clip");
    this.clearNose = new JButton("Clear Nose");
    this.clearNose.setToolTipText("Clear Nose Clip");
    this.clearLips = new JButton("Clear Lips");
    this.clearLips.setToolTipText("Clear Lips Clip");
    this.clearChin = new JButton("Clear Chin");
    this.clearChin.setToolTipText("Clear Chin Clip");
    
    this.btnForeHead = new JButton("Forehead ");
    this.btnEyes = new JButton("Eyes ");
    this.btnNose = new JButton("Nose");
    this.btnLips = new JButton("Lips ");
    this.btnChin = new JButton("Chin");
    this.btnHair = new JButton("Hair ");
    this.btnPhoto = new JButton("Photo");
    this.btnSave = new JButton("Save");
    this.btnCancel = new JButton("Cancel");
    this.btnClear = new JButton("Clear");
    
    this.jcbCrimId = new JComboBox();
    
    this.btnHair.setBounds(20, 25, 120, 30);
    this.btnForeHead.setBounds(150, 25, 120, 30);
    this.btnEyes.setBounds(280, 25, 120, 30);
    this.btnNose.setBounds(410, 25, 120, 30);
    this.btnLips.setBounds(540, 25, 120, 30);
    this.btnChin.setBounds(670, 25, 120, 30);
    
    this.clearHair.setBounds(20, 580, 120, 30);
    this.clearForeHead.setBounds(150, 580, 120, 30);
    this.clearEyes.setBounds(280, 580, 120, 30);
    this.clearNose.setBounds(410, 580, 120, 30);
    this.clearLips.setBounds(540, 580, 120, 30);
    this.clearChin.setBounds(670, 580, 120, 30);
    

    this.btnClear.setBounds(660, 520, 100, 30);
    localContainer.add(this.clearForeHead);
    localContainer.add(this.clearEyes);
    localContainer.add(this.clearNose);
    localContainer.add(this.clearLips);
    localContainer.add(this.clearChin);
    localContainer.add(this.clearHair);
    

    this.btnSave.setBounds(400, 520, 100, 30);
    localContainer.add(this.btnSave);
    
    this.btnCancel.setBounds(530, 520, 100, 30);
    localContainer.add(this.btnCancel);
    
    localContainer.add(this.btnClear);
    
    this.jcbCrimId.setBounds(20, 520, 120, 30);
    localContainer.add(this.jcbCrimId);
    
    this.note = new JLabel("Note: Minimize the screen once");
    this.note.setFont(new Font("Times New Roman", 0, 15));
    
    this.btnPhoto.setBounds(170, 520, 100, 30);
    localContainer.add(this.btnPhoto);
    localContainer.add(this.btnForeHead);
    localContainer.add(this.btnEyes);
    localContainer.add(this.btnNose);
    localContainer.add(this.btnLips);
    localContainer.add(this.btnChin);
    localContainer.add(this.btnHair);
    
    this.note.setBounds(20, 620, 200, 30);
    localContainer.add(this.note);
    this.sourceimgcan.setBounds(40, 95, 250, 300);
    localContainer.add(this.sourceimgcan);
    
    this.lblHair = new JLabel("\t\t\t              ");
    this.lblHair.setBounds(420, 100, 190, 80);
    localContainer.add(this.lblHair);
    
    this.lblForeHead = new JLabel("                   ");
    this.lblForeHead.setBounds(420, 160, 190, 80);
    localContainer.add(this.lblForeHead);
    
    this.lblEyes = new JLabel("                    ");
    this.lblEyes.setBounds(420, 220, 190, 80);
    localContainer.add(this.lblEyes);
    
    this.lblNose = new JLabel("                    ");
    this.lblNose.setBounds(420, 280, 190, 80);
    localContainer.add(this.lblNose);
    
    this.lblLips = new JLabel("                    ");
    this.lblLips.setBounds(420, 340, 190, 80);
    localContainer.add(this.lblLips);
    
    this.lblChin = new JLabel("                    ");
    this.lblChin.setBounds(420, 400, 190, 80);
    localContainer.add(this.lblChin);
    
    this.btnForeHead.addActionListener(this);
    this.btnEyes.addActionListener(this);
    this.btnNose.addActionListener(this);
    this.btnLips.addActionListener(this);
    this.btnChin.addActionListener(this);
    this.btnHair.addActionListener(this);
    this.btnSave.addActionListener(this);
    this.btnCancel.addActionListener(this);
    this.btnPhoto.addActionListener(this);
    this.jcbCrimId.addItem("Select Child");
    
    this.btnClear.addActionListener(this);
    this.clearHair.addActionListener(this);
    this.clearForeHead.addActionListener(this);
    this.clearEyes.addActionListener(this);
    this.clearNose.addActionListener(this);
    this.clearLips.addActionListener(this);
    this.clearChin.addActionListener(this);
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      this.cn = DriverManager.getConnection("jdbc:odbc:abc", "", "");
      this.stmt = this.cn.createStatement();
      ResultSet localResultSet = this.stmt.executeQuery("select cid from face order by cid asc");
      while (localResultSet.next()) {
        this.jcbCrimId.addItem(localResultSet.getString(1));
      }
    }
    catch (Exception localException)
    {
      JOptionPane.showMessageDialog(this, localException.getMessage(), "Clipping Image", 0);
    }
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (paramActionEvent.getSource() == this.btnPhoto)
    {
      this.selcrimid = this.jcbCrimId.getSelectedItem().toString();
      if (this.selcrimid.equalsIgnoreCase("Select Child"))
      {
        JOptionPane.showMessageDialog(this, "Select the ID of the Child to clip the Photo", "clipping Photograph", 0);
      }
      else
      {
        this.imgstatus = true;
        try
        {
          ResultSet localResultSet = this.stmt.executeQuery("select photofile from face where CID=" + Integer.parseInt(this.selcrimid));
          if (localResultSet.next())
          {
            this.imgfile = localResultSet.getString(1);
            JOptionPane.showMessageDialog(this, "Child Selected", "clipping Photograph", 1);
            repaint();
          }
        }
        catch (Exception localException1) {}
      }
    }
    DataOutputStream localDataOutputStream;
    int i;
    if (paramActionEvent.getSource() == this.btnHair)
    {
      setTitle(this.x1 + ":" + this.y1 + ":" + this.w + ":" + this.h + ":" + this.x2 + ":" + this.y2 + ":" + "Criminal Id" + ":" + this.selcrimid);
      this.clipimg = createImage(new MemoryImageSource(this.w, this.h, this.pixels, 0, this.w));
      this.htHair = this.h;
      this.lblHair.setIcon(new ImageIcon(this.clipimg));
      try
      {
        FileOutputStream localFileOutputStream1 = new FileOutputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/hair/hair" + this.selcrimid + ".gif");
        localDataOutputStream = new DataOutputStream(localFileOutputStream1);
        for (i = 0; i < this.pixels.length; i++) {
          localDataOutputStream.writeInt(this.pixels[i]);
        }
        localDataOutputStream.close();
        localFileOutputStream1.close();
      }
      catch (Exception localException2)
      {
        JOptionPane.showMessageDialog(this, localException2.getMessage(), "Child Details", 0);
      }
    }
    if (paramActionEvent.getSource() == this.btnEyes)
    {
      setTitle(this.x1 + ":" + this.y1 + ":" + this.w + ":" + this.h + ":" + this.x2 + ":" + this.y2 + ":" + "Criminal Id" + ":" + this.selcrimid);
      this.clipimg = createImage(new MemoryImageSource(this.w, this.h, this.pixels, 0, this.w));
      this.htEyes = this.h;
      this.lblEyes.setIcon(new ImageIcon(this.clipimg));
      try
      {
        FileOutputStream localFileOutputStream2 = new FileOutputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/eyes/eyes" + this.selcrimid + ".gif");
        localDataOutputStream = new DataOutputStream(localFileOutputStream2);
        for (i = 0; i < this.pixels.length; i++) {
          localDataOutputStream.writeInt(this.pixels[i]);
        }
        localDataOutputStream.close();
        localFileOutputStream2.close();
      }
      catch (Exception localException3)
      {
        JOptionPane.showMessageDialog(this, localException3.getMessage(), "Child Details", 0);
      }
    }
    if (paramActionEvent.getSource() == this.btnForeHead)
    {
      setTitle(this.x1 + ":" + this.y1 + ":" + this.w + ":" + this.h + ":" + this.x2 + ":" + this.y2 + ":" + "Criminal Id" + ":" + this.selcrimid);
      this.clipimg = createImage(new MemoryImageSource(this.w, this.h, this.pixels, 0, this.w));
      this.htForeHead = this.h;
      this.lblForeHead.setIcon(new ImageIcon(this.clipimg));
      try
      {
        FileOutputStream localFileOutputStream3 = new FileOutputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/forehead/forehead" + this.selcrimid + ".gif");
        localDataOutputStream = new DataOutputStream(localFileOutputStream3);
        for (i = 0; i < this.pixels.length; i++) {
          localDataOutputStream.writeInt(this.pixels[i]);
        }
        localDataOutputStream.close();
        localFileOutputStream3.close();
      }
      catch (Exception localException4)
      {
        JOptionPane.showMessageDialog(this, localException4.getMessage(), "Child Details", 0);
      }
    }
    if (paramActionEvent.getSource() == this.btnNose)
    {
      setTitle(this.x1 + ":" + this.y1 + ":" + this.w + ":" + this.h + ":" + this.x2 + ":" + this.y2 + ":" + "Criminal Id" + ":" + this.selcrimid);
      this.clipimg = createImage(new MemoryImageSource(this.w, this.h, this.pixels, 0, this.w));
      this.htNose = this.h;
      this.lblNose.setIcon(new ImageIcon(this.clipimg));
      try
      {
        FileOutputStream localFileOutputStream4 = new FileOutputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/nose/nose" + this.selcrimid + ".gif");
        localDataOutputStream = new DataOutputStream(localFileOutputStream4);
        for (i = 0; i < this.pixels.length; i++) {
          localDataOutputStream.writeInt(this.pixels[i]);
        }
        localDataOutputStream.close();
        localFileOutputStream4.close();
      }
      catch (Exception localException5)
      {
        JOptionPane.showMessageDialog(this, localException5.getMessage(), "Child Details", 0);
      }
    }
    if (paramActionEvent.getSource() == this.btnLips)
    {
      setTitle(this.x1 + ":" + this.y1 + ":" + this.w + ":" + this.h + ":" + this.x2 + ":" + this.y2 + ":" + "Criminal Id" + ":" + this.selcrimid);
      this.clipimg = createImage(new MemoryImageSource(this.w, this.h, this.pixels, 0, this.w));
      this.htLips = this.h;
      this.lblLips.setIcon(new ImageIcon(this.clipimg));
      try
      {
        FileOutputStream localFileOutputStream5 = new FileOutputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/lips/lips" + this.selcrimid + ".gif");
        localDataOutputStream = new DataOutputStream(localFileOutputStream5);
        for (i = 0; i < this.pixels.length; i++) {
          localDataOutputStream.writeInt(this.pixels[i]);
        }
        localDataOutputStream.close();
        localFileOutputStream5.close();
      }
      catch (Exception localException6)
      {
        JOptionPane.showMessageDialog(this, localException6.getMessage(), "Criminal Details", 0);
      }
    }
    if (paramActionEvent.getSource() == this.btnChin)
    {
      setTitle(this.x1 + ":" + this.y1 + ":" + this.w + ":" + this.h + ":" + this.x2 + ":" + this.y2 + ":" + "Criminal Id" + ":" + this.selcrimid);
      this.clipimg = createImage(new MemoryImageSource(this.w, this.h, this.pixels, 0, this.w));
      this.htChin = this.h;
      this.lblChin.setIcon(new ImageIcon(this.clipimg));
      try
      {
        FileOutputStream localFileOutputStream6 = new FileOutputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/chin/chin" + this.selcrimid + ".gif");
        localDataOutputStream = new DataOutputStream(localFileOutputStream6);
        for (i = 0; i < this.pixels.length; i++) {
          localDataOutputStream.writeInt(this.pixels[i]);
        }
        localDataOutputStream.close();
        localFileOutputStream6.close();
      }
      catch (Exception localException7)
      {
        JOptionPane.showMessageDialog(this, localException7.getMessage(), "Criminal Details", 0);
      }
    }
    if (paramActionEvent.getSource() == this.btnSave) {
      try
      {
        String str = "insert into face_height(cid, hair, forehead, eyes, nose, lips, chin) values(" + this.selcrimid + "," + this.htHair + "," + this.htForeHead + "," + this.htEyes + "," + this.htNose + "," + this.htLips + "," + this.htChin + ")";
        this.stmt.executeUpdate(str);
        JOptionPane.showMessageDialog(this, "Clips Stored Successfully", "Clipping Images", 1);
      }
      catch (Exception localException8) {}
    }
    if (paramActionEvent.getSource() == this.btnCancel)
    {
      setVisible(false);
      dispose();
    }
    if (paramActionEvent.getSource() == this.clearHair) {
      this.lblHair.setIcon(new ImageIcon("Icons\\anand.bmp"));
    }
    if (paramActionEvent.getSource() == this.clearForeHead) {
      this.lblForeHead.setIcon(new ImageIcon("Icons\\anand.bmp"));
    }
    if (paramActionEvent.getSource() == this.clearEyes) {
      this.lblEyes.setIcon(new ImageIcon("Icons\\anand.bmp"));
    }
    if (paramActionEvent.getSource() == this.clearNose) {
      this.lblNose.setIcon(new ImageIcon("Icons\\anand.bmp"));
    }
    if (paramActionEvent.getSource() == this.clearLips) {
      this.lblLips.setIcon(new ImageIcon("Icons\\anand.bmp"));
    }
    if (paramActionEvent.getSource() == this.clearChin) {
      this.lblChin.setIcon(new ImageIcon("Icons\\anand.bmp"));
    }
    if (paramActionEvent.getSource() == this.btnClear)
    {
      this.lblHair.setIcon(new ImageIcon("Icons\\anand.bmp"));
      this.lblForeHead.setIcon(new ImageIcon("Icons\\anand.bmp"));
      this.lblEyes.setIcon(new ImageIcon("Icons\\anand.bmp"));
      this.lblNose.setIcon(new ImageIcon("Icons\\anand.bmp"));
      this.lblLips.setIcon(new ImageIcon("Icons\\anand.bmp"));
      this.lblChin.setIcon(new ImageIcon("Icons\\anand.bmp"));
      this.jcbCrimId.setSelectedItem("Select Child");
      setTitle("");
    }
  }
  
  class SourceImageCanvas
    extends Canvas
    implements MouseListener
  {
    Toolkit tkt;
    
    SourceImageCanvas()
    {
      this.tkt = Toolkit.getDefaultToolkit();
      addMouseListener(this);
    }
    
    public void paint(Graphics paramGraphics)
    {
      if (ClipImage.this.imgstatus)
      {
        ClipImage.this.orgimg = this.tkt.getImage(ClipImage.this.imgfile);
        paramGraphics.drawImage(ClipImage.this.orgimg, 0, 0, this);
      }
    }
    
    public void mousePressed(MouseEvent paramMouseEvent)
    {
      ClipImage.this.x1 = paramMouseEvent.getX();
      ClipImage.this.y1 = paramMouseEvent.getY();
    }
    
    public void mouseReleased(MouseEvent paramMouseEvent)
    {
      try
      {
        ClipImage.this.x2 = paramMouseEvent.getX();
        ClipImage.this.y2 = paramMouseEvent.getY();
        
        ClipImage.this.w = 200;
        ClipImage.this.h = (ClipImage.this.y2 - ClipImage.this.y1);
        
        ClipImage.this.pixels = new int[ClipImage.this.w * ClipImage.this.h];
        PixelGrabber localPixelGrabber = new PixelGrabber(ClipImage.this.orgimg, ClipImage.this.x1, ClipImage.this.y1, ClipImage.this.w, ClipImage.this.h, ClipImage.this.pixels, 0, ClipImage.this.w);
        localPixelGrabber.grabPixels();
        JOptionPane.showMessageDialog(this, "ClickedImage");
        ClipImage.this.clipstatus = true;
      }
      catch (Exception localException) {}
    }
    
    public void mouseClicked(MouseEvent paramMouseEvent) {}
    
    public void mouseEntered(MouseEvent paramMouseEvent) {}
    
    public void mouseExited(MouseEvent paramMouseEvent) {}
  }
  
  class ClipImagePanel
    extends Canvas
  {
    ClipImagePanel() {}
    
    public void paint(Graphics paramGraphics)
    {
      if (ClipImage.this.clipstatus) {
        paramGraphics.drawImage(ClipImage.this.clipimg, 0, 0, this);
      }
    }
  }
}
