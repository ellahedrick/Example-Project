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
    while(!Deck.isEmpty) Deck.dequeue
    Deck.createDeck
    
    while(!PlayerOrder.isEmpty) PlayerOrder.dequeue
    PlayerOrder.addPlayers
    
    for(i <- 0 until 4){
      PlayerOrder.current.hand = List()
      PlayerOrder.current.properties = List()
      PlayerOrder.current.bank = List()
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
  
  /** display the name of the winner
   */
  def showWinner: String = {
    if(hasWinner) winner
    else "No Winner"
  }
  
  /** run through one iteration of each player's move
   */
  def doTurn: Unit = {
     for(i <- 0 until 4){
       if(gameOver == false){
         PlayerOrder.current.doMove
         gameOver = PlayerOrder.current.checkIsWinner
         if(gameOver) winner = PlayerOrder.current.name
         else PlayerOrder.advance
       }
     }
  }
  
  /** run the entire game and return the name of the winner
   */
  def doGame: String = {
    while(gameOver == false) doTurn
    Menu.winner
  }
  
  /** set the strategy of a specified player
   *  @param player the player to assign the new strategy to
   *  @param strategy the strategy to be assigned
   */
  def setStrategy(player: Player, strategy: Strategy): Unit = {
    player.strategy = strategy
  }
  
  /** display the strategy of the current player
   */
  def curStrategy: String = {
    PlayerOrder.current.showStrategy
  }
  
  /** display the strategies of all players
   */
  def showStrategies: String = {
    var result = "Current Player Strategies:\n"
    for(i <- 0 until 4){
      result += PlayerOrder.current.name + ": " + PlayerOrder.current.showStrategy + "\n"
      PlayerOrder.advance
    }
    result
  }

}