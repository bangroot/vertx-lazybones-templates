import org.apache.commons.io.FileUtils
import java.util.logging.Logger

def log = Logger.getLogger("add-vertx-util")

def props = [:]
props.putAll(parentParams)

props.vertxUtilsVersion = ask("Which version of vertx-utils to install [1.2-SNAPSHOT]: ", "1.2-SNAPSHOT", "vertxUtilsVersion")

File buildFile = new File(projectDir, "build.gradle")
File tmpBuildFile = new File(projectDir, "build.gradle.tmp")

buildFile.eachLine { line ->

	tmpBuildFile << "${line}\n"

	if (line.trim().startsWith("compile \"io.vertx:vertx-core")) {
		tmpBuildFile << "\tcompile \"com.github.bangroot.vertx:vertx-utils:${props.vertxUtilsVersion}\"\n"
	}
}

buildFile.delete()
FileUtils.moveFile(tmpBuildFile, buildFile)
