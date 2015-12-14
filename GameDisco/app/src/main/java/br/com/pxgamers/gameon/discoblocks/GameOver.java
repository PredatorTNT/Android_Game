package br.com.pxgamers.gameon.discoblocks;

/**
 * Created by Dioni on 14/12/2015.
 */

import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGInputManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;


import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGInputManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGTimer;

public class GameOver extends AGScene {

    private AGSprite vrFim = null;
    private AGTimer vrTempo = null;

    private int piscaCor = 0;

    //contruto de cena
    public GameOver(AGGameManager vrGerente) {
        super(vrGerente);
    }

    //Metodo chamado sempre que a sena é exibida
    public void init() {
        setSceneBackgroundColor(0.541176f, 0.168627f, 0.886275f);
        vrFim = createSprite(R.drawable.tela_morte, 1, 1);
        vrFim.setScreenPercent(100, 100);
        vrFim.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        vrTempo = new AGTimer(10000);
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
        vrTempo.update();


        if (AGInputManager.vrTouchEvents.backButtonClicked()
                || AGInputManager.vrTouchEvents.screenClicked()
                || vrTempo.isTimeEnded()) {
            vrGameManager.setCurrentScene(1);
        }
    }
}
