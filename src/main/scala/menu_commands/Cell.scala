package menu_commands

//******* CELL *******
class Cell {
  var card : Option[Card] = None

  def show = {
    card match {
      case Some(card) => card.show
      case None => "[          ]"
    }    
  }
}