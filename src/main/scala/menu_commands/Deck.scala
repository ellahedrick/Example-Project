package menu_commands
import scala.util.Random

/** creates the deck object (extended from a mutable Queue of type Card)
   */
object Deck extends scala.collection.mutable.Queue[Card] {
  
  /** the seed to use for randomness */
  val seed = 16
  scala.util.Random.setSeed(seed)
  
  /** the discard pile */
  var discard = new scala.collection.mutable.Queue[Card]
  
  /** a default deck to use when randomness is unwanted */
  var fixedDeck = new scala.collection.mutable.Queue[Card]
  
  
  
  /** adds cards to a deck
	*/
  def createDeck : Unit = {
    this.clear
    if(!Menu.useRandom && !fixedDeck.isEmpty){
      for (card <- fixedDeck) this += card
      return
    }
    for(i <- 1 to 1) this += new Card("    -Money-   ",'m',10)
    for(i <- 1 to 2) this += new Card("    -Money-   ",'m',5)
    for(i <- 1 to 3) this += new Card("    -Money-   ",'m',4)
    for(i <- 1 to 3) this += new Card("    -Money-   ",'m',3)
    for(i <- 1 to 5) this += new Card("    -Money-   ",'m',2)
    for(i <- 1 to 6) this += new Card("    -Money-   ",'m',1)
    
    for(i <- 1 to 3) this += new Card("     Money    ",'a',1)
    for(i <- 1 to 4) this += new Card("     Money    ",'a',2)
    for(i <- 1 to 5) this += new Card("     Money    ",'a',3)
    for(i <- 1 to 3) this += new Card("     Money    ",'a',4)
    for(i <- 1 to 2) this += new Card("     Money    ",'a',5) 
    for(i <- 1 to 5) this += new Card("    Property  ",'a',3)
    for(i <- 1 to 3) this += new Card("    Property  ",'a',5)
    
    for(i <- 1 to 2) this += new Card("P Wld: ~~ANY~~", 'p',0)
    for(i <- 1 to 1) this += new Card("P Wld: Blu/Grn", 'p',4)
    for(i <- 1 to 1) this += new Card("P Wld: Cyn/Brn", 'p',1)
    for(i <- 1 to 1) this += new Card("P Wld: Grn/RRd", 'p',4)
    for(i <- 1 to 1) this += new Card("P Wld: Cyn/RRd", 'p',4)
    for(i <- 1 to 1) this += new Card("P Wld: Utl/RRd", 'p',2)
    for(i <- 1 to 2) this += new Card("P Wld: Ylw/Red", 'p',3)
    for(i <- 1 to 2) this += new Card("P Wld: Org/Pnk", 'p',2)
    this += new Card("Brn Baltic Ave", 'p',1)
    this += new Card("Brn Medtrn Ave", 'p',1)
    this += new Card("Blu Boardwalk ", 'p',4)
    this += new Card("Blu Park Place", 'p',4)
    this += new Card("Grn N Car. Ave", 'p',4)
    this += new Card("Grn Pacifc Ave", 'p',4)
    this += new Card("Grn Pnslyv Ave", 'p',4)
    this += new Card("Cyn Connec Ave", 'p',1)
    this += new Card("Cyn Orient Ave", 'p',1)
    this += new Card("Cyn Vermnt Ave", 'p',1)
    this += new Card("Org NwYork Ave", 'p',2)
    this += new Card("Org St Jms Plc", 'p',2)
    this += new Card("Org Tennes Ave", 'p',2)
    this += new Card("Pnk St Chr Plc", 'p',2)
    this += new Card("Pnk Virgin Ave", 'p',2)
    this += new Card("Pnk States Ave", 'p',2)
    this += new Card("RRd Short Line", 'p',2)
    this += new Card("RRd B & O RRd ", 'p',2)
    this += new Card("RRd Readng RRd", 'p',2)
    this += new Card("RRd Pnslyv RRd", 'p',2)
    this += new Card("Red Kentky Ave", 'p',3)
    this += new Card("Red Indian Ave", 'p',3)
    this += new Card("Red Ilnois Ave", 'p',3)
    this += new Card("Utl WaterWorks", 'p',2)
    this += new Card("Utl ElctrCmpny", 'p',2)
    this += new Card("Ylw Ventnr Ave", 'p',3)
    this += new Card("Ylw Marvin Gdn", 'p',3)
    this += new Card("Ylw Atlntc Ave", 'p',3)
    this.shuffle
    if(fixedDeck.isEmpty) for(card <- this) fixedDeck += card
  }
  
  
 
  /** return the next card in the deck
   */
  def deal : Card = {
    return this.dequeue
  }

  /** shuffle the deck
   */
  def shuffle {
      for (card <- discard) this += card
      var shuffled = new scala.collection.mutable.Queue[Card]
      shuffled = scala.util.Random.shuffle(this)
      this.clear
      discard.clear
      for (card <- shuffled) this += card
  }
  
  
}