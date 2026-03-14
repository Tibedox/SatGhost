package ru.itschool.satghosts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    static final float SCR_WIDTH = 1600, SCR_HEIGHT = 900;
    SpriteBatch batch;
    Texture imgBackGround;
    Texture imgGhost;
    Ghost ghost;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgBackGround = new Texture("grave.png");
        imgGhost = new Texture("ghost.png");
        ghost = new Ghost();
    }

    @Override
    public void render() {
        // события
        ghost.move();

        // отрисовка
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        batch.draw(imgGhost, ghost.x, ghost.y, ghost.width, ghost.height);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackGround.dispose();
        imgGhost.dispose();
    }
}
