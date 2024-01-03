package game2.view;

import javax.swing.*;

public class GameFrame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("喵咪小游戏");

        jf.add(new GamePanel());

        jf.setSize(806,600);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
