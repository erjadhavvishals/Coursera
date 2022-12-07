// write your code here
var image = new SimpleImage("chapel.png");

var w = image.getWidth();
var h = image.getHeight();


for (i = 0; i < 50; i++) {
    for (j = 0; j < 50; j++) {
        currentPixel = image.getPixel(i, j);
        currentPixel.setRed(0);
        currentPixel.setGreen(255);
        currentPixel.setBlue(0);
    }
}
print(image);