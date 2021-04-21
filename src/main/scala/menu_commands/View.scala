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
  
  var bgEmma = new ButtonGroup()
  var bgRocco = new ButtonGroup()
  var bgGrace = new ButtonGroup()
  var bgErik = new ButtonGroup()

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
            val playerRef = PlayerOrder.find(p => {p.name == "Emma"}).get
            var s1 = new RadioMenuItem("Property-First")
            s1.action = Action("Property-First"){ 
              controller.setStrategy( playerRef, new Agent_PropertyFirst(playerRef) )
            }
            var s2 = new RadioMenuItem("Property-Last")
            s2.action = Action("Property-Last"){ 
              controller.setStrategy( playerRef, new Agent_PropertyLast(playerRef) )
            }
            var s3 = new RadioMenuItem("Offensive-Money")
            s3.action = Action("Offensive-Money"){ 
              controller.setStrategy( playerRef, new Agent_OffensiveMoney(playerRef) )
            }
            var s4 = new RadioMenuItem("Offensive-Property")
            s4.action = Action("Offensive-Property"){ 
              controller.setStrategy( playerRef, new Agent_OffensiveProperty(playerRef) )
            }
            bgEmma.buttons += s1
            bgEmma.buttons += s2
            bgEmma.buttons += s3
            bgEmma.buttons += s4
            bgEmma.select(s1)
            contents ++= bgEmma.buttons
          }
          contents += new Menu("Rocco") {
            val playerRef = PlayerOrder.find(p => {p.name == "Rocco"}).get
            var s1 = new RadioMenuItem("Property-First")
            s1.action = Action("Property-First"){ 
              controller.setStrategy( playerRef, new Agent_PropertyFirst(playerRef) )
            }
            var s2 = new RadioMenuItem("Property-Last")
            s2.action = Action("Property-Last"){ 
              controller.setStrategy( playerRef, new Agent_PropertyLast(playerRef) )
            }
            var s3 = new RadioMenuItem("Offensive-Money")
            s3.action = Action("Offensive-Money"){ 
              controller.setStrategy( playerRef, new Agent_OffensiveMoney(playerRef) )
            }
            var s4 = new RadioMenuItem("Offensive-Property")
            s4.action = Action("Offensive-Property"){ 
              controller.setStrategy( playerRef, new Agent_OffensiveProperty(playerRef) )
            }
            bgRocco.buttons += s1
            bgRocco.buttons += s2
            bgRocco.buttons += s3
            bgRocco.buttons += s4
            bgRocco.select(s1)
            contents ++= bgRocco.buttons
          }
          contents += new Menu("Grace") {
            val playerRef = PlayerOrder.find(p => {p.name == "Grace"}).get
            var s1 = new RadioMenuItem("Property-First")
            s1.action = Action("Property-First"){ 
              controller.setStrategy( playerRef, new Agent_PropertyFirst(playerRef) )
            }
            var s2 = new RadioMenuItem("Property-Last")
            s2.action = Action("Property-Last"){ 
              controller.setStrategy( playerRef, new Agent_PropertyLast(playerRef) )
            }
            var s3 = new RadioMenuItem("Offensive-Money")
            s3.action = Action("Offensive-Money"){ 
              controller.setStrategy( playerRef, new Agent_OffensiveMoney(playerRef) )
            }
            var s4 = new RadioMenuItem("Offensive-Property")
            s4.action = Action("Offensive-Property"){ 
              controller.setStrategy( playerRef, new Agent_OffensiveProperty(playerRef) )
            }
            bgGrace.buttons += s1
            bgGrace.buttons += s2
            bgGrace.buttons += s3
            bgGrace.buttons += s4
            bgGrace.select(s1)
            contents ++= bgGrace.buttons
          }
          contents += new Menu("Erik") {
            val playerRef = PlayerOrder.find(p => {p.name == "Erik"}).get
            var s1 = new RadioMenuItem("Property-First")
            s1.action = Action("Property-First"){ 
              controller.setStrategy( playerRef, new Agent_PropertyFirst(playerRef) )
            }
            var s2 = new RadioMenuItem("Property-Last")
            s2.action = Action("Property-Last"){ 
              controller.setStrategy( playerRef, new Agent_PropertyLast(playerRef) )
            }
            var s3 = new RadioMenuItem("Offensive-Money")
            s3.action = Action("Offensive-Money"){ 
              controller.setStrategy( playerRef, new Agent_OffensiveMoney(playerRef) )
            }
            var s4 = new RadioMenuItem("Offensive-Property")
            s4.action = Action("Offensive-Property"){ 
              controller.setStrategy( playerRef, new Agent_OffensiveProperty(playerRef) )
            }
            bgErik.buttons += s1
            bgErik.buttons += s2
            bgErik.buttons += s3
            bgErik.buttons += s4
            bgErik.select(s1)
            contents ++= bgErik.buttons
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