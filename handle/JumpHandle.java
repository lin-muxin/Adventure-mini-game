package game2.handle;

import game2.view.GamePanel;

public class JumpHandle implements Runnable {
    GamePanel gamePanel;
    boolean isJump = false;
    boolean isSky = false;
    int c;

    public JumpHandle(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        while (true) {
            c = 0;

            if (isJump) {
                isJump = false;
                jumpUp();
                jumpDown();
            }
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void jumpDown() {
        loop:
        while (true) {
            for (int i = 0; i < gamePanel.v.size(); i++) {
                if (gamePanel.hero_x  + gamePanel.hero_width> gamePanel.v.get(i)[0]
                        && gamePanel.hero_x < gamePanel.v.get(i)[0] + gamePanel.v.get(i)[2]) {
                    if (gamePanel.hero_y == gamePanel.v.get(i)[1] - gamePanel.hero_height) {
                        isSky = false;
                        break loop;
                    }
                }
            }
            if (isJump && c < 2) {
                isJump = false;
                jumpUp();
            }
            gamePanel.hero_y += 1;
            for(int i=0;i<gamePanel.ms.size();i++) {
                if (gamePanel.hero_y + gamePanel.hero_height == gamePanel.ms.get(i)[1]
                        && gamePanel.hero_x + gamePanel.hero_width > gamePanel.ms.get(i)[0]
                        && gamePanel.hero_x < gamePanel.ms.get(i)[0] + gamePanel.ms.get(i)[2]) {
                    gamePanel.ms.remove(i);
                    break ;
                }
            }
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void jumpUp() {
        c++;
        for (int i = 0; i < 80; i++) {
            if (isJump && c < 2) {
                isJump = false;
                jumpUp();
                break;
            }
            if(!isJumpD()){
                break;
            }
            gamePanel.hero_y -= 1;

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isJumpD() {
        for (int i = 0; i < gamePanel.v.size(); i++) {
            if (gamePanel.hero_y == gamePanel.v.get(i)[1] + gamePanel.v.get(i)[3]
                    && gamePanel.hero_x  + gamePanel.hero_width> gamePanel.v.get(i)[0]
                    && gamePanel.hero_x < gamePanel.v.get(i)[0] + gamePanel.v.get(i)[2]) {
                return false;
            }
        }
        return true;
    }
}
