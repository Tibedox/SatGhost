package ru.itschool.satghosts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

public class Main extends ApplicationAdapter {
    static final float SCR_WIDTH = 1600, SCR_HEIGHT = 900;

    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;

    Texture imgBackGround;
    Texture imgGhost;
    Texture imgFly;
    Sound[] sndGhost = new Sound[15];
    BitmapFont font;

    Ghost[] ghosts = new Ghost[10];
    Fly[] flies = new Fly[30];

    int kills = 0;
    long timeStartGame;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();
        font = new BitmapFont(Gdx.files.internal("comic50.fnt"));

        imgBackGround = new Texture("grave.png");
        imgGhost = new Texture("ghost.png");
        imgFly = new Texture("fly.png");
        for (int i = 0; i < sndGhost.length; i++) {
            sndGhost[i] = Gdx.audio.newSound(Gdx.files.internal("sound/man_death_" +i/10+i%10+ ".ogg"));
        }

        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i] = new Ghost();
        }
        for (int i = 0; i < flies.length; i++) {
            flies[i] = new Fly();
        }
        timeStartGame = TimeUtils.millis();
    }

    @Override
    public void render() {
        // касания
        if (Gdx.input.justTouched()) {
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            for (int i = 0; i < ghosts.length; i++) {
                if (ghosts[i].hit(touch) && ghosts[i].show) {
                    ghosts[i].show = false;
                    sndGhost[MathUtils.random(0, 14)].play();
                    kills++;
                }
            }
        }

        // события
        for (int i = 0; i < ghosts.length; i++) {
            if (ghosts[i].show) ghosts[i].move();
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
            if (ghosts[i].show) {
                batch.draw(imgGhost, ghosts[i].x, ghosts[i].y, ghosts[i].width, ghosts[i].height);
            }
        }
        font.draw(batch, getTime(), 10, 890);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackGround.dispose();
        imgGhost.dispose();
        imgFly.dispose();
        for (int i = 0; i < sndGhost.length; i++) {
            sndGhost[i].dispose();
        }
    }

    String getTime(){
        long time = TimeUtils.millis() - timeStartGame;
        long milisec = time%1000/100;
        long sec = time/1000%60;
        long min = time/1000/60%60;
        long hours = time/1000/60/60;
        String strTime = hours+":"+min/10+min%10+":"+sec/10+sec%10+":"+milisec;
        return strTime;
    }
}
