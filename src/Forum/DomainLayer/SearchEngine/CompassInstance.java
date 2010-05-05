/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Forum;
import java.io.File;
import org.compass.core.Compass;
import org.compass.core.config.CompassConfiguration;
import org.compass.core.config.CompassConfigurationFactory;

/**
 *
 * @author Arseny
 */
public class CompassInstance {


    private static Compass _compass;

    /**
     * sort of Singleton design implementation
     * @return Compass instance if exist, or new if it doesn't
     */
    public static Compass getInstance() {
        if (_compass == null) {
            _compass = CompassInit();

        }
        return _compass;
    }

    /**
     * private constructor for the Singleton design
     */
    private CompassInstance() {
        _compass = null;
    }

    private static Compass CompassInit(){
        File file = new File("compassSettings.xml");
        /* The genData directory is where the search engine will save its data */
        CompassConfiguration conf = CompassConfigurationFactory
                .newConfiguration().configure(file);
         conf.setSetting("compass.engine.store.jdbc.dialect", "Forum.DomainLayer.SearchEngine.MyDriver");

        Compass compass = conf.buildCompass();
        return compass;
    }
}
