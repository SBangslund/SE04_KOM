/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgo.kom.core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 *
 * @author sbang
 */
public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg =
			new LwjglApplicationConfiguration();
		cfg.title = "Cell Defender";
		cfg.width = 1000;
		cfg.height = 800;
		cfg.useGL30 = false;
		cfg.resizable = false;
		
		new LwjglApplication(new Game(), cfg);
    }
}
