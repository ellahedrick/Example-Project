package menu_commands

import scala.swing._

/** The object that holds the MVC architecture
*/
object Demo {
  
  /** the main method for the program
   *  @param args the arguments to be passed in (if any)
	*/
  def main(args: Array[String]): Unit = {
    
    /** the MVC model object */
    val model = new Model
    
    /** the MVC view object */
    val view  = new View 
    
    /** the MVC controller object */
    val controller = new Controller(view, model)
    
    view.init(controller, model)    
  }
  
}