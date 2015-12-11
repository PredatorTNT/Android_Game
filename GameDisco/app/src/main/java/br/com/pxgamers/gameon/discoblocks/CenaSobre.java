package br.com.pxgamers.gameon.discoblocks;


import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGInputManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;

public class CenaSobre extends AGScene {

    private AGSprite vrCreditos = null;

    private int piscaCor = 0;

    //contruto de cena
    public CenaSobre(AGGameManager vrGerente) {
        super(vrGerente);
    }

    //Metodo chamado sempre que a sena é exibida
    public void init() {
        setSceneBackgroundColor(0.541176f, 0.168627f, 0.886275f);
        vrCreditos = createSprite(R.drawable.telacreditos, 1, 1);
        vrCreditos.setScreenPercent(50, 100);
        vrCreditos.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, -vrCreditos.getSpriteHeight() / 2);
        vrCreditos.moveTo(16000, vrCreditos.vrPosition.fX, AGScreenManager.iScreenHeight + (vrCreditos.getSpriteHeight() / 2));
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

        if (AGInputManager.vrTouchEvents.backButtonClicked()
                || AGInputManager.vrTouchEvents.screenClicked()
                || vrCreditos.moveEnded()) {
            vrGameManager.setCurrentScene(1);
        }
    }
}
