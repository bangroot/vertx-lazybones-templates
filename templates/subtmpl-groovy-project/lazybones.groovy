import groovy.text.SimpleTemplateEngine
import org.apache.commons.io.FileUtils
import org.apache.commons.io.FilenameUtils
import static org.apache.commons.io.filefilter.FileFilterUtils.*

registerDefaultEngine new SimpleTemplateEngine()

def props = [:]

props.putAll(parentParams)
props.mainVerticle = "groovy:${props.basePackage}.MainVerticle"

processTemplates "**/*.gtpl", props

FileUtils.copyDirectory(templateDir, projectDir, or(directoryFileFilter(), and(fileFileFilter(), notFileFilter(suffixFileFilter('.gtpl')), notFileFilter(nameFileFilter('lazybones.groovy')))));

new File(projectDir, 'gradlew').setExecutable(true, false)

def templatesToMove = [
	'gradle.properties.gtpl': 'gradle.properties',
	'src/main/groovy/MainVerticle.groovy.gtpl': "/src/main/groovy/" + props.basePackage.split("\\.").join("/") + "/MainVerticle.groovy"
]

templatesToMove.each {from, to ->
	File fromFile = new File(templateDir, from)
	File toFile = new File(projectDir, to)
	toFile.parentFile.mkdirs()
	FileUtils.moveFile(fromFile, toFile)
}
