package menu_commands

import scala.swing._

/** The controller in the MVC architecture
*
*  @constructor the controller in the MVC architecture
*  @param view the View in the MVC architecture
*  @param model the Model in the MVC architecture
*/
class Controller(view: View, model: Model) {

  /** shows the game by telling the view to update */
  def showGame = view.update

  /** shuffles the deck by telling the model to shuffle */
  def shuffle = model.shuffle

  /** shows the player order by telling the model to showPlayerOrder */
  def showPlayerOrder = model.showPlayerOrder

  /** advances the player order by telling the model to advancePlayerOrder */
  def advancePlayerOrder = model.advancePlayerOrder

  /** initializes the game by telling the model to initializeGame */
  def initializeGame = model.initializeGame

  /** executes a turn by telling the model to doTurn */
  def doTurn = model.doTurn

  /** simulates the whole game by telling the model to doGame */
  def doGame = model.doGame

  /** shows the strategies by telling the model to showStrategies */
  def showStrategies = model.showStrategies

  /** sets a given [Strategy] for a [Player] by telling the model to setStrategy */
  def setStrategy(player: Player, strategy: Strategy) = model.setStrategy(player, strategy)

  /** quits the application */
  def exit = sys.exit(0)
}
