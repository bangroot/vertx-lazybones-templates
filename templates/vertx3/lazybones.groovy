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
def defaultVertxVersion = (props.vertxVersion) ?: "3.0.0-milestone4"

props.group = ask("Define value for 'group' [${defaultGroup}]: ", defaultGroup, "group")
props.modName = ask("Define value for 'modName' [${defaultModName}]: ", defaultModName, "modName")
props.version = ask("Define value for 'version' [${defaultVersion}]: ", defaultVersion, "version")
props.vertxVersion = ask("Define value for 'vertxVersion' [${defaultVertxVersion}]: ", defaultVertxVersion, "vertxVersion")
