/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotesteenginevs;

import br.silo.engine.vs.audio.Music;
import br.silo.engine.vs.gamelogic.objects.DialogText;
import br.silo.engine.vs.gamelogic.Game;
import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.gamelogic.Sprite;
import br.silo.engine.vs.gamelogic.objects.DialogChoose;
import br.silo.engine.vs.utils.GameFacilitador;
import br.silo.engine.vs.visualnovel.ActionCommand;
import br.silo.engine.vs.visualnovel.actions.ActionChangeScene;
import br.silo.engine.vs.visualnovel.actions.ActionPlayMusic;
import br.silo.engine.vs.visualnovel.actions.ActionShowQuestion;
import br.silo.engine.vs.visualnovel.actions.ActionShowText;
import br.silo.engine.vs.visualnovel.actions.ActionStopMusic;
import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class JogoTesteEngineVS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = Game.getInstance();
        
        //Scenes
        Scene scene = new Scene("cena_rua");
        Scene scene2 = new Scene("cena_parque");
        
        //Setup scene 1
        GameFacilitador.makeObjectSprite(scene, "bg_street.png",0,0, true);
        GameFacilitador.makeObjectSprite(scene, "girl10.png",200,0, true);
                
        GameFacilitador.makeCmdDialogText(scene, "Bom dia!", true);
        
        ArrayList<ActionCommand> listaAcaoResposta1 = new ArrayList<>();
        ArrayList<ActionCommand> listaAcaoResposta2 = new ArrayList<>();
        ArrayList<ActionCommand> listaAcaoResposta3 = new ArrayList<>();
        
        GameFacilitador.makeCmdQuestion(scene, "Você é novo aqui?", "Sim", "Não", "Talvez"
                , listaAcaoResposta1, listaAcaoResposta2, listaAcaoResposta3, true);
        
        listaAcaoResposta1.add(GameFacilitador.makeCmdDialogText(scene, "Que bom!", false));
        listaAcaoResposta2.add(GameFacilitador.makeCmdDialogText(scene, "Eu nunca lhe vi antes!", false));
        listaAcaoResposta3.add(GameFacilitador.makeCmdDialogText(scene, "Hmm!", false));
        listaAcaoResposta3.add(GameFacilitador.makeCmdDialogText(scene, "Vamos mudar de assunto então!", false));
        
        
        GameFacilitador.makeCmdDialogText(scene, "Eu estou indo ao parque, vem comigo!", true);
        
        
        GameFacilitador.makeCmdChangeScene(scene, scene2, true);
        
        
        //Setup scene 2
        GameFacilitador.makeObjectSprite(scene2, "bg_park.png",0,0, true);
        GameFacilitador.makeObjectSprite(scene2, "girl7.png",200,0, true);
        
        
        GameFacilitador.makeCmdPlayMusic(scene2, "passaros.wav", true);
        
        ArrayList<ActionCommand> listaAcaoResposta21 = new ArrayList<>();
        ArrayList<ActionCommand> listaAcaoResposta22 = new ArrayList<>();
        ArrayList<ActionCommand> listaAcaoResposta23 = new ArrayList<>();
        
        GameFacilitador.makeCmdQuestion(scene2, "Você gosta do som dos passarinhos?", "Claro, é lindo!",
                "Não, é irritante!!!", "Só o dos que cantam bem."
                , listaAcaoResposta21, listaAcaoResposta22, listaAcaoResposta23, true);
                
        listaAcaoResposta22.add(GameFacilitador.makeCmdDialogText(scene, "Que pena! Você parecia legal!", false));
        listaAcaoResposta23.add(GameFacilitador.makeCmdDialogText(scene, "Verdade.", false));
        
        GameFacilitador.makeCmdDialogText(scene2, "Eu gosto muito!", true);
        GameFacilitador.makeCmdDialogText(scene2, "Eu venho no parque só para ouvi-los, \n"
                + "é muito legal ficar sentada só ouvindo eles cantarem!", true);
        GameFacilitador.makeCmdDialogText(scene2, "Bem... Eu tenho que ir embora agora!\n" +
                    "Foi muito bom te conhecer, até outro dia!", true);
        
        
        //FIm
        GameFacilitador.makeCmdDialogText(scene2, "Fim", true);
        GameFacilitador.makeCmdStopMusic(scene2);
        
        //Adiconando as cenas
        game.addScenes(scene);
        game.addScenes(scene2);
        
        
        //Iniciando Jogo
        game.startGame();
        
                        
    }
    
}
