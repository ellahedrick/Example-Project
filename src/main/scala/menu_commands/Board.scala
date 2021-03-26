package menu_commands

/** Creates the board object
   */
object Board {

  // create the 21 x 21 collection of cells
  val rows = 21
  val cols = 21  
  val cells = Array.ofDim[Cell](rows, cols)
  for {  i <- 0 until rows
         j <- 0 until cols
  } cells(i)(j) = new Cell

  
  /** shows the game board
   */
  def show : String = {
    
    for {  i <- 0 until rows
         j <- 0 until cols
    } cells(i)(j) = new Cell
    
    for(i <- 0 until 4){ //For Each Player
      //North Player
      if(PlayerOrder.current.name == "Emma"){
        for(j <- 0 until PlayerOrder.current.hand.length)
          cells(0)(j+7).card = Some(PlayerOrder.current.hand(j))
        for(j <- 0 until PlayerOrder.current.properties.length)
          cells(1)(j+3).card = Some(PlayerOrder.current.properties(j))
        var one: Int = 0
        var two: Int = 0
        var three: Int = 0
        var four: Int = 0
        var five: Int = 0
        var ten: Int = 0
        for(j <- 0 until PlayerOrder.current.bank.length){
          if(PlayerOrder.current.bank(j).value == 1) one +=1
          if(PlayerOrder.current.bank(j).value == 2) two +=1
          if(PlayerOrder.current.bank(j).value == 3) three +=1
          if(PlayerOrder.current.bank(j).value == 4) four +=1
          if(PlayerOrder.current.bank(j).value == 5) five +=1
          if(PlayerOrder.current.bank(j).value == 10) ten +=1
          cells(2)(4).card = Some(new Card(((if(one > 9) "" else " ")+"           "+one.toString+"x"),' ',1))
          cells(2)(5).card = Some(new Card(((if(two > 9) "" else " ")+"           "+two.toString+"x"),' ',2))
          cells(2)(6).card = Some(new Card(((if(three > 9) "" else " ")+"           "+three.toString+"x"),' ',3))
          cells(2)(7).card = Some(new Card(((if(four > 9) "" else " ")+"           "+four.toString+"x"),' ',4))
          cells(2)(8).card = Some(new Card(((if(five > 9) "" else " ")+"           "+five.toString+"x"),' ',5))
          cells(2)(9).card = Some(new Card(((if(ten > 9) "" else " ")+"           "+ten.toString+"x"),' ',10))
        }

      }
      //East Player
      if(PlayerOrder.current.name == "Rocco"){
        for(j <- 0 until PlayerOrder.current.hand.length)
          cells(j+7)(20).card = Some(PlayerOrder.current.hand(j))
        for(j <- 0 until PlayerOrder.current.properties.length)
          cells(j+3)(19).card = Some(PlayerOrder.current.properties(j))
        var one: Int = 0
        var two: Int = 0
        var three: Int = 0
        var four: Int = 0
        var five: Int = 0
        var ten: Int = 0
        for(j <- 0 until PlayerOrder.current.bank.length){
          if(PlayerOrder.current.bank(j).value == 1) one +=1
          if(PlayerOrder.current.bank(j).value == 2) two +=1
          if(PlayerOrder.current.bank(j).value == 3) three +=1
          if(PlayerOrder.current.bank(j).value == 4) four +=1
          if(PlayerOrder.current.bank(j).value == 5) five +=1
          if(PlayerOrder.current.bank(j).value == 10) ten +=1
          cells(4)(18).card = Some(new Card(((if(one > 9) "" else " ")+"           "+one.toString+"x"),' ',1))
          cells(5)(18).card = Some(new Card(((if(two > 9) "" else " ")+"           "+two.toString+"x"),' ',2))
          cells(6)(18).card = Some(new Card(((if(three > 9) "" else " ")+"           "+three.toString+"x"),' ',3))
          cells(7)(18).card = Some(new Card(((if(four > 9) "" else " ")+"           "+four.toString+"x"),' ',4))
          cells(8)(18).card = Some(new Card(((if(five > 9) "" else " ")+"           "+five.toString+"x"),' ',5))
          cells(9)(18).card = Some(new Card(((if(ten > 9) "" else " ")+"           "+ten.toString+"x"),' ',10))
        }

      }
      //South Player
      if(PlayerOrder.current.name == "Grace"){
        for(j <- 0 until PlayerOrder.current.hand.length)
          cells(20)(14-j).card = Some(PlayerOrder.current.hand(j))
        for(j <- 0 until PlayerOrder.current.properties.length)
          cells(19)(18-j).card = Some(PlayerOrder.current.properties(j))
        var one: Int = 0
        var two: Int = 0
        var three: Int = 0
        var four: Int = 0
        var five: Int = 0
        var ten: Int = 0
        for(j <- 0 until PlayerOrder.current.bank.length){
          if(PlayerOrder.current.bank(j).value == 1) one +=1
          if(PlayerOrder.current.bank(j).value == 2) two +=1
          if(PlayerOrder.current.bank(j).value == 3) three +=1
          if(PlayerOrder.current.bank(j).value == 4) four +=1
          if(PlayerOrder.current.bank(j).value == 5) five +=1
          if(PlayerOrder.current.bank(j).value == 10) ten +=1
          cells(18)(11).card = Some(new Card(((if(one > 9) "" else " ")+"           "+one.toString+"x"),' ',1))
          cells(18)(12).card = Some(new Card(((if(two > 9) "" else " ")+"           "+two.toString+"x"),' ',2))
          cells(18)(13).card = Some(new Card(((if(three > 9) "" else " ")+"           "+three.toString+"x"),' ',3))
          cells(18)(14).card = Some(new Card(((if(four > 9) "" else " ")+"           "+four.toString+"x"),' ',4))
          cells(18)(15).card = Some(new Card(((if(five > 9) "" else " ")+"           "+five.toString+"x"),' ',5))
          cells(18)(16).card = Some(new Card(((if(ten > 9) "" else " ")+"           "+ten.toString+"x"),' ',10))
        }

      }
      //West Player
      if(PlayerOrder.current.name == "Erik"){
        for(j <- 0 until PlayerOrder.current.hand.length)
          cells(j+7)(0).card = Some(PlayerOrder.current.hand(j))
        for(j <- 0 until PlayerOrder.current.properties.length)
          cells(j+3)(1).card = Some(PlayerOrder.current.properties(j))
        var one: Int = 0
        var two: Int = 0
        var three: Int = 0
        var four: Int = 0
        var five: Int = 0
        var ten: Int = 0
        for(j <- 0 until PlayerOrder.current.bank.length){
          if(PlayerOrder.current.bank(j).value == 1) one +=1
          if(PlayerOrder.current.bank(j).value == 2) two +=1
          if(PlayerOrder.current.bank(j).value == 3) three +=1
          if(PlayerOrder.current.bank(j).value == 4) four +=1
          if(PlayerOrder.current.bank(j).value == 5) five +=1
          if(PlayerOrder.current.bank(j).value == 10) ten +=1
          cells(17)(2).card = Some(new Card(((if(one > 9) "" else " ")+"           "+one.toString+"x"),' ',1))
          cells(16)(2).card = Some(new Card(((if(two > 9) "" else " ")+"           "+two.toString+"x"),' ',2))
          cells(15)(2).card = Some(new Card(((if(three > 9) "" else " ")+"           "+three.toString+"x"),' ',3))
          cells(14)(2).card = Some(new Card(((if(four > 9) "" else " ")+"           "+four.toString+"x"),' ',4))
          cells(13)(2).card = Some(new Card(((if(five > 9) "" else " ")+"           "+five.toString+"x"),' ',5))
          cells(12)(2).card = Some(new Card(((if(ten > 9) "" else " ")+"           "+ten.toString+"x"),' ',10))
        }

      }
      PlayerOrder.advance
    }
        
    var result = "Board: (Will look much better once GUI is implemented)\n"
    for ( i <- 0 until rows ) {
      for ( j <- 0 until cols )
        result += cells(i)(j).show
      result += "\n"
    }
    result
  }

}