package br.com.pxgamers.gameon.discoblocks;


import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSoundManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;

public class CenaAbertura extends AGScene {

    private AGSprite Logo = null;
    private int estadoLogo = 0;

    //contruto de cena
    public CenaAbertura(AGGameManager vrGerente) {
        super(vrGerente);
    }

    //Metodo chamado sempre que a sena é exibida
    public void init() {
        setSceneBackgroundColor(1, 1, 1);
        Logo = createSprite(R.drawable.disco_vecteur, 1, 1);
        Logo.setScreenPercent(100, 35);
        Logo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        Logo.fadeIn(4000);
        estadoLogo = 0;
        AGSoundManager.vrMusic.loadMusic("musica.mp3", true);
        AGSoundManager.vrMusic.play();
    }

    //chamado após uma interrupção de um aplicativo
    public void restart() {

    }

    //Chamado após um interrupçõa
    public void stop() {

    }

    //Metodo chamado quadro a quadro(logica do jogo)
    public void loop() {

        if (estadoLogo == 0) {
            if (Logo.fadeEnded()) {
                Logo.fadeOut(4000);
                estadoLogo = 1;
            }
        } else {
            if (Logo.fadeEnded()) {
                vrGameManager.setCurrentScene(1);
            }
        }
    }
}
