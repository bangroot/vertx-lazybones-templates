package ${basePackage}

import io.vertx.core.logging.Logger
import io.vertx.core.logging.impl.LoggerFactory
import io.vertx.lang.groovy.GroovyVerticle

class ${verticleName} extends GroovyVerticle {
  private static Logger _log = LoggerFactory.getLogger(${verticleName})

  @Override
  void start() throws Exception {
    _log.info("\${${verticleName}.name} started")
  }
}
