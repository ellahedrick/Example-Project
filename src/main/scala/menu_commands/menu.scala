package menu_commands

import PlayerOrder._

object Menu {
  var gameOver = false
  var winner = ""
  
  def initialize: Unit = {
    for(i <- 0 until 4){
      for(i <- 0 until 5){
        PlayerOrder.current.hand = PlayerOrder.current.hand :+ Deck.deal
      }
      PlayerOrder.advance
    }
  }
  
  def showGameArea : String = {
    Board.show
  }
  
  def showPlayerOrder : String = {
    return PlayerOrder.show
  }
  
  def advancePlayerOrder : Unit = {
    PlayerOrder.advance
  }
  
  def doMove: Unit = {
    PlayerOrder.current.doMove
  }
  
  def hasWinner: Boolean = {
    PlayerOrder.current.checkIsWinner
  }
  
  def doTurn: Unit = {
     for(i <- 0 until 4){
       if(gameOver == false){
         PlayerOrder.current.doMove
         gameOver = PlayerOrder.current.checkIsWinner
         if(gameOver) winner = PlayerOrder.current.name
         PlayerOrder.advance
       }
     }
  }
  
  def doGame: String = {
    while(gameOver == false){
      doTurn
    }
    PlayerOrder.current.name
  }

}