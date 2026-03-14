package ru.itschool.satghosts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    final float SCR_WIDTH = 1600, SCR_HEIGHT = 900;
    SpriteBatch batch;
    Texture imgBackGround;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgBackGround = new Texture("grave.png");
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackGround.dispose();
    }
}
