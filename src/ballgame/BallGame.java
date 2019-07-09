package ballgame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yaochao on 2019/7/5 14:04
 */

public class BallGame extends JFrame {

    private double x = 100; // 小球的横坐标
    private double y = 100; // 小球的纵坐标
    private boolean right = true; // 小球默认向左运动
    private boolean bottom = true; //小球默认向
    private double stepLength = 4; // 步子长度
    private Image ball = Toolkit.getDefaultToolkit().getImage("src/images/ball.png");
    private Image desk = Toolkit.getDefaultToolkit().getImage("src/images/desk.jpg");

    // 画窗口的方法
    @Override
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        if (right) {
            x = x + stepLength;
        } else {
            x = x - stepLength;
        }

        if ( x > 856 - 40 - 30) {
            right = false;
        }

        if (x < 40) {
            right = true;
        }

        if (bottom) {
            y += stepLength;
        } else {
            y -= stepLength;
        }

        if (y > 500 - 40 -30) {
            bottom = false;
        }

        if (y < (40 + 30)) {
            bottom = true;
        }

    }

    // 窗口加载
    public void launchFrame() {
        setSize(856, 500);
        setLocation(100, 200);
        setVisible(true);

        // 重画窗口，每秒30次
        while (true) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}

