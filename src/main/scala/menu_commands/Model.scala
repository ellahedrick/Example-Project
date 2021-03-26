package menu_commands

/** A model in the MVC architecture
*/
class Model {

  private val gameArea = "\n" + 
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n" +
  "[   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ][   ]\n"
  private val playerOrder = "Player Order: Emma, Rocco, Grace, Erik"
    
  /** Calls showGameArea within Menu */
  def showGameArea = Menu.showGameArea
  
  /** Calls showPlayerOrder within Menu */
  def showPlayerOrder = Menu.showPlayerOrder
  
  /** Calls advancePlayerOrder within Menu */
  def advancePlayerOrder = Menu.advancePlayerOrder
  
  /** Calls initializeGame within Menu */
  def initializeGame = Menu.initialize
  
  /** Calls checkForWinner within Menu */
  def checkForWinner = Menu.showWinner
  
  /** Calls doMove within Menu */
  def doMove = Menu.doMove
  
  /** Calls doTurn within Menu */
  def doTurn = Menu.doTurn
  
  /** Calls doGame within Menu */
  def doGame = Menu.doGame
  
}