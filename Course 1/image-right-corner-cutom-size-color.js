// write your code here


function topRightCorner(cornerWidth, cornerHeight, someImage, red, green, blue) {
    var image = new SimpleImage(someImage);

    var w = image.getWidth();
    var h = image.getHeight();


    for (i = w - cornerWidth; i < w; i++) {
        for (j = 0; j < cornerHeight; j++) {
            currentPixel = image.getPixel(i, j);
            currentPixel.setRed(red);
            currentPixel.setGreen(green);
            currentPixel.setBlue(blue);
        }
    }
    
    return image;
}
var result = topRightCorner(30, 60, "chapel.png", 255, 255, 0)
print(result);