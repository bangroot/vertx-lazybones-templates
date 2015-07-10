Vert.x 3 Project Templates
--------------------------

Welcome to your new Vert.x 3 project. This template is different than other lazybones template in
that it **does not** install any files by default. Rather, it is a collection of sub-templates that
work together over the life of your project. As an interesting side effect, this means you can
always upgrade this set of scripts with `lazybones create vertx3 .` which will get the latest
version of the template along with the most recent sub-templates.

Sub-Templates/Commands
----------------------

### groovy-project

Generates the shell of a groovy Vert.x project with integrated gradle build framework. Out of the
box, the gradle build supports `./gradlew run` to run locally and `./gradlew shadowJar` to create an
executable fat jar. 

The groovy project will come with vertx-core, vertx-lang-groovy and spock as dependencies. It will
also generate a MainVerticle.groovy in the proper package which is pre-configured as the
"controller" verticle during startup.

### groovy-verticle

Creates a new groovy verticle in the specified package.

### add-vertx-util

Adds my opinionated Vert.x utilities to the dependencies. More
information [here](https://github.com/bangroot/vertx-utils). 

### add-vertx-web

Adds support for Vert.x Web. Currently only adds the dependency. Soon will stub out a WebVerticle as
well.
