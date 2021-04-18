package ExamPreparation_1.viceCity.models.neighbourhood;
//created by J.M.

import ExamPreparation_1.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {

    void action(Player mainPlayer, Collection<Player> civilPlayers);

}
