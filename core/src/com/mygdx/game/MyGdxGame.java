package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
    private Skin skin;

    private Stage stage;

    public void create() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("skin.json"));
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);

        Stack stack = new Stack();

        Image image = new Image(skin, "bg");
        image.setScaling(Scaling.fill);
        stack.addActor(image);

        Table table1 = new Table();
        table1.padLeft(50.0f);
        table1.padRight(0.0f);
        table1.padTop(50.0f);
        table1.padBottom(0.0f);
        table1.align(Align.topLeft);

        image = new Image(skin, "logo");
        image.setScaling(Scaling.none);
        table1.add(image).spaceBottom(20.0f);

        table1.row();
        TextButton textButton = new TextButton("Single-Player Campaign", skin);
        textButton.setName("single");
        table1.add(textButton).align(Align.topLeft);

        table1.row();
        textButton = new TextButton("Multiplayer Mayhem", skin);
        textButton.setName("multi");
        table1.add(textButton).align(Align.topLeft);

        table1.row();
        textButton = new TextButton("Options", skin);
        textButton.setName("options");
        table1.add(textButton).align(Align.topLeft);

        table1.row();
        textButton = new TextButton("Exit", skin);
        textButton.setName("exit");
        table1.add(textButton).align(Align.topLeft);
        stack.addActor(table1);
        table.add(stack);
        stage.addActor(table);
    }

    public void render() {
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
