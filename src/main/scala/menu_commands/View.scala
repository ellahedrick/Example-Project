package menu_commands
import scala.swing._
import event._
import BorderPanel.Position._
import java.awt.geom.Rectangle2D
import java.awt.geom.Ellipse2D
import java.awt.Color
import scala.collection.mutable.ArrayBuffer
import java.awt.image.BufferedImage
import scala.swing.Orientation





//******* VIEW ******* 
/** A view that holds all of the structure/layout for the GUI
*
*/
class View {

  /** the controller that the view communicates with in the MVC architecture */
  var controller: Option[Controller] = None
  
  /** the model that the view communicates with in the MVC architecture */
  var model: Option[Model] = None
  
  /** a buttongroup to allow only 1 strategy to be set at a time */
  var bgEmma = new ButtonGroup()
  
  /** a buttongroup to allow only 1 strategy to be set at a time */
  var bgRocco = new ButtonGroup()
  
  /** a buttongroup to allow only 1 strategy to be set at a time */
  var bgGrace = new ButtonGroup()
  
  /** a buttongroup to allow only 1 strategy to be set at a time */
  var bgErik = new ButtonGroup()

  //******* init *******
  /** initializes the view 
   *  @param ctr the controller associated with the view
   *  @param mod the model associated with the view
   */
  def init(ctr: Controller, mod: Model) {
    controller = Some(ctr)
    model = Some(mod)    
  }  
  
  
  //******* View components ******* 
  /** buttons to be shown at the bottom of the screen */
  val buttons = new BoxPanel(Orientation.Horizontal) {
    contents += new Button(Action("Initialize Game") { 
      controller.get.initializeGame
      controller.get.showGame
    })
    contents += new Button(Action("Advance Player Order") { 
      controller.get.advancePlayerOrder
    })
    contents += new Button(Action("Do Turn") { 
      controller.get.doTurn
      controller.get.showGame
    })
    contents += new Button(Action("Do Game") { 
      controller.get.doGame
      controller.get.showGame
    })
    contents += new Button(Action("Exit") { 
      controller.get.exit
    })  }
    
  
  var flippedCard = new CardPanel

  val hiddenDeck = new HiddenCardPanel
  
  val winnerDeck = new WinnerPanel
 
  /** a container for the board and deck graphics */
  val deckSpaces = new BoxPanel(Orientation.Horizontal) {
    if(Menu.hasWinner) {
      contents += winnerDeck
    }
    else{
      contents += hiddenDeck
      contents += flippedCard 
    }
    background = Color.black
    preferredSize = new Dimension(300,200)
  }

  /** a labeled area for each player's cards */
  val cardSpaces = new BorderPanel {    
    layout += new Label("Erik") -> West      
    layout += new Label("Emma") -> North
    layout += new Label("Rocco") -> East
    layout += new Label("Grace") -> South
    layout += deckSpaces -> Center    
  }
  
  /** a container for each of the player's held cards */
  val playerHands = new ArrayBuffer[PlayerHandPanel] {

    this += new PlayerHandPanel("Emma")
    this += new PlayerHandPanel("Rocco")
    this += new PlayerHandPanel("Grace")
    this += new PlayerHandPanel("Erik") 
    
  }

  /** graphics for the bottom of the screen */
  val south = new BoxPanel(Orientation.Vertical) {
    preferredSize = new Dimension(800,300)
    contents += playerHands(2)
    contents += buttons
    opaque = false
  }  
  
  /** graphics for the center of the screen */
  val gameArea = new BorderPanel {
    background = Color.darkGray
    layout += south -> South
    layout += playerHands(3) -> West      
    layout += playerHands(0) -> North
    layout += playerHands(1) -> East
    layout += cardSpaces -> Center  
  }

  //******* MainFrame *******
  /** the MainFrame of the GUI */
  val frame = new MainFrame {
    title = "Card Game"
    menuBar = new MenuBar {
      contents += new Menu("Set Player Strategies") {
        contents += new Menu("Emma") {
          val playerRef = PlayerOrder.find(p => {p.name == "Emma"}).get
          var s1 = new RadioMenuItem("Property-First")
          s1.action = Action("Property-First"){ 
            Menu.setStrategy( playerRef, new Agent_PropertyFirst(playerRef) )
            update
          }
          var s2 = new RadioMenuItem("Property-Last")
          s2.action = Action("Property-Last"){ 
            Menu.setStrategy( playerRef, new Agent_PropertyLast(playerRef) )
            update
          }
          var s3 = new RadioMenuItem("Offensive-Money")
          s3.action = Action("Offensive-Money"){ 
            Menu.setStrategy( playerRef, new Agent_OffensiveMoney(playerRef) )
            update
          }
          var s4 = new RadioMenuItem("Offensive-Property")
          s4.action = Action("Offensive-Property"){ 
            Menu.setStrategy( playerRef, new Agent_OffensiveProperty(playerRef) )
            update
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
            Menu.setStrategy( playerRef, new Agent_PropertyFirst(playerRef) )
            update
          }
          var s2 = new RadioMenuItem("Property-Last")
          s2.action = Action("Property-Last"){ 
            Menu.setStrategy( playerRef, new Agent_PropertyLast(playerRef) )
            update
          }
          var s3 = new RadioMenuItem("Offensive-Money")
          s3.action = Action("Offensive-Money"){ 
            Menu.setStrategy( playerRef, new Agent_OffensiveMoney(playerRef) )
            update
          }
          var s4 = new RadioMenuItem("Offensive-Property")
          s4.action = Action("Offensive-Property"){ 
            Menu.setStrategy( playerRef, new Agent_OffensiveProperty(playerRef) )
            update
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
            Menu.setStrategy( playerRef, new Agent_PropertyFirst(playerRef) )
            update
          }
          var s2 = new RadioMenuItem("Property-Last")
          s2.action = Action("Property-Last"){ 
            Menu.setStrategy( playerRef, new Agent_PropertyLast(playerRef) )
            update
          }
          var s3 = new RadioMenuItem("Offensive-Money")
          s3.action = Action("Offensive-Money"){ 
            Menu.setStrategy( playerRef, new Agent_OffensiveMoney(playerRef) )
            update
          }
          var s4 = new RadioMenuItem("Offensive-Property")
          s4.action = Action("Offensive-Property"){ 
            Menu.setStrategy( playerRef, new Agent_OffensiveProperty(playerRef) )
            update
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
            Menu.setStrategy( playerRef, new Agent_PropertyFirst(playerRef) )
            update
          }
          var s2 = new RadioMenuItem("Property-Last")
          s2.action = Action("Property-Last"){ 
            Menu.setStrategy( playerRef, new Agent_PropertyLast(playerRef) )
            update
          }
          var s3 = new RadioMenuItem("Offensive-Money")
          s3.action = Action("Offensive-Money"){ 
            Menu.setStrategy( playerRef, new Agent_OffensiveMoney(playerRef) )
            update
          }
          var s4 = new RadioMenuItem("Offensive-Property")
          s4.action = Action("Offensive-Property"){ 
            Menu.setStrategy( playerRef, new Agent_OffensiveProperty(playerRef) )
            update
          }
          bgErik.buttons += s1
          bgErik.buttons += s2
          bgErik.buttons += s3
          bgErik.buttons += s4
          bgErik.select(s1)
          contents ++= bgErik.buttons
        }
      }
      val checkRandom = new CheckBox("Random Deck")
      contents += checkRandom
      listenTo(checkRandom)
      reactions += {
        case ButtonClicked(`checkRandom`) =>
          Menu.useRandom = checkRandom.selected
      }
    }
    contents = gameArea
    centerOnScreen
    //preferredSize = new Dimension(1600,1000)
    visible = true  
  }
  
  //******* update *******
  /** updates the view to replace old graphics with the proper content */
  def update {
    frame.repaint
    for(panel <- playerHands) panel.repaint
    flippedCard.repaint
  }

  
  //******* CARDPANEL ******* 
  /** A panel to be shown when a player wins the game */  
  class WinnerPanel extends Panel {
    var image = javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
    if(Menu.hasWinner){
      image = javax.imageio.ImageIO.read(new java.io.File("resources/" + Menu.winner + ".jpg"))
    }
    override def paint(g: Graphics2D) {
      g.drawImage(image, 54, 48, null)
    }
  }
  
  /** a panel for displaying card information */
  class CardPanel extends Panel {
    var image = javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
    
    def showAsEmpty {
      image = javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
      this.repaint
    }
    
    def changeCard(card : Card) {
      image = javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(Deck.discard.head.name, Deck.discard.head.value)+ ".jpg"))
          this.repaint 
    }
    
    override def paint(g: Graphics2D) {
      if(Deck.discard.length > 0) image = javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(Deck.discard.head.name, Deck.discard.head.value)+ ".jpg"))
      g.drawImage(image, 18, 48, null)
    }
  }

  //******* HIDDENCARDPANEL *******
  /** a panel for holding the hidden cards */
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
 
  /** gets the filename of a given card
   *  @param cardName the name of the card
   *  @param cardMoney the value of the card
   */
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
    case ("Grn Pnslyv Ave", _) => "pennsylvaniaAve"
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
    case ("RRd Pnslyv RRd", _) => "pennsylvaniaRailroad"
    case ("Red Kentky Ave", _) => "kentucky"
    case ("Red Indian Ave", _) => "indian"
    case ("Red Ilnois Ave", _) => "illinois"
    case ("Utl WaterWorks", _) => "waterworks"
    case ("Utl ElctrCmpny", _) => "electricCompany"
    case ("Ylw Ventnr Ave", _) => "ventnor"
    case ("Ylw Marvin Gdn", _) => "marvinGardens"
    case ("Ylw Atlntc Ave", _) => "atlantic"
  }  
  
  //******* PLAYERHANDPANEL ******* 
  /** a panel to hold the player's cards */
  class PlayerHandPanel(name: String) extends Panel {

    preferredSize = new Dimension(800, 300)

    var handImages = new ArrayBuffer[BufferedImage]
    var propertyImages = new ArrayBuffer[BufferedImage]
    var bankImages = new ArrayBuffer[BufferedImage]
    var image = javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
    
    //images += javax.imageio.ImageIO.read(new java.io.File("resources/empty.jpg"))
 
    override def paint(g: Graphics2D) {
      if(Menu.hasWinner){
        image = javax.imageio.ImageIO.read(new java.io.File("resources/"+Menu.winner+".jpg"))
        if (name == "Rocco" || name == "Erik") g.drawImage(image, 300, 70, null)
        else g.drawImage(image, 800, 70, null)
      }
      else{
        if(PlayerOrder(0).name == name){
          for(card <- PlayerOrder(0).hand){
            handImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
          for(card <- PlayerOrder(0).bank){
            bankImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
          for(card <- PlayerOrder(0).properties){
            propertyImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
        }
        if(PlayerOrder(1).name == name){
          for(card <- PlayerOrder(1).hand){
            handImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
          for(card <- PlayerOrder(1).bank){
            bankImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
          for(card <- PlayerOrder(1).properties){
            propertyImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
        }
        if(PlayerOrder(2).name == name){
          for(card <- PlayerOrder(2).hand){
            handImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
          for(card <- PlayerOrder(2).bank){
            bankImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
          for(card <- PlayerOrder(2).properties){
            propertyImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
        }
        if(PlayerOrder(3).name == name){
          for(card <- PlayerOrder(3).hand){
            handImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
          for(card <- PlayerOrder(3).bank){
            bankImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
          for(card <- PlayerOrder(3).properties){
            propertyImages += javax.imageio.ImageIO.read(new java.io.File("resources/" + getFile(card.name, card.value) + ".jpg"))
          }
        }
        var xOffset = 100
        var yOffset = 0
        for (image <- handImages) {
          if (name == "Rocco" || name == "Erik") g.drawImage(image, xOffset, 0, null)
          else g.drawImage(image, xOffset + 500, 0, null)
          xOffset += 90
        }
        xOffset = 100
        yOffset = 100
        for (image <- bankImages) {
          if (name == "Rocco" || name == "Erik") g.drawImage(image, xOffset, yOffset, null)
          else g.drawImage(image, xOffset+500, yOffset, null)
          xOffset += 90
        }
        xOffset = 100
        yOffset = 200
        for (image <- propertyImages) {
          if (name == "Rocco" || name == "Erik") g.drawImage(image, xOffset, yOffset, null)
          else g.drawImage(image, xOffset+500, yOffset, null)
          xOffset += 90
        }
        handImages.clear
        propertyImages.clear
        bankImages.clear
      }    
    }
  } 
  
}

