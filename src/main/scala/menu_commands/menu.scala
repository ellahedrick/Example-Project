package menu_commands

import PlayerOrder._

object Menu {
  
  def initialize() = ???
  
  def showGameArea : String = {
    Board.show
  }
  
  def showPlayerOrder : String = {
    return PlayerOrder.show
  }
  
  def advancePlayerOrder : Unit = {
    PlayerOrder.advance
  }
}