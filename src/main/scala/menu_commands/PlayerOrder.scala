package menu_commands

/** creates the PlayerOrder object (extended from a mutable Queue of type Player)
   */
object PlayerOrder extends scala.collection.mutable.Queue[Player] {

  /** adds players to the queue
	*/
  def addPlayers : Unit = {
    this += new Player("Emma")
    this += new Player("Rocco")
    this += new Player("Grace")
    this += new Player("Erik")
  }
  
  addPlayers
  
  /** advance to the next player in the order
   */
  def advance{
    this += this.dequeue
  }

 /** return the current order of players
   */
  def show : String = {
    var result = ""    
    for (p <- this.toArray) 
      result += p.name + ", "
    result.substring(0, result.length-2)
  }

  /** return the current player
   */
  def current : Player = {
    return this.head
  }
}