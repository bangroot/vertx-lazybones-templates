import uk.co.cacoethes.lazybones.commands.InstallationScriptExecuter

def props = [:] as Properties

File previousProps = new File("${templateDir}/.lazybones", InstallationScriptExecuter.STORED_PROPS_FILENAME)
if (previousProps.exists()) {
	previousProps.withReader("UTF-8") { Reader r ->
		props.load(r)
	}
}

def defaultGroup = (props.group) ?: "org.example"
def defaultModName = (props.modName) ?: projectDir.name
def defaultVersion = (props.version) ?: "1.0-SNAPSHOT"
def defaultVertxVersion = (props.vertxVersion) ?: "3.0.0"

props.group = ask("Project group (e.g. maven group id) [${defaultGroup}]: ", defaultGroup, "group")
def defaultPackage = (props.basePackage) ?: props.group
props.basePackage = ask("Base package for classes [${defaultPackage}]: ", defaultPackage, "basePackage")
props.modName = ask("Vertx module name [${defaultModName}]: ", defaultModName, "modName")
props.version = ask("Initial version [${defaultVersion}]: ", defaultVersion, "version")
props.vertxVersion = ask("Vert.x version [${defaultVertxVersion}]: ", defaultVertxVersion, "vertxVersion")
