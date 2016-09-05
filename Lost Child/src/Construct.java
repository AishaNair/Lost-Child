import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.MemoryImageSource;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Construct
  extends JFrame
  implements ActionListener
{
  String stor;
  String selcid = "";
  int i;
  int hr;
  int fr;
  int ey;
  int no;
  int lip;
  int ch;
  int ht1;
  int ht2;
  int ht3;
  int ht4;
  int ht5;
  int ht6;
  int ha1;
  int ha2;
  int ha3;
  int ha4;
  int ha5;
  int ha6;
  int[] cids= new int[6];
  int finalhairht;
  int finalfhht;
  int finaleyesht;
  int finalnoseht;
  int finallipsht;
  int finalchinht;
  ArrayList hairAL = new ArrayList();
  ArrayList fhAL = new ArrayList();
  ArrayList eyesAL = new ArrayList();
  ArrayList noseAL = new ArrayList();
  ArrayList lipsAL = new ArrayList();
  ArrayList chinAL = new ArrayList();
  Connection con;
  Statement st;
  int nextheight = 0;
  JComboBox cHair;
  JComboBox cForehead;
  JComboBox cEyes;
  JComboBox cNose;
  JComboBox cLips;
  JComboBox cChin;
  JButton bSave;
  JButton bCancel;
  JButton bClear;
  JLabel lHair;
  JLabel lForehead;
  JLabel lEyes;
  JLabel lNose;
  JLabel lLips;
  JLabel lChin;
  JLabel lHair1;
  JLabel lForehead1;
  JLabel lEyes1;
  JLabel lNose1;
  JLabel lLips1;
  JLabel lChin1;
  int hair;
  int forehead;
  int eyes;
  int nose;
  int lips;
  int chin;
  String s = "";
  
  Construct()
  {
    super("Construct Face Screen");
    
    Color customColor = new Color(00,192,255);
    Color customColor1 = new Color(255,64,00);
    Color customColor2 = new Color(255,192,64);
    
    this.cHair = new JComboBox();
    this.cForehead = new JComboBox();
    this.cEyes = new JComboBox();
    this.cNose = new JComboBox();
    this.cLips = new JComboBox();
    this.cChin = new JComboBox();
    
    this.cHair.setBounds(10, 40, 130, 30);
    this.cForehead.setBounds(180, 40, 130, 30);
    this.cEyes.setBounds(330, 40, 130, 30);
    this.cNose.setBounds(480, 40, 130, 30);
    this.cLips.setBounds(630, 40, 130, 30);
    this.cChin.setBounds(780, 40, 130, 30);
    
    this.bSave = new JButton("Save");
    this.bCancel = new JButton("Cancel");
    this.bClear = new JButton("Clear");
    
    this.bSave.setBounds(100, 600, 100, 30);
    this.bCancel.setBounds(350, 600, 100, 30);
    this.bClear.setBounds(600, 600, 100, 30);
    

    this.bClear.addActionListener(this);
    this.bCancel.addActionListener(this);
    this.bSave.addActionListener(this);
    

    this.lHair = new JLabel("  Hair\t");
    this.lForehead = new JLabel("\tForehead\t");
    this.lEyes = new JLabel("\tEyes\t  ");
    this.lNose = new JLabel("\tNose\t  ");
    this.lLips = new JLabel("\tLips\t  ");
    this.lChin = new JLabel("\tChin\t  ");
    
    this.lHair1 = new JLabel("");
    this.lForehead1 = new JLabel("");
    this.lEyes1 = new JLabel("");
    this.lNose1 = new JLabel("");
    this.lLips1 = new JLabel("");
    this.lChin1 = new JLabel("");
    
    this.lHair.setBounds(30, 10, 130, 30);
    this.lForehead.setBounds(200, 10, 130, 30);
    this.lEyes.setBounds(350, 10, 130, 30);
    this.lNose.setBounds(500, 10, 130, 30);
    this.lLips.setBounds(650, 10, 130, 30);
    this.lChin.setBounds(800, 10, 130, 30);
    
    this.lHair1.setBounds(350, 150, 250, 30);
    this.lForehead1.setBounds(350, 181, 250, 30);
    this.lEyes1.setBounds(350, 212, 250, 30);
    this.lNose1.setBounds(350, 243, 250, 30);
    this.lLips1.setBounds(350, 274, 250, 30);
    this.lChin1.setBounds(350, 305, 250, 30);
    
    this.cHair.addActionListener(this);
    this.cForehead.addActionListener(this);
    this.cEyes.addActionListener(this);
    this.cNose.addActionListener(this);
    this.cLips.addActionListener(this);
    this.cChin.addActionListener(this);
    
    Container localContainer = getContentPane();
    localContainer.setLayout(null);
    localContainer.setBackground(new Color(0,0,0));
    localContainer.add(this.cHair);
    localContainer.add(this.cForehead);
    localContainer.add(this.cEyes);
    localContainer.add(this.cNose);
    localContainer.add(this.cLips);
    localContainer.add(this.cChin);
    
    localContainer.add(this.bSave);
    localContainer.add(this.bCancel);
    localContainer.add(this.bClear);
    
    localContainer.add(this.lHair);
    localContainer.add(this.lForehead);
    localContainer.add(this.lEyes);
    localContainer.add(this.lNose);
    localContainer.add(this.lLips);
    localContainer.add(this.lChin);
    
    localContainer.add(this.lHair1);
    localContainer.add(this.lForehead1);
    localContainer.add(this.lEyes1);
    localContainer.add(this.lNose1);
    localContainer.add(this.lLips1);
    localContainer.add(this.lChin1);
    
    this.lHair.setForeground(customColor1);
    this.lForehead.setForeground(customColor1);
    this.lEyes.setForeground(customColor1);
    this.lNose.setForeground(customColor1);
    this.lLips.setForeground(customColor1);
    this.lChin.setForeground(customColor1);

    setSize(950, 700);
    setResizable(false);
    Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle localRectangle = getBounds();
    setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      this.con = DriverManager.getConnection("jdbc:odbc:abc","","");
      this.st = this.con.createStatement();
      ResultSet localResultSet = this.st.executeQuery("select * from face_height");
      while (localResultSet.next())
      {
        ArrayList localArrayList1 = new ArrayList();
        this.selcid = localResultSet.getString(1);
        localArrayList1.add(new Integer(Integer.parseInt(this.selcid)));
        if (this.selcid.equalsIgnoreCase("Select Hair")) {
          JOptionPane.showMessageDialog(this, "Select the hair of the Child to construct the Photo", "constructing Photograph", 0);
        }
        FileInputStream localFileInputStream1 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/hair/hair" + this.selcid + ".gif");
        DataInputStream localDataInputStream1 = new DataInputStream(localFileInputStream1);
        int j = localFileInputStream1.available();
        int[] arrayOfInt1 = new int[j];
        int k = 0;
        while (localFileInputStream1.available() > 0)
        {
          arrayOfInt1[k] = localDataInputStream1.readInt();
          k++;
        }
        localFileInputStream1.close();
        localDataInputStream1.close();
        int m = Integer.parseInt(localResultSet.getString(2));
        localArrayList1.add(new Integer(m));
        this.hairAL.add(localArrayList1);
        Image localImage1 = createImage(new MemoryImageSource(200, m, arrayOfInt1, 0, 200));
        ImageIcon localImageIcon1 = new ImageIcon(localImage1);
        this.cHair.addItem(localImageIcon1);
        

        ArrayList localArrayList2 = new ArrayList();
        FileInputStream localFileInputStream2 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/forehead/forehead" + this.selcid + ".gif");
        DataInputStream localDataInputStream2 = new DataInputStream(localFileInputStream2);
        j = localFileInputStream2.available();
        int[] arrayOfInt2 = new int[j];
        k = 0;
        while (localFileInputStream2.available() > 0)
        {
          arrayOfInt2[k] = localDataInputStream2.readInt();
          k++;
        }
        localFileInputStream2.close();
        localDataInputStream2.close();
        int n = Integer.parseInt(localResultSet.getString(3));
        localArrayList2.add(new Integer(Integer.parseInt(this.selcid)));
        localArrayList2.add(new Integer(n));
        this.fhAL.add(localArrayList2);
        Image localImage2 = createImage(new MemoryImageSource(200, n, arrayOfInt2, 0, 200));
        ImageIcon localImageIcon2 = new ImageIcon(localImage2);
        this.cForehead.addItem(localImageIcon2);
        
        ArrayList localArrayList3 = new ArrayList();
        FileInputStream localFileInputStream3 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/eyes/eyes" + this.selcid + ".gif");
        DataInputStream localDataInputStream3 = new DataInputStream(localFileInputStream3);
        j = localFileInputStream3.available();
        int[] arrayOfInt3 = new int[j];
        k = 0;
        while (localFileInputStream3.available() > 0)
        {
          arrayOfInt3[k] = localDataInputStream3.readInt();
          k++;
        }
        localFileInputStream3.close();
        localDataInputStream3.close();
        int i1 = Integer.parseInt(localResultSet.getString(4));
        localArrayList3.add(new Integer(Integer.parseInt(this.selcid)));
        localArrayList3.add(new Integer(i1));
        this.eyesAL.add(localArrayList3);
        Image localImage3 = createImage(new MemoryImageSource(200, i1, arrayOfInt3, 0, 200));
        ImageIcon localImageIcon3 = new ImageIcon(localImage3);
        this.cEyes.addItem(localImageIcon3);
        

        ArrayList localArrayList4 = new ArrayList();
        FileInputStream localFileInputStream4 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/nose/nose" + this.selcid + ".gif");
        DataInputStream localDataInputStream4 = new DataInputStream(localFileInputStream4);
        j = localFileInputStream4.available();
        int[] arrayOfInt4 = new int[j];
        k = 0;
        while (localFileInputStream4.available() > 0)
        {
          arrayOfInt4[k] = localDataInputStream4.readInt();
          k++;
        }
        localFileInputStream4.close();
        localDataInputStream4.close();
        int i2 = Integer.parseInt(localResultSet.getString(5));
        localArrayList4.add(new Integer(Integer.parseInt(this.selcid)));
        localArrayList4.add(new Integer(i2));
        this.noseAL.add(localArrayList4);
        Image localImage4 = createImage(new MemoryImageSource(200, i2, arrayOfInt4, 0, 200));
        ImageIcon localImageIcon4 = new ImageIcon(localImage4);
        this.cNose.addItem(localImageIcon4);
        

        ArrayList localArrayList5 = new ArrayList();
        FileInputStream localFileInputStream5 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/lips/lips" + this.selcid + ".gif");
        DataInputStream localDataInputStream5 = new DataInputStream(localFileInputStream5);
        j = localFileInputStream5.available();
        int[] arrayOfInt5 = new int[j];
        k = 0;
        while (localFileInputStream5.available() > 0)
        {
          arrayOfInt5[k] = localDataInputStream5.readInt();
          k++;
        }
        localFileInputStream5.close();
        localDataInputStream5.close();
        int i3 = Integer.parseInt(localResultSet.getString(6));
        localArrayList5.add(new Integer(Integer.parseInt(this.selcid)));
        localArrayList5.add(new Integer(i3));
        this.lipsAL.add(localArrayList5);
        Image localImage5 = createImage(new MemoryImageSource(200, i3, arrayOfInt5, 0, 200));
        ImageIcon localImageIcon5 = new ImageIcon(localImage5);
        this.cLips.addItem(localImageIcon5);
        
        ArrayList localArrayList6 = new ArrayList();
        FileInputStream localFileInputStream6 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/chin/chin" + this.selcid + ".gif");
        DataInputStream localDataInputStream6 = new DataInputStream(localFileInputStream6);
        j = localFileInputStream6.available();
        int[] arrayOfInt6 = new int[j];
        k = 0;
        while (localFileInputStream6.available() > 0)
        {
          arrayOfInt6[k] = localDataInputStream6.readInt();
          k++;
        }
        localFileInputStream6.close();
        localDataInputStream6.close();
        int i4 = Integer.parseInt(localResultSet.getString(7));
        localArrayList6.add(new Integer(Integer.parseInt(this.selcid)));
        localArrayList6.add(new Integer(i4));
        this.chinAL.add(localArrayList6);
        Image localImage6 = createImage(new MemoryImageSource(200, i4, arrayOfInt6, 0, 200));
        ImageIcon localImageIcon6 = new ImageIcon(localImage6);
        this.cChin.addItem(localImageIcon6);
      }
    }
    catch (Exception localException)
    {
      JOptionPane.showMessageDialog(this, localException.getMessage(), "Construct Face", 0);
    }
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (paramActionEvent.getSource() == this.bClear)
    {
      this.cHair.setSelectedIndex(0);
      this.cForehead.setSelectedIndex(0);
      this.cEyes.setSelectedIndex(0);
      this.cNose.setSelectedIndex(0);
      this.cLips.setSelectedIndex(0);
      this.cChin.setSelectedIndex(0);
    }
    if (paramActionEvent.getSource() == this.bCancel)
    {
      setVisible(false);
      dispose();
    }
    int j;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Rectangle localRectangle2;
    if (paramActionEvent.getSource() == this.cHair)
    {
      j = this.cHair.getSelectedIndex();
      localObject1 = (ArrayList)this.hairAL.get(j);
      localObject2 = (Integer)((ArrayList)localObject1).get(1);
      this.finalhairht = ((Integer)localObject2).intValue();
      localObject3 = (Integer)((ArrayList)localObject1).get(0);
      this.cids[0] = ((Integer)localObject3).intValue();
      localObject4 = (ImageIcon)this.cHair.getSelectedItem();
      localRectangle2 = this.lHair1.getBounds();
      this.lHair1.setBounds(new Rectangle((int)localRectangle2.getX(), (int)localRectangle2.getY(), (int)localRectangle2.getWidth(), this.finalhairht));
      this.lHair1.setIcon((Icon)localObject4);
    }
    Rectangle localRectangle3;
    if (paramActionEvent.getSource() == this.cForehead)
    {
      j = this.cForehead.getSelectedIndex();
      localObject1 = (ArrayList)this.fhAL.get(j);
      localObject2 = (Integer)((ArrayList)localObject1).get(1);
      this.finalfhht = ((Integer)localObject2).intValue();
      localObject3 = (Integer)((ArrayList)localObject1).get(0);
      this.cids[1] = ((Integer)localObject3).intValue();
      localObject4 = (ImageIcon)this.cForehead.getSelectedItem();
      localRectangle2 = this.lForehead1.getBounds();
      localRectangle3 = this.lHair1.getBounds();
      this.lForehead1.setBounds(new Rectangle((int)localRectangle2.getX(), (int)localRectangle3.getY() + this.finalhairht, (int)localRectangle2.getWidth(), this.finalfhht));
      this.lForehead1.setIcon((Icon)localObject4);
    }
    Object localObject5;
    if (paramActionEvent.getSource() == this.cEyes)
    {
      j = this.cEyes.getSelectedIndex();
      localObject1 = (ArrayList)this.eyesAL.get(j);
      localObject2 = (Integer)((ArrayList)localObject1).get(1);
      this.finaleyesht = ((Integer)localObject2).intValue();
      localObject3 = (Integer)((ArrayList)localObject1).get(0);
      this.cids[2] = ((Integer)localObject3).intValue();
      localObject4 = (ImageIcon)this.cEyes.getSelectedItem();
      localRectangle2 = this.lHair1.getBounds();
      localRectangle3 = this.lForehead1.getBounds();
      localObject5 = this.lEyes1.getBounds();
      this.lEyes1.setBounds(new Rectangle((int)localRectangle3.getX(), (int)localRectangle2.getY() + this.finalhairht + this.finalfhht, (int)localRectangle3.getWidth(), this.finaleyesht));
      this.lEyes1.setIcon((Icon)localObject4);
    }
    Object localObject6;
    if (paramActionEvent.getSource() == this.cNose)
    {
      j = this.cNose.getSelectedIndex();
      localObject1 = (ArrayList)this.noseAL.get(j);
      localObject2 = (Integer)((ArrayList)localObject1).get(1);
      this.finalnoseht = ((Integer)localObject2).intValue();
      localObject3 = (Integer)((ArrayList)localObject1).get(0);
      this.cids[3] = ((Integer)localObject3).intValue();
      localObject4 = (ImageIcon)this.cNose.getSelectedItem();
      localRectangle2 = this.lNose1.getBounds();
      localRectangle3 = this.lHair1.getBounds();
      localObject5 = this.lForehead1.getBounds();
      localObject6 = this.lEyes1.getBounds();
      this.lNose1.setBounds(new Rectangle((int)((Rectangle)localObject5).getX(), (int)localRectangle3.getY() + this.finalhairht + this.finalfhht + this.finaleyesht, (int)((Rectangle)localObject5).getWidth(), this.finalnoseht));
      this.lNose1.setIcon((Icon)localObject4);
    }
    Rectangle localRectangle4;
    if (paramActionEvent.getSource() == this.cLips)
    {
      j = this.cLips.getSelectedIndex();
      localObject1 = (ArrayList)this.lipsAL.get(j);
      localObject2 = (Integer)((ArrayList)localObject1).get(1);
      this.finallipsht = ((Integer)localObject2).intValue();
      localObject3 = (Integer)((ArrayList)localObject1).get(0);
      this.cids[4] = ((Integer)localObject3).intValue();
      localObject4 = (ImageIcon)this.cLips.getSelectedItem();
      localRectangle2 = this.lForehead1.getBounds();
      localRectangle3 = this.lHair1.getBounds();
      localObject5 = this.lEyes1.getBounds();
      localObject6 = this.lNose1.getBounds();
      localRectangle4 = this.lLips1.getBounds();
      this.lLips1.setBounds(new Rectangle((int)localRectangle2.getX(), (int)localRectangle3.getY() + this.finalhairht + this.finalfhht + this.finaleyesht + this.finalnoseht, (int)localRectangle2.getWidth(), this.finallipsht));
      this.lLips1.setIcon((Icon)localObject4);
    }
    if (paramActionEvent.getSource() == this.cChin)
    {
      j = this.cChin.getSelectedIndex();
      localObject1 = (ArrayList)this.chinAL.get(j);
      localObject2 = (Integer)((ArrayList)localObject1).get(1);
      this.finalchinht = ((Integer)localObject2).intValue();
      localObject3 = (Integer)((ArrayList)localObject1).get(0);
      this.cids[5] = ((Integer)localObject3).intValue();
      localObject4 = (ImageIcon)this.cChin.getSelectedItem();
      localRectangle2 = this.lForehead1.getBounds();
      localRectangle3 = this.lHair1.getBounds();
      localObject5 = this.lEyes1.getBounds();
      localObject6 = this.lNose1.getBounds();
      localRectangle4 = this.lLips1.getBounds();
      Rectangle localRectangle5 = this.lChin1.getBounds();
      this.lChin1.setBounds(new Rectangle((int)localRectangle2.getX(), (int)localRectangle3.getY() + this.finalhairht + this.finalfhht + this.finaleyesht + this.finalnoseht + this.finallipsht, (int)localRectangle2.getWidth(), this.finalchinht));
      this.lChin1.setIcon((Icon)localObject4);
    }
    if (paramActionEvent.getSource() == this.bSave)
    {
      Rectangle localRectangle1 = this.lHair1.getBounds();
      this.lHair1.setBounds(new Rectangle((int)localRectangle1.getX(), (int)localRectangle1.getY(), (int)localRectangle1.getWidth(), (int)localRectangle1.getHeight()));
      
      localObject1 = this.lForehead1.getBounds();
      this.nextheight = ((int)localRectangle1.getY() + (int)localRectangle1.getHeight());
      this.lForehead1.setBounds(new Rectangle((int)((Rectangle)localObject1).getX(), this.nextheight, (int)((Rectangle)localObject1).getWidth(), (int)((Rectangle)localObject1).getHeight()));
      
      localObject2 = this.lEyes1.getBounds();
      this.nextheight += (int)((Rectangle)localObject1).getHeight();
      this.lEyes1.setBounds(new Rectangle((int)((Rectangle)localObject2).getX(), this.nextheight, (int)((Rectangle)localObject2).getWidth(), (int)((Rectangle)localObject2).getHeight()));
      
      localObject3 = this.lNose1.getBounds();
      this.nextheight += (int)((Rectangle)localObject2).getHeight();
      this.lNose1.setBounds(new Rectangle((int)((Rectangle)localObject3).getX(), this.nextheight, (int)((Rectangle)localObject3).getWidth(), (int)((Rectangle)localObject3).getHeight()));
      
      localObject4 = this.lLips1.getBounds();
      this.nextheight += (int)((Rectangle)localObject3).getHeight();
      this.lLips1.setBounds(new Rectangle((int)((Rectangle)localObject4).getX(), this.nextheight, (int)((Rectangle)localObject4).getWidth(), (int)((Rectangle)localObject4).getHeight()));
      
      localRectangle2 = this.lChin1.getBounds();
      this.nextheight += (int)((Rectangle)localObject4).getHeight();
      this.lChin.setBounds(new Rectangle((int)localRectangle2.getX(), this.nextheight, (int)localRectangle2.getWidth(), (int)localRectangle2.getHeight()));
      
      this.nextheight += (int)localRectangle2.getHeight();
      
      int k = 0;
      try
      {
        localObject5 = this.st.executeQuery("select max(childid) from face_suspectphoto");
        if (((ResultSet)localObject5).next())
        {
          localObject6 = ((ResultSet)localObject5).getString(1);
          if (localObject6 != null) {
            k = Integer.parseInt((String)localObject6);
          }
          k++;
          writePhoto(this.cids, k);
          this.st.executeUpdate("insert into face_suspectphoto(childid, suspectphoto, photo_height) values(" + k + ",'suspect" + k + ".gif'," + this.nextheight + ")");
          for (int m = 0; m < 6; m++) {
          this.st.executeUpdate("insert into face_suspects(childid, cid) values(" + k + "," + this.cids[m] + ")");
          }
          JOptionPane.showMessageDialog(this, "Photo saved successfully for the Child Identification Number: " + k, "Child Status", 1);
        }
      }
      catch (Exception localException)
      {
        JOptionPane.showMessageDialog(this, localException.getMessage(), "Construct Image", 0);
      }
    }
  }
  
  public void writePhoto(int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Suspects/suspect" + paramInt + ".gif");
      DataOutputStream localDataOutputStream = new DataOutputStream(localFileOutputStream);
      
      FileInputStream localFileInputStream1 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/hair/hair" + this.cids[0] + ".gif");
      DataInputStream localDataInputStream1 = new DataInputStream(localFileInputStream1);
      while (localFileInputStream1.available() > 0) {
        localDataOutputStream.writeInt(localDataInputStream1.readInt());
      }
      localFileInputStream1.close();
      localDataInputStream1.close();
      
      FileInputStream localFileInputStream2 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/forehead/forehead" + this.cids[1] + ".gif ");
      DataInputStream localDataInputStream2 = new DataInputStream(localFileInputStream2);
      while (localFileInputStream2.available() > 0) {
        localDataOutputStream.writeInt(localDataInputStream2.readInt());
      }
      localFileInputStream2.close();
      localDataInputStream2.close();
      
      FileInputStream localFileInputStream3 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/eyes/eyes" + this.cids[2] + ".gif");
      DataInputStream localDataInputStream3 = new DataInputStream(localFileInputStream3);
      while (localFileInputStream3.available() > 0) {
        localDataOutputStream.writeInt(localDataInputStream3.readInt());
      }
      localFileInputStream3.close();
      localDataInputStream3.close();
      
      FileInputStream localFileInputStream4 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/nose/nose" + this.cids[3] + ".gif");
      DataInputStream localDataInputStream4 = new DataInputStream(localFileInputStream4);
      while (localFileInputStream4.available() > 0) {
        localDataOutputStream.writeInt(localDataInputStream4.readInt());
      }
      localFileInputStream4.close();
      localDataInputStream4.close();
      
      FileInputStream localFileInputStream5 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/lips/lips" + this.cids[4] + ".gif");
      DataInputStream localDataInputStream5 = new DataInputStream(localFileInputStream5);
      while (localFileInputStream5.available() > 0) {
        localDataOutputStream.writeInt(localDataInputStream5.readInt());
      }
      localFileInputStream5.close();
      localDataInputStream5.close();
      
      FileInputStream localFileInputStream6 = new FileInputStream("C://Users/Aisha/Lost Child Returns/face-id/face-id/1/FaceIdentification/Clips/chin/chin" + this.cids[5] + ".gif");
      DataInputStream localDataInputStream6 = new DataInputStream(localFileInputStream6);
      while (localFileInputStream6.available() > 0) {
        localDataOutputStream.writeInt(localDataInputStream6.readInt());
      }
      localFileInputStream6.close();
      localDataInputStream6.close();
      localDataOutputStream.close();
      localFileOutputStream.close();
    }
    catch (Exception localException)
    {
      JOptionPane.showMessageDialog(this, localException.getMessage());
    }
  }
}
