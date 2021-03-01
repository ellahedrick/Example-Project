package menu_commands

//******* Card *******
class Card (val name: String, val variant : Char, val value : Int) {

  def show = {
    var result : String = "["+ name + " (" + variant.toString + "): $" + value +
      (if(value==10) "m" else "m ") + "]"
    result
  }
}