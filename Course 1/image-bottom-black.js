// write your code here
var image = new SimpleImage("astrachan.jpg");

var w = image.getWidth();
var h = image.getHeight();


for (i = 0; i < w; i++) {
    for (j = h - 10; j < h; j++) {
        currentPixel = image.getPixel(i, j);
        currentPixel.setRed(0);
        currentPixel.setGreen(0);
        currentPixel.setBlue(0);
    }
}
print(image);