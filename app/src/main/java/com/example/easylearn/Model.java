package com.example.easylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.Locale;

public class Model extends AppCompatActivity {

    TextToSpeech mTTS;
    private ArFragment arFragment;
    private ModelRenderable tigerRenderable,lionRenderable,jagRenderable,cheetRenderable,muleRenderable,snowRenderable,zebRenderable,snakeRenderable;
    private ArSceneView arView;
    private Scene scene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);


        String model = getIntent().getStringExtra("keyname");
        mTTS =new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","Langauge not supported");
                    }

                }
                else
                {
                    Log.e("TTS","Initialization failed");
                }

            }


        });



        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        arView = arFragment.getArSceneView();
        scene = arView.getScene();


        setUpModel();
        if(model.equalsIgnoreCase("Tiger")) {
            setUpTiger();
        }
        else if(model.equalsIgnoreCase("Lion")){
            setUpLion();
        }
        else if(model.equalsIgnoreCase("Jaguar")){
            setUpJag();
        }
        else if(model.equalsIgnoreCase("Cheetah")){
            setUpCheetah();
        }
        else if(model.equalsIgnoreCase("MuleDeer")){
            setUpMuleDeer();
        }
        else if(model.equalsIgnoreCase("snowleopard")){
            setUpSnow();
        }
        else if(model.equalsIgnoreCase("zebra")){
            setUpZebra();
        }
        else if(model.equalsIgnoreCase("snake")){
            setUpSnake();
        }





    }


    private void setUpModel() {
       /* ViewRenderable.builder()
                .setView(this,R.layout.animal_card)
                .build()
                .thenAccept(
                        (renderable)-> {
                            infoCard.setRenderable(renderable);
                            TextView textView = (TextView)renderable.getView();
                            Button button = (Button)renderable.getView();
                        }

                );*/
        ModelRenderable.builder()
                .setSource(this, R.raw.tiger)
                .build()
                .thenAccept(renderable -> tigerRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(Model.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.lion)
                .build()
                .thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(Model.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.jaguar)
                .build()
                .thenAccept(renderable -> jagRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(Model.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.cheetah)
                .build()
                .thenAccept(renderable -> cheetRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(Model.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.muledeer)
                .build()
                .thenAccept(renderable -> muleRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(Model.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.snowleopard)
                .build()
                .thenAccept(renderable -> snowRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(Model.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.zebra)
                .build()
                .thenAccept(renderable -> zebRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(Model.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.snake)
                .build()
                .thenAccept(renderable -> snakeRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(Model.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

    }

    //private void create



    private void setUpTiger(){
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(scene);

                    createTiger(anchorNode);
                    speakTiger();


            }
        });
    }

    private void setUpLion(){
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(scene);

                createLion(anchorNode);
                speakLion();


            }
        });
    }

    private void setUpJag(){
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(scene);

                createJag(anchorNode);
                speakJag();


            }
        });
    }





    private void createTiger(AnchorNode anchorNode){
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        //TransformableNode node2 = new TransformableNode(arFragment.getTransformationSystem());
        //node.setLocalScale(new Vector3(0.00025f,0.00025f,0.00025f));
        node.getScaleController().setMaxScale(0.4f);
        node.getScaleController().setMinScale(0.2f);
        node.setParent(anchorNode);
        //node2.setParent(node);
        node.setRenderable(tigerRenderable);


        node.select();


    }

    private void createLion(AnchorNode anchorNode){
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        //TransformableNode node2 = new TransformableNode(arFragment.getTransformationSystem());
        //node.setLocalScale(new Vector3(0.00025f,0.00025f,0.00025f));
        node.getScaleController().setMaxScale(0.4f);
        node.getScaleController().setMinScale(0.2f);
        node.setParent(anchorNode);
        //node2.setParent(node);
        node.setRenderable(lionRenderable);


        node.select();


    }

    public void speakTiger()
    {
        String text = "The tiger (Panthera tigris) is the largest living cat species and a member of the genus Panthera. It is most recognisable for its dark vertical stripes on orange-brown fur with a lighter underside.A punch from a Tiger may kill you.Tiger cubs are born blind and only half of the cubs survive. ";
        float pitch = 1/4;
        float speed = 1/8;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);

    }

    public void speakLion()
    {
        String text = "The lion (Panthera leo) is a species in the family Felidae and a member of the genus Panthera. It has a muscular, deep-chested body, short, rounded head, round ears, and a hairy tuft at the end of its tail.Lion’s roar can be heard from 8kms away.";
        float pitch = 1/4;
        float speed = 1/8;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);

    }

    private void createJag(AnchorNode anchorNode){
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        //TransformableNode node2 = new TransformableNode(arFragment.getTransformationSystem());
        //node.setLocalScale(new Vector3(0.00025f,0.00025f,0.00025f));
        node.getScaleController().setMaxScale(0.4f);
        node.getScaleController().setMinScale(0.2f);
        node.setParent(anchorNode);
        //node2.setParent(node);
        node.setRenderable(jagRenderable);


        node.select();


    }

    public void speakJag()
    {
        String text = "The jaguar is the third biggest cat in the world - after the tiger and the lion - and is the largest cat in the Americas.The jaguar has a very powerful jaw, its bite exerts more force than that of a lion.Jaguars live in the wild for 11-15 years, in captivity they can live over 20 years.";
        float pitch = 1/4;
        float speed = 1/8;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);

    }

    public void setUpCheetah()
    {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(scene);

                createCheetah(anchorNode);
                speakCheetah();
            }
        });
    }

    public void createCheetah(AnchorNode anchorNode) {


        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        //TransformableNode node2 = new TransformableNode(arFragment.getTransformationSystem());
        //node.setLocalScale(new Vector3(0.00025f,0.00025f,0.00025f));
        node.getScaleController().setMaxScale(0.4f);
        node.getScaleController().setMinScale(0.2f);
        node.setParent(anchorNode);
        //node2.setParent(node);
        node.setRenderable(cheetRenderable);


        node.select();

    }
    public void speakCheetah()
            {
                String text = "The cheetah is the world's fastest land mammal. With acceleration that would leave most automobiles in the dust, a cheetah can go from 0 to 60 miles an hour in only three seconds.They're Built for Speed.Cheetahs Don't Roar, They Meow and Purr.They're Racing Toward Extinction.";
                float pitch = 1/4;
                float speed = 1/8;

                mTTS.setPitch(pitch);
                mTTS.setSpeechRate(speed);

                mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);

            }

    public void setUpMuleDeer()
    {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(scene);

                createMule(anchorNode);
                speakMule();
            }
        });
    }

    public void createMule(AnchorNode anchorNode) {


        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        //TransformableNode node2 = new TransformableNode(arFragment.getTransformationSystem());
        //node.setLocalScale(new Vector3(0.00025f,0.00025f,0.00025f));
        node.getScaleController().setMaxScale(0.4f);
        node.getScaleController().setMinScale(0.2f);
        node.setParent(anchorNode);
        //node2.setParent(node);
        node.setRenderable(muleRenderable);


        node.select();

    }
    public void speakMule()
    {
        String text = "Mule Deer are the largest member of the Odocoileus genus. They gained their name from their large, mule like ears which they can move independently, allowing them to survey their surroundings for sounds of potential danger. Mule deer stand 40 to 42 inches tall at the shoulders and weigh an average of 200 pounds.";
        float pitch = 1/4;
        float speed = 1/8;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);

    }


    public void setUpSnow()
    {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(scene);

                createSnow(anchorNode);
                speakSnow();
            }
        });
    }

    public void createSnow(AnchorNode anchorNode) {


        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        //TransformableNode node2 = new TransformableNode(arFragment.getTransformationSystem());
        //node.setLocalScale(new Vector3(0.00025f,0.00025f,0.00025f));
        node.getScaleController().setMaxScale(0.4f);
        node.getScaleController().setMinScale(0.2f);
        node.setParent(anchorNode);
        //node2.setParent(node);
        node.setRenderable(snowRenderable);


        node.select();

    }
    public void speakSnow()
    {
        String text = "Snow leopards have powerful legs and are tremendous jumpers, able to leap as far as 50 feet. These big cats use their long tails for balance and as blankets to cover sensitive body parts against the severe mountain chill. They are shy and reclusive, and rarely seen in the wild.";
        float pitch = 1/4;
        float speed = 1/8;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);

    }

    public void setUpZebra()
    {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(scene);

                createZebra(anchorNode);
                speakZebra();
            }
        });
    }

    public void createZebra(AnchorNode anchorNode) {


        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        //TransformableNode node2 = new TransformableNode(arFragment.getTransformationSystem());
        //node.setLocalScale(new Vector3(0.00025f,0.00025f,0.00025f));
        node.getScaleController().setMaxScale(0.4f);
        node.getScaleController().setMinScale(0.2f);
        node.setParent(anchorNode);
        //node2.setParent(node);
        node.setRenderable(zebRenderable);


        node.select();

    }
    public void speakZebra()
    {
        String text = "Zebras are single-hoofed animals that are native to Africa. Zebras are very closely related to horses and donkeys; in fact, they are in the same genus, Equus. ... The Grevy's zebra has very thin stripes.Every zebra has a unique pattern of black and white stripes.There are a number of different theories which attempt to explain zebra's unique stripes with most relating to camouflage.";
        float pitch = 1/4;
        float speed = 1/8;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);

    }


    public void setUpSnake()
    {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(scene);

                createSnake(anchorNode);
                speakSnake();
            }
        });
    }

    public void createSnake(AnchorNode anchorNode) {


        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        //TransformableNode node2 = new TransformableNode(arFragment.getTransformationSystem());
        //node.setLocalScale(new Vector3(0.00025f,0.00025f,0.00025f));
        node.getScaleController().setMaxScale(0.4f);
        node.getScaleController().setMinScale(0.2f);
        node.setParent(anchorNode);
        //node2.setParent(node);
        node.setRenderable(snakeRenderable);


        node.select();

    }
    public void speakSnake()
    {
        String text = "There are more than 3,000 species of snakes on the planet and they're found everywhere except in Antarctica, Iceland, Ireland, Greenland, and New Zealand. Snakes are Deaf and Cannot Hear Sounds.Most Poisonous Snakes Have Bright Colours.Snakes Live Longer in Zoos Than in the Wild.";
        float pitch = 1/4;
        float speed = 1/8;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text , TextToSpeech.QUEUE_FLUSH,null);

    }









}
