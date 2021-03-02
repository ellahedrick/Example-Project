 package menu_commands

/** A player in the game
*  
*  @constructor create a new player with a name
*  @param name the player's name
*/
class Player (val name : String) {
  var hand: List[Card] = List()
  var properties: List[Card] = List()
  var bank: List[Card] = List()
  
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
  
  def checkIsWinner: Boolean = {
  
    var green = 0
    var brown = 0
    var red = 0
    var cyan = 0
    var yellow = 0
    var rail = 0
    var util = 0
    var pink = 0
    var orange = 0
    var blue = 0
    var any = 0
    var bg = 0
    var cb = 0
    var grr = 0
    var crr = 0
    var urr = 0
    var yrd = 0
    var op = 0
  
    for(card <- properties){
      var col = card.name.slice(0, 3)
      if(col == "Pro") col = card.name.slice(card.name.length-7, card.name.length)
      if(col == "Brn") brown +=1
      else if(col == "Grn") green += 1
      else if(col == "Cyn") cyan += 1
      else if(col == "Red") red += 1
      else if(col == "RRd") rail += 1
      else if(col == "Utl") util += 1
      else if(col == "Ylw") yellow += 1
      else if(col == "Pnk") pink += 1
      else if(col == "Org") orange += 1
      else if(col == "Blu") blue += 1
      else if(col == "Blu/Grn") {
        blue += 1
        green += 1
      }
      else if(col == "~~ANY~~") {
        blue += 1
        brown += 1
        cyan += 1
        yellow += 1
        util += 1
        rail += 1
        red += 1
        pink += 1
        orange += 1
        green += 1
      }
      else if(col == "Cyn/Brn"){
        cyan += 1
        brown += 1
      }
      else if(col == "Grn/RRd"){
        green += 1
        rail += 1
      }
      else if(col == "Cyn/RRd") {
        cyan += 1
        rail += 1
      }
      else if(col == "Utl/RRd"){
        util += 1
        rail += 1
      }
      else if(col == "Ylw/Red"){
        yellow += 1
        red += 1
      }
      else{
        orange += 1
        pink += 1
      }
    }
  
    var totalSets = 0
  
    if(green >= 3) totalSets +=1
    if(yellow >= 3) totalSets +=1
    if(red >= 3) totalSets +=1
    if(pink >= 3) totalSets +=1
    if(orange >= 3) totalSets +=1
    if(rail >= 4) totalSets +=1
    if(util >= 2) totalSets +=1
    if(brown >= 2) totalSets +=1
    if(cyan >= 3) totalSets +=1
    if(blue >= 2) totalSets +=1
  
    if(totalSets >= 3) true
    else false
  }

 def doMove : Unit = { 
    
    hand = hand :+ Deck.deal
    hand = hand :+ Deck.deal
    
    var counter = 0
    
    for (card <- hand){
      if(counter < 3 && card.variant == 'p'){
        properties = properties :+ card
        //println("PPPP" + curPlay.hand)

        hand = hand.filter(_ != card)
        //println("CCCCC" + curPlay.hand)
        counter +=1
      }
    }
    
    for (card <- hand){
      if(counter < 3 && card.variant == 'm'){
        bank = bank :+ card
        //println("BANK" + curPlay.bank)
        hand = hand.filter(_ != card)
        //println("Hand5" + curPlay.hand)
        counter +=1
      }
    }
    
    for (card <- hand){
      if(counter < 3 && card.variant == 'a'){
        bank = bank :+ card
        hand = hand.filter(_ != card)
        counter +=1
      }
    }
    
    if(hand.length < 3){
      hand = hand :+ Deck.deal
      hand = hand :+ Deck.deal
      hand = hand :+ Deck.deal
    }
    //println("FINAL:" + curPlay.hand)
  }
  
}