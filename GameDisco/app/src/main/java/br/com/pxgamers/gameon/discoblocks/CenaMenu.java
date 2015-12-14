package br.com.pxgamers.gameon.discoblocks;


import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGInputManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSoundManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;

public class CenaMenu extends AGScene {
    private AGSprite vrNomeJogo = null;
    private AGSprite vrBotaoJogo = null;
    private AGSprite vrBotaoSobre = null;
    private AGSprite vrBotaoSair = null;

    private int piscaCor = 0;

    //contruto de cena
    public CenaMenu(AGGameManager vrGerente) {
        super(vrGerente);
    }

    //Metodo chamado sempre que a cena é exibida
    public void init() {


        vrNomeJogo = createSprite(R.drawable.logo, 1, 1);
        vrNomeJogo.setScreenPercent(80, 20);
        vrNomeJogo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2,
                AGScreenManager.iScreenHeight - vrNomeJogo.getSpriteHeight() / 2);

        AGSoundManager.vrMusic.stop();
        AGSoundManager.vrMusic.loadMusic("musicaMenu.mp3", true);
        AGSoundManager.vrMusic.play();
        AGSoundManager.vrMusic.setVolume(0.5f, 0.5f);

        vrBotaoSobre = createSprite(R.drawable.botaosobre, 1, 1);
        vrBotaoSobre.setScreenPercent(40, 15);
        vrBotaoSobre.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        vrBotaoJogo = createSprite(R.drawable.botaodancar, 1, 1);
        vrBotaoJogo.setScreenPercent(40, 15);
        vrBotaoJogo.vrPosition.setXY(vrBotaoSobre.vrPosition.fX, vrBotaoSobre.vrPosition.fY + vrBotaoJogo.getSpriteHeight() * 1.5f);

        vrBotaoSair = createSprite(R.drawable.botaosair, 1, 1);
        vrBotaoSair.setScreenPercent(40, 15);
        vrBotaoSair.vrPosition.setXY(vrBotaoSobre.vrPosition.fX, vrBotaoSobre.vrPosition.fY - vrBotaoSair.getSpriteHeight() * 1.5f);

        setSceneBackgroundColor(0.541176f, 0.168627f, 0.886275f);
    }

    //chamado após uma interrupção de um aplicativo
    public void restart() {

    }

    //Chamado após um interrupçõa
    public void stop() {

    }

    //Metodo chamado quadro a quadro(logica do jogo)
    public void loop() {

        piscaCor ++;

        //violeta
        if(piscaCor == 1) setSceneBackgroundColor(0.541176f, 0.168627f, 0.886275f);
        //coral
        else if(piscaCor == 80) setSceneBackgroundColor(0.941176f, 0.501961f, 0.501961f);
        //lima
        else if(piscaCor == 160) setSceneBackgroundColor(0.678431f, 1f, 0.184314f);

        if (piscaCor == 240) piscaCor = 0;

        if (AGInputManager.vrTouchEvents.screenClicked()) {
            if (vrBotaoSair.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                vrGameManager.vrActivity.finish();
            }
            if (vrBotaoSobre.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                vrGameManager.setCurrentScene(2);
                return;
            }
            if (vrBotaoJogo.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                vrGameManager.setCurrentScene(3);
                return;
            }
        }
    }
}
