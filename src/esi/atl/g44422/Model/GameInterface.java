package esi.atl.g44422.Model;

import esi.atl.g44422.Util.*;

import java.util.ArrayList;

public interface GameInterface extends Observable {
	Board getBoard();
	Player getWinner();
	Player getCurrentPlayer();
	int getNumberRequiredPlayers();
	ArrayList<Player> getPlayers();
	void addPlayer(Player player);
	void start();
	boolean isDone();
	void currentPlayerPutsPiece(int index);
	void currentPlayerSkips();
}
