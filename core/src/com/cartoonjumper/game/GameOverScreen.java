/*
 * This file is part of Jump Don't Die
 * Copyright (C) 2015 Dani Rodríguez <danirod@outlook.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cartoonjumper.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.cartoonjumper.AdHandler;

/**
 * This is the screen that you see when you lose. It has buttons to replay the game again or
 * to go back to the main menu and it is the second screen of this game that uses Scene2D UI.
 */
public class GameOverScreen extends com.cartoonjumper.game.BaseScreen {

    /** The stage where all the buttons are added. */
    private Stage stage;

    /** The skin that we use to set the style of the buttons. */
    private Skin skin;
int highscore;
    Label text;
    Label name ;
    BitmapFont scoreFont;
    String scoreAsString;
    /** The GAME OVER image you see on top of the screen. */
    private Image gameover;
    Label.LabelStyle label1Style = new Label.LabelStyle();
    /** The buttons for retrying or for going back to menu. */
    private TextButton retry, menu;
    AdHandler adHandler ;

    public GameOverScreen(final MainGame game , AdHandler adHandler ) {
        super(game , adHandler);
        this.adHandler = adHandler ;

        scoreFont = new BitmapFont(Gdx.files.internal("close.fnt"));
        // Create a new stage, as usual.
        stage = new Stage(new FitViewport(640, 480));

        // Load the skin file. The skin file contains information about the skins. It can be
        // passed to any widget in Scene2D UI to set the style. It just works, amazing.
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        label1Style.font = scoreFont;
        text = new Label("" ,label1Style);



        // For instance, here you see that I create a new button by telling the label of the
        // button as well as the skin file. The background image for the button is in the skin
        // file.
        retry = new TextButton("Retry", skin);


        // Also, create an image. Images are actors that only display some texture. Useful if you
        // want to display a texture in a Scene2D based screen but you don't want to rewrite code.
        gameover = new Image(game.getManager().get("gameover.png", Texture.class));

        // Add capture listeners. Capture listeners have one method, changed, that is executed
        // when the button is pressed or when the user interacts somehow with the widget. They are
        // cool because they let you execute some code when you press them.
        retry.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Here I go to the game screen again.
                game.score = 0 ;
                game.setScreen(game.startScreen);

            }
        });


        // Now I position things on screen. Sorry for making this the hardest part of this screen.
        // I position things on the screen so that they look centered. This is why I make the
        // buttons the same size.
        gameover.setPosition(320 - gameover.getWidth() / 2, gameover.getHeight()/2 + 20);
        retry.setSize(200, 80);
        retry.setPosition(stage.getWidth()/5 , stage.getHeight()/6);

        // Do not forget to add actors to the stage or we wouldn't see anything.
        stage.addActor(retry);
        stage.addActor(gameover);
    }

    @Override
    public void show() {
        // Now this is important. If you want to be able to click the button, you have to make
        // the Input system handle input using this Stage. Stages are also InputProcessors. By
        // making the Stage the default input processor for this game, it is now possible to
        // click on buttons and even to type on input fields.
        scoreAsString = " " ;


        if(adHandler != null) {

            adHandler.showInterstitialAd(new Runnable() {



                public void run() {

                    System.out.println("Interstitial app closed");

                }

            });

        } else {

            System.out.println("Interstitial ad not (yet) loaded");

        };
        Gdx.input.setInputProcessor(stage);


        scoreAsString = new String(Integer.toString(game.score/20)) ;
        String HighscoreAsString = Integer.toString(highscore);
        label1Style.font = scoreFont;
        text.setText("Score " + scoreAsString );
        name = new Label("HighScore" + HighscoreAsString,label1Style) ;
        name.setPosition(stage.getWidth()/2,stage.getHeight()/2, Align.center);
        text.setPosition(stage.getWidth()/1.5f,(stage.getHeight())/5 + 25,Align.center);
        stage.addActor(text);
     //   stage.addActor(name);
    }

    @Override
    public void hide() {
        // When the screen is no more visible, you have to remember to unset the input processor.
        // Otherwise, input might act weird, because even if you aren't using this screen, you are
        // still using the stage for handling input.
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        // Dispose assets.
        text.setText("");
        text.textEquals("");
        skin.dispose();
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        // Just render things.
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
