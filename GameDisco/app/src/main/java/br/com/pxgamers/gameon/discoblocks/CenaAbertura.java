package br.com.pxgamers.gameon.discoblocks;


import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSoundManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;

public class CenaAbertura extends AGScene {

    private AGSprite Logo = null;
    private int estadoLogo = 0;

    private AGSprite Disco = null;
    private int estadoDisco = 0;

    private int contador = 0;

    //contruto de cena
    public CenaAbertura(AGGameManager vrGerente) {
        super(vrGerente);
    }

    //Metodo chamado sempre que a sena é exibida
    public void init() {
        setSceneBackgroundColor(1, 1, 1);

        Logo = createSprite(R.drawable.logo_uri, 1, 1);
        Logo.setScreenPercent(100, 35);
        Logo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        Logo.fadeIn(3000);
        estadoLogo = 0;

        Disco = createSprite(R.drawable.disco1, 4, 1);
        Disco.setScreenPercent(90, 70);
        Disco.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        Disco.bVisible = false;
        Disco.addAnimation(3,true,0,3);
        estadoDisco = 0;

        AGSoundManager.vrMusic.loadMusic("musicaMenu.mp3", true);
    }

    //chamado após uma interrupção de um aplicativo
    public void restart() {

    }

    //Chamado após um interrupçõa
    public void stop() {

    }

    //Metodo chamado quadro a quadro(logica do jogo)
    public void loop() {

        contador ++;

        if (estadoLogo == 0) {
            if (Logo.fadeEnded()) {
                Logo.fadeOut(3000);
                estadoLogo = 1;
            }
        } else {
            if (Logo.fadeEnded()) {

                setSceneBackgroundColor(0.541176f, 0.168627f, 0.886275f);
                Disco.bVisible = true;
                AGSoundManager.vrMusic.play();
                estadoDisco = 1;

                estadoLogo = 2;
                Logo.bVisible = false;
            }
        }

        if (estadoDisco == 1) {
            Disco.setCurrentAnimation(0);
            estadoDisco = 2;
        }

        if (estadoDisco == 2 && estadoLogo == 2 && contador >= 500) vrGameManager.setCurrentScene(1);
    }
}
