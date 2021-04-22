package menu_commands

/** An Agent that plays in the most basic manner by playing properties as soon as possible.
*  
*  @constructor player the player associated with this strategy
*/
class Agent_PropertyFirst(override val player: Player) extends Strategy(player) {
  
  /** show the name of the strategy
   */
  override def show: String = {
    "Property First" 
  }
  
  /** play the current turn
   */
  override def doMove : Unit = { 
       
    player.hand = player.hand :+ Deck.deal
    player.hand = player.hand :+ Deck.deal
    
    var counter = 0
    
    for (card <- player.hand){
      if(counter < 3 && card.variant == 'p'){
        player.properties = player.properties :+ card
        player.hand = player.hand.filter(_ != card)
        counter +=1
      }
    }
    
    for (card <- player.hand){
      if(counter < 3 && card.variant == 'm'){
        player.bank = player.bank :+ card
        player.hand = player.hand.filter(_ != card)
        counter +=1
      }
    }
    
    for (card <- player.hand){
      if(counter < 3 && card.variant == 'a'){
        player.bank = player.bank :+ card
        player.hand = player.hand.filter(_ != card)
        counter +=1
      }
    }
    
    if(player.hand.length < 3){
      player.hand = player.hand :+ Deck.deal
      player.hand = player.hand :+ Deck.deal
      player.hand = player.hand :+ Deck.deal
    }
  }
  
}