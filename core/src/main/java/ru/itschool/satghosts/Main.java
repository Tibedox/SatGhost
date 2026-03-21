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
    Ghost[] ghosts = new Ghost[10];

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgBackGround = new Texture("grave.png");
        imgGhost = new Texture("ghost.png");

        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i] = new Ghost();
            i=10;
        }
    }

    @Override
    public void render() {
        // события
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].move();
        }
        // отрисовка
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        for (int i = 0; i < ghosts.length; i++) {
            batch.draw(imgGhost, ghosts[i].x, ghosts[i].y, ghosts[i].width, ghosts[i].height);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackGround.dispose();
        imgGhost.dispose();
    }
}
