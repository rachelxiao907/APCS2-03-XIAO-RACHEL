public class Kernel {
  float[][]kernel;
  /*Constructor takes the kernel that will be applied to the image*/
  public Kernel(float[][]init) {
    kernel = new float[init.length][init[0].length];
     for (int r = 0; r < init.length; r++) {
        for (int c = 0; c < init[0].length; c++) {
           kernel[r][c] = init[r][c]; //make a copy
        }
     }
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    float red = 0;
    float green = 0;
    float blue = 0;
    if (x + 1 < img.width && x - 1 >= 0  && y + 1 < img.height && y - 1 >= 0) { //centered at pixel x,y
      int row = y-1;
      for (int r = 0; r < kernel.length; r++) {
        int col = x-1;
        for (int c = 0; c < kernel[0].length; c++) {
          color p = img.get(col,row); //color of the pixel
          //calculate the convolution of r/g/b separately
          red += kernel[r][c] * red(p);
          green += kernel[r][c] * green(p);
          blue += kernel[r][c] * blue(p);
          col++;
        }
        row++;
      }
    }
    return color(red, green, blue);
  }


  /*Assume the destination is the same dimensions as the source.
  */
  void apply(PImage source, PImage destination) {
    //loop over the source image's pixels
    for (int r = 0; r < source.height; r++) {
      for (int c = 0; c < source.width; c++){
        color col = calcNewColor(source, c, r); //calculate the color for that pixel
        destination.set(c, r, col); //set the destination's pixels to the results of the convolution
      }
    }
  }

}
