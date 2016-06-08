import javax.swing.*;
import java.awt.*;

public class Play extends JFrame {
    public Play(){
        JButton button = new JButton();
        ImageIcon icon = new ImageIcon("picture/button.png");
        button.setIcon(icon);
       ImageIcon bg = new ImageIcon("picture/bg.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
        getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel jp=(JPanel)getContentPane();
        jp.setOpaque(false);//设置透明 
        JPanel panel=new JPanel();
        panel.setOpaque(false);//也要让他透明   
        panel.setLayout(null);//为了使用按钮的定位   
        button.setBounds(650,750,200,80);
        panel.add(button);
        add(panel);


    }
    public static void main(String[] args){
        Play frame = new Play();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
