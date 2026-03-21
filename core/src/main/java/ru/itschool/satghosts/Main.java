package ru.itschool.satghosts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Main extends ApplicationAdapter {
    static final float SCR_WIDTH = 1600, SCR_HEIGHT = 900;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;

    Texture imgBackGround;
    Texture imgGhost;
    Texture imgFly;

    Ghost[] ghosts = new Ghost[10];
    Fly[] flies = new Fly[30];

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();

        imgBackGround = new Texture("grave.png");
        imgGhost = new Texture("ghost.png");
        imgFly = new Texture("fly.png");

        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i] = new Ghost();
        }
        for (int i = 0; i < flies.length; i++) {
            flies[i] = new Fly();
        }
    }

    @Override
    public void render() {
        // касания
        if(Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            for (int i = 0; i < ghosts.length; i++) {
                if(ghosts[i].hit(touch)){
                    System.out.println("потрогали");
                }
            }
        }
        // события
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].move();
        }
        for (int i = 0; i < flies.length; i++) {
            flies[i].move();
        }
        // отрисовка
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        for (int i = 0; i < flies.length; i++) {
            batch.draw(imgFly, flies[i].x, flies[i].y, flies[i].width, flies[i].height);
        }
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
        imgFly.dispose();
    }
}
