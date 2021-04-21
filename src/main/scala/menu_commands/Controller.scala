package menu_commands

import scala.swing._

class Controller(view: View, model: Model) {

  def showGame = {
    view.update
  }
  
  def shuffle = model.shuffle
  
  def showPlayerOrder = model.showPlayerOrder
  
  def advancePlayerOrder = model.advancePlayerOrder
  
  def initializeGame = {
    model.initializeGame
  }
  
  def doTurn = model.doTurn
  
  def doGame = model.doGame
  
  def showStrategies = model.showStrategies
  
  def setStrategy(player: Player, strategy: Strategy) = model.setStrategy(player, strategy)

  def exit = sys.exit(0)
}