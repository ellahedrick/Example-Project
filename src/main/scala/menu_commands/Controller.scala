package menu_commands

import scala.swing._

class Controller(view: View, model: Model) {

  def showGameArea = Action("Show Game Area") {
    view.textArea.text = model.showGameArea
  }
  
  def showPlayerOrder = Action("Show Player Order") {
    view.textArea.text = model.showPlayerOrder
  }
  
  def advancePlayerOrder = Action("Advance Player Order") {
    model.advancePlayerOrder
  }
  
  def initializeGame = Action("Initialize Game") {
    model.initializeGame
  }
  
  def checkForWinner = Action("Check For Winner") {
    view.textArea.text = model.checkForWinner
  }
  
  def doMove = Action("Do Move") {
    model.doMove
  }
  
  def doTurn = Action("Do Turn") {
    model.doTurn
  }
  
  def doGame = Action("Do Game") {
    model.doGame
  }
  
  def showStrategies = Action("Show Strategies"){
    model.showStrategies
  }
  
  def setStrategy(player: Player, strategy: Strategy) = Action("Property First"){
    model.setStrategy(player, strategy)
  }

  def exit = Action("Exit") {
    sys.exit(0)
  }
}