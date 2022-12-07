// write your code here
var image = new SimpleImage("hilton.jpg");

var w = image.getWidth();
var h = image.getHeight();
print(w / 3);

for (pixel of image.values()) {
    if (pixel.getX() < (w / 3)) {
        pixel.setRed(255);
    }
    
    if (pixel.getX() > (w / 3) && pixel.getX() < (2 * (w / 3))) {
        pixel.setGreen(255);
    }
    
    if (pixel.getX() > (2 * (w / 3))) {
        pixel.setBlue(255);
    }
    
}
print(image);