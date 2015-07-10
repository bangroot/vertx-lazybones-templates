import java.util.logging.Logger

def log = Logger.getLogger("groovy-verticle")
def props = [:]
props.putAll(parentParams)

props.basePackage = ask("Package [${props.basePackage}]: ", props.basePackage, "basePackage")
props.verticleName = ask("Define value for 'verticleName' [NewVerticle]: ", "NewVerticle", "verticleName")


processTemplates "Verticle.groovy.gtpl", props

File destPkg = new File(projectDir, "/src/main/groovy/" + props.basePackage.split("\\.").join("/"))
if (!destPkg.exists()) destPkg.mkdirs()
File destFile = new File(destPkg, "${props.verticleName}.groovy")
File mainVerticle = new File(templateDir, "Verticle.groovy.gtpl")
log.fine "Moving ${mainVerticle.absolutePath} to ${destFile.absolutePath}"
mainVerticle.renameTo(destFile)
log.info "Add the following to your deploy in MainVerticle: verticle \"groovy:${props.basePackage}.${props.verticleName}\""
