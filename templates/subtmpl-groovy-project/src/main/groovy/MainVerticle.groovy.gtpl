package ${group}

import io.vertx.lang.groovy.GroovyVerticle;
import io.vertx.core.logging.Logger
import io.vertx.core.logging.impl.LoggerFactory

/**
 *
 */
class MainVerticle extends GroovyVerticle {
  private static final Logger _log = LoggerFactory.getLogger(MainVerticle)

  void start() {
    _log.info("Started MainVerticle!")
  }

  void stop() {
  }
}
