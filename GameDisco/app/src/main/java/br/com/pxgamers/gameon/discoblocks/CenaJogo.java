package br.com.pxgamers.gameon.discoblocks;


import java.util.ArrayList;

import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGInputManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSoundManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGTimer;

public class CenaJogo extends AGScene {

    private AGSprite vrAlfredoJogo = null;
    private AGSprite[] vrCaixaJogo = null;
    private AGSprite vrFundoJogo = null;

    private AGTimer vrTempoAlfredo = null;
    private AGTimer vrTempoCaixa = null;

    private ArrayList<AGSprite> vetorDeCaixasVerde = null;
    private ArrayList<AGSprite> vetorDeCaixasVermelha = null;
    private ArrayList<AGSprite> vetorDeCaixasAzul = null;


    private ArrayList<AGSprite> vetorDeQuebra = null;

    private int somBoneco = 0;
    private int somMorte = 0;
    private int somCaixa = 0;


    //contruto de cena
    public CenaJogo(AGGameManager vrGerente){
        super(vrGerente);
    }

    //Metodo chamado sempre que a sena é exibida
    public void init() {
        setSceneBackgroundColor(1,1,1);
        vrFundoJogo = createSprite(R.drawable.fundo,1,1);
        vrFundoJogo.setScreenPercent(100, 100);
        vrFundoJogo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        vrAlfredoJogo = createSprite(R.drawable.alfredo,23,1);
        vrAlfredoJogo.setScreenPercent(20, 40);
        vrAlfredoJogo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, vrAlfredoJogo.getSpriteHeight() / 2);
        vrAlfredoJogo.addAnimation(5, true, 1, 4);
        vrAlfredoJogo.addAnimation(5, true, 6, 9);
        vrAlfredoJogo.addAnimation(5, true, 11, 15);
        vrAlfredoJogo.addAnimation(5, true, 17, 22);
        vrTempoAlfredo = new AGTimer(100);
        AGSoundManager.vrMusic.stop();
        AGSoundManager.vrMusic.loadMusic("disco_drum_loop.mp3", true);
        AGSoundManager.vrMusic.setVolume(1f, 1f);
        AGSoundManager.vrMusic.play();

        somBoneco = AGSoundManager.vrSoundEffects.loadSoundEffect("linhaTrompete.wav");
    }
    private void trataTelaPressionada() {
        vrTempoAlfredo.update();

        if (!vrTempoAlfredo.isTimeEnded()) {
            return;
        } else {
            vrTempoAlfredo.restart();
        }

        if(AGInputManager.vrTouchEvents.screenDown()) {
            //se tocou no lado direito da tela
            if (AGInputManager.vrTouchEvents.getLastPosition().fX > AGScreenManager.iScreenWidth / 2) {
                //testa limite da tela
                if (vrAlfredoJogo.vrPosition.fX < (AGScreenManager.iScreenWidth - vrAlfredoJogo.getSpriteWidth()) && !vrAlfredoJogo.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                    vrAlfredoJogo.vrPosition.fX += AGScreenManager.iScreenWidth / 3;
                    vrAlfredoJogo.setCurrentAnimation(2);
                    //AGSoundManager.vrSoundEffects.play(somBoneco);
                }
            } else if (!vrAlfredoJogo.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                if (vrAlfredoJogo.vrPosition.fX > (vrAlfredoJogo.getSpriteWidth())) {
                    vrAlfredoJogo.vrPosition.fX -= AGScreenManager.iScreenWidth / 3;
                    vrAlfredoJogo.setCurrentAnimation(3);
                   // AGSoundManager.vrSoundEffects.play(somBoneco);
                }
            }
        }

        /* CODIGO PARA QUEM FOR UTILIZAR O ACELEROMETRO

            if (AGInputManager.vrAccelerometer.fAccelX > 2)
            {
                vrCanhao.vrPosition.fX +=  AGScreenManager.iScreenWidth / 3;
                AGSoundManager.vrSoundEffects.play(somCatraca);
            }
            else if (AGInputManager.vrAccelerometer.fAccelX < -2)
            {
                vrCanhao.vrPosition.fX-= AGScreenManager.iScreenWidth / 3;
                AGSoundManager.vrSoundEffects.play(somCatraca);
            }
         */
    }

    //Chamado apos uma interrupcao no aplicativo
    public void restart() {
    }

    //Chamado após um interrupçõa
    public void stop() {
    }


    //Metodo chamado quadro a quadro(logica do jogo)
    public void loop() {
        if(AGInputManager.vrTouchEvents.backButtonClicked()){
            vrGameManager.setCurrentScene(1);
            return;
        }
        trataTelaPressionada();
        if(AGInputManager.vrTouchEvents.screenClicked()){
            if (vrAlfredoJogo.getCurrentAnimationIndex() == 0 )
                vrAlfredoJogo.setCurrentAnimation(1);
            else
                vrAlfredoJogo.setCurrentAnimation(0);
        }
    }
}
