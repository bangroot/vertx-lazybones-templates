import java.util.logging.Logger

def log = Logger.getLogger("add-vertx-util")

File buildFile = new File(projectDir, "build.gradle")
File tmpBuildFile = new File(projectDir, "build.gradle.tmp")

buildFile.eachLine { line ->

	tmpBuildFile << "${line}\n"

	if (line.trim().startsWith("compile \"io.vertx:vertx-core")) {
		tmpBuildFile << "\tcompile \"com.github.bangroot.vertx:vertx-utils:1.2-SNAPSHOT\"\n"
	}
}
