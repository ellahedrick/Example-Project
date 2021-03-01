package menu_commands
import scala.util.Random

//******* PLAYER_ORDER *******
object Deck extends scala.collection.mutable.Queue[Card] {
  
  val discard: List[Card] = List()
  /*
  for(i <- 1 to 1) this += new Card("-Money-",'m',10)
  for(i <- 1 to 2) this += new Card("-Money-",'m',5)
  for(i <- 1 to 3) this += new Card("-Money-",'m',4)
  for(i <- 1 to 3) this += new Card("-Money-",'m',3)
  for(i <- 1 to 5) this += new Card("-Money-",'m',2)
  for(i <- 1 to 6) this += new Card("-Money-",'m',1)
  for(i <- 1 to 3) this += new Card("Rent: ~~ANY~~", 'a',3)
  for(i <- 1 to 2) this += new Card("Rent: Grn/Blu", 'a',1)
  for(i <- 1 to 2) this += new Card("Rent: Brn/Cyn", 'a',1)
  for(i <- 1 to 2) this += new Card("Rent: Pnk/Org", 'a',1)
  for(i <- 1 to 2) this += new Card("Rent: Red/Ylw", 'a',1)
  for(i <- 1 to 2) this += new Card("Rent: RRd/Utl", 'a',1)
  for(i <- 1 to 2) this += new Card("Rent: RRd/Utl", 'a',1)
  for(i <- 1 to 2) this += new Card("Deal Breaker", 'a',5)
  for(i <- 1 to 2) this += new Card("Debt Cllctor", 'a',3)
  for(i <- 1 to 2) this += new Card("Double Rent ", 'a',1)
  for(i <- 1 to 4) this += new Card("Forced Deal ", 'a',3)
  for(i <- 1 to 3) this += new Card("   Hotel    ", 'a',4)
  for(i <- 1 to 3) this += new Card("   House    ", 'a',3)
  for(i <- 1 to 3) this += new Card("My Birthday ", 'a',2)
  for(i <- 1 to 10) this += new Card("  Pass Go   ", 'a',1)
  for(i <- 1 to 3) this += new Card("  Sly Deal   ", 'a',3)
  for(i <- 1 to 2) this += new Card("Prop Wild: ~~ANY~~", 'p',0)
  for(i <- 1 to 1) this += new Card("Prop Wild: Blu/Grn", 'p',4)
  for(i <- 1 to 1) this += new Card("Prop Wild: Cyn/Brn", 'p',1)
  for(i <- 1 to 1) this += new Card("Prop Wild: Grn/RRd", 'p',4)
  for(i <- 1 to 1) this += new Card("Prop Wild: Cyn/RRd", 'p',4)
  for(i <- 1 to 1) this += new Card("Prop Wild: Utl/RRd", 'p',2)
  for(i <- 1 to 2) this += new Card("Prop Wild: Ylw/Red", 'p',3)
  for(i <- 1 to 2) this += new Card("Prop Wild: Org/Pnk", 'p',2)
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
  this += new Card("Grn Atlntc Ave", 'p',3)
	*/
  
  this += new Card("  Sly Deal   ",'a',3)
  this += new Card("-Money-",'m',4)
  this += new Card("-Money-",'m',2)
  this += new Card("Brn Medtrn Ave",'p',1)
  this += new Card("Cyn Orient Ave",'p',1)
  this += new Card("Ylw Marvin Gdn",'p',3)
  this += new Card("  Sly Deal   ",'a',3)
  this += new Card("Prop Wild: ~~ANY~~",'p',0)
  this += new Card("Utl WaterWorks",'p',2)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("Red Indian Ave",'p',3)
  this += new Card("Prop Wild: Cyn/RRd",'p',4)
  this += new Card("Debt Cllctor",'a',3)
  this += new Card("Org NwYork Ave",'p',2)
  this += new Card("-Money-",'m',5)
  this += new Card("Pnk St Chr Plc",'p',2)
  this += new Card("Ylw Ventnr Ave",'p',3)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("Prop Wild: Cyn/Brn",'p',1)
  this += new Card("Blu Boardwalk ",'p',4)
  this += new Card("Rent: ~~ANY~~",'a',3)
  this += new Card("-Money-",'m',1)
  this += new Card("Red Kentky Ave",'p',3)
  this += new Card("-Money-",'m',2)
  this += new Card("Grn Atlntc Ave",'p',3)
  this += new Card("Rent: RRd/Utl",'a',1)
  this += new Card("  Sly Deal   ",'a',3)
  this += new Card("Rent: Pnk/Org",'a',1)
  this += new Card("   House    ",'a',3)
  this += new Card("RRd Pnslyv RRd",'p',2)
  this += new Card("Double Rent ",'a',1)
  this += new Card("Forced Deal ",'a',3)
  this += new Card("Cyn Vermnt Ave",'p',1)
  this += new Card("   Hotel    ",'a',4)
  this += new Card("Rent: Pnk/Org",'a',1)
  this += new Card("-Money-",'m',1)
  this += new Card("RRd Readng RRd",'p',2)
  this += new Card("Rent: Grn/Blu",'a',1)
  this += new Card("Forced Deal ",'a',3)
  this += new Card("My Birthday ",'a',2)
  this += new Card("-Money-",'m',5)
  this += new Card("Rent: RRd/Utl",'a',1)
  this += new Card("Cyn Connec Ave",'p',1)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("Double Rent ",'a',1)
  this += new Card("   Hotel    ",'a',4)
  this += new Card("-Money-",'m',3)
  this += new Card("Grn Pacifc Ave",'p',4)
  this += new Card("Prop Wild: Ylw/Red",'p',3)
  this += new Card("   House    ",'a',3)
  this += new Card("Pnk States Ave",'p',2)
  this += new Card("Deal Breaker",'a',5)
  this += new Card("-Money-",'m',2)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("Org St Jms Plc",'p',2)
  this += new Card("Rent: Grn/Blu",'a',1)
  this += new Card("RRd Short Line",'p',2)
  this += new Card("   House    ",'a',3)
  this += new Card("-Money-",'m',1)
  this += new Card("Rent: Red/Ylw",'a',1)
  this += new Card("Prop Wild: Org/Pnk",'p',2)
  this += new Card("-Money-",'m',10)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("Pnk Virgin Ave",'p',2)
  this += new Card("-Money-",'m',2)
  this += new Card("Rent: RRd/Utl",'a',1)
  this += new Card("Org Tennes Ave",'p',2)
  this += new Card("RRd B & O RRd ",'p',2)
  this += new Card("Brn Baltic Ave",'p',1)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("-Money-",'m',4)
  this += new Card("Rent: Red/Ylw",'a',1)
  this += new Card("Grn N Car. Ave",'p',4)
  this += new Card("-Money-",'m',1)
  this += new Card("Prop Wild: Ylw/Red",'p',3)
  this += new Card("Deal Breaker",'a',5)
  this += new Card("Rent: Brn/Cyn",'a',1)
  this += new Card("-Money-",'m',2)
  this += new Card("Blu Park Place",'p',4)
  this += new Card("Prop Wild: ~~ANY~~",'p',0)
  this += new Card("Rent: ~~ANY~~",'a',3)
  this += new Card("Prop Wild: Grn/RRd",'p',4)
  this += new Card("Red Ilnois Ave",'p',3)
  this += new Card("-Money-",'m',4)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("Prop Wild: Org/Pnk",'p',2)
  this += new Card("Utl ElctrCmpny",'p',2)
  this += new Card("My Birthday ",'a',2)
  this += new Card("-Money-",'m',1)
  this += new Card("Rent: RRd/Utl",'a',1)
  this += new Card("Prop Wild: Blu/Grn",'p',4)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("-Money-",'m',3)
  this += new Card("My Birthday ",'a',2)
  this += new Card("  Pass Go   ",'a',1)
  this += new Card("Grn Pnslyv Ave",'p',4)
  this += new Card("Forced Deal ",'a',3)
  this += new Card("Debt Cllctor",'a',3)
  this += new Card("Forced Deal ",'a',3)
  this += new Card("Rent: ~~ANY~~",'a',3)
  this += new Card("Prop Wild: Utl/RRd",'p',2)
  this += new Card("   Hotel    ",'a',4)
  this += new Card("Rent: Brn/Cyn",'a',1)
  this += new Card("-Money-",'m',3)
  this += new Card("-Money-",'m',1)
  this += new Card("  Pass Go   ",'a',1)
  
 

  def deal : Card = {
    return this.dequeue
  }

  def shuffle = {
    //this = util.Random.shuffle(this)
    util.Random.shuffle(this)
  }
  
  def debug = {
    //var result = ""    
    for (card <- util.Random.shuffle(this).toArray) 
      println("this += new Card(\"" + card.name + "\",\'" + card.variant.toString + "\',"+card.value.toString+")")
    //this += new Card("-Money-",'m',10)
    //result.substring(0, result.length-2)
  }
}