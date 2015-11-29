package br.com.pxgamers.gameon.discoblocks;


import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGInputManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSoundManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;

public class CenaMenu extends AGScene {
    private AGSprite vrNomeJovo = null;
    private AGSprite vrBotaoJogo = null;
    private AGSprite vrBotaoSobre = null;
    private AGSprite vrBotaoSair = null;

    //contruto de cena
    public CenaMenu(AGGameManager vrGerente) {
        super(vrGerente);
    }

    //Metodo chamado sempre que a sena é exibida
    public void init() {
        vrNomeJovo = createSprite(R.drawable.titulo, 1, 1);
        vrNomeJovo.setScreenPercent(80, 20);
        vrNomeJovo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2,
                AGScreenManager.iScreenHeight - vrNomeJovo.getSpriteHeight() / 2);

        AGSoundManager.vrMusic.setVolume(1, 1);

        vrBotaoSobre = createSprite(R.drawable.btnsobre, 1, 1);
        vrBotaoSobre.setScreenPercent(40, 10);
        vrBotaoSobre.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        vrBotaoJogo = createSprite(R.drawable.btnjogar, 1, 1);
        vrBotaoJogo.setScreenPercent(40, 10);
        vrBotaoJogo.vrPosition.setXY(vrBotaoSobre.vrPosition.fX, vrBotaoSobre.vrPosition.fY + vrBotaoJogo.getSpriteHeight() * 1.5f);


        vrBotaoSair = createSprite(R.drawable.btnsair, 1, 1);
        vrBotaoSair.setScreenPercent(40, 10);
        vrBotaoSair.vrPosition.setXY(vrBotaoSobre.vrPosition.fX, vrBotaoSobre.vrPosition.fY - vrBotaoSair.getSpriteHeight() * 1.5f);

        setSceneBackgroundColor(1, 1, 1);
    }

    //chamado após uma interrupção de um aplicativo
    public void restart() {

    }

    //Chamado após um interrupçõa
    public void stop() {

    }

    //Metodo chamado quadro a quadro(logica do jogo)
    public void loop() {
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
