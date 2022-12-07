// write your code here
var opImage = new SimpleImage(200, 200);

for (var pixel of opImage.values()) {
    if (pixel.getX() <= 100 && pixel.getY() <= 100) {
        pixel.setRed(255);
        pixel.setGreen(0);
        pixel.setBlue(0);
    } else if (pixel.getX() > 100 && pixel.getY() <= 100) {
        pixel.setRed(0);
        pixel.setGreen(255);
        pixel.setBlue(0);
    } else if (pixel.getX() <= 100 && pixel.getY() > 100) {
        pixel.setRed(255);
        pixel.setGreen(0);
        pixel.setBlue(255);
    } else {
        pixel.setRed(0);
        pixel.setGreen(0);
        pixel.setBlue(255);
    }
    
}
print(opImage);