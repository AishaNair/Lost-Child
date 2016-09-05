import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class FaceMenu
  extends JFrame
  implements ActionListener
{
  JLabel l1 = new JLabel();
  JToolBar j1 = new JToolBar();
   JLabel pic;
  JMenuItem fileNew = new JMenuItem("New Missing Case");
  JMenuItem fileNewFound = new JMenuItem("New Found Case");
  JMenuItem fileShow = new JMenuItem("Show details");
  JMenuItem fileDel = new JMenuItem("Delete Record");
  JMenuItem fileExit = new JMenuItem("Exit");
  
  JMenuItem editClip = new JMenuItem("Clipping");
 
  JMenuItem editUpdate = new JMenuItem("Update details");
 
  JMenuItem identificationConstruct = new JMenuItem("Construct Face");
  
  JMenuItem identificationFind = new JMenuItem("Find Face");
  
  JMenuItem Missing = new JMenuItem("View Missing Report");
  JMenuItem Found = new JMenuItem("View Found Report");
  JMenuItem CaseSolved = new JMenuItem("View Solved Cases");
  public FaceMenu()
  {
    super(" Lost Child Main Screen");
    Container localContainer = getContentPane();
    Color customColor = new Color(00,192,255);
    localContainer.setBackground(new Color(0,0,0));
    l1.setForeground(customColor);
    this.l1.setFont(new Font("Eras Bold ITC", 0, 50));
    
    JMenu localJMenu1 = new JMenu("File");
    JMenu localJMenu2 = new JMenu("Edit");
    JMenu localJMenu3 = new JMenu("Identification");
    JMenu localJMenu4 = new JMenu("Reports");
    this.l1.setText("The Lost Child");
    this.l1.setBounds(50, 150, 400, 50);
    this.pic= new JLabel("");
    ImageIcon image = new ImageIcon("C://Users/Aisha/Lost Child Returns/icon2.jpg");
    this.pic.setIcon(image);
    this.pic.setBounds(50, 300, 500, 140);
   localContainer.setLayout(null);
    localContainer.add(this.l1);
    localContainer.add(this.pic);
    this.setResizable(false);
    localJMenu1.add(this.fileNew);
    localJMenu1.add(this.fileNewFound);
    localJMenu1.add(this.fileShow);
    
    
    localJMenu1.addSeparator();
    localJMenu1.add(this.fileExit);
    
    localJMenu2.add(this.editClip);
    localJMenu2.add(this.editUpdate);
    localJMenu2.add(this.fileDel);
    
    localJMenu3.add(this.identificationConstruct);
    localJMenu3.add(this.identificationFind);
    
    localJMenu4.add(this.Missing);
    localJMenu4.add(this.Found);
    localJMenu4.add(this.CaseSolved);
    
    JMenuBar localJMenuBar = new JMenuBar();
    localJMenuBar.add(localJMenu1);
    localJMenuBar.add(localJMenu2);
    localJMenuBar.add(localJMenu3);
    localJMenuBar.add(localJMenu4);
    
    setJMenuBar(localJMenuBar);
    setSize(500, 500);
    
    Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle localRectangle = getBounds();
    setLocation((localDimension.width - localRectangle.width) / 2, (localDimension.height - localRectangle.height) / 2);
       
    this.fileNew.addActionListener(this);
    this.fileNewFound.addActionListener(this);
    this.fileShow.addActionListener(this);
    this.fileDel.addActionListener(this);
    this.fileExit.addActionListener(this);
    
    this.editClip.addActionListener(this);
    this.editUpdate.addActionListener(this);
    
    this.identificationConstruct.addActionListener(this);
    this.identificationFind.addActionListener(this);
    
    this.Missing.addActionListener(this);
    this.Found.addActionListener(this);
    this.CaseSolved.addActionListener(this);
    
   
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (paramActionEvent.getSource() == this.fileNew) {
      new New().show();
    }
    if (paramActionEvent.getSource() == this.fileNewFound) {
        new NewFound().show();
      }
    if (paramActionEvent.getSource() == this.fileShow) {
      new Show1().show();
    }
    if (paramActionEvent.getSource() == this.fileDel) {
        new Delete().show();
      }
    if (paramActionEvent.getSource() == this.fileExit) {
      System.exit(0);
    }
    if (paramActionEvent.getSource() == this.editClip) {
      new ClipImage().show();
    }
    if (paramActionEvent.getSource() == this.editUpdate) {
      new Update().show();
    }
    if (paramActionEvent.getSource() == this.identificationConstruct) {
      new Construct().show();
    }
    if (paramActionEvent.getSource() == this.identificationFind) {
      new FindFace().show();
    }
    if (paramActionEvent.getSource() == this.Missing) {
        new MissingReport().show();
      }
    if (paramActionEvent.getSource() == this.Found) {
        new FoundReport().show();
      }
    if (paramActionEvent.getSource() == this.CaseSolved) {
        new CaseSolvedReport().show();
      }
  
  }
  
  public static void main(String[] paramArrayOfString)
  {
    new FaceMenu().show();
    new FaceMenu().addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent paramAnonymousWindowEvent)
      {
        System.exit(0);
      }
    });
  }
}
