import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.sound.sampled.*;
import java.applet.*;

class List implements ItemListener
{
   Choice chc=new Choice(); 
   int index=-1;//number of creatures
    String path;
    String path1;
    String path2;
    String path3;
    String path4;
    String imgpath;
    String star50 = "JAVA_img\\star50.png";
    String star75 ="JAVA_img\\star75.png";
    String star = "JAVA_img\\star.png"; 
    String star200="JAVA_img\\star200.png";
   public List()
   {
      chc.setBounds(100, 100, 300, 100);
        
      chc.add("choose one");
      chc.add("lee sin");
      chc.add("son");
      chc.add("baba");
      chc.add("pupu");
      chc.add("RRRR");
      chc.add("nt");
      chc.addItemListener(this); 
      chc.setFont(new Font("SansSerif", Font.BOLD, 50)); 
   }
   public void itemStateChanged(ItemEvent e)
   {
       
      String choice=chc.getSelectedItem();
      if(choice=="lee sin"){
        index=0;
            path = "JAVA_wav\\lee sin0 MAX.wav";
            path1 = "JAVA_wav\\lee sin1.wav";
            path2 = "JAVA_wav\\lee sin2.wav";
            path3 = "JAVA_wav\\lee sin3.wav";
            path4 = "JAVA_wav\\lee sin4.wav";

            imgpath = "JAVA_img\\lee sin0 MAX.png";
           
            
        }
      else if(choice=="son"){
         index=1;
            path = "JAVA_wav\\son0 MAX.wav";
            path1 = "JAVA_wav\\son1.wav";
            path2 = "JAVA_wav\\son2.wav";
            path3 = "JAVA_wav\\son3.wav";
            path4 = "JAVA_wav\\son4.wav";

            imgpath = "JAVA_img\\son0 MAX.png";
          
        }
      else if(choice=="baba"){
         index=2;
            path = "JAVA_wav\\baba0 MAX.wav";
            path1 = "JAVA_wav\\baba1.wav";
            path2 = "JAVA_wav\\baba2.wav";
            path3 = "JAVA_wav\\baba3.wav";
            path4 = "JAVA_wav\\baba4.wav";

            imgpath = "JAVA_img\\baba0 MAX.png";
           
        }
      else if(choice=="pupu"){
         index=3;
            path = "JAVA_wav\\pupu0 MAX.wav";
            path1 = "JAVA_wav\\pupu1.wav";
            path2 = "JAVA_wav\\pupu2.wav";
            path3 = "JAVA_wav\\pupu3.wav";
            path4 = "JAVA_wav\\pupu4.wav";

            imgpath = "JAVA_img\\pupu0 MAX.png";
            
        }
      else if(choice=="RRRR"){
         index=4;
            path = "JAVA_wav\\RRRR0 MAX.wav";
            path1 = "JAVA_wav\\RRRR1.wav";
            path2 = "JAVA_wav\\RRRR2.wav";
            path3 = "JAVA_wav\\RRRR3.wav";
            path4 = "JAVA_wav\\RRRR4.wav";

            imgpath = "JAVA_img\\RRRR0 MAX.png";
            
        }
      else if(choice=="nt"){
         index=5;
            path = "JAVA_wav\\nt0 MAX.wav";
            path1 = "JAVA_wav\\nt1.wav";
            path2 = "JAVA_wav\\nt2.wav";
            path3 = "JAVA_wav\\nt3.wav";
            path4 = "JAVA_wav\\nt4.wav";

            imgpath = "JAVA_img\\nt0 MAX.png";

        }
        chc.setVisible(false);
        
   }
}

public class main extends MouseAdapter {
    JFrame jframe;
    JPanel jpanel;
    ImageIcon img;
    JLabel bg;
    
    JComponent p;
    JButton jbutton;
    
    int x = (int)(Math.random() * 1400) + 50;
    int y = (int)(Math.random() * 700) + 50;
    
    

    static Clip clip;
    static Clip clip1;
    static Clip clip2;
    static Clip clip3;
    static Clip clip4;
    List list = new List();
    
    
    public static void main(String[] args) {
        new main();
    }

    public main() {
        System.out.println(x + "   " + y);

        jframe = new JFrame("invisual");
        jframe.setSize(1600, 900);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        
        jpanel = new JPanel();
        
        

        jpanel.addMouseListener(this);
        jpanel.addMouseWheelListener(this);
        jpanel.addMouseMotionListener(this);
        
        jpanel.setLayout(null);
        jpanel.setBackground(Color.black);
        jpanel.add(list.chc);
        jframe.add(jpanel);
        
        p = (JComponent)jframe.getLayeredPane();

    }
    
    // from MouseListener
    public void mouseClicked(MouseEvent e) {
        if (list.index != -1){
            
            try
                {
                clip = AudioSystem.getClip();
                clip1 = AudioSystem.getClip();
                clip2 = AudioSystem.getClip();
                clip3 = AudioSystem.getClip();
                clip4 = AudioSystem.getClip();
                
                clip.open(AudioSystem.getAudioInputStream(new File(list.path)));
                clip1.open(AudioSystem.getAudioInputStream(new File(list.path1)));
                clip2.open(AudioSystem.getAudioInputStream(new File(list.path2)));
                clip3.open(AudioSystem.getAudioInputStream(new File(list.path3)));
                clip4.open(AudioSystem.getAudioInputStream(new File(list.path4)));
            }
            catch (Exception exc)
                {
                exc.printStackTrace(System.out);
            }

            double dis = Point.distance(e.getX(), e.getY(), x + 25, y + 25);
            
            if (dis > 800){       
                clip4.start();
            }
            else if (dis > 500){                
                clip3.start();
            }
            else if (dis > 250){               
                clip2.start();
            }
            else if (dis > 25){
                clip1.start();
            }
            else{
                bg = new JLabel(new ImageIcon(list.imgpath));
                bg.setBounds(0, 0, 1600, 900);
                p.add(bg);
                
                clip.start();
            }
        }
    }
    
    
    //////////////////////////////////////////////////////
    public void mousePressed(MouseEvent e) {
        double dis = Point.distance(e.getX(), e.getY(), x + 25, y + 25);
            
            if (dis > 800){
                if (list.index != -1){
                 bg = new JLabel(new ImageIcon(list.star50));
                 bg.setBounds(e.getX()-45, e.getY()-45, 90, 90);
                 p.add(bg);
                }
            }
            else if (dis > 500){
                if (list.index != -1){
                 bg = new JLabel(new ImageIcon(list.star75));
                 bg.setBounds(e.getX()-90, e.getY()-90, 180, 180);
                 p.add(bg);
                 }
            }
            else if (dis > 250){
                if (list.index != -1){
                bg = new JLabel(new ImageIcon(list.star));
                bg.setBounds(e.getX()-90, e.getY()-90, 180, 180);
                p.add(bg);
                }
            }
            else if(dis > 25){
                if (list.index != -1){
                bg = new JLabel(new ImageIcon(list.star200));
                 bg.setBounds(e.getX()-180, e.getY()-180, 360, 360);
                 p.add(bg);
                }
            }
            else {

            }

    }

    public void mouseReleased(MouseEvent e) {
        if (list.index != -1){
        bg.setVisible(false);
    }
    }


    public void mouseEntered(MouseEvent e) {
        
    }
     
    public void mouseExited(MouseEvent e) {
        
    }


//////////////////////////////////////////////////////
    // from MouseWheelListener////////////////////////
    public void mouseWheelMoved(MouseWheelEvent e) {//
        
    }/////////////////////////////////////////////////
//////////////////////////////////////////////////////
    // from MouseMotionListener///////////////////////
    public void mouseDragged(MouseEvent e) {//////////
    }/////////////////////////////////////////////////
//////////////////////////////////////////////////////


    public void mouseMoved(MouseEvent e) {
        //System.out.println(e.getX() + "   " + e.getY());
        if (list.index != -1){
            double dis = Point.distance(e.getX(), e.getY(), x + 25, y + 25);
            if (dis > 25){
                jpanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            else{
                jpanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }
    }

}