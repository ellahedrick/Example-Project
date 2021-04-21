package menu_commands

import scala.swing._

class Controller(view: View, model: Model) {

  def showGame = {
    view.update
  }
  
  def shuffle = Action("Shuffle Cards") {
    model.shuffle
  }
  
  def randomOrder = model.randomOrder
  
  def showPlayerOrder = Action("Show Player Order") {
    model.showPlayerOrder
  }
  
  def advancePlayerOrder = Action("Advance Player Order") {
    model.advancePlayerOrder
  }
  
  def initializeGame = model.initializeGame
  
  def checkForWinner = Action("Check For Winner") {
    model.checkForWinner
  }
  
  def doMove = Action("Do Move") {
    model.doMove
  }
  
  def doTurn = model.doTurn
  
  def doGame = model.doGame
  
  def showStrategies = model.showStrategies
  
  def setStrategy(player: Player, strategy: Strategy) = Action("Property First"){
    model.setStrategy(player, strategy)
  }

  def exit = Action("Exit") {
    sys.exit(0)
  }
}