package menu_commands

object Board {

  // create the 21 x 21 collection of cells
  val rows = 21
  val cols = 21  
  val cells = Array.ofDim[Cell](rows, cols)  
  for {  i <- 0 until rows
         j <- 0 until cols
  } cells(i)(j) = new Cell

  def show : String = {
    var result = "Board: (Will look much better once GUI is implemented)\n"
    for ( i <- 0 until rows ) {
      for ( j <- 0 until cols )
        result += cells(i)(j).show
      result += "\n"
    }
    result
  }

}