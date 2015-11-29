package br.com.pxgamers.gameon.discoblocks;


import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGInputManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScene;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGScreenManager;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGSprite;

public class CenaJogo extends AGScene {


    private AGSprite vrFundoJogo = null;

    private int vPontucao = 0;
    private int vPontucaoTemp = 0;

    //contruto de cena
    public CenaJogo(AGGameManager vrGerente) {
        super(vrGerente);
    }

    //Metodo chamado sempre que a sena é exibida
    public void init() {
        setSceneBackgroundColor(1, 1, 1);

        vrFundoJogo = createSprite(R.drawable.fundo, 1, 1);
        vrFundoJogo.setScreenPercent(100, 100);
        vrFundoJogo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

    }

    //Reescrevendo o metodo de desenho da cena
    public void render() {
        super.render();
    }

    //Metodo responsavel pela criacao de um novo tiro


    //Chamado apos uma interrupcao no aplicativo
    public void restart() {
    }

    //Chamado após um interrupçõa
    public void stop() {
    }

    //Metodo chamado quadro a quadro(logica do jogo)
    public void loop() {
        if (AGInputManager.vrTouchEvents.backButtonClicked()) {
            vrGameManager.setCurrentScene(1);
            return;
        }
    }
}
