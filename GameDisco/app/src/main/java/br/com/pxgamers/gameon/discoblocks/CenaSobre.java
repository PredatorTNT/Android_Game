package br.com.pxgamers.gameon.discoblocks;


import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGInputManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;

public class CenaSobre extends AGScene {

    private AGSprite vrCreditos = null;

    //contruto de cena
    public CenaSobre(AGGameManager vrGerente) {
        super(vrGerente);
    }

    //Metodo chamado sempre que a sena é exibida
    public void init() {
        setSceneBackgroundColor(1, 1, 1);
        vrCreditos = createSprite(R.drawable.creditos, 1, 1);
        vrCreditos.setScreenPercent(90, 45);
        vrCreditos.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, -vrCreditos.getSpriteHeight() / 2);
        vrCreditos.moveTo(10000, vrCreditos.vrPosition.fX, AGScreenManager.iScreenHeight + (vrCreditos.getSpriteHeight() / 2));
    }

    //chamado após uma interrupção de um aplicativo
    public void restart() {

    }

    //Chamado após um interrupçõa
    public void stop() {

    }

    //Metodo chamado quadro a quadro(logica do jogo)
    public void loop() {
        if (AGInputManager.vrTouchEvents.backButtonClicked()
                || AGInputManager.vrTouchEvents.screenClicked()
                || vrCreditos.moveEnded()) {
            vrGameManager.setCurrentScene(1);
        }
    }
}
