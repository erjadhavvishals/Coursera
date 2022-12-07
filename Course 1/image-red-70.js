var image = new SimpleImage("eastereggs.jpg");

var w = image.getWidth();
var h = image.getHeight();


for (i = 0; i < w; i++) {
    for (j = 0; j < h; j++) {
        currentPixel = image.getPixel(i, j);
        
        if (currentPixel.getRed() > 70) {
            currentPixel.setRed(70);
        }
    }
}
print(image);