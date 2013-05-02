/*
 * Copyright (C) 2013 Code Universe. All rights reserved.
 * 
 * http://www.codeuniverse.org
 * 
 * Created by Jaison Brooks 4/26/2013
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codeuniverse.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.activity_splashscreen);
		Animation a = AnimationUtils.loadAnimation(this, R.anim.animation);
		a.reset();
		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		iv.clearAnimation();
		iv.startAnimation(a);
		Thread splashThread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (waited < 2000) {
						sleep(100);
						waited += 100;
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
					startActivity(myIntent);
				}
			}
		};
		splashThread.start();
	}
}
