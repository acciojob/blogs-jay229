package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();
        Image image=new Image(description,dimensions,blog);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return  image;

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String screen[]=screenDimensions.split("X");
        Image image=imageRepository2.findById(id).get();
        String image_size[]=image.getDimensions().split("X");
        int screenLength=Integer.parseInt(screen[0]);
        int screenBreadth=Integer.parseInt(screen[1]);
        int imageLength=Integer.parseInt(image_size[0]);
        int imageBreadth=Integer.parseInt(image_size[1]);
        return findNoOfImages(screenLength,screenBreadth,imageLength,imageBreadth);
    }
    public int findNoOfImages(int screenLength, int screenBreadth, int imageLength, int imageBreadth ){
        int length=screenLength/imageLength;
        int breadth=screenBreadth/imageBreadth;
        return length*breadth;
    }
}
