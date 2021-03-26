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
  var strategy: Strategy = new Agent_PropertyFirst(this)
  
  
  
  
  /** check whether the game was won after the turn
   */
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
      if(col == "P W") col = card.name.slice(card.name.length-7, card.name.length)
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

/** play the current turn
   */  
 def doMove : Unit = { 
   strategy.doMove
 }
 
 /** show the current strategy
   */
 def showStrategy : String = {
   strategy.show
 }
  
}