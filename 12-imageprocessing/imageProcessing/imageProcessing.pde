void setup(){
  size(1450,500);
  PImage car = loadImage("redcar.jpg");
  PImage output = car.copy();
  //colorful edge detection of the car
  Kernel k = new Kernel( new float[][]   { {-1, -1, -1},
                                           {-1,  8, -1},
                                           {-1, -1, -1} } );
  //blurry car
  float[][] arr = { {0.111, 0.111, 0.111}, 
                    {0.111, 0.111, 0.111}, 
                    {0.111, 0.111, 0.111} };
  k.apply(car,output);
  image(car,0,0);
  image(output,car.width,0);
}
