package menu_commands

/** A card in the game
*  
*  @constructor create a new card with a name, variant, and value (in millions)
*  @param name the name on the card
*  @param variant the type of card (a -> action / p -> property / m -> money)
*/
class Card (val name: String, val variant : Char, val value : Int) {
  
  /** return the string representation of the card
   */
  def show = {
    var result : String = "["+ name + " (" + variant.toString + "): $" + value +
      (if(value==10) "m" else "m ") + "]"
    result
  }
}
