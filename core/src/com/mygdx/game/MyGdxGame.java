package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img,redcapImg;

	MyAnimation anim;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		redcapImg = new Texture("SeekPng.com_red-hood-png_1195165(1).png");
		anim = new MyAnimation("SeekPng.com_red-hood-png_1195165(1).png",3,1,15, Animation.PlayMode.LOOP);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		anim.setTime(Gdx.graphics.getDeltaTime());

		float x = Gdx.input.getX() - anim.draw().getRegionWidth()/2;
		float y = Gdx.graphics.getHeight() - Gdx.input.getY() - anim.draw().getRegionHeight()/2 ;


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
	}
}
