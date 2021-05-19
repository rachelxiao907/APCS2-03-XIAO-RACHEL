public class Kernel {
  float[][]kernel;
  /*Constructor takes the kernel that will be applied to the image*/
  public Kernel(float[][]init) {
    kernel = new float[init.length][init[0].length];
     for (int r = 0; r < init.length; r++) {
        for (int c = 0; c < init[0].length; c++) {
           kernel[r][c] = init[r][c];
        }
     }
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    int con = 0;
    return color(con);
  }


  /*Assume the destination is the same dimensions as the source.
  */
  void apply(PImage source, PImage destination) {
    for (int r = 0; r < source.height; r++) {
      for (int c = 0; c < source.width; c++){
        color col = calcNewColor(source, c, r);
        destination.set(c, r, col);
      }
    }
  }

}
