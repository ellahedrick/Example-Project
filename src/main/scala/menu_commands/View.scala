package menu_commands

import scala.swing._
import java.awt.Font

/** A view in the MVC architecture
*/
class View extends MainFrame {

   var _controller : Option[Controller] = None

  // Components
  val textArea = new TextArea
  textArea.font = new Font("Monospaced", Font.PLAIN, 11)

  /**
   * initializes the view
   * @param controller
   */
  def init(controller: Controller) {
    _controller = Some(controller)
    title = "Monopoly Deal"
    contents = textArea
    centerOnScreen

    menuBar = new MenuBar {
      contents += new Menu("Commands") {
        contents += new MenuItem(controller.initializeGame)
        contents += new Separator
        contents += new MenuItem(controller.showGameArea)
        contents += new MenuItem(controller.showPlayerOrder)
        contents += new MenuItem(controller.checkForWinner)
        contents += new Separator
        contents += new MenuItem(controller.advancePlayerOrder)
        contents += new MenuItem(controller.doMove)
        contents += new MenuItem(controller.doTurn)
        contents += new MenuItem(controller.doGame)
        contents += new Separator
        contents += new MenuItem(controller.showStrategies)
        contents += new Menu("Set Strategies") {
          contents += new Menu("Emma") {
            contents += new MenuItem("Property-First")
            contents += new MenuItem("Property-Last")
            contents += new MenuItem("Offensive-Money")
            contents += new MenuItem("Offensive-Property")
            //contents += new RadioMenuItem(controller.setStrategy(PlayerOrder.find(_))
          }
          contents += new Menu("Rocco") {
            contents += new MenuItem("Property-First")
            contents += new MenuItem("Property-Last")
            contents += new MenuItem("Offensive-Money")
            contents += new MenuItem("Offensive-Property")
          }
          contents += new Menu("Grace") {
            contents += new MenuItem("Property-First")
            contents += new MenuItem("Property-Last")
            contents += new MenuItem("Offensive-Money")
            contents += new MenuItem("Offensive-Property")
          }
          contents += new Menu("Erik") {
            contents += new MenuItem("Property-First")
            contents += new MenuItem("Property-Last")
            contents += new MenuItem("Offensive-Money")
            contents += new MenuItem("Offensive-Property")
          }
        }
        contents += new Separator
        contents += new MenuItem(controller.exit) // end Exit menuItem
      } // end Menu 1
    } // end MenuBar

    size = new Dimension(500, 500)
    visible = true
  }

}