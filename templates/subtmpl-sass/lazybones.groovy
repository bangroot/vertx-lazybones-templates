import uk.co.cacoethes.util.NameType
import groovy.text.SimpleTemplateEngine
import org.apache.commons.io.FileUtils
import org.apache.commons.io.FilenameUtils
import static org.apache.commons.io.filefilter.FileFilterUtils.*

registerDefaultEngine new SimpleTemplateEngine()

def props = [:]
props.putAll(parentParams)

props.cssName = transformText(parentParams.modName, from: NameType.HYPHENATED, to: NameType.PROPERTY)
println props.cssName

File destFile = new File(projectDir, "src/main/sass/${props.cssName}.scss")
if(!destFile.parentFile.exists()) destFile.parentFile.mkdirs()

processTemplates "**/*.gtpl", props

File mainVerticle = new File(templateDir, "src/main/sass/module.scss.gtpl")
mainVerticle.renameTo(destFile)

FileUtils.copyDirectory(templateDir, projectDir, or(directoryFileFilter(), and(fileFileFilter(), suffixFileFilter('.scss'))));
FileUtils.copyDirectory(templateDir, projectDir, or(directoryFileFilter(), and(fileFileFilter(), suffixFileFilter('.gradle'))));

new File(projectDir, "build.gradle").append("\napply from: \"gradle/sass.gradle\"\n")
