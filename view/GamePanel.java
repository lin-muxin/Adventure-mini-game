package game2.view;

import game2.handle.MonsterMove;
import game2.handle.MoveHandle;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GamePanel extends JPanel {
    ImageIcon b = new ImageIcon("src\\game2\\pic\\b.png");
    ImageIcon xyq = new ImageIcon("src\\game2\\pic\\xyq.png");
    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;

    public int hero_x;
    public int hero_y;
    public int hero_width = 30;
    public int hero_height = 60;

    public Vector<int[]> v = new Vector<>();
    int[] f0 = {0,500,800,10};
    int[] f1 = {300,500-80,200,10};
    int[] f2 = {500,500-40,50,40};
    int[] f3 = {100,500-150,80,30};
    int[] f4 = {200,500-250,340,10};
    {
        v.add(f0);
        v.add(f1);
        v.add(f2);
        v.add(f3);
        v.add(f4);
    }

    public Vector<int[]> ms = new Vector<>();
    public int[] m0 = {600,500-40,40,40,600,750,1};
    public int[] m1 = {0,500-40,40,40,0,100,1};
    {
        ms.add(m0);
        ms.add(m1);
    }
    public boolean mIsDie = false;

    public GamePanel() {
        setFocusable(true);

        MoveHandle moveHandle = new MoveHandle(this);
        addKeyListener(moveHandle);
        Thread thread = new Thread(moveHandle);
        thread.start();

        MonsterMove monsterMove = new MonsterMove(this);
        Thread thread2 =new Thread(monsterMove);
        thread2.start();

        init();
    }

    public void init() {
        hero_x = 200;
        hero_y = 500-hero_height;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        b.paintIcon(this,g,0,0);
        g.setColor(Color.blue);
        g.fillRect(hero_x, hero_y, hero_width, hero_height);
        g.setColor(Color.red);
        for (int i=0;i<ms.size();i++){
            g.fillRect(ms.get(i)[0],ms.get(i)[1],ms.get(i)[2],ms.get(i)[3]);
        }
        paintRect(g,v);
    }

    private void paintRect(Graphics g,Vector<int[]> v) {
        g.setColor(Color.black);
        for (int i = 0; i<v.size(); i++){
            int[] f = v.get(i);
            g.fillRect(f[0],f[1],f[2],f[3]);
        }
    }
}
