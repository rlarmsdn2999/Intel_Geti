package com.example.geti_bug;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.lite.Interpreter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class CameraActivity extends AppCompatActivity {
    private Bitmap bitmap;
    private ImageView imageView;
    private TextView resultTextView;
    private Interpreter tflite;
    private static final String MODEL_PATH = "model_unquant.tflite";
    private static final String LABELS_PATH = "labels.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageView = findViewById(R.id.imageView);
        resultTextView = findViewById(R.id.resultTextView);

        Button picBtn = findViewById(R.id.pic_btn);
        picBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });

        Button pickImageButton = findViewById(R.id.pickImageButton);
        pickImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        Button classifyBtn = findViewById(R.id.classify_btn);
        classifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                classifyImage();
            }
        });
    }

    private void classifyImage() {
        if (bitmap != null) {
            try {
                // Initialize the TensorFlow Lite interpreter
                tflite = new Interpreter(loadModelFile());

                // Preprocess the image and run inference
                String label = classify(bitmap);

                // Display the result in the TextView
                String labelStr[] = label.toString().split(" ");
                resultTextView.setText(labelStr[1]);
                TextView textView = findViewById(R.id.textView);

                String result = resultTextView.getText().toString().replaceAll(" ", "");
                if(result.equals("곱등이")){
                    textView.setText("살충제를 이용해서 퇴치하면 됩니다! 에프킬라와 같은 살충제를 직접 살포하는 것입니다. 하지만 덩치가 워낙에 크고 높은 점프력 때문에 쉽게 죽지 않는 수가 있습니다!");
                }else if(result.equals("그리마")){
                    textView.setText("살충제를 뿌려주면 살아남을 가능성이 낮습니다!");
                }else if(result.equals("빈대")){
                    textView.setText("100도 이상의 고온 스팀을 분사해주면 빈대의 성충과 알을 제거할 수 있다고 합니다!");
                }else if(result.equals("나방파리")){
                    textView.setText("하수구에 뜨거운 물을 부어주세요!");
                }else if(result.equals("쌀바구미")){
                    textView.setText("쌀에 뜨거운 물을 부어서 알과 바구미를 다 죽일수 있습니다!");
                }else if(result.equals("집게벌레")){
                    textView.setText("살충제를 뿌려주면 살아남을 가능성이 낮습니다!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "사진을 넣어주세요.", Toast.LENGTH_SHORT).show();
        }
    }

    public void killBtn(View view){
        TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.resultTextView);

        String result = textView1.getText().toString().replaceAll(" ", "");
        if(result.equals("곱등이")){
            textView.setText("살충제를 이용해서 퇴치하면 됩니다! 에프킬라와 같은 살충제를 직접 살포하는 것입니다. 하지만 덩치가 워낙에 크고 높은 점프력 때문에 쉽게 죽지 않는 수가 있습니다!");
        }else if(result.equals("그리마")){
            textView.setText("살충제를 뿌려주면 살아남을 가능성이 낮습니다!");
        }else if(result.equals("빈대")){
            textView.setText("100도 이상의 고온 스팀을 분사해주면 빈대의 성충과 알을 제거할 수 있다고 합니다!");
        }else if(result.equals("나방파리")){
            textView.setText("하수구에 뜨거운 물을 부어주세요!");
        }else if(result.equals("쌀바구미")){
            textView.setText("쌀에 뜨거운 물을 부어서 알과 바구미를 다 죽일수 있습니다!");
        }else if(result.equals("집게벌레")){
            textView.setText("살충제를 뿌려주면 살아남을 가능성이 낮습니다!");
        }
    }

    private MappedByteBuffer loadModelFile() throws IOException {
        AssetFileDescriptor fileDescriptor = getAssets().openFd(MODEL_PATH);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    private String classify(Bitmap bitmap) {
        // Preprocess the image and run inference using your TensorFlow Lite model
        // Modify this part based on your specific model and preprocessing requirements

        int imageTensorIndex = 0;
        int[] inputShape = tflite.getInputTensor(imageTensorIndex).shape();
        int imageSizeX = inputShape[1];
        int imageSizeY = inputShape[2];

        // Preprocess the bitmap into the required input size
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, imageSizeX, imageSizeY, true);
        ByteBuffer inputBuffer = convertBitmapToByteBuffer(resizedBitmap);

        // Run inference
        float[][] outputScores = new float[1][6];  // Modify NUM_CLASSES based on your model
        tflite.run(inputBuffer, outputScores);

        // Postprocess the result and return the predicted label
        String predictedLabel = postprocessResult(outputScores);

        return predictedLabel;
    }

    private ByteBuffer convertBitmapToByteBuffer(Bitmap bitmap) {
        int imageSizeX = tflite.getInputTensor(0).shape()[1];
        int imageSizeY = tflite.getInputTensor(0).shape()[2];
        int channels = tflite.getInputTensor(0).shape()[3];

        ByteBuffer inputBuffer = ByteBuffer.allocateDirect(4 * imageSizeX * imageSizeY * channels);
        inputBuffer.order(ByteOrder.nativeOrder());

        int[] pixels = new int[imageSizeX * imageSizeY];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        int pixel = 0;
        for (int i = 0; i < imageSizeX; ++i) {
            for (int j = 0; j < imageSizeY; ++j) {
                final int val = pixels[pixel++];
                inputBuffer.putFloat(((val >> 16) & 0xFF) / 255.0f);
                inputBuffer.putFloat(((val >> 8) & 0xFF) / 255.0f);
                inputBuffer.putFloat((val & 0xFF) / 255.0f);
            }
        }

        return inputBuffer;
    }

    private String postprocessResult(float[][] outputScores) {
        // Postprocess the model output to get the predicted label
        // Modify this part based on your specific model and postprocessing requirements
        // In this example, it assumes the output is a single label with the highest probability

        int maxIndex = 0;
        float maxScore = outputScores[0][0];

        for (int i = 1; i < outputScores[0].length; i++) {
            if (outputScores[0][i] > maxScore) {
                maxScore = outputScores[0][i];
                maxIndex = i;
            }
        }

        List<String> labels = getLabels();  // Load labels from your labels.txt file
        return labels.get(maxIndex);
    }

    private List<String> getLabels() {
        List<String> labels = new ArrayList<>();

        try {
            InputStream is = getAssets().open(LABELS_PATH);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = reader.readLine()) != null) {
                labels.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return labels;
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activityResultPicture.launch(intent);
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activityResultGallery.launch(intent);
    }

    ActivityResultLauncher<Intent> activityResultPicture = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle extras = result.getData().getExtras();
                        bitmap = (Bitmap) extras.get("data");
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });

    ActivityResultLauncher<Intent> activityResultGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri imageUri = result.getData().getData();
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                            imageView.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
}