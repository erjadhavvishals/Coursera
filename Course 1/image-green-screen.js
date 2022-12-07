// write your code here
var fgImage = new SimpleImage("drewRobert.png");
var bgImage = new SimpleImage("dinos.png");
var opImage = new SimpleImage(fgImage.getWidth(), fgImage.getHeight());

for (var pixel of fgImage.values()) {
    if (pixel.getGreen() > pixel.getRed() + pixel.getBlue()) {
        var x = pixel.getX();
        var y = pixel.getY();
        
        var bgPixel = bgImage.getPixel(x, y);
        opImage.setPixel(x, y, bgPixel);
    } else {
        opImage.setPixel(pixel.getX(), pixel.getY(), pixel);
    }
}
print(opImage);