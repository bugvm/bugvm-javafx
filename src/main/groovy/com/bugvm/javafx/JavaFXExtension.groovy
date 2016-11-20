package com.bugvm.javafx

import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator
import org.gradle.util.ConfigureUtil
import com.bugvm.javafx.android.AndroidExtension
import com.bugvm.javafx.embedded.EmbeddedExtension
import com.bugvm.javafx.ios.IosExtension

/**
 *
 * @author joeri
 */
class JavaFXExtension {

    String javacEncoding = 'utf-8'
    String javafxportsVersion = "8.60.8"

    DownConfiguration downConfig

    public JavaFXExtension(Project project, Instantiator instantiator) {
        extensions.create("android", AndroidExtension, project)
        extensions.create("ios", IosExtension, project)
        extensions.create("embedded", EmbeddedExtension, project)

        downConfig = instantiator.newInstance(DownConfiguration, project)
    }

    void downConfig(Closure configureClosure) {
        ConfigureUtil.configure(configureClosure, downConfig)
    }
}
