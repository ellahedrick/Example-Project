package menu_commands

/** A cell of the game board
*  
*  @constructor create a new cell
*/
class Cell {
  var card : Option[Card] = None

  /** Return the string representation of the cell
   */
  def show = {
    card match {
      case Some(card) => card.show
      case None => "[                        ]"
    }    
  }
}