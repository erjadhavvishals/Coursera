function changeRed(width, height) {
    var picture = new SimpleImage(width, height);
    var red = 0;

    for (i = 0; i < width; i++) {
        for (j = 0; j < height; j++) {
            currentPixel = picture.getPixel(i, j);
            currentPixel.setRed(i);
            currentPixel.setGreen(0);
            currentPixel.setBlue(0);
        }
    }

    return picture;
}

var result = changeRed(256, 200);
print(result);