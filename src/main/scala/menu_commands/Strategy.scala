package menu_commands

/** An Agent blueprint for creating AI agents, cannot be used as-is
*  
*  @constructor player the player associated with this strategy
*/
class Strategy(val player: Player) {
    
  /** play the current turn
   */
  def doMove: Unit = {
    println("No Strategy Set... How did we get here?")
  }
  
  /** show the name of the strategy
   */
  def show: String = {
    "Undefined Strategy" 
  }
  
}