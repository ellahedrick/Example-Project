package menu_commands
import scala.swing._
import BorderPanel.Position._
import java.awt.geom.Rectangle2D
import java.awt.geom.Ellipse2D
import java.awt.Color
import scala.collection.mutable.ArrayBuffer
import java.awt.image.BufferedImage
import scala.swing.Orientation





//******* VIEW ******* 
class View {

  var controller: Option[Controller] = None
  var model: Option[Model] = None

  //******* init *******  
  def init(ctr: Controller, mod: Model) {
    controller = Some(ctr)
    model = Some(mod)    
  }  
  
  
  //******* View components ******* 
  
  val buttons = new BoxPanel(Orientation.Horizontal) {
    contents += new Button(Action("Initialize Game") { 
      controller.get.initializeGame
    })
    contents += new Button(Action("Do Turn") { 
      controller.get.doTurn
    })
    contents += new Button(Action("Do Game") { 
      controller.get.doGame
    })
    contents += new Button(Action("Show Game") { 
      controller.get.showGame
    })
    contents += new Button(Action("Reset") { 
      controller.get.exit
    })  }
    
  var flippedCard = new CardPanel

  val hiddenDeck = new HiddenCardPanel
  
  val deckSpaces = new BoxPanel(Orientation.Horizontal) {
    contents += hiddenDeck
    contents += flippedCard   
    background = Color.black
    preferredSize = new Dimension(300,200)
  }
  
  val cardSpaces = new BorderPanel {    
    layout += new Label("Erik") -> West      
    layout += new Label("Emma") -> North
    layout += new Label("Rocco") -> East
    layout += new Label("Grace") -> South
    layout += deckSpaces -> Center    
  }
  
  val playerHands = new ArrayBuffer[PlayerHandPanel] {

    this += new PlayerHandPanel("Emma")
    this += new PlayerHandPanel("Rocco")
    this += new PlayerHandPanel("Grace")
    this += new PlayerHandPanel("Erik") 
    
  }

  val south = new BoxPanel(Orientation.Vertical) {
    preferredSize = new Dimension(800,300)
    contents += playerHands(2)
    contents += buttons
    opaque = false
  }  
  
  val gameArea = new BorderPanel {
    background = Color.darkGray
    layout += south -> South
    layout += playerHands(3) -> West      
    layout += playerHands(0) -> North
    layout += playerHands(1) -> East
    layout += cardSpaces -> Center  
  }

  //******* MainFrame *******   
  val frame = new MainFrame {
    title = "Card Game"
    contents = gameArea
    centerOnScreen
    //preferredSize = new Dimension(1600,1000)
    visible = true    
  }
  
  //******* update *******   
  def update {
    frame.repaint
    println("repainting")
    for(panel <- playerHands) panel.repaint
  }

  
  //******* CARDPANEL ******* 
    
  class CardPanel extends Panel {

    var image = javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
    
    def showAsEmpty {
      image = javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
      this.repaint
    }
    
    def changeCard(card : Card) {
      image = javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
      this.repaint 
    }
    
    override def paint(g: Graphics2D) {
      g.drawImage(image, 18, 48, null)
    }
  }

  //******* HIDDENCARDPANEL *******   
  class HiddenCardPanel extends Panel {

    var image = javax.imageio.ImageIO.read(new java.io.File("resources/back.jpg"))
     
    def showAsEmpty {
      image = javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
      this.repaint
    }
    
    def showAsHidden {
      image = javax.imageio.ImageIO.read(new java.io.File("resources/back.jpg"))
      this.repaint
    }
    
    override def paint(g: Graphics2D) {
      g.drawImage(image, 54, 48, null)
    }
  }     
  
  //******* PLAYERHANDPANEL ******* 
  class PlayerHandPanel(name: String) extends Panel {

    preferredSize = new Dimension(800, 300)

    var handImages = new ArrayBuffer[BufferedImage]
    var propertyImages = new ArrayBuffer[BufferedImage]
    var bankImages = new ArrayBuffer[BufferedImage]
    //images += javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))

    def getFile(cardName: String, cardMoney: Int): String = (cardName, cardMoney) match {
      case ("    -Money-   ", 1) => "1m"
      case ("    -Money-   ", 2) => "2m"
      case ("    -Money-   ", 3) => "3m"
      case ("    -Money-   ", 4) => "4m"
      case ("    -Money-   ", 5) => "5m"
      case ("    -Money-   ", 10) => "10m"
      case ("     Money    ", 1) => "s1m"
      case ("     Money    ", 2) => "s2m"
      case ("     Money    ", 3) => "s3m"
      case ("     Money    ", 4) => "s4m"
      case ("     Money    ", 5) => "s5m"
      case ("    Property  ", 3) => "sp3"
      case ("    Property  ", 5) => "sp5"
      case ("P Wld: ~~ANY~~", _) => "wildAny"
      case ("P Wld: Blu/Grn", _) => "wildBlueGreen"
      case ("P Wld: Cyn/Brn", _) => "wildCyanBrown"
      case ("P Wld: Grn/RRd", _) => "wildGreenRrd"
      case ("P Wld: Cyn/RRd", _) => "wildCyanRrd"
      case ("P Wld: Utl/RRd", _) => "wildUtilRrd"
      case ("P Wld: Ylw/Red", _) => "wildYellowRed"
      case ("P Wld: Org/Pnk", _) => "wildOrangePink"
      case ("Brn Baltic Ave", _) => "baltic"
      case ("Brn Medtrn Ave", _) => "mediterranean"
      case ("Blu Boardwalk ", _) => "boardwalk"
      case ("Blu Park Place", _) => "parkPlace"
      case ("Grn N Car. Ave", _) => "northCarolina"
      case ("Grn Pacifc Ave", _) => "pacific"
      case ("Grn Pnslyv Ave", _) => "pennsylvania"
      case ("Cyn Connec Ave", _) => "connecticut"
      case ("Cyn Orient Ave", _) => "oriental"
      case ("Cyn Vermnt Ave", _) => "vermont"
      case ("Org NwYork Ave", _) => "newYork"
      case ("Org St Jms Plc", _) => "stJames"
      case ("Org Tennes Ave", _) => "tennes"
      case ("Pnk St Chr Plc", _) => "stCharlesPlace"
      case ("Pnk Virgin Ave", _) => "virginia"
      case ("Pnk States Ave", _) => "states"
      case ("RRd Short Line", _) => "shortLineRailroad"
      case ("RRd B & O RRd ", _) => "boRailroad"
      case ("RRd Readng RRd", _) => "readingRailroad"
      case ("RRd Pnsylv RRd", _) => "pennsylvaniaRailroad"
      case ("Red Kentky Ave", _) => "kentucky"
      case ("Red Indian Ave", _) => "indian"
      case ("Red Ilnois Ave", _) => "illinois"
      case ("Utl WaterWorks", _) => "waterworks"
      case ("Utl ElctrCmpny", _) => "electricCompany"
      case ("Ylw Ventnr Ave", _) => "ventnor"
      case ("Ylw Marvin Gdn", _) => "marvinGardens"
      case ("Ylw Atlntc Ave", _) => "atlantic"
  }  

    
    override def paint(g: Graphics2D) {
      if(PlayerOrder(0).name == name){
        //println(PlayerOrder(0).hand.length)
        for(card <- PlayerOrder(0).hand){
          handImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
        }
      }
      if(PlayerOrder(1).name == name){
        println("here1")
        for(card <- PlayerOrder(1).hand){
          println("names")
          handImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
        }
      }
      if(PlayerOrder(2).name == name){
        for(card <- PlayerOrder(2).hand){
          handImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
        }
      }
      if(PlayerOrder(3).name == name){
        for(card <- PlayerOrder(3).hand){
          
          handImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
        }
      }
      //println("repainting panel")
      var offset = 100
      //println(handImages.length)
      for (image <- handImages) {
        //println(images.length)
        if (name == "Rocco" || name == "Erik") g.drawImage(image, 0, offset, null)
        else g.drawImage(image, offset+500, 0, null)
        offset += 90
      }
      handImages.clear
      propertyImages.clear
      bankImages.clear
    }    
  } 
  
}

