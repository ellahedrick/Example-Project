package menu_commands

class Strategy(val player: Player) {
  
  //insert universal def's here
  
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