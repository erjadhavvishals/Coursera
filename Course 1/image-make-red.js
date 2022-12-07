// write your code here
var image = new SimpleImage("chapel.png");

var w = image.getWidth();
var h = image.getHeight();


for (i = 0; i < w; i++) {
    for (j = 0; j < h; j++) {
        currentPixel = image.getPixel(i, j);
        currentPixel.setRed(255);
    }
}
print(image);