public class Kernel {
  float[][]kernel;
  public Kernel(float[][]init) {
    kernel = new float[init.length][init[0].length];
     for (int r = 0; r < init.length; r++) {
        for (int c = 0; c < init.length; c++) {
           kernel[r][c] = init[r][c];
        }
     }
  }
  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
  }


  void apply(PImage source, PImage destination) {
  }

}
