var image = new SimpleImage("astrachan.jpg");

function cropImage(image, width, height) {
    var answer = new SimpleImage(width, height);
    
    for (var px of answer.values()) {
        var x = px.getX();
        var y = px.getY();
        
        answer.setPixel(x, y, image.getPixel(x, y));
    }
    
    return answer;
}


print(image);
print(image.getWidth());
print(image.getHeight());

var opImage = cropImage(image, 200, 300);
print(opImage);
print(opImage.getWidth());
print(opImage.getHeight());

