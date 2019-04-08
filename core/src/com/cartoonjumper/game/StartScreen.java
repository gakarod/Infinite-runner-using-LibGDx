package com.cartoonjumper.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.cartoonjumper.AdHandler;

/**
 * Created by vaibh on 7/4/2017.
 */

public class StartScreen extends com.cartoonjumper.game.BaseScreen {

    private static final float WORLD_WIDTH = 640;
    private static final float WORLD_HEIGHT = 480;
    private Stage stage;
    AdHandler adHandler ;
    private Texture bgTexture;
    private Texture bUpTexture;
    private Texture bDnTexture;
    private Texture titleTexture;
   // AdHandler handler ;

   // private final Game game;
    com.cartoonjumper.game.MainGame game1 ;
    public StartScreen(final com.cartoonjumper.game.MainGame game , AdHandler adHandler  ) {
        super(game,adHandler);
        this.game1 = game;
        this.adHandler = adHandler ;

    //    this.handler = handler ;
    }


    public void show(){
        stage = new Stage(new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT));
        Gdx.input.setInputProcessor(stage);

    //    Music background = Gdx.audio.newMusic(Gdx.files.internal("music.wav"));
      //  background.setLooping(true);
       // background.play();

        bgTexture = new Texture(Gdx.files.internal("back.png"));
        Image bgImage = new Image(bgTexture);
        stage.addActor(bgImage);
        bUpTexture = new Texture(Gdx.files.internal("play.png"));
        bDnTexture = new Texture(Gdx.files.internal("playPress.png"));
        ImageButton play = new ImageButton(
                new TextureRegionDrawable(new TextureRegion(bUpTexture)),
                new TextureRegionDrawable(new TextureRegion(bDnTexture))
        );
        ImageButton play1 = new ImageButton(
                new TextureRegionDrawable(new TextureRegion(bUpTexture)),
                new TextureRegionDrawable(new TextureRegion(bDnTexture))
        );
        ImageButton play2 = new ImageButton(
                new TextureRegionDrawable(new TextureRegion(bUpTexture)),
                new TextureRegionDrawable(new TextureRegion(bDnTexture))
        );
        ImageButton play3 = new ImageButton(
                new TextureRegionDrawable(new TextureRegion(bUpTexture)),
                new TextureRegionDrawable(new TextureRegion(bDnTexture))
        );
        ImageButton play4 = new ImageButton(
                new TextureRegionDrawable(new TextureRegion(bUpTexture)),
                new TextureRegionDrawable(new TextureRegion(bDnTexture))
        );
        ImageButton play5 = new ImageButton(
                new TextureRegionDrawable(new TextureRegion(bUpTexture)),
                new TextureRegionDrawable(new TextureRegion(bDnTexture))
        );
        ImageButton play6 = new ImageButton(
                new TextureRegionDrawable(new TextureRegion(bUpTexture)),
                new TextureRegionDrawable(new TextureRegion(bDnTexture))
        );
        ImageButton play7 = new ImageButton(
                new TextureRegionDrawable(new TextureRegion(bUpTexture)),
                new TextureRegionDrawable(new TextureRegion(bDnTexture))
        );

        // Add event listener to this button
        play.addListener(new ActorGestureListener(){
            public void tap(InputEvent event, float x, float y, int count, int button){
                super.tap(event, x, y, count, button);
                game1.type = 1 ;
                game1.setScreen(game1.gameScreen);

                dispose();
            }
        });
        play1.addListener(new ActorGestureListener(){
            public void tap(InputEvent event, float x, float y, int count, int button){
                super.tap(event, x, y, count, button);
                game1.type = 2 ;
                game1.setScreen(game1.gameScreen);

                dispose();
            }
        });
        play2.addListener(new ActorGestureListener(){
            public void tap(InputEvent event, float x, float y, int count, int button){
                super.tap(event, x, y, count, button);
                game1.type = 3 ;
                game1.setScreen(game1.gameScreen);

                dispose();
            }
        });
        play3.addListener(new ActorGestureListener(){
            public void tap(InputEvent event, float x, float y, int count, int button){
                super.tap(event, x, y, count, button);
                game1.type = 4;
                game1.setScreen(game1.gameScreen);

                dispose();
            }
        });
        play4.addListener(new ActorGestureListener(){
            public void tap(InputEvent event, float x, float y, int count, int button){
                super.tap(event, x, y, count, button);
                game1.type = 5 ;
                game1.setScreen(game1.gameScreen);

                dispose();
            }
        });
        play5.addListener(new ActorGestureListener(){
            public void tap(InputEvent event, float x, float y, int count, int button){
                super.tap(event, x, y, count, button);
                game1.type = 6 ;
                game1.setScreen(game1.gameScreen);

                dispose();
            }
        });
        play6.addListener(new ActorGestureListener(){
            public void tap(InputEvent event, float x, float y, int count, int button){
                super.tap(event, x, y, count, button);
                game1.type = 7 ;
                game1.setScreen(game1.gameScreen);

                dispose();
            }
        });
        play7.addListener(new ActorGestureListener(){
            public void tap(InputEvent event, float x, float y, int count, int button){
                super.tap(event, x, y, count, button);
                game1.type = 8 ;
                game1.setScreen(game1.gameScreen);

                dispose();
            }
        });



        play.setPosition(WORLD_WIDTH/1.15f,WORLD_HEIGHT/1.9f, Align.center);
        play1.setPosition(WORLD_WIDTH/1.65f,WORLD_HEIGHT/1.9f, Align.center);
        play2.setPosition(WORLD_WIDTH/2.8f,WORLD_HEIGHT/1.9f, Align.center);
        play3.setPosition(WORLD_WIDTH/7f,WORLD_HEIGHT/1.9f, Align.center);
        play4.setPosition(WORLD_WIDTH/1.15f,WORLD_HEIGHT/15, Align.center);
        play5.setPosition(WORLD_WIDTH/1.65f,WORLD_HEIGHT/15, Align.center);
        play6.setPosition(WORLD_WIDTH/2.8f,WORLD_HEIGHT/15, Align.center);
        play7.setPosition(WORLD_WIDTH/7f,WORLD_HEIGHT/15, Align.center);



        stage.addActor(play);
        stage.addActor(play1);
        stage.addActor(play2);
        stage.addActor(play3);
        stage.addActor(play4);
        stage.addActor(play5);
        stage.addActor(play6);
        stage.addActor(play7);


    }



    public void resize(int w, int h){
        stage.getViewport().update(w,h,true);
    }

    public void render(float delta){
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        bDnTexture.dispose();
        bDnTexture.dispose();
        bUpTexture.dispose();
    }
}