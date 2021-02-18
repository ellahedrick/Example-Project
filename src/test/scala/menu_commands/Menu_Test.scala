package menu_commands

import org.scalatest.FunSpec
import org.scalatest.Matchers


class Menu_Test extends FunSpec with Matchers {

   describe("Monopoly Deal Simulation") {
    describe("has a menu") {

      //******* SHOW GAME AREA *******
      it("can show the game area, including the players, player hands, money piles, and property collections") {

        val expectedResult =
    "Board: (Will look much better once GUI is implemented)\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"+
    "[          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ][          ]\n"

        Menu.showGameArea should be(expectedResult)
      }

      //******* SHOW PLAYER ORDER *******
      it("can show the player order") {
        val expectedResult = "Emma, Rocco, Grace, Erik"
        Menu.showPlayerOrder should be(expectedResult)
      }

      //******* ADVANCE ORDER *******
      it("can advance the player order") {
        val expectedResult_0_advances = "Emma, Rocco, Grace, Erik"
        val expectedResult_1_advances = "Rocco, Grace, Erik, Emma"
        val expectedResult_2_advances = "Grace, Erik, Emma, Rocco"
        val expectedResult_4_advances = "Emma, Rocco, Grace, Erik"

        Menu.showPlayerOrder should be(expectedResult_0_advances)

        Menu.advancePlayerOrder 
        Menu.showPlayerOrder should be(expectedResult_1_advances)

        Menu.advancePlayerOrder
        Menu.showPlayerOrder should be(expectedResult_2_advances)

        Menu.advancePlayerOrder   // 3 advances
        Menu.advancePlayerOrder
        Menu.showPlayerOrder should be(expectedResult_4_advances)
        Menu.showPlayerOrder should be(expectedResult_0_advances)
      }


    }
  }
}
