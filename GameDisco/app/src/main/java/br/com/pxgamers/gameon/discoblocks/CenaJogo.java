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

    private AGSprite vrCaixaJogo1 = null;
    private AGSprite vrCaixaJogo2 = null;
    private AGSprite vrCaixaJogo3 = null;

    private AGSprite vrFlechas1 = null;
    private AGSprite vrFlechas2 = null;
    private AGSprite vrFlechas3 = null;

    private AGSprite[] vrCaixaJogo = null;
    private AGSprite vrFundoJogo = null;
    private AGSprite vrBarraPlacar = null;

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
        setSceneBackgroundColor(0, 0, 0);
        vrFundoJogo = createSprite(R.drawable.fundo_jogo,2,1);
        vrFundoJogo.setScreenPercent(100, 110);
        vrFundoJogo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, (AGScreenManager.iScreenHeight) - (vrFundoJogo.getSpriteHeight() / 2));
        vrFundoJogo.addAnimation(4, true, 0, 1);
        vrFundoJogo.setCurrentAnimation(0);

        vrAlfredoJogo = createSprite(R.drawable.alfredo_redimen,23,1);
        vrAlfredoJogo.setScreenPercent(20, 25);
        vrAlfredoJogo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, vrAlfredoJogo.getSpriteHeight() - vrFundoJogo.getSpriteHeight() / 14);
        vrAlfredoJogo.addAnimation(3, true, 1, 4);
        vrAlfredoJogo.addAnimation(3, true, 6, 9);
        vrAlfredoJogo.addAnimation(3, true, 11, 15);
        vrAlfredoJogo.addAnimation(3, true, 17, 22);
        vrTempoAlfredo = new AGTimer(100);

        Float cornerSize = vrFundoJogo.getSpriteWidth() / 13;

        vrCaixaJogo1 = createSprite(R.drawable.caixa_redimen,23,1);
        vrCaixaJogo1.setScreenPercent(22, 13);
        vrCaixaJogo1.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 - vrCaixaJogo1.getSpriteWidth() / 2 - (cornerSize / 2), AGScreenManager.iScreenHeight - vrCaixaJogo1.getSpriteWidth() * 2);
        vrCaixaJogo1.addAnimation(1, true, 0);
        vrCaixaJogo1.addAnimation(3, true, 0, 7);
        vrCaixaJogo1.setCurrentAnimation(0);

        vrCaixaJogo2 = createSprite(R.drawable.caixa_redimen,23,1);
        vrCaixaJogo2.setScreenPercent(22, 13);
        vrCaixaJogo2.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight - vrCaixaJogo1.getSpriteWidth() * 2);
        vrCaixaJogo2.addAnimation(1, true, 8);
        vrCaixaJogo2.addAnimation(3, true, 8, 15);
        vrCaixaJogo2.setCurrentAnimation(0);

        vrCaixaJogo3 = createSprite(R.drawable.caixa_redimen,23,1);
        vrCaixaJogo3.setScreenPercent(22, 13);
        vrCaixaJogo3.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 + (vrCaixaJogo3.getSpriteWidth() * 2) + (cornerSize / 2), AGScreenManager.iScreenHeight - vrCaixaJogo1.getSpriteWidth() * 2);
        vrCaixaJogo3.addAnimation(1, true, 16);
        vrCaixaJogo3.addAnimation(3, true, 16, 22);
        vrCaixaJogo3.setCurrentAnimation(0);

        vrBarraPlacar = createSprite(R.drawable.barra_placar, 1, 1);
        vrBarraPlacar.setScreenPercent(100, 14);
        vrBarraPlacar.vrPosition.setXY(AGScreenManager.iScreenWidth - vrBarraPlacar.getSpriteWidth() / 2, AGScreenManager.iScreenHeight - vrBarraPlacar.getSpriteHeight() / 3);

        vrFlechas1 = createSprite(R.drawable.flechas_verdes, 2, 1);
        vrFlechas1.setScreenPercent(50, 50);
        vrFlechas1.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 - vrCaixaJogo1.getSpriteWidth() / 2 - (cornerSize / 2), AGScreenManager.iScreenHeight / 2 + vrFlechas1.getSpriteHeight() / 4);
        vrFlechas1.addAnimation(3, true, 0, 1);

        vrFlechas2 = createSprite(R.drawable.flechas_rosas, 2, 1);
        vrFlechas2.setScreenPercent(50, 50);
        vrFlechas2.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2 + vrFlechas1.getSpriteHeight() / 4);
        vrFlechas2.addAnimation(3, true, 0, 1);

        vrFlechas3 = createSprite(R.drawable.flechas_azuis, 2, 1);
        vrFlechas3.setScreenPercent(50, 50);
        vrFlechas3.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 + (vrCaixaJogo3.getSpriteWidth() * 2) + (cornerSize / 2), AGScreenManager.iScreenHeight / 2 + vrFlechas1.getSpriteHeight() /4  );
        vrFlechas3.addAnimation(3, true, 0, 1);

        AGSoundManager.vrMusic.stop();
        AGSoundManager.vrMusic.loadMusic("loopBateria.wav", true);
        AGSoundManager.vrMusic.setVolume(0.8f, 0.8f);
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
