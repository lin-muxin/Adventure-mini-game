package game2.handle;

import game2.view.GamePanel;

public class MonsterMove implements Runnable {
    GamePanel gamePanel;

    public MonsterMove(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {

        while(true) {
            for (int i = 0; i < gamePanel.ms.size(); i++) {
                gamePanel.ms.get(i)[0]+=gamePanel.ms.get(i)[6];
                if(gamePanel.ms.get(i)[0]==gamePanel.ms.get(i)[4]||gamePanel.ms.get(i)[0]+gamePanel.ms.get(i)[2]==gamePanel.ms.get(i)[5]){
                    gamePanel.ms.get(i)[6] = -gamePanel.ms.get(i)[6];
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
