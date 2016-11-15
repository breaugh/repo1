import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Circle_Set_Controller  extends JFrame  implements MouseListener {
	private static final long serialVersionUID = 1L;
	// may need other variables storing placement of buttons and cards in % of window size
    final public int NUMBER_OF_CARDS = 9;
    Circle_Set_Card[] testCard;
   int cardXPosition[] = new int[NUMBER_OF_CARDS];
   int cardYPosition[] = new int[NUMBER_OF_CARDS];
   int cardMargin = 20;  //arbitrary guess
   int titleBarOffset = 20;  //arbitrary guess
   int cardWidth;
   int cardHeight;

   public Circle_Set_Controller(){
   		setSize(800,800);
        setBackground(Color.green);
        cardWidth = (getSize().width-4*cardMargin)/3; // for 3 cards, 4 margins between
        cardHeight = (getSize().height-4*cardMargin-titleBarOffset)/3; // for 3 cards, 4 margins between
        // put any setup code here, such as:
        cardXPosition[0] = cardXPosition[3] = cardXPosition[6] = 0+cardMargin;  // first column
        cardXPosition[1] = cardXPosition[4] = cardXPosition[7] = cardWidth + 2*cardMargin; //2nd column
        cardXPosition[2] = cardXPosition[5] = cardXPosition[8] = cardWidth * 2 + 3*cardMargin; // 3rd column
        cardYPosition[0] = cardYPosition[1] = cardYPosition[2] = 0 +cardMargin +titleBarOffset;  //1st row
        cardYPosition[3] = cardYPosition[4] = cardYPosition[5] = cardHeight + 2*cardMargin +titleBarOffset; // 2nd row
        cardYPosition[6] = cardYPosition[7] = cardYPosition[8] = cardHeight * 2 + 3*cardMargin +titleBarOffset; //3rd row

        testCard = new Circle_Set_Card [NUMBER_OF_CARDS];

        testCard[0] = new Circle_Set_Card (Color.green, Circle_Set_Card.RECTANGLE, Circle_Set_Card.SOLID, 1); //color,shape,fill,# of shapes
        testCard[1] = new Circle_Set_Card (Color.green, Circle_Set_Card.RECTANGLE, Circle_Set_Card.HALF_FULL, 2); //color,shape,fill,# of shapes
        testCard[2] = new Circle_Set_Card (Color.green, Circle_Set_Card.RECTANGLE, Circle_Set_Card.DASHES, 3); //color,shape,fill,# of shapes
        testCard[3] = new Circle_Set_Card (Color.blue, Circle_Set_Card.STAR, Circle_Set_Card.EMPTY, 2); //color,shape,fill,# of shapes
        testCard[4] = new Circle_Set_Card (Color.blue, Circle_Set_Card.OVAL, Circle_Set_Card.HALF_FULL, 3); //color,shape,fill,# of shapes
        testCard[5] = new Circle_Set_Card (Color.blue, Circle_Set_Card.OVAL, Circle_Set_Card.STRIPES, 1); //color,shape,fill,# of shapes
        testCard[6] = new Circle_Set_Card (Color.red, Circle_Set_Card.STAR, Circle_Set_Card.SOLID, 3); //color,shape,fill,# of shapes
        testCard[7] = new Circle_Set_Card (Color.red, Circle_Set_Card.STAR, Circle_Set_Card.HALF_FULL, 2); //color,shape,fill,# of shapes
        testCard[8] = new Circle_Set_Card (Color.red, Circle_Set_Card.STAR, Circle_Set_Card.STRIPES, 1); //color,shape,fill,# of shapes
        addMouseListener(this);
        setVisible(true);
        repaint();

        int delay = 1000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                repaint(); // repaint function eventually calls paint(Graphics g) below
           }
        };
   new Timer(delay, taskPerformer).start();

      }


 


      public void paint(Graphics g) { // called every time need to repaint JFrame
    	  //should put in code to check size of window, and change positions
        for (int i=0; i < NUMBER_OF_CARDS; i++){ // use TicTacToeSquares 0 to 8   top row: 0, 1, 2
                testCard[i].draw(g, cardXPosition[i], cardYPosition[i], cardWidth, cardHeight);
        }
        g.drawString("Try to avoid clicking",getSize().width/2-40,getSize().height/2+20); // arbitrary placement

      }

      public void mousePressed(MouseEvent evt) {
        // in this case, I move card 4 no matter where clicked in the JFrame
          int c = 4;

          java.util.Random r = new java.util.Random();
          int randomX = (int) (r.nextFloat()*40); // arbitrary movement
          int randomY = (int) (r.nextFloat()*30) ;  // arbitrary movement
          cardXPosition[c] = (cardXPosition[c] + randomX) % (getSize().width-cardWidth);
          cardYPosition[c] = (cardYPosition[c] + randomY) % (getSize().height-cardHeight);
          repaint();  // eventually calls the paint function which calls paintComponent( ) above
      }


      // Empty methods, required by the MouseEvent and MouseListener interfaces.
      // you can code these if desired
      public void mouseClicked(MouseEvent evt) {  }
      public void mouseReleased(MouseEvent evt) {  }
      public void mouseEntered(MouseEvent evt) { }
      public void mouseExited(MouseEvent evt) { }
      
         public static void main(String [] args){
        	 Circle_Set_Controller myGame = new Circle_Set_Controller();
         }

}  // end class DrawCards2
}
