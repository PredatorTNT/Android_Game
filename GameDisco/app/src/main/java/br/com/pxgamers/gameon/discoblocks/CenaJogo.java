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

    private ArrayList<AGSprite> vetorDeQuebraCx1 = null;
    private ArrayList<AGSprite> vetorDeQuebraCx2 = null;
    private ArrayList<AGSprite> vetorDeQuebraCx3 = null;


    private AGSprite vrFlechas1 = null;
    private AGSprite vrFlechas2 = null;
    private AGSprite vrFlechas3 = null;



    private AGSprite vrFundoJogo = null;
    private AGSprite vrBarraPlacar = null;
    private AGSprite[] vrPlacarInfo = null;

    private AGTimer vrTempoAlfredo = null;
    private AGTimer vrTempoCaixa1 = null;
    private AGTimer vrTempoCaixa2 = null;
    private AGTimer vrTempoCaixa3 = null;

    private ArrayList<AGSprite> vetorDeCaixasVerde = null;
    private ArrayList<AGSprite> vetorDeCaixasRosas = null;
    private ArrayList<AGSprite> vetorDeCaixasAzul = null;


    private ArrayList<AGSprite> vetorDeQuebra = null;

    private int somBoneco = 0;
    private int somMorte = 0;
    private int somCaixa = 0;
    private Float cornerSize;

    private int vPontuacao = 0;
    private int vPontuacaoTemp = 0;

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

        vrTempoCaixa1 = new AGTimer(3000);
        vrTempoCaixa2 = new AGTimer(5000);
        vrTempoCaixa3 = new AGTimer(4000);


        cornerSize = vrFundoJogo.getSpriteWidth() / 13;

        vetorDeCaixasVerde = new ArrayList<AGSprite>();
        vetorDeCaixasRosas = new ArrayList<AGSprite>();
        vetorDeCaixasAzul = new ArrayList<AGSprite>();

        vetorDeQuebraCx1 = new ArrayList<AGSprite>();
        vetorDeQuebraCx2 = new ArrayList<AGSprite>();
        vetorDeQuebraCx3 = new ArrayList<AGSprite>();
        //////////////////////////////

        somCaixa = AGSoundManager.vrSoundEffects.loadSoundEffect("explodenavio.wav");

        vrCaixaJogo1 = createSprite(R.drawable.caixa_redimen,23,1);
        vrCaixaJogo1.setScreenPercent(22, 13);
        vrCaixaJogo1.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 - vrCaixaJogo1.getSpriteWidth() / 2 - (cornerSize / 2), AGScreenManager.iScreenHeight);
        vrCaixaJogo1.addAnimation(1, true, 0);
        vrCaixaJogo1.addAnimation(3, true, 0, 7);
        vrCaixaJogo1.setCurrentAnimation(0);



        vrCaixaJogo2 = createSprite(R.drawable.caixa_redimen,23,1);
        vrCaixaJogo2.setScreenPercent(22, 13);
        vrCaixaJogo2.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight);
        vrCaixaJogo2.vrDirection.fY = 1;
        vrCaixaJogo2.iMirror= AGSprite.VERTICAL;
        vrCaixaJogo2.addAnimation(1, true, 8);
        vrCaixaJogo2.addAnimation(3, true, 8, 15);
        vrCaixaJogo2.setCurrentAnimation(0);

        vrCaixaJogo3 = createSprite(R.drawable.caixa_redimen,23,1);
        vrCaixaJogo3.setScreenPercent(22, 13);
        vrCaixaJogo3.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 + (vrCaixaJogo3.getSpriteWidth() * 2) + (cornerSize / 2), AGScreenManager.iScreenHeight);
        vrCaixaJogo3.addAnimation(1, true, 16);
        vrCaixaJogo3.addAnimation(3, true, 16, 22);
        vrCaixaJogo3.setCurrentAnimation(0);

        ////////////////////////



        vrBarraPlacar = createSprite(R.drawable.barra_placar, 1, 1);
        vrBarraPlacar.setScreenPercent(100, 14);
        vrBarraPlacar.bAutoRender = false;
        vrBarraPlacar.vrPosition.setXY(AGScreenManager.iScreenWidth - vrBarraPlacar.getSpriteWidth() / 2, AGScreenManager.iScreenHeight - vrBarraPlacar.getSpriteHeight() / 3);

        //placar
        vrPlacarInfo = new AGSprite[6];
        for (int i = 0; i < vrPlacarInfo.length;i++){
            vrPlacarInfo[i] = createSprite(R.drawable.numeros,6,4);
            vrPlacarInfo[i].setScreenPercent(14,14);
            vrPlacarInfo[i].bAutoRender = false;
            for (int j = 0; j < 10; j++) {
                vrPlacarInfo[i].addAnimation(1,false,j);
            }
            if(i == 0){
                vrPlacarInfo[i].vrPosition.setXY(vrPlacarInfo[0].getSpriteWidth(),vrBarraPlacar.vrPosition.fY);
            }
            else {
                vrPlacarInfo[i].vrPosition.setXY(vrPlacarInfo[i-1].vrPosition.fX +
                                vrPlacarInfo[i].getSpriteWidth(), vrBarraPlacar.vrPosition.fY);
            }
        }





        vrFlechas1 = createSprite(R.drawable.flechas_verdes, 2, 1);
        vrFlechas1.setScreenPercent(50, 50);
        vrFlechas1.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 - vrCaixaJogo1.getSpriteWidth() / 2 - (cornerSize / 2), AGScreenManager.iScreenHeight / 2 + vrFlechas1.getSpriteHeight() / 4);
        vrFlechas1.addAnimation(3, true, 0, 1);
        vrFlechas1.bVisible = false;

        vrFlechas2 = createSprite(R.drawable.flechas_rosas, 2, 1);
        vrFlechas2.setScreenPercent(50, 50);
        vrFlechas2.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2 + vrFlechas1.getSpriteHeight() / 4);
        vrFlechas2.addAnimation(3, true, 0, 1);
        vrFlechas2.bVisible = false;

        vrFlechas3 = createSprite(R.drawable.flechas_azuis, 2, 1);
        vrFlechas3.setScreenPercent(50, 50);
        vrFlechas3.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 + (vrCaixaJogo3.getSpriteWidth() * 2) + (cornerSize / 2), AGScreenManager.iScreenHeight / 2 + vrFlechas1.getSpriteHeight() / 4);
        vrFlechas3.addAnimation(3, true, 0, 1);
        vrFlechas3.bVisible = false;


        AGSoundManager.vrMusic.stop();
        AGSoundManager.vrMusic.loadMusic("loopBateria.wav", true);
        AGSoundManager.vrMusic.setVolume(0.8f, 0.8f);
        AGSoundManager.vrMusic.play();
        somBoneco = AGSoundManager.vrSoundEffects.loadSoundEffect("linhaTrompete.wav");

    }
    public void render(){
        super.render();
        vrBarraPlacar.render();
        desenhaPlacar();
    }
    void desenhaPlacar(){
        for (int i = 0; i < vrPlacarInfo.length; i++) {
            vrPlacarInfo[i].render();
        }
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
        //Caixas Verdes
        verificaCaixaVerde();
        atualizaCaixaVerde();
        atualizaquebraCaixaVerde();
        //Caixas Rosas
        verificaCaixaRosa();
        atualizaCaixaRosa();
        atualizaquebraCaixaRosa();
        //Caixas Azul
        verificaCaixaAzul();
        atualizaCaixaAzul();
        atualizaquebraCaixaAzul();

        //outras funções
        atualizaplacar();

    }
    ///Funções da Caixa Verde
    private void criaatualizaCaixaVerde() {
        //Verifica se ja nao existe um sprite de tiro que pode ser reciclado
        for (int indice = 0; indice < vetorDeCaixasVerde.size(); indice++) {
            if (vetorDeCaixasVerde.get(indice).bRecycled == true) {
                vetorDeCaixasVerde.get(indice).bRecycled = false;
                vetorDeCaixasVerde.get(indice).bVisible = true;
                vetorDeCaixasVerde.get(indice).vrPosition.setXY(vrCaixaJogo1.vrPosition.fX,  vrCaixaJogo1.vrPosition.fY  +  vetorDeCaixasVerde.get(indice).getSpriteHeight() / 2);
                vetorDeCaixasVerde.get(indice).setCurrentAnimation(0);
                return;
            }
        }
        AGSprite vrNovaCaixa = createSprite(R.drawable.caixa_redimen,23,1);
        vrNovaCaixa.setScreenPercent(22, 13);
        vrNovaCaixa.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 - vrNovaCaixa.getSpriteWidth() / 2 - (cornerSize / 2), AGScreenManager.iScreenHeight);
        vrNovaCaixa.addAnimation(1, true, 0);
        vrNovaCaixa.addAnimation(3, true, 0, 7);
        vrNovaCaixa.setCurrentAnimation(0);
        vetorDeCaixasVerde.add(vrNovaCaixa);
    }
    private void verificaCaixaVerde() {
        vrTempoCaixa1.update();
            if (vrTempoCaixa1.isTimeEnded()) {
                vrTempoCaixa1.restart();
                criaatualizaCaixaVerde();
            }
    }
    private void atualizaCaixaVerde() {
        for (int indice = 0; indice < vetorDeCaixasVerde.size(); indice++) {
            vetorDeCaixasVerde.get(indice).vrPosition.fY -= 10;
            vrFlechas1.bVisible = true;

            if (vetorDeCaixasVerde.get(indice).vrPosition.fY < vetorDeCaixasVerde.get(indice).getSpriteHeight()) {
                vetorDeCaixasVerde.get(indice).bRecycled = true;
                vetorDeCaixasVerde.get(indice).bVisible = false;
                vPontuacaoTemp = vPontuacaoTemp + 1;

            }

        }
    }
    private void atualizaquebraCaixaVerde(){
        for (int iIndex = 0; iIndex < vetorDeQuebraCx1.size();iIndex++){
            if(vetorDeQuebraCx1.get(iIndex).getCurrentAnimation().isAnimationEnded()){
                vetorDeQuebraCx1.get(iIndex).bRecycled = true;
            }
        }
    }
    private void quebraCaixaVerde(float posX, float posY){
        for (int iIndex = 0; iIndex<vetorDeQuebraCx1.size();iIndex++){
            if(vetorDeQuebraCx1.get(iIndex).bRecycled){
                vetorDeQuebraCx1.get(iIndex).bRecycled = false;
                vetorDeQuebraCx1.get(iIndex).getCurrentAnimation().restart();
                vetorDeQuebraCx1.get(iIndex).vrPosition.setXY(posX,posY);
                return;
            }
        }
        AGSprite  vrNovaExplosao = createSprite(R.drawable.caixa_redimen,23,1);
        vrNovaExplosao.setScreenPercent(22, 13);
        vrNovaExplosao.addAnimation(3, false, 0, 7);
        vrNovaExplosao.vrPosition.setXY(posX, posY);
        vetorDeQuebraCx1.add(vrNovaExplosao);
    }

    ///Funções da Caixa Rosa
    private void criaatualizaCaixaRosa() {
        //Verifica se ja nao existe um sprite de tiro que pode ser reciclado
        for (int indice = 0; indice < vetorDeCaixasRosas.size(); indice++) {
            if (vetorDeCaixasRosas.get(indice).bRecycled == true) {
                vetorDeCaixasRosas.get(indice).bRecycled = false;
                vetorDeCaixasRosas.get(indice).bVisible = true;
                vetorDeCaixasRosas.get(indice).vrPosition.setXY(vrCaixaJogo2.vrPosition.fX,  vrCaixaJogo2.vrPosition.fY  +  vetorDeCaixasRosas.get(indice).getSpriteHeight() / 2);
                vetorDeCaixasRosas.get(indice).setCurrentAnimation(0);
                return;
            }
        }

        AGSprite vrNovaCaixa = createSprite(R.drawable.caixa_redimen,23,1);
        vrNovaCaixa.setScreenPercent(22, 13);
        vrNovaCaixa.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight);
        vrNovaCaixa.addAnimation(1, true, 8);
        vrNovaCaixa.addAnimation(3, true, 8, 15);
        vrNovaCaixa.setCurrentAnimation(0);
        vetorDeCaixasRosas.add(vrNovaCaixa);
    }
    private void verificaCaixaRosa() {
        vrTempoCaixa2.update();
        if (vrTempoCaixa2.isTimeEnded()) {
            vrTempoCaixa2.restart();
            criaatualizaCaixaRosa();
        }
    }
    private void atualizaCaixaRosa() {
        for (int indice = 0; indice < vetorDeCaixasRosas.size(); indice++) {
            vetorDeCaixasRosas.get(indice).vrPosition.fY -= 10;
            vrFlechas2.bVisible = true;

            if (vetorDeCaixasRosas.get(indice).vrPosition.fY < vetorDeCaixasRosas.get(indice).getSpriteHeight()) {
                vetorDeCaixasRosas.get(indice).bRecycled = true;
                vetorDeCaixasRosas.get(indice).bVisible = false;
                vPontuacaoTemp = vPontuacaoTemp + 1;

            }

        }
    }
    private void atualizaquebraCaixaRosa(){
        for (int iIndex = 0; iIndex < vetorDeQuebraCx2.size();iIndex++){
            if(vetorDeQuebraCx2.get(iIndex).getCurrentAnimation().isAnimationEnded()){
                vetorDeQuebraCx2.get(iIndex).bRecycled = true;
            }
        }
    }
    private void quebraCaixaRosa(float posX, float posY){
        for (int iIndex = 0; iIndex<vetorDeQuebraCx2.size();iIndex++){
            if(vetorDeQuebraCx2.get(iIndex).bRecycled){
                vetorDeQuebraCx2.get(iIndex).bRecycled = false;
                vetorDeQuebraCx2.get(iIndex).getCurrentAnimation().restart();
                vetorDeQuebraCx2.get(iIndex).vrPosition.setXY(posX,posY);
                return;
            }
        }
        AGSprite  vrNovaExplosao = createSprite(R.drawable.caixa_redimen,23,1);
        vrNovaExplosao.setScreenPercent(22, 13);
        vrNovaExplosao.addAnimation(3, false, 8, 15);
        vrNovaExplosao.vrPosition.setXY(posX, posY);
        vetorDeQuebraCx2.add(vrNovaExplosao);
    }


    ///Funções da Caixa Azul
    private void criaatualizaCaixaAzul() {
        //Verifica se ja nao existe um sprite de tiro que pode ser reciclado
        for (int indice = 0; indice < vetorDeCaixasAzul.size(); indice++) {
            if (vetorDeCaixasAzul.get(indice).bRecycled == true) {
                vetorDeCaixasAzul.get(indice).bRecycled = false;
                vetorDeCaixasAzul.get(indice).bVisible = true;
                vetorDeCaixasAzul.get(indice).vrPosition.setXY(vrCaixaJogo3.vrPosition.fX,  vrCaixaJogo3.vrPosition.fY  +  vetorDeCaixasAzul.get(indice).getSpriteHeight() / 2);
                vetorDeCaixasAzul.get(indice).setCurrentAnimation(0);
                return;
            }
        }

        AGSprite vrNovaCaixa = createSprite(R.drawable.caixa_redimen,23,1);
        vrNovaCaixa.setScreenPercent(22, 13);
        vrNovaCaixa.vrPosition.setXY(AGScreenManager.iScreenWidth / 3 + (vrNovaCaixa.getSpriteWidth() * 2) + (cornerSize / 2), AGScreenManager.iScreenHeight);
        vrNovaCaixa.addAnimation(1, true, 16);
        vrNovaCaixa.addAnimation(3, true, 16, 22);
        vrNovaCaixa.setCurrentAnimation(0);
        vetorDeCaixasAzul.add(vrNovaCaixa);
    }
    private void verificaCaixaAzul() {
        vrTempoCaixa3.update();
        if (vrTempoCaixa3.isTimeEnded()) {
            vrTempoCaixa3.restart();
            criaatualizaCaixaAzul();
        }
    }
    private void atualizaCaixaAzul() {
        for (int indice = 0; indice < vetorDeCaixasAzul.size(); indice++) {
            vetorDeCaixasAzul.get(indice).vrPosition.fY -= 10;
            vrFlechas3.bVisible = true;

            if (vetorDeCaixasAzul.get(indice).vrPosition.fY < vetorDeCaixasAzul.get(indice).getSpriteHeight()) {
                vetorDeCaixasAzul.get(indice).bRecycled = true;
                vetorDeCaixasAzul.get(indice).bVisible = false;
                vPontuacaoTemp = vPontuacaoTemp + 1;

            }

        }
    }
    private void atualizaquebraCaixaAzul(){
        for (int iIndex = 0; iIndex < vetorDeQuebraCx3.size();iIndex++){
            if(vetorDeQuebraCx3.get(iIndex).getCurrentAnimation().isAnimationEnded()){
                vetorDeQuebraCx3.get(iIndex).bRecycled = true;
            }
        }
    }
    private void quebraCaixaAzul(float posX, float posY){
        for (int iIndex = 0; iIndex<vetorDeQuebraCx3.size();iIndex++){
            if(vetorDeQuebraCx3.get(iIndex).bRecycled){
                vetorDeQuebraCx3.get(iIndex).bRecycled = false;
                vetorDeQuebraCx3.get(iIndex).getCurrentAnimation().restart();
                vetorDeQuebraCx3.get(iIndex).vrPosition.setXY(posX,posY);
                return;
            }
        }
        AGSprite  vrNovaExplosao = createSprite(R.drawable.caixa_redimen,23,1);
        vrNovaExplosao.setScreenPercent(22, 13);
        vrNovaExplosao.addAnimation(3, false, 16, 22);
        vrNovaExplosao.vrPosition.setXY(posX, posY);
        vetorDeQuebraCx3.add(vrNovaExplosao);
    }


    private void atualizaplacar(){
        if(vPontuacaoTemp >0){
            vPontuacao++;
            vPontuacaoTemp--;
        }
        vrPlacarInfo[5].setCurrentAnimation((int)vPontuacao % 10);
        vrPlacarInfo[4].setCurrentAnimation(((int)vPontuacao % 100)/10);
        vrPlacarInfo[3].setCurrentAnimation(((int) vPontuacao % 1000) / 100);
        vrPlacarInfo[2].setCurrentAnimation(((int) vPontuacao % 10000) / 1000);
        vrPlacarInfo[1].setCurrentAnimation(((int) vPontuacao % 100000) / 10000);
        vrPlacarInfo[0].setCurrentAnimation((int) vPontuacao / 100000);

    }




    private void caixaVerdeNoAlfredo(){
        for (int iIndex = 0 ; iIndex < vetorDeCaixasVerde.size();iIndex++){
            if(vetorDeCaixasVerde.get(iIndex).bRecycled)
                continue;
                if(vetorDeCaixasVerde.get(iIndex).collide(vrAlfredoJogo)){
                    vetorDeCaixasVerde.get(iIndex).bRecycled = true;
                    vetorDeCaixasVerde.get(iIndex).bVisible = false;
                    AGSoundManager.vrSoundEffects.play(somCaixa);
                    //fazer
                   //quebraCaixa(vrAlfredoJogo.vrPosition.fX, vrAlfredoJogo.vrPosition.fY);
                    vPontuacaoTemp = vPontuacaoTemp - 10;
                    if(vrAlfredoJogo.vrDirection.fX >0){
                        vrAlfredoJogo.iMirror = AGSprite.NONE;
                        vrAlfredoJogo.vrPosition.fX = AGScreenManager.iScreenWidth+vrAlfredoJogo.getSpriteWidth()/2;
                    }else{
                        vrAlfredoJogo.iMirror = AGSprite.HORIZONTAL;
                        vrAlfredoJogo.vrPosition.fX = -vrAlfredoJogo.getSpriteWidth()/2;
                    }
                    break;
                }
        }
    }

}
