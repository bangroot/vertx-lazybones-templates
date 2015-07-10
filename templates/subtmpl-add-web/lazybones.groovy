import org.apache.commons.io.FileUtils
import java.util.logging.Logger

def log = Logger.getLogger("add-vertx-util")

def props = [:]
props.putAll(parentParams)

props.apexVersion = ask("Which version of Vert.x Web to install [${props.vertxVersion}]: ", props.vertxVersion, "apexVersion")

File buildFile = new File(projectDir, "build.gradle")
File tmpBuildFile = new File(projectDir, "build.gradle.tmp")

buildFile.eachLine { line ->

	tmpBuildFile << "${line}\n"

	if (line.trim().startsWith("compile \"io.vertx:vertx-core")) {
		tmpBuildFile << "\tcompile \"io.vertx:vertx-web:${props.apexVersion}\"\n"
	}
}

buildFile.delete()
FileUtils.moveFile(tmpBuildFile, buildFile)
