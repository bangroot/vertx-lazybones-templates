def props = [:]

props.group = ask("Define value for 'group' [org.example]: ", "org.example", "group")
props.modName = ask("Define value for 'modName' [${projectDir.name}]: ", projectDir.name, "modName")
props.version = ask("Define value for 'version' [1.0-SNAPSHOT]: ", "1.0-SNAPSHOT", "version")
props.vertxVersion = ask("Define value for 'vertxVersion' [3.0.0-dev_preview1]: ", "3.0.0-dev_preview1", "vertxVersion")

processTemplates "src/main/resources/mod.json", props
processTemplates "src/main/groovy/MainVerticle.groovy", props

File destPkg = new File(projectDir, "/src/main/groovy/" + props.group.split("\\.").join("/"))
println "main dir: ${destPkg.absolutePath}"
if (!destPkg.exists()) destPkg.mkdirs()
File destFile = new File(destPkg, "MainVerticle.groovy")
File mainVerticle = new File(projectDir, "/src/main/groovy/MainVerticle.groovy")
mainVerticle.renameTo(destFile)

props.mainVerticle = "groovy:${props.group}.MainVerticle"

processTemplates "gradle.properties", props

