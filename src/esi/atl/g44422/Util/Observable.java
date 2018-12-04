package esi.atl.g44422.Util;

import java.util.ArrayList;

public interface Observable {
	public void addObserver(Observer obs);
	public void removeObserver(Observer obs);
}
