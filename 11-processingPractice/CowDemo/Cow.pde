public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding;
  boolean selected;
  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));
    colliding = false;
    selected = false;
  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    if (selected && colliding) { //when a cow is both selected and colliding, make the cow move double its speed
      x += (2 * dx);
      y += (2 * dy);
    } else {
      x += dx;
      y += dy;
    }
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    noStroke();
    if (colliding) {
      fill(255,0,0,100); //when a cow is colliding, change the display method so the cow body is RED and mostly transparent
    } else {
      fill(c);
    }
    ellipse(x, y, radius*2, radius*2); //body
    if (selected) {
      fill(255); //eyes
      ellipse(x-radius/3, y-radius/4, radius/2, radius/2);
      ellipse(x+radius/3, y-radius/4, radius/2, radius/2);
      fill(0); //pupils
      ellipse(x-radius/3, y-radius/4, radius/4, radius/4);
      ellipse(x+radius/3, y-radius/4, radius/4, radius/4);
      stroke(0); //mouth
      fill(#E3459C);
      arc(x, y+radius/4, radius/2, radius/2, 0, 3.14);
      
      //display the DX and DY of the cow on the screen on the right side of the cow
      fill(0);
      textSize(12);
      text("dx: "+dx + "\ndy: "+dy, x+radius, y);
    }
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, 
   //change the cow...
   if (dist(mouseX, mouseY, x, y) <= radius) {
     selected = !selected; //when a Cow is clicked on in the click method, you toggle the selected state
   }
  }
  
  void collide(ArrayList<Cow>others) {
    colliding = false;
    for (Cow cw : others) {
      if (!cw.equals(this) && dist(cw.x, cw.y, x, y) <= (cw.radius + radius)) {
        colliding = true; //when this cow is touching any other cow, it will set the colliding variable to true, otherwise it will set it to false
      }
    }
  }
 
}
