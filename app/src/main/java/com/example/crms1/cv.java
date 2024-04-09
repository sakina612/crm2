package com.example.crms1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class cv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);

        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

// imageList.add(new SlideModel("String Url" or R.drawable))
// imageList.add(new SlideModel("String Url" or R.drawable, "title")) You can add title

        imageList.add(new SlideModel("https://img.cakeresume.com/cdn-cgi/image/fit=scale-down,format=auto,w=1200/https://images.cakeresume.com/images/4611596e-980a-4a95-9f2b-3784beba0487.png", "Example 1", ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel("https://images.template.net/118/Resume-For-Softwere-1X.jpg", "Example 2",ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel("https://d25zcttzf44i59.cloudfront.net/entry-level-computer-science-resume-example.png", "Example 3",ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel("https://1minresume.com/storage/logos/U5SJglWNqPaJIJTg1SYPYFxqJsNQ4Xkiyt0u6zHx.jpg", "Example 4",ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel("https://cvgenius.com/wp-content/uploads/Graduate-CV-Example-2.png", "Example 5",ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel("https://www.my-resume-templates.com/wp-content/uploads/2023/12/resume-for-fresher-template-281.jpg", "Example 6",ScaleTypes.CENTER_INSIDE));


        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
    }
}