package menu_commands

import PlayerOrder._

/** creates the menu object
   */
object Menu {
  var gameOver = false
  var winner = ""
  
  /** initializes the game by dealing cards to each player (will eventually shuffle the deck as well)
   */
  def initialize: Unit = {
    for(i <- 0 until 4){
      for(i <- 0 until 5){
        PlayerOrder.current.hand = PlayerOrder.current.hand :+ Deck.deal
      }
      PlayerOrder.advance
    }
  }
  
  /** displays the game area
   */
  def showGameArea : String = {
    Board.show
  }
  
  /** display the player order
   */
  def showPlayerOrder : String = {
    return PlayerOrder.show
  }
  
  /** advance the player order
   */
  def advancePlayerOrder : Unit = {
    PlayerOrder.advance
  }
  
  /** run through the current player's move
   */
  def doMove: Unit = {
    PlayerOrder.current.doMove
  }
  
  /** return whether someone has won the game
   */
  def hasWinner: Boolean = {
    PlayerOrder.current.checkIsWinner
  }
  
  /** run through one iteration of each player's move
   */
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
  
  /** run the entire game and return the name of the winner
   */
  def doGame: String = {
    while(gameOver == false) doTurn
    Menu.winner
  }

}