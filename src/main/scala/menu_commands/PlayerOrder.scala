package menu_commands

//******* PLAYER_ORDER *******
object PlayerOrder extends scala.collection.mutable.Queue[Player] {

  this += new Player("Emma")
  this += new Player("Rocco")
  this += new Player("Grace")
  this += new Player("Erik")

  def advance {
    this += this.dequeue
  }

  def show : String = {
    var result = ""    
    for (p <- this.toArray) 
      result += p.name + ", "
    result.substring(0, result.length-2)
  }

  def current : Player = {
    return this.head
  }
}