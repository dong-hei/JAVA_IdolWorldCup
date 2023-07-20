import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IdolWorldCupMain {
    static JPanel panelNorth;
    static JPanel panelCenter;
    static JLabel labelMessage;
    static JLabel labelVs;
    static JButton buttonLeft;
    static JButton buttonRight;
    static String[] images={
            "1.jpg", "2.jpg", "3.jpg", "4.jpg",
            "5.jpg", "6.jpg", "7.jpg", "8.jpg",
            "9.jpg", "10.jpg", "11.jpg", "12.jpg",
            "13.jpg", "14.jpg", "15.jpg", "16.jpg",
    };
    static int imageIndex = 2;

    //function : 이미지를 버튼컨트롤에 추가
    static ImageIcon changeImage(String fileName) {
        ImageIcon icon = new ImageIcon("./"+fileName);
        Image originImage = icon.getImage();
        Image changedImage = originImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon_new = new ImageIcon(changedImage);
        return icon_new;
    }

    static class MyFrame extends JFrame implements ActionListener {
        public MyFrame(String title) {
            super(title);

            //UI Init
            this.setSize(450, 250);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelNorth = new JPanel();
            labelMessage = new JLabel("what is your favorite Idol?");
            labelMessage.setFont(new Font("Arial", Font.BOLD, 20));
            panelNorth.add(labelMessage);
            this.add("North", panelNorth);

            panelCenter = new JPanel();
            labelVs = new JLabel("vs");
            labelMessage.setFont(new Font("Arial", Font.BOLD, 20));
            buttonLeft = new JButton("LeftButton");
            buttonLeft.setIcon(changeImage("1.jpg"));
            buttonLeft.setPreferredSize(new Dimension(200,200));
            buttonRight = new JButton("RightButton");
            buttonRight.setIcon(changeImage("2.jpg"));
            buttonRight.setPreferredSize(new Dimension(200,200));

            buttonLeft.addActionListener(this);
            buttonRight.addActionListener(this);
            panelCenter.add(buttonLeft);
            panelCenter.add(labelVs);
            panelCenter.add(buttonRight);
            this.add("Center", panelCenter);

            this.pack(); // 빈 공간 없애고 감싼다.
        }

        //버튼 클릭 콜백 함수
        @Override
        public void actionPerformed(ActionEvent e) {
            if ( imageIndex == 16){
                labelMessage.setText("Found You No.1 K-Pop Star");
                if (e.getActionCommand().equals("LeftButton")) {
                    buttonRight.hide();
                    labelVs.hide();
                }else{
                    buttonLeft.hide();
                    labelVs.hide();
                }
            }
            else {
                if (e.getActionCommand().equals("LeftButton")) {
                    buttonRight.setIcon(changeImage(images[imageIndex]));
                    imageIndex++;
                } else {
                    buttonLeft.setIcon(changeImage(images[imageIndex]));
                    imageIndex++;
                }
            }
        }
    }


    public static void main(String[] args) {
        new MyFrame("Idol World Cup");
    }
}
