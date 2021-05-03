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
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    noStroke();
    fill(c);
    if (colliding == true) {
      fill(255,0,0,100); //when a cow is colliding, change the display method so the cow body is RED and mostly transparent
    }
    ellipse(x, y, radius*2, radius*2);
    if (selected == true) {
      fill(255); //eyes
      ellipse(x-radius/3, y-radius/4, radius/2, radius/2);
      ellipse(x+radius/3, y-radius/4, radius/2, radius/2);
      fill(0); //pupils
      ellipse(x-radius/3, y-radius/4, radius/4, radius/4);
      ellipse(x+radius/3, y-radius/4, radius/4, radius/4);
      stroke(0); //mouth
      fill(#E3459C);
      arc(x, y+radius/4, radius/2, radius/2, 0, 3.14);
    }
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, 
   //change the cow...
   if (dist(mouseX, mouseY, x, y) <= radius) {
     selected = !selected; //when a Cow is clicked on in the click method, you toggle the selected state
     radius = 20+(int)(Math.random()*30);
     c = color(random(255),random(255),random(255));
   }
  }
  
  void collide(ArrayList<Cow>others) {
    boolean hold = false;
    for (Cow cw : others) {
      if (cw != this && dist(cw.x, cw.y, x, y) <= (cw.radius + radius)) {
        hold = true; //when this cow is touching any other cow, it will set the colliding variable to true, otherwise it will set it to false
      }
    }
    colliding = hold;
  }
 
}
