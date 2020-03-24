package surgo.kom.core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.openide.modules.ModuleInstall;

public class Main extends ModuleInstall {

    @Override
    public void restored() {
        LwjglApplicationConfiguration cfg =
			new LwjglApplicationConfiguration();
		cfg.title = "Asteroids - wannabe";
		cfg.width = 1000;
		cfg.height = 800;
		cfg.useGL30 = false;
		cfg.resizable = false;
		
		new LwjglApplication(new Game(), cfg);
    }
}
