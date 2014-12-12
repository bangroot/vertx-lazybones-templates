package ${group}

import com.github.bangroot.vertx.groovy.ExtensionVerticle

/**
 *
 */
class MainVerticle extends ExtensionVerticle {

  def start() {
    launch({
      //see DeployExtension
    })

  }

  def vertxStop() {
  }
}
