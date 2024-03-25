import processing.core.PApplet;

public class Sketch extends PApplet {

  public void settings() {
    size(400, 400); // Default Size of Screen
  }

  public void setup() {
    background(255, 255, 255); // White Background
    surface.setResizable(true); // Makes Window Resizeable
  }

  public void draw() {
    drawQuadrantOne(0, 0, width/2, height/2, 255, 10, 10); // Draws a 10 x 10 Grid
    drawQuadrantTwo(5, 5, width/2, 0, 20); // Draws a 5 x 5 grid of Balls
    drawQuadrantThree(); // Draws a Grey Scale Gradient
    drawQuadrantFour((int) (0.75 * width), (int) (0.75 * height), true, 9); // Draws an 8 petal flower

  }

  public void drawQuadrantOne(int intStartX, int intStartY, int intWidth, int intHeight, int intStroke, int intRows,
      int intColumns) {
    // Creates Rows of lines
    stroke(intStroke); // Colour
    for (int intGridLineOffset = 0; intGridLineOffset < intWidth; intGridLineOffset += intWidth/intRows) {
      stroke(0);
      line(intStartX + intGridLineOffset, intStartY, intStartX + intGridLineOffset, intHeight);
    }

    // Creates Columns of lines
    for (int intGridLineOffset = 0; intGridLineOffset < intHeight; intGridLineOffset += intHeight/intColumns) {
      stroke(0);
      line(intStartX, intStartY + intGridLineOffset, intWidth, intStartY + intGridLineOffset);

    }
  }

  public void drawQuadrantTwo(int intRowBalls, int intColumnBalls, int intStartX, int intStartY, int intSize) {
    // Creates a grid of balls, in a way the user wants
    fill(216, 12, 124);
    for (int intColumns = 0; intColumns < intColumnBalls; intColumns++) { // Columns
      for (int intRows = 0; intRows < intRowBalls; intRows++) { // Rows
        ellipse(((width/2 - intSize * 2)/intRowBalls) * intRows + (intStartX + intSize * 2),
            ((height/2 - intSize * 2)/intColumnBalls) * intColumns + (intStartY + intSize * 2), intSize, intSize);
      }
    }
  }

  public void drawQuadrantThree() {
    // Cheks if Quadrant 3 is smaller or bigger than Colours amount
    if (width/2.0 > 256) {
      // Draws a Gradient
      for (int intPixelColumn = 0; intPixelColumn <= (int) (width / 2.0); intPixelColumn++) {
        stroke((int) ((255.0/400.0) * intPixelColumn));
        line((int) intPixelColumn, height, (int) (intPixelColumn), height/2);
      }
    } else {
      // Draws a Gradient
      for (int intPixelColumn = 0; intPixelColumn <= 255; intPixelColumn++) {
        stroke(intPixelColumn);
        line((int) ((width/2.0)/255.0 * intPixelColumn), height, (int) ((width/2.0)/255.0 * intPixelColumn), (int) (height/2.0));
      }
    }
  }

  public void drawQuadrantFour(int intPositionX, int intPositionY, boolean blnHasStroke, int intPetals) {
    // Adds Stroke if user wants
    if (blnHasStroke) {
      stroke(0);
    } else {
      noStroke();
    }

    // Creates set amount of petals
    translate(intPositionX, intPositionY); // Translates this to desired quadrant
    for (int intDegrees = 0; intDegrees < 360; intDegrees += 360/intPetals) {
      pushMatrix(); // Saves current Matrix
      fill(255, 125, 0);
      rotate((float) Math.toRadians(intDegrees)); // Roates Petals
      ellipse(0, 25, 20, 75);
      popMatrix(); // Previous Matrix Loaded
    }

    // Creates inner circle
    noStroke();
    fill(24, 97, 8);
    int x = 0;
    int y = 0;
    int diameterX = 30; // width
    int diameterY = 30; // height
    ellipse(0,0,30,30);
   
  }
}
