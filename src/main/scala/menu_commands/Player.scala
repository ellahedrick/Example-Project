 package menu_commands

/** A player in the game
*  
*  @constructor create a new player with a name
*  @param name the player's name
*/
class Player (val name : String) {
  val hand: List[Card] = List()
  val properties: List[Card] = List()
  val bank: List[Card] = List()
  
  /** begin turn (calls any of the other methods to determine best move)
   */
  def playTurn = {
    
  }
  
  /** respond to another player's action card
   * @param cards the cards to be given up in response to the action
   */
  def actionRespond(cards: List[Card]) = {
    
  }
  
  /** draw cards from the deck
   * @param n the number of cards to draw
   */
  def draw(n: Int) = {
    
  }
  
  /** place a card into the player's bank
   * @param card the card to be deposited
   */
  def bankDeposit(card: Card) = {
    
  }
  
  /** place a property onto the board
   * @param card the property to be placed
   */
  def propertyDeposit(card: Card) = {
    
  }
  
  /** use an action card
   * @param card the action card to be used
   */
  def playAction(card: Card) = {
    
  }
  
}