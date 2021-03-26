package menu_commands

class Agent_OffensiveMoney(override val player: Player) extends Strategy(player) {
  
  /** show the name of the strategy
   */
  override def show: String = {
    "Offensive Money" 
  }
  
  /** play the current turn
   */
  override def doMove : Unit = { 
       
    player.hand = player.hand :+ Deck.deal
    player.hand = player.hand :+ Deck.deal
    
    var counter = 0
    
    for (card <- player.hand){
      if(counter < 3 && card.variant == 'a' && card.name == "     Money    "){ 
        if(!PlayerOrder.tail.head.bank.isEmpty){
          val stealCard = PlayerOrder.tail.head.bank.head
          PlayerOrder.tail.head.bank = PlayerOrder.tail.head.bank.filter(_ != stealCard)
          player.bank = player.bank :+ stealCard
        }
        else{
          player.bank = player.bank :+ card
        }
        player.hand = player.hand.filter(_ != card)
        counter +=1
      }
    }
    
    for (card <- player.hand){
      if(counter < 3 && card.variant == 'a' && card.name == "    Property  "){
        player.bank = player.bank :+ card
        player.hand = player.hand.filter(_ != card)
        counter +=1
      }
    }
    
    for (card <- player.hand){
      if(counter < 3 && card.variant == 'm'){
        player.bank = player.bank :+ card
        //println("BANK" + curPlay.bank)
        player.hand = player.hand.filter(_ != card)
        //println("Hand5" + curPlay.hand)
        counter +=1
      }
    }
    
    
    for (card <- player.hand){
      if(counter < 3 && card.variant == 'p'){
        player.properties = player.properties :+ card
        //println("PPPP" + curPlay.hand)

        player.hand = player.hand.filter(_ != card)
        //println("CCCCC" + curPlay.hand)
        counter +=1
      }
    }
    
    if(player.hand.length < 3){
      player.hand = player.hand :+ Deck.deal
      player.hand = player.hand :+ Deck.deal
      player.hand = player.hand :+ Deck.deal
    }
    //println("FINAL:" + curPlay.hand)
  }
  
}