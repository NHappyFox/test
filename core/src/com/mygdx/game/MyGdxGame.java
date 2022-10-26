package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img,redcapImg;

	private MyAnimation anim;
	private Music music;
	private Sound sound;
	MyInputProcessor myInputProcessor;

	private float x,y;

	@Override
	public void create () {
		myInputProcessor = new MyInputProcessor();
		Gdx.input.setInputProcessor(myInputProcessor);

		music = Gdx.audio.newMusic(Gdx.files.internal("kusanie-yabloka-jevanie-chavkane-proglatyivanie-otryijka-34568.mp3"));
		music.setVolume(0.5f);
		music.setPan(0,1);
		music.setLooping(true);
		music.play();
		// music.isPlaying(); можно чтобы музыка повторялась после того, как закончится

		sound = Gdx.audio.newSound(Gdx.files.internal("volk-zvuk.mp3"));
//		настройка pitch - нужен для растягивания или замедления звука

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		redcapImg = new Texture("SeekPng.com_red-hood-png_1195165(1).png");
		anim = new MyAnimation("SeekPng.com_red-hood-png_1195165(1).png",1,3,15, Animation.PlayMode.LOOP);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		anim.setTime(Gdx.graphics.getDeltaTime());

//		float x = Gdx.input.getX() - anim.draw().getRegionWidth()/2;
//		float y = Gdx.graphics.getHeight() - Gdx.input.getY() - anim.draw().getRegionHeight()/2 ;
		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) sound.play(0.25f);

		if (myInputProcessor.getOutString().contains("A")) x--;
		if (myInputProcessor.getOutString().contains("D")) x++;
		if (myInputProcessor.getOutString().contains("W")) y--;
		if (myInputProcessor.getOutString().contains("S")) y++;
		if (myInputProcessor.getOutString().contains("Space")) {
			x = Gdx.graphics.getWidth()/2;
			y = Gdx.graphics.getHeight()/2;
		}

		batch.begin();

		batch.draw(anim.draw(),x,y);

	//	batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

//		batch.draw(redcapImg, x, y,
//				redcapImg.getWidth()/2,
//				redcapImg.getHeight()/2,
//				redcapImg.getWidth(),
//				redcapImg.getHeight(),
//				1,
//				1,
//				0,
//				0,
//				0,
//				redcapImg.getWidth(),
//				redcapImg.getHeight(),
//				false,
//				false);


		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		redcapImg.dispose();
		anim.dispose();
		music.dispose();
		sound.dispose();
	}
}
