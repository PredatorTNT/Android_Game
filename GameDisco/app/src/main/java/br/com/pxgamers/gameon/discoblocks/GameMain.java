package br.com.pxgamers.gameon.discoblocks;

import android.os.Bundle;

import br.com.pxgamers.gameon.discoblocks.AndGraph.AGActivityGame;
import br.com.pxgamers.gameon.discoblocks.AndGraph.AGGameManager;

public class GameMain extends AGActivityGame {

    private CenaAbertura vrCenaAbertura = null;
    private CenaMenu vrCenaMenu = null;
    private CenaSobre vrCenaSobre = null;
    private CenaJogo vrCenaJogo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //cria o gerenciador principal com acelerometro desabilitado
        vrManager = new AGGameManager(this, false);
        //para usar com acelerometro
        //vrManager = new AGGameManager(this,true);

        //cria os objetos do jogo
        vrCenaAbertura = new CenaAbertura(vrManager);
        vrCenaMenu = new CenaMenu(vrManager);
        vrCenaSobre = new CenaSobre(vrManager);
        vrCenaJogo = new CenaJogo(vrManager);


        //registra a cena ao gerente do jogo
        //A order é feita pelo código abaixo 0 - 1 - 2
        vrManager.addScene(vrCenaAbertura);// 0 cena
        vrManager.addScene(vrCenaMenu);// 1 cena
        vrManager.addScene(vrCenaSobre);// 2 cena
        vrManager.addScene(vrCenaJogo);// 3 cena
    }
}