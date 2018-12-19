package esi.atl.g44422.util;

/**
 * Represents an observable component of the application
 */
public interface Observable {
	/**
	 * Adds an observer to a component
	 *
	 * @param obs the observer
	 */
	void addObserver(Observer obs);

	/**
	 * Removes an observer to a component
	 *
	 * @param obs the observer
	 */
	void removeObserver(Observer obs);
}
